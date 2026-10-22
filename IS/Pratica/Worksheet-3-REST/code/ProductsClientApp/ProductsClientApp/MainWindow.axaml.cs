using System.Collections.Generic;
using System.Threading.Tasks;
using Avalonia.Controls;
using Avalonia.Interactivity;
using Tmds.DBus.Protocol;

namespace ProductsClientApp;

public partial class MainWindow : Window
{
    private ProductsApiCliente api = new ProductsApiCliente();
    public MainWindow()
    {
        InitializeComponent();
    }

    private async void GetAll_Click(object? sender, RoutedEventArgs e)
    {
        List<Product?> products = await api.GetAll();

        foreach (Product item in products)
        {
            lstProducts.Items.Add($"Id: {item.Id} | {item.Name} | {item.Category} | {item.Price}");
        }

        txtStatus.Text = "API call with producst.";
    }

    private async void BtnGetSpecific_Click(object? sender, RoutedEventArgs e)
    {
        int id = int.Parse(txtSearchId.Text);
        Product result = await api.Get(id);
    }

    private void BtnCreate_Click(object? sender, RoutedEventArgs e)
    {
        // Criar produto.
    }

    private void BtnGetUpdate_Click(object? sender, RoutedEventArgs e)
    {
        // Atualizar produto.
    }

    private void BtnDelete_Click(object? sender, RoutedEventArgs e)
    {
        // Excluir produto.
    }
}