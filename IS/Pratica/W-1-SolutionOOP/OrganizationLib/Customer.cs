namespace OrganizationLib;

public class Customer : Person
{
    public string Address { get; set; }

    public Customer(string firstName, string lastName, DateTime birthDate, string address)
        : base(firstName, lastName, birthDate)
    {
        Address = address;
    }

    public override string Print()
    {
        string output = base.Print();
        output += "Morada: " + Address + Environment.NewLine;
        return output;
    }
}
