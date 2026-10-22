namespace OrganizationLib;

public class Manager : Employee
{
    private List<Programmer> programmers;

    public Manager(string firstName, string lastName, DateTime birthDate, double salary)
        : base(firstName, lastName, birthDate, salary)
    {
        programmers = new();
    }

    public int NumberOfProgrammers
    {
        get { return programmers.Count; }
    }

    public Programmer this[int index]
    {
        get { return programmers[index]; }
    }

    public void AddProgrammer(Programmer programmer)
    {
        programmers.Add(programmer);
    }

    public override string Print()
    {
        string output = base.Print();
        output += "Elementos da equipa: " + NumberOfProgrammers + Environment.NewLine;
        foreach (Programmer item in programmers)
        {
            output += "\t" + item.FullName + Environment.NewLine;
        }
        return output;
    }
}
