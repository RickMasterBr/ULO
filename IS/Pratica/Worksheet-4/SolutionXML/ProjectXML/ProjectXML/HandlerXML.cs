using System;
using System.Collections.Generic;
using System.Diagnostics;
using System.Xml;
using System.Xml.Schema;

namespace ProjectXML;

public class HandlerXML
{

    public HandlerXML(string xmlFilePath, string xsdFilePath)
    {
        XmlFilePath = xmlFilePath;
        XsdFilePath = xsdFilePath;
    }

    public HandlerXML(string xmlFilePath)
    {
        XmlFilePath = xmlFilePath;
        XsdFilePath = "";
    }

    public string XmlFilePath { get; set; }
    public string XsdFilePath { get; set; }

    //**********************************************
    // Ex. 7
    //**********************************************
    public List<string> GetTitles()
{
    var titles = new List<string>();

    XmlDocument doc = new XmlDocument();
    doc.Load(XmlFilePath);

    XmlNodeList? nodes = doc.SelectNodes("/bookstore/book/title");
    if (nodes != null)
    {
        foreach (XmlNode node in nodes)
            titles.Add(node.InnerText);
    }

    return titles;
}
    //**********************************************
    // Ex. 8
    //**********************************************       
    public bool UpdateAuthorByTitle(string title, string author)
    {
        try
        {
            XmlDocument doc = new();
        doc.Load(XmlFilePath);

        XmlNode? authorNode = doc.SelectSingleNode($"/bookstore/book[title=\"{title}\"]/author");

        if (authorNode == null)
            return false;

        authorNode.InnerText = author;

        doc.Save(XmlFilePath);

        return true;
        }

        catch (SystemException)
        {
            return false;
        }
    
    }

    public void UpdateNode(string path, string value, string parentTag, string new_value)
    {
        throw new NotImplementedException();
    }
    //**********************************************
    // Ex. 9
    //**********************************************  
    public bool AddRateToBook(string title, string rate)
    {
         XmlDocument doc = new XmlDocument();
    doc.Load(XmlFilePath);

    XmlNode? book = doc.SelectSingleNode($"/bookstore/book[title=\"{title}\"]");
    if (book == null)
        return false;

    XmlNode? rateNode = book.SelectSingleNode("rate");
    if (rateNode != null)
    {
        rateNode.InnerText = rate;
    }
    else
    {
        XmlElement newRate = doc.CreateElement("rate");
        newRate.InnerText = rate;

        XmlNode? format = book.SelectSingleNode("bookformat");
        if (format != null)
            book.InsertBefore(newRate, format);
        else
            book.AppendChild(newRate);
    }

    doc.Save(XmlFilePath);
    return true;
}
    
    //**********************************************
    // Ex. 10 Add Attribute
    //**********************************************  
    public void AddAttributeISBNToBook(string title, string isbn)
    {
         XmlDocument doc = new XmlDocument();
    doc.Load(XmlFilePath);

    XmlElement? book = doc.SelectSingleNode($"/bookstore/book[title=\"{title}\"]") as XmlElement;
    if (book == null)
        return;

    book.SetAttribute("isbn", isbn);
    doc.Save(XmlFilePath);
    }


    #region Exercise 6 - Validate XML with XML Schema (xsd)
    // =======================================
    // if (!ValidateXml(out string message))
    // {
    //     Debug.WriteLine(message);
    // }
    // =======================================

    /// <summary>
    /// Valida um ficheiro XML contra o esquema XSD configurado e devolve
    /// as mensagens de erro ou aviso encontradas durante a validação.
    /// </summary>
    /// <param name="validationMessage">
    /// Contém as mensagens de validação geradas durante o processo.
    /// Será uma string vazia caso não existam erros nem avisos.
    /// </param>
    /// <returns>
    /// <c>true</c> se o XML for válido; caso contrário, <c>false</c>.
    /// </returns>
    public bool ValidateXML(out string validationMessage)
    {
        string message = string.Empty;
        bool isValid = true;

        try
        {
            XmlDocument doc = new XmlDocument();
            doc.Load(XmlFilePath);
            doc.Schemas.Add(null, XsdFilePath);

            doc.Validate((sender, args) =>
            {
                isValid = false;
                message += $"{args.Severity}: {args.Message}";
            });
        }
        catch (XmlException ex)
        {
            isValid = false;
            message += $"XML ERROR: {ex.ToString()}\n";
        }
        catch (Exception ex)
        {
            isValid = false;
            message += $"UNEXPECTED ERROR: {ex.Message}\n";
        }
        validationMessage = message;
        return isValid;
    }
    #endregion
}
