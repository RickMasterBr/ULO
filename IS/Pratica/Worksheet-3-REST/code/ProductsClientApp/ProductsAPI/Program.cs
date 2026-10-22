using ProductsAPI;

var builder = WebApplication.CreateBuilder(args);
var app = builder.Build();

List<Product> products = new List<Product>() // "banco" em memória
{
    new Product { Id = 1, Name = "Tomato Soup", Category = "Groceries", Price = 1 },
    new Product { Id = 2, Name = "Yo-yo", Category = "Toys", Price = 3.75m },
    new Product { Id = 3, Name = "Hammer", Category = "Hardware", Price = 16.99m },
};

app.MapGet("/", () => "IS - Minimal API {products}");
app.MapGet("/api/products", GetProducts);
app.MapGet("/api/products/{id:int}", GetProductsById);
app.MapPost("/api/products", CreateProduct);
app.MapPut("/api/products/{id:int}", UpdateProduct); // PUT: atualiza o produto com esse id
app.MapDelete("/api/products/{id:int}", DeleteProduct);

app.Run();

IResult GetProducts()
{
    return Results.Ok(products);
}

IResult GetProductsById(int id)
{
    return products.FirstOrDefault(p => p.Id == id) is Product prod ? Results.Ok(prod) : Results.NotFound();
}

IResult CreateProduct(Product prod)
{
    prod.Id = products.Max(p => p.Id) + 1;
    products.Add(prod);
    return Results.Created($"/api/products/{prod.Id}", prod);
}

IResult UpdateProduct(int id, Product updated) // id vem da rota, updated vem do corpo (JSON)
{
    var prod = products.FirstOrDefault(p => p.Id == id); // procura o produto pelo id
    if (prod is null) // não existe
    {
        return Results.NotFound(); // 404
    }

    prod.Name = updated.Name; // troca o nome
    prod.Category = updated.Category; // troca a categoria
    prod.Price = updated.Price; // troca o preço
    return Results.NoContent(); // 204: atualizou, sem corpo na resposta
}

IResult DeleteProduct(int id) // id vem da rota
{
    var prod = products.FirstOrDefault(p => p.Id == id); // procura o produto pelo id
    if (prod is null) // não existe
    {
        return Results.NotFound(); // 404
    }

    products.Remove(prod);
    return Results.NoContent();



}