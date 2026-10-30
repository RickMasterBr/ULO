using System.Diagnostics;
using System.Formats.Asn1;
using System.Xml;
using Avalonia.Controls;
using Avalonia.Interactivity;
using Avalonia.Platform.Storage;

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
            doc, "CHILDREN", "333", "Charlotte's Web", "E.B. White", "1952", "12.60", "EBOOK"));

        // fill the missing data ....

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
    }

    private void GetTitles_Click(object? sender, RoutedEventArgs e)
    {
        // TODO
    }

    private void listBoxBookTitles_SelectionChanged(object? sender, SelectionChangedEventArgs e)
    {
        // TODO
    }

    private void UpdateAuthor_Click(object? sender, RoutedEventArgs e)
    {
        // TODO
    }

    private void AddRate_Click(object? sender, RoutedEventArgs e)
    {
        // TODO
    }

    private void AddISBN_Click(object? sender, RoutedEventArgs e)
    {
        // TODO
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