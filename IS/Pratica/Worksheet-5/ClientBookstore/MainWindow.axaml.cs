using System;
using System.Linq;
using System.ServiceModel.Channels;
using Avalonia.Controls;
using Avalonia.Interactivity;
using MsBox.Avalonia;
using ServiceReference;

namespace ClientBookstore;

public partial class MainWindow : Window
{
    public MainWindow()
    {
        InitializeComponent();

        LoadComboBox();

    }

    private void LoadComboBox()
    {
        cmbCategory.ItemsSource = Enum.GetValues(typeof(BookCategory));
        cmbBookCategory.ItemsSource = Enum.GetValues(typeof(BookCategory));
    }

    private async void BtnGetBooks_Click(object? sender, RoutedEventArgs e)
    {
        
        try
        {
            using ServiceBookstoreClient service = new();
            Book[] livros = await service.GetBooksAsync();   

            // prencher segunda combo box

            lstBooks.ItemsSource = livros.Select(i=> i.Title);
        }
        catch (System.Exception ex)
        {
            await MessageBoxManager.GetMessageBoxStandard("Client Bookstore Error",
            ex.Message, MsBox.Avalonia.Enums.ButtonEnum.Ok ).ShowAsync();
        }

    }

    private async void BtnFilterCategory_Click(object? sender, RoutedEventArgs e)
    {
        
        try
        {
            if(cmbTitles.SelectedItem == null) 
            await MessageBoxManager.GetMessageBoxStandard("Client Bookstore Error",
            "You must select a book title", MsBox.Avalonia.Enums.ButtonEnum.Ok ).ShowAsync();

            BookCategory cat = (BookCategory)cmbTitles.SelectedItem!; 
        }
        catch (System.Exception ex)
        {
            
            await MessageBoxManager.GetMessageBoxStandard("Client Bookstore Error",
            ex.Message, MsBox.Avalonia.Enums.ButtonEnum.Ok ).ShowAsync();
        }

    }

    private async void BtnFilterTitle_Click(object? sender, RoutedEventArgs e)
    {
        
        try
        {
            if(cmbTitles.SelectedItem == null) 
            await MessageBoxManager.GetMessageBoxStandard("Client Bookstore Error",
            "You must select a book title", MsBox.Avalonia.Enums.ButtonEnum.Ok ).ShowAsync();

            string title = (string)cmbTitles.SelectedItem!; 
            using ServiceBookstoreClient service = new();
            Book livro = await service.GetBookByTitleAsync(title);

            txtTitle.Text = livro.Title;
            txtAuthor.Text = livro.Author;
            txtYear.Text = livro.Year.ToString();
            txtPrice.Text = livro.Price.ToString();
            cmbBookCategory.SelectedItem = livro.Category;
        }
        catch (System.Exception ex)
        {
            
            await MessageBoxManager.GetMessageBoxStandard("Client Bookstore Error",
            ex.Message, MsBox.Avalonia.Enums.ButtonEnum.Ok ).ShowAsync();
        }
            
            
    }
    

    private void lstBooks_SelectionChanged(object? sender, SelectionChangedEventArgs e)
    {
    }

    private async void BtnClear_Click(object? sender, RoutedEventArgs e)
    {
    }

    private async void BtnDelete_Click(object? sender, RoutedEventArgs e)
    {
    }

    private async void BtnAdd_Click(object? sender, RoutedEventArgs e)
    {
    }
}