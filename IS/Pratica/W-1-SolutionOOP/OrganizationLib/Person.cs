namespace OrganizationLib;

public abstract class Person
{
    private string _firstName = string.Empty;
    private string _lastName = string.Empty;
    private DateTime _birthDate = new(1900, 1, 1);

    public Person(string firstName, string lastName, DateTime birthDate)
    {
        _firstName = firstName;
        _lastName = lastName;
        _birthDate = birthDate;
        Gender = GenderType.Undefined;
    }

    public string FullName => _firstName + " " + _lastName;

    public int Age
    {
        get
        {
            int age = DateTime.Today.Year - _birthDate.Year;
            if (DateTime.Today.Month < _birthDate.Month)
            {
                age--;
            }
            return age;
        }
    }

    public DateTime Birthdate
    {
        get => _birthDate;
        set => _birthDate = value;
    }

    public GenderType Gender { get; set; }

    public virtual string Print()
    {
        string output = string.Empty;
        output += "Nome completo: " + FullName + Environment.NewLine;
        output += "Idade: " + Age + Environment.NewLine;
        output += "Data de nascimento: " + Birthdate + Environment.NewLine;
        output += "Género: " + Gender + Environment.NewLine;
        return output;
    }
}
