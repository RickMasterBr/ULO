using Microsoft.AspNetCore.Mvc;
using ProductsDatabaseAPI.Models;

namespace ProductsDatabaseAPI.Controllers;

[ApiController]
public class ProductsController : ControllerBase
{
    private readonly ProductsDatabase db;

    public ProductsController(ProductsDatabase repository)
    {
        db = repository;
    }

    [HttpGet("/api/v3/products")]
    public IActionResult GetAllProducts()
    {
        return Ok(db.GetAll());
    }

    [HttpGet("/api/v3/products/{id:int}")]
    public IActionResult GetProductById(int id)
    {
        Product? result = db.Get(id);
        if (result == null)
            return NotFound();
        return Ok(result);
    }

    [HttpPost("/api/v3/products")]
    public IActionResult PostProduct(Product product)
    {
        int idNewProd = db.Insert(product);
        product.Id = idNewProd;
        return Created($"/api/v3/products/{idNewProd}", product);
    }

    [HttpDelete("/api/v3/products/{id:int}")]
    public IActionResult DeleteProduct(int id)
    {
        if (!db.Delete(id))
        {
            return NotFound();
        }
        return NoContent();
    }

    [HttpPut("/api/v3/products/{id:int}")]
    public IActionResult PutProduct(int id, Product product)
    {
        Product? prod = db.Get(id);
        if (prod == null)
        {
            return NotFound();
        }

        product.Id = id;
        db.Update(product);

        return Ok(product);
    }
}