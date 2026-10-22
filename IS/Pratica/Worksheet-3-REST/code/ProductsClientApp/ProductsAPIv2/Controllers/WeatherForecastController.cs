using Microsoft.AspNetCore.Mvc; 
using ProductsAPIv2.Models; 
 
namespace ProductsAPIv2.Controllers; 
 
[ApiController] 
public class ProductsController : ControllerBase     
{ 
 
    static List<Product> products = new () 
    { 
    new Product { Id = 1, Name = "Tomato Soup", Category = "Groceries", Price = 1 }, 
    new Product { Id = 2, Name = "Yo-yo", Category = "Toys", Price = 3.75m }, 
    new Product { Id = 3, Name = "Hammer", Category = "Hardware", Price = 16.99m }, 
    }; 
 
    [HttpGet("/api/v2/products")] 
    public IActionResult GetAll() 
    { 
        return Ok(products); 
    } 
 
    [HttpGet("/api/v2/products/{id:int}")]
public IActionResult GetById(int id)
{
    var product = products.FirstOrDefault(p => p.Id == id);
    if (product is null) return NotFound();
    return Ok(product);
}

// exercício 3.5: produtos por categoria
[HttpGet("/api/v2/products/{category}")]
public IActionResult GetByCategory(string category)
{
    var list = products.Where(p => p.Category.Equals(category, StringComparison.OrdinalIgnoreCase)).ToList();
    return Ok(list);
}

[HttpPost("/api/v2/products")]
public IActionResult Create([FromBody] Product product)
{
    product.Id = products.Count == 0 ? 1 : products.Max(p => p.Id) + 1;
    products.Add(product);
    return CreatedAtAction(nameof(GetById), new { id = product.Id }, product); // 201
}

[HttpPut("/api/v2/products/{id:int}")]
public IActionResult Update(int id, [FromBody] Product product)
{
    var existing = products.FirstOrDefault(p => p.Id == id);
    if (existing is null) return NotFound();
    existing.Name = product.Name;
    existing.Category = product.Category;
    existing.Price = product.Price;
    return NoContent(); // 204
}

[HttpDelete("/api/v2/products/{id:int}")]
public IActionResult Delete(int id)
{
    var existing = products.FirstOrDefault(p => p.Id == id);
    if (existing is null) return NotFound();
    products.Remove(existing);
    return NoContent(); // 204
}
}