const person = {
    firstName: 'Richard',
    lastName: 'Lopes',
    fullName: function () {return `${this.firstName} ${this.lastName}`}
}

console.log(person.fullName());