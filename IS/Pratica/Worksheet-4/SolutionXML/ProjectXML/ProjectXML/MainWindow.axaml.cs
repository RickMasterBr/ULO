using System;
using System.Diagnostics;
using System.Formats.Asn1;
using System.Xml;
using Avalonia.Controls;
using Avalonia.Interactivity;
using Avalonia.Platform.Storage;
using MsBox.Avalonia;
using MsBox.Avalonia.Enums;

namespace ProjectXML;

public partial class MainWindow : Window
{
    private string selectedTitle = string.Empty;
    public MainWindow()
    {
        InitializeComponent();
    }

    private void GenerateByCode_Click(object? sender, RoutedEventArgs e)
    {
        XmlDocument doc = new XmlDocument();
        // Create the XML Declaration, and append it to XML document
        XmlDeclaration dec = doc.CreateXmlDeclaration("1.0", null, null);
        doc.AppendChild(dec);
        // Create the root element
        XmlElement root = doc.CreateElement("bookstore");
        doc.AppendChild(root);


        root.AppendChild(CreateBook(
            doc, "CHILDREN", "333", "Charlotte's Web", "E.B. White", "1952", "12.60", "ebook"));

        // fill the missing data ....
        root.AppendChild(CreateBook(
            doc, "WEB", "444", "Beginning XML", "Joe Fawcett", "2012", "31.30", "paperback", "4"));
        
        root.AppendChild(CreateBook(
            doc, "WEB", "555", "Programing .NET Web Services", "Alex Ferrara", "2002", "38.36", "paperback", "3"));

        doc.Save(@"sample.xml");
        //string xmlOutput = doc.OuterXml;

    }

    private async void OpenXml_Click(object? sender, RoutedEventArgs e)
    {
        var files = await StorageProvider.OpenFilePickerAsync(
            new FilePickerOpenOptions
            {
                Title = "Select the XML file",
                AllowMultiple = false,
                FileTypeFilter =
                [
                    new FilePickerFileType("XML files")
                            {
                                Patterns = ["*.xml"]
                            }
                ]
            });

        if (files.Count > 0)
            txtXmlFile.Text = files[0].Path.LocalPath;  //or AbsolutePath
    }

    private async void OpenXsd_Click(object? sender, RoutedEventArgs e)
    {
        var files = await StorageProvider.OpenFilePickerAsync(
            new FilePickerOpenOptions
            {
                Title = "Select the XML Schema Definition file (XSD file)",
                AllowMultiple = false,
                FileTypeFilter =
                [
                    new FilePickerFileType("XSD files")
                                    {
                                        Patterns = ["*.xsd"]
                                    }
                ]
            });

        if (files.Count > 0)
            txtXsdFile.Text = files[0].Path.LocalPath;
    }
    private void Validate_Click(object? sender, RoutedEventArgs e)
    {
        // TODO

        var handler = new HandlerXML(txtXmlFile.Text ?? "", txtXsdFile.Text ?? "");

        if (handler.ValidateXML(out string message))
            txtSelectedTitle.Text = "XML valido";
        else
            txtSelectedTitle.Text = message;
    }

    private void GetTitles_Click(object? sender, RoutedEventArgs e)
    {
        // TODO

        var handler = new HandlerXML(txtXmlFile.Text ?? "");
        listBoxBookTitles.ItemsSource = handler.GetTitles();

    }

    private void listBoxBookTitles_SelectionChanged(object? sender, SelectionChangedEventArgs e)
    {
        // TODO

         selectedTitle = listBoxBookTitles.SelectedItem?.ToString() ?? string.Empty;
    txtSelectedTitle.Text = selectedTitle;

    }

    private async void UpdateAuthor_Click(object? sender, RoutedEventArgs e)
{
    
    if (string.IsNullOrWhiteSpace(selectedTitle) || string.IsNullOrWhiteSpace(txtNewAuthor.Text))
        return;

    var handler = new HandlerXML(txtXmlFile.Text ?? "");
    bool result = handler.UpdateAuthorByTitle(selectedTitle, txtNewAuthor.Text);

    var box = MessageBoxManager.GetMessageBoxStandard(
        "Update Author",
        result ? "Autor atualizado." : "Livro não encontrado.",
        ButtonEnum.Ok);
    await box.ShowAsync();
}

    

    private async void AddRate_Click(object? sender, RoutedEventArgs e)
    {
        // TODO

         if (string.IsNullOrWhiteSpace(selectedTitle))
        return;

    var handler = new HandlerXML(txtXmlFile.Text ?? "");
    string rate = ((int)(numRate.Value ?? 1)).ToString();
    bool result = handler.AddRateToBook(selectedTitle, rate);

    var box = MessageBoxManager.GetMessageBoxStandard(
        "Add Rate", result ? "Rate adicionado." : "Livro não encontrado.", ButtonEnum.Ok);
    await box.ShowAsync();
    }

    private async void AddISBN_Click(object? sender, RoutedEventArgs e)
    {
        // TODO

        if (string.IsNullOrWhiteSpace(selectedTitle) || string.IsNullOrWhiteSpace(txtISBN.Text))
        return;

    var handler = new HandlerXML(txtXmlFile.Text ?? "");
    handler.AddAttributeISBNToBook(selectedTitle, txtISBN.Text);

    var box = MessageBoxManager.GetMessageBoxStandard(
        "Add ISBN", "ISBN adicionado.", ButtonEnum.Ok);
    await box.ShowAsync();
    }


    private XmlElement CreateBook(XmlDocument doc, string category, string isbn, string title, string author, string year, string price, string format, string? rate = null)
    {
        XmlElement book = doc.CreateElement("book");
        book.SetAttribute("category", category);
        book.SetAttribute("isbn", isbn);

        XmlElement e = doc.CreateElement("title");
        e.InnerText = title;
        book.AppendChild(e);

        e = doc.CreateElement("author");
        e.InnerText = author;
        book.AppendChild(e);

        e = doc.CreateElement("year");
        e.InnerText = year;
        book.AppendChild(e);

        e = doc.CreateElement("price");
        e.InnerText = price;
        book.AppendChild(e);

        if (rate != null)
        {
            e = doc.CreateElement("rate");
            e.InnerText = rate;
            book.AppendChild(e);
        }

        e = doc.CreateElement("bookformat");
        e.InnerText = format;
        book.AppendChild(e);

        return book;
    }
}