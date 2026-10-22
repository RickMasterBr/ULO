using Avalonia.Controls;
using Avalonia.Interactivity;
using MsBox.Avalonia;
using MsBox.Avalonia.Enums;

namespace ExcelDesktopApp;

using ExcelLib;

public partial class MainWindow : Window
{
    private string filename = "default.xlsx";

    public MainWindow()
    {
        InitializeComponent();
    }

    private async void CreateExcel_Click(object? sender, RoutedEventArgs e)
    {
        filename = string.IsNullOrWhiteSpace(txtFileName.Text) ? "default.xlsx" : txtFileName.Text;

        var result = ExcelHandler.CreateNewExcelFile(filename);
        if (!result.Success)
            txtOutput.Text = $"Error creating excel file: {result.Msg}";
        else
            txtOutput.Text = $"Excel file created: {result.Msg}";

        await MessageBoxManager
            .GetMessageBoxStandard("Excel Automation", result.Msg, ButtonEnum.Ok)
            .ShowAsync();
    }

    private void WriteExcel_Click(object? sender, RoutedEventArgs e)
    {
        filename = string.IsNullOrWhiteSpace(txtFileName.Text) ? "default.xlsx" : txtFileName.Text;

        var result = ExcelHandler.WriteExcelFile(filename);
        if (!result.Success)
            txtOutput.Text = $"Error: {result.Msg}";
        else
            txtOutput.Text = $"Success: {result.Msg}";
    }

    private void ReadExcel_Click(object? sender, RoutedEventArgs e)
    {
        filename = string.IsNullOrWhiteSpace(txtFileName.Text) ? "default.xlsx" : txtFileName.Text;

        var result = ExcelHandler.ReadExcelFile(filename);
        if (!result.Success)
            txtOutput.Text = $"Error: {result.Msg}";
        else
            txtOutput.Text = result.Msg;   // no Read, o Msg já é o conteúdo das células
    }
}