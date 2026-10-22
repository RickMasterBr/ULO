using Microsoft.Data.Sqlite;
using ProductsDatabaseAPI.Models;

public class ProductsDatabase
{
    private readonly string connectionString = "Data Source=Products.db";

    public ProductsDatabase()
    {
        CreateDatabase();
    }

    private void CreateDatabase()
    {
        using var connection = new SqliteConnection(connectionString);
        connection.Open();
        var command = connection.CreateCommand();
        command.CommandText = @"
            CREATE TABLE IF NOT EXISTS Products
            (
                Id INTEGER PRIMARY KEY AUTOINCREMENT,
                Name TEXT NOT NULL,
                Category TEXT NOT NULL,
                Price REAL NOT NULL
            );";
        command.ExecuteNonQuery();
    }

    public List<Product> GetAll()
{
    var list = new List<Product>();
    using SqliteConnection connection = new SqliteConnection(connectionString);
    connection.Open();
    using SqliteCommand command = connection.CreateCommand();
    command.CommandText = "SELECT Id, Name, Category, Price FROM Products";
    using SqliteDataReader reader = command.ExecuteReader();
    while (reader.Read())
    {
        list.Add(new Product {
            Id = reader.GetInt32(0), Name = reader.GetString(1),
            Category = reader.GetString(2), Price = reader.GetDecimal(3) });
    }
    return list;
}

public Product? Get(int id)
{
    using SqliteConnection connection = new SqliteConnection(connectionString);
    connection.Open();
    using SqliteCommand command = connection.CreateCommand();
    command.CommandText = "SELECT Id, Name, Category, Price FROM Products WHERE Id = @id";
    command.Parameters.AddWithValue("@id", id);
    using SqliteDataReader reader = command.ExecuteReader();
    if (!reader.Read()) return null;
    return new Product {
        Id = reader.GetInt32(0), Name = reader.GetString(1),
        Category = reader.GetString(2), Price = reader.GetDecimal(3) };
}

public int Insert(Product prod)
{
    using SqliteConnection connection = new SqliteConnection(connectionString);
    connection.Open();
    using SqliteCommand command = connection.CreateCommand();
    command.CommandText =
    @"
        INSERT INTO Products (Name, Category, Price)
        VALUES (@name, @cat, @price);
        SELECT last_insert_rowid();
    ";
    command.Parameters.AddWithValue("@name", prod.Name);
    command.Parameters.AddWithValue("@cat", prod.Category);
    command.Parameters.AddWithValue("@price", prod.Price);
    return Convert.ToInt32(command.ExecuteScalar());
}

public bool Update(Product prod)
{
    using SqliteConnection connection = new SqliteConnection(connectionString);
    connection.Open();
    using SqliteCommand command = connection.CreateCommand();
    command.CommandText =
    @"
        UPDATE Products
        SET Name = @name, Category = @cat, Price = @price
        WHERE Id = @id
    ";
    command.Parameters.AddWithValue("@name", prod.Name);
    command.Parameters.AddWithValue("@cat", prod.Category);
    command.Parameters.AddWithValue("@price", prod.Price);
    command.Parameters.AddWithValue("@id", prod.Id);

    int numRows = command.ExecuteNonQuery();
    return numRows > 0;
}

public bool Delete(int id)
{
    using SqliteConnection connection = new SqliteConnection(connectionString);
    connection.Open();
    using SqliteCommand command = connection.CreateCommand();
    command.CommandText = "DELETE FROM Products WHERE Id = @id";
    command.Parameters.AddWithValue("@id", id);
    return command.ExecuteNonQuery() > 0;
}

}