
/*
console.clear();
console.log(person.fullName());
console.log(person.age());
person.lastName = "Smith";
console.log(person.fullName());

showObjectOnTable("data-table-1", person);
*/

const randomPersonFactory = () => {

    const getRandomElemente = (array) => array[Math.floor(Math.random() * array.length)];

    const person = {
        firstName: getRandomElemente(englishFirstNames),
        lastName: getRandomElemente(englishLastNames),
        new: Date(
            Math.floor(Math.random() * 87) + 1920, // 1920 a 2006
            Math.floor(Math.random() * 12), // mês 0-11
            Math.floor(Math.random() * 28) + 1, // dia 1-28 (por simplicidade)
        ), // 20 de setembro de 1995 (o mês começa em 0)

        fullName: function () {
            return `${this.firstName} ${this.lastName}`;
        },

        age: function () {
            const today = new Date();
            let age = today.getFullYear() - this.dateOfBirth.getFullYear();
            let deltaM = today.getMonth() - this.dateOfBirth.getMonth();
            if (
                deltaM < 0 ||
                (deltaM === 0 && today.getDate() < this.dateOfBirth.getDate())
            ) {
                age--;
            }
            return age;
        },
    };

    return person;

}

const newPerson = randomPersonFactory();
console.log(newPerson);
console.dir(newPerson);
console.table(newPerson);

const clonePersonWithSpread = (person) => {

    return { ...person };

}

const clonePersonWithAssign = (person) => Object.assign({}, person);

const clone1 = clonePersonWithAssign(newPerson);
const clone2 = clonePersonWithSpread(newPerson);

console.log(clone1);
console.log(clone2);

console.log(clone1 === clone2);

const personB = randomPersonFactory();

personB.contacts = {
    email: `${personB.firstName.toLowerCase()}.${personB.lastName.toLowerCase()}@example.com`,
    phone: "923 843 343",
};

personB.children = [`Richard ${personB.lastName}`, `Mary ${personB.lastName}`];

const copiedPersonB1 = clonePersonWithSpread(personB);
const copiedPersonB2 = clonePersonWithAssign(personB);

console.clear();
console.log("personB", personB);
console.log("copiedPersonB1", copiedPersonB1);
console.log("copiedPersonB2", copiedPersonB2);

personB.contacts = "923 392 293";
personB.firstName = "João";
personB.children.push("Daniel Oliveira");

console.log("personB", personB);
console.log("copiedPersonB1", copiedPersonB1);
console.log("copiedPersonB2", copiedPersonB2);


console.clear();

const personD = randomPersonFactory();

personD.contacts = {
    email: `${personD.firstName.toLowerCase()}.${personD.lastName.toLowerCase()}@example.com`,
    phone: "910 111 222",
};

personD.children = [`Pedro ${personD.lastName}`, `Dany ${personD.lastName}`];

const newPersonD = Object.create(personD);

console.log("personD", personD);
console.log("newPersonD", newPersonD);











function createObjFrom(object, overrides = {}) {
    // Passo 1: cria um novo objeto cujo protótipo é object
    const newObj = Object.create(object);

    // Passo 2: copia as propriedades próprias que não são funções
    for (const [key, value] of Object.entries(object)) {
        if (typeof value !== "function") {
            newObj[key] = structuredClone(value);
        }
    }

    // Passo 3: aplica os overrides (dados personalizados)
    Object.assign(newObj, overrides);

    return newObj;
}

console.clear();

const student = randomPersonFactory();

student.id = Math.floor(Math.random() * 9999);

student.course = courseNames[Math.floor(Math.random() * courseNames.length)];

student.disciplines = disciplineNames.map((discipline) => {
    return {
        name: discipline,
        grade: Math.random() < 0.2 ? null : Math.floor(Math.random() * 11) + 10, // 10 a 20, ou null
    };
});

student.averageGrade = function () {
    const passed = this.disciplines.filter((d) => d.grade !== null);
    return passed.reduce((acc, d) => acc + d.grade, 0) / passed.length;
};

console.log(student);
console.log(student.averageGrade());

const studentsArray = [];

for (let i = 0; i < 2; i++) {
    studentsArray.push(createObjFrom(student));
}

console.clear();
console.log(student);
console.log(studentsArray[1].disciplines[0].grade);

studentsArray[1].firstName = "Ann";
studentsArray[1].disciplines[0].grade = 20;

console.log(studentsArray);