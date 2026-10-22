namespace ProductsAPI;

public class Product
{
    public int Id { get; set; } // identificador único do produto
    public string Name { get; set; } = ""; // nome do produto
    public string Category { get; set; } = ""; // categoria do produto
    public decimal Price { get; set; } // preço
}