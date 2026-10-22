using OrganizationLib;

Customer c = new("Marisa", "Maximiano", new DateTime(2000, 12, 25), "Leiria");
c.Address = "Leiria, Portugal";
c.Gender = GenderType.Feminine;
Console.WriteLine(c.Print());

Programmer p1 = new("Antonio", "Silva", new DateTime(2001, 1, 30), 1500);
Console.WriteLine(p1.Print());

Manager m = new("Rita", "Fonseca", new DateTime(1995, 2, 2), 2300);
m.AddProgrammer(p1);
m.AddProgrammer(new Programmer("Rui", "Jorge", new DateTime(2005, 6, 12), 1350));
Console.WriteLine(m.Print());

Console.WriteLine(m[1].Print());
