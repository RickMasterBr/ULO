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
        throw new NotImplementedException();
    }
    //**********************************************
    // Ex. 8
    //**********************************************       
    public bool UpdateAuthorByTitle(string title, string author)
    {
        throw new NotImplementedException();
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
        throw new NotImplementedException();
    }
    //**********************************************
    // Ex. 10 Add Attribute
    //**********************************************  
    public void AddAttributeISBNToBook(string title, string isbn)
    {
        throw new NotImplementedException();
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
