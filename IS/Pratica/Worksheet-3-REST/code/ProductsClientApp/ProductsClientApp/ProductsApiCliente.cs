using System.Collections.Generic;
using System.Net.Http;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace ProductsClientApp;

public class ProductsApiCliente
{
    private static string BASE_URL = "http://localhost:5004/api/v3/";

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
        using HttpResponseMessage response =
            await httpClient.GetAsync("products");

        if (!response.IsSuccessStatusCode)
            return null;

        string json = await response.Content.ReadAsStringAsync();

        return JsonSerializer.Deserialize<List<Product>>(json);
    }

    public async Task<Product?> Get(int id)
    {
        using HttpResponseMessage response =
            await httpClient.GetAsync($"products/{id}");

        if (!response.IsSuccessStatusCode)
            return null;

        string json = await response.Content.ReadAsStringAsync();

        return JsonSerializer.Deserialize<Product>(json);
    }

    public async Task<Product?> Create(Product product)
    {
    string json = JsonSerializer.Serialize(product);

    using StringContent content =
        new StringContent(json, Encoding.UTF8, "application/json");

    using HttpResponseMessage response =
        await httpClient.PostAsync("products", content);

    if (!response.IsSuccessStatusCode)
        return null;

    string responseJson = await response.Content.ReadAsStringAsync();

    return JsonSerializer.Deserialize<Product>(responseJson);
    }

    public async Task<Product?> Update(int id, Product product)
    {
        string json = JsonSerializer.Serialize(product);

        using StringContent content =
            new StringContent(json, Encoding.UTF8, "application/json");

        using HttpResponseMessage response =
            await httpClient.PutAsync($"products/{id}", content);

        if (!response.IsSuccessStatusCode)
            return null;

        string responseJson = await response.Content.ReadAsStringAsync();

        return JsonSerializer.Deserialize<Product>(responseJson);
    }

    public async Task<bool> Delete(int id)
    {
        using HttpResponseMessage response =
            await httpClient.DeleteAsync($"products/{id}");

        return response.IsSuccessStatusCode;
    }
}