using Avalonia.Controls;
using Avalonia.Interactivity;
using ServiceReference;
using System;

namespace GlobalHolidaysClient;

public partial class MainWindow : Window
{
    public MainWindow()
    {
        InitializeComponent();
        numericUpDownYear.Value = DateTime.Today.Year;
        Holiday[] feriados = await service.GetAllHolidaysAsync(year);

        listBoxHoliday.Items.Clear();
        foreach (Holiday item in feriados){
            listBoxHoliday.Items.Add($"{item.Date:yyyy-MM-dd} - {item.Name} - {item.Description}");
        }
    }

    private async void GetServiceButton_Click(object? sender, RoutedEventArgs e)
    {
        using HolidaySoapClient service = new HolidaySoapCliente();

        int year = (int)numericUpDownYear.Value;
    }
}