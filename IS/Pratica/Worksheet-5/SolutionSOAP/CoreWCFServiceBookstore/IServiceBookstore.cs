using CoreWCF;
using System;
using System.Runtime.Serialization;
using System.Xml;

namespace CoreWCFServiceBookstore
{
    [ServiceContract]
    public interface IServiceBookstore
    {
        [OperationContract]
        List<Book> GetBooks();

        [OperationContract]
        Book? GetBookByTitle(string title);

        [OperationContract]
        List<Book> GetBooksByCategory(BookCategory category);

        [OperationContract]
        void AddBook(Book book);

        [OperationContract]
        bool DeleteBook(string title);


    }

    [ServiceBehavior(IncludeExceptionDetailInFaults = true)]
    public class ServiceBookstore : IServiceBookstore
    {

        private readonly string filename = Path.Combine(Directory.GetCurrentDirectory(), "bookstore.xml");

        public void AddBook(Book book)
        {
            XmlDocument doc = new();
            doc.Load(filename);

            XmlNode? root = doc.SelectSingleNode($"/bookstore");

            XmlElement livro = doc.CreateElement("book");
            livro.SetAttribute("category", book.Category.ToString());

            XmlElement e = doc.CreateElement("title");
            e.InnerText = book.Title;
            livro.AppendChild(e);

            e = doc.CreateElement("author");
            e.InnerText = book.Author;
            livro.AppendChild(e);

            e = doc.CreateElement("year");
            e.InnerText = book.Year.ToString();
            livro.AppendChild(e);

            e = doc.CreateElement("price");
            e.InnerText = book.Price.ToString();
            livro.AppendChild(e);

            root?.AppendChild(livro);
            

            doc.Save(filename);
        }

        public bool DeleteBook(string title)
        {
            XmlDocument doc = new();
            doc.Load(filename);

            XmlNode? nodeLivro = doc.SelectSingleNode($"/bookstore/book[title=\"{title}\"]");

            if (nodeLivro == null) return false;
            else
            {
                XmlNode? pai = nodeLivro.ParentNode;
                pai?.RemoveChild(nodeLivro);
                doc.Save(filename);
                return true;
            }


        }

        public Book? GetBookByTitle(string title)
        {

            XmlDocument doc = new();
            doc.Load(filename);

            XmlNode? nodeLivro = doc.SelectSingleNode($"/bookstore/book[title=\"{title}\"]");

            if (nodeLivro is null)
                return null;
            else
            {
                Book livro = new Book
                {
                    Title = nodeLivro["title"]!.InnerText,
                    Author = nodeLivro["author"]!.InnerText,
                    Year = int.Parse(nodeLivro["year"]!.InnerText),
                    Price = double.Parse(nodeLivro["price"]!.InnerText, System.Globalization.CultureInfo.InvariantCulture),
                    Category = Enum.Parse<BookCategory>(nodeLivro.Attributes!["category"]!.Value),
                };

                return livro;
            }
        }

        public List<Book> GetBooks()
        {
            List<Book> livros = new();
            XmlDocument doc = new();
            doc.Load(filename);

            XmlNodeList? nodes = doc.SelectNodes($"/bookstore/book");

            if (nodes is null) return livros;

            foreach (XmlNode item in nodes)
            {
                Book livro = new Book
                {
                    Title = item["title"]!.InnerText,
                    Author = item["author"]!.InnerText,
                    Year = int.Parse(item["year"]!.InnerText),
                    Price = double.Parse(item["price"]!.InnerText, System.Globalization.CultureInfo.InvariantCulture),
                    Category = Enum.Parse<BookCategory>(item.Attributes!["category"]!.Value),
                };

                livros.Add(livro);
            }


            return livros;
        }

        public List<Book> GetBooksByCategory(BookCategory category)
        {
            throw new NotImplementedException();
        }
    }

    // Use a data contract as illustrated in the sample below to add composite types to service operations.
    [DataContract]
    public class Book
    {
        [DataMember]
        public string Title { get; set; } = string.Empty;

        [DataMember]
        public string Author { get; set; } = string.Empty;

        [DataMember]
        public int Year { get; set; }

        [DataMember]
        public double Price { get; set; }

        [DataMember]
        public BookCategory Category { get; set; }
    }

    [DataContract]
    public enum BookCategory
    {
        [EnumMember]
        WEB,
        [EnumMember]
        CHILDREN,
        [EnumMember]
        SCIENCE,
        [EnumMember]
        ROMANCE,
        [EnumMember]
        OTHER
    }

}
