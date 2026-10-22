using System;
using System.Text.Json.Serialization;

namespace ProductsClientApp;

public class Product
{
   [JsonPropertyName("id")]
   public int Id {get;set;}

   [JsonPropertyName("name")]
   public string? Name {get;set;}

   [JsonPropertyName("category")]
   public string? Category {get;set;}

   [JsonPropertyName("price")]
   public decimal Price {get;set;}
}
