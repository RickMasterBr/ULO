namespace OrganizationLib;

public class Programmer : Employee
{
    public Programmer(string firstName, string lastName, DateTime birthDate, double salary)
        : base(firstName, lastName, birthDate, salary)
    {
    }
}
