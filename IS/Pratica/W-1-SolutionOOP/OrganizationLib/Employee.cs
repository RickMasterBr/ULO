namespace OrganizationLib;

public abstract class Employee : Person
{
    private double salary;

    public virtual double Salary
    {
        get { return salary; }
        private set { salary = value; }
    }

    public Employee(string firstName, string lastName, DateTime birthDate, double salary)
        : base(firstName, lastName, birthDate)
    {
        this.salary = salary;
    }

    public override string Print()
    {
        string output = base.Print();
        output += "Salário: " + Salary + Environment.NewLine;
        return output;
    }
}
