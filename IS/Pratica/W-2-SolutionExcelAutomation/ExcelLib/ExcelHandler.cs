namespace ExcelLib;

using DocumentFormat.OpenXml.Bibliography;
using DocumentFormat.OpenXml.Packaging;
using DocumentFormat.OpenXml.Presentation;
using DocumentFormat.OpenXml.Spreadsheet;
using OfficeOpenXml; // EPPlus

public class ExcelHandler
{

    // boll = vai devolver true ou false.
    // string filePath = parametro do caminho onde o arquivo vai ser salvo.

    public static (bool Success, string Msg) CreateNewExcelFile(string filepath) {
        
        // Tenta criar o arquivo Excel; se falhar, o erro é tratado no catch
        
        try
        {

            using SpreadsheetDocument document = SpreadsheetDocument.Create(filepath,
            DocumentFormat.OpenXml.SpreadsheetDocumentType.Workbook);

            WorkbookPart workbookPart = document.AddWorkbookPart();
            workbookPart.Workbook = new Workbook();

            WorksheetPart worksheetPart = workbookPart.AddNewPart<WorksheetPart>();
            worksheetPart.Worksheet = new Worksheet(new SheetData());

            Sheets sheets = workbookPart.Workbook.AppendChild(new Sheets());

            Sheet sheet = new Sheet{
                Id = workbookPart.GetIdOfPart(worksheetPart),
                SheetId = 1,
                Name = "IS"
            };

            sheets.Append(sheet);

            workbookPart.Workbook.Save();



            return (true, $"Excel File created sucesfully: {filepath}");
        }
        catch (System.Exception ex)
        {
            
            return (false, ex.Message);
        }








    }



    public static (bool Success,  string Msg) WriteExcelFile(string filename){
        try
        {
            using SpreadsheetDocument document = SpreadsheetDocument.Open(filename, true);

            WorkbookPart workbookPart = document.WorkbookPart!;

            WorksheetPart worksheetPart = workbookPart.WorksheetParts.First();

            SheetData sheetData = worksheetPart.Worksheet?.GetFirstChild<SheetData>()!;

            Row row1 = new Row();
            row1.Append(CreateTextCell("A1", "Name"), CreateTextCell("B1", "Age"));
            sheetData.Append(row1);

            Row row2 = new Row();
            row2.Append(CreateTextCell("A2", "Richard"), CreateNumberCell("B2", "20"));
            sheetData.Append(row2);

            worksheetPart.Worksheet?.Save(); // "??" para caso seja nulo




            return (true, $"Excel file written successfully: {filename}");
        }
        catch (System.Exception ex)
        {
            
            return(false, ex.Message);
        }
    }


    private static Cell CreateTextCell(string reference, string text){

        return new Cell{
            CellReference = reference,
            CellValue = new CellValue(text),
            DataType = CellValues.String
        };

    }

    private static Cell CreateNumberCell(string reference, string number){

        return new Cell {
            CellReference = reference,
            CellValue = new CellValue(number),
            DataType = CellValues.Number
        };
    }



    public static (bool Success, string Msg) ReadExcelFile (string filename) {

        string output = ""; // Ou String.Empty

        try
        {

            using SpreadsheetDocument document = SpreadsheetDocument.Open(filename, false);

            WorkbookPart? workbookPart = document.WorkbookPart;
            if (workbookPart == null)
                return(false, "Workbook not found");

            WorksheetPart? worksheetPart = workbookPart.WorksheetParts.FirstOrDefault();
            if (worksheetPart == null)
                return(false, "Workhsheet not found");

            SheetData? sheetData = worksheetPart?.Worksheet?.GetFirstChild<SheetData>();  
            if (sheetData == null)
                return(false, "Worksheet is empty"); 


            foreach(Row row in sheetData.Elements<Row>()){

                foreach(Cell cell in row.Elements<Cell>()){

                    output += $"Cell {cell.CellReference} : {cell.CellValue}";
                }
            }


            return (true, output);
            
        }
        catch (System.Exception ex)
        {
            
            return (false, ex.Message);
        }
    }

    public static (bool Success, string Msg) CreateChart(string filename)
{
    try
    {
        // Licença não comercial: chamar uma vez, antes de criar qualquer ExcelPackage
        ExcelPackage.License.SetNonCommercialPersonal("IS");

        using var package = new ExcelPackage(new FileInfo(filename));

        var worksheet = package.Workbook.Worksheets.Add("Vendas");

        worksheet.Cells["A1"].Value = "Month";
        worksheet.Cells["B1"].Value = "Value";
        worksheet.Cells["A2"].Value = "JAN";
        worksheet.Cells["B2"].Value = 1000;   // número, sem aspas

        worksheet.Drawings.Clear();                                         // remove desenhos/gráficos antigos da aba
        var chart = worksheet.Drawings.AddLineChart("chart1", eLineChartType.Line);  // cria o gráfico de linha, com nome
        chart.SetPosition(5, 0, 0, 0);                                      // linha 5, offset 0 px, coluna 0, offset 0 px
        chart.SetSize(400, 300);                                            // largura x altura, em pixels
        chart.Series.Add(worksheet.Cells["B2:B4"], worksheet.Cells["A2:A4"]);  // (valores, categorias)



        package.Save();
        return (true, "Chart file saved.");
    }
    catch (Exception ex)
    {
        return (false, ex.Message);
    }
}


}
