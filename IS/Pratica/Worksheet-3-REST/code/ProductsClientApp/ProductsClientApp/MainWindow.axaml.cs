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

        txtStatus.Text = "API call with products.";
    }

    private async void BtnGetSpecific_Click(object? sender, RoutedEventArgs e)
    {
        int id = int.Parse(txtSearchId.Text);
        Product result = await api.Get(id);
    }

    private async void BtnCreate_Click(object? sender, RoutedEventArgs e)
    {
        if (txtName.Text == "" || txtCategory.Text == "")
        {
            txtStatus.Text = "Empty fields! You need to define a name and category.";
            return;
        }

        if (!decimal.TryParse(txtPrice.Text, out decimal myPrice))
        {
            txtStatus.Text = "Price field incorrect!";
        }

        Product prod = new()
        {
            Id = 0,
            Name = txtName.Text,
            Category = txtCategory.Text,
            Price = myPrice
        };

        Product? p = await api.Create(prod);

        if( p == null)
        {
            
        }

    }

    private async void BtnGetUpdate_Click(object? sender, RoutedEventArgs e)
    {

        if(!int.TryParse(txtId.Text, out int idProd))
        {
            txtStatus.Text = "You must enter a valid Id Prod";
            return;
        }

        if (txtName.Text == "" || txtCategory.Text == "")
        {
            txtStatus.Text = "Empty fields! You need to define a name and category.";
            return;
        }

        if (!decimal.TryParse(txtPrice.Text, out decimal myPrice))
        {
            txtStatus.Text = "Price field incorrect!";
        }

        Product prod = new()
        {
            Id = idProd,
            Name = txtName.Text,
            Category = txtCategory.Text,
            Price = myPrice
        };

        Product? p = await api.Update(idProd, prod);

        if( p == null)
        {
            txtStatus.Text = "Product was not updated";
        } else
        {
            txtStatus.Text = "Product updated";
        }

    }

    private async void BtnDelete_Click(object? sender, RoutedEventArgs e)
    {
        
        if(!int.TryParse(txtId.Text, out int idProd))
        {
            txtStatus.Text = "You must enter a valid Id Prod";
            return;
        }

        bool result = await api.Delete(idProd);

        if (result)
        {
            txtStatus.Text = "Product deleted";
        } else
        {
            txtStatus.Text = "Product was not deleted";
        }

    }
}