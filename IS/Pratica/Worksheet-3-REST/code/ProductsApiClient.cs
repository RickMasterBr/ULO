using System;
using System.Buffers.Text;
using System.Collections.Generic;
using System.Net.Http;
using System.Net.Http.Headers;
using System.Net.Http.Json;
using System.Reflection.Metadata.Ecma335;
using System.Text;
using System.Text.Json;
using System.Threading.Tasks;

namespace ProductsClientApp;

public class ProductsApiClient
{
    private readonly HttpClient httpClient;
    private static string BASE_URL = "http://localhost:5140/api/v3/";   // NEEDS TO BE UPDATED

    public ProductsApiClient()
    {
        httpClient = new HttpClient()
        {
            BaseAddress = new Uri(BASE_URL)
        };
    }

    public async Task<List<Product>?> GetAll()
    {
        throw new NotImplementedException();
    }

    public async Task<Product?> Get(int id)
    {
        throw new NotImplementedException();
    }

    public async Task<Product?> Create(Product product)
    {
        throw new NotImplementedException();
    }

    public async Task<Product?> Update(Product product)
    {
        throw new NotImplementedException();
    }

    public async Task<bool> Delete(int id)
    {
        throw new NotImplementedException();
    }
}
