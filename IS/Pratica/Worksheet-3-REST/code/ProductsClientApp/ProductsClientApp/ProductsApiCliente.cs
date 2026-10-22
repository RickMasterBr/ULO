using System.Collections.Generic;
using System.Net;
using System.Net.Http;
using System.Text.Json;
using System.Threading.Tasks;

namespace ProductsClientApp;

public class ProductsApiCliente
{
    private static string BASE_URL = "http://localhost:5004/api/v3";

    private readonly HttpClient httpClient;

    public ProductsApiCliente()
    {
        httpClient = new HttpClient()
        {
            BaseAddress = new System.Uri(BASE_URL)
        };
    }

    public async Task<List<Product>?> GetAll()
    {
        using HttpResponseMessage response = await httpClient.GetAsync("products");

        if(response.IsSuccessStatusCode)
            return null;

        string json =await response.Content.ReadAsStringAsync();
        return JsonSerializer.Deserialize<List<Product>>(json);
    }

    public async Task<List<Product>?> Get(int id)
    {
        using HttpResponseMessage response = await httpClient.GetAsync($"products/{id}")
    }





}