function add1 (a,b ){
    return a+b;
}

const add2 = function(a,b){
    return a+b;
}

const add3 = (a,b) =>{
    return a+b;
}

const add4 = (a,b) => a+b;

console.dir(add1)
console.dir(add3)

console.log(add1(1,2))
console.log(add2(1,2))
console.log(add3(1,2))
console.log(add4(1,2))

console.clear();


const obj = {
  name: "Alice",
  age: 30,

  greet: function () {
    return `Hello, my name is ${this.name} and I am ${this.age} years old.`;
  },

  farewell() {
    return `Goodbye from ${this.name}!`;
  },

  greetAgain: () => {
    return `Hello again from ${this.name}, I'm ${this.age} years old!`;
  },
};

console.clear();
console.log(obj.greet());
console.log(obj.farewell());
console.log(obj.greetAgain());


function globalTest1() {
  console.log(this);
}

const globalTest2 = () => {
    // call bind -- scope = window
  console.log(this); 
};

const globalTest3 = () => {
    // call bind -- scope = window
  console.log(this);
};

console.clear();
globalTest1(); // call bind -- scope = window
globalTest2();
globalTest3();

const obj2 = {
    a:globalTest1(),
    b:globalTest2,
};

obj2.a() // call bind -- scope bj2
obj2.b()










const student = {
  id: "20250323",
  name: "John Smith",
  course: "Computer Science",
  grades: [
    { discipline: "Mathematics", grade: 8 },
    { discipline: "Physics", grade: 12 },
    { discipline: "English", grade: 14 },
    { discipline: "Programming 1", grade: 18 },
  ],

  reportGrade1() {
    return this.grades.map(
      (item) =>
        this.id + " | " + this.name + " | " + item.discipline + " | " + item.grade,
    );
  },

  reportGrade2() {
    return this.grades.map(function (item) {
        console.log(this)
      return (
        this.id + " | " + this.name + " | " + item.discipline + " | " + item.grade
      );
    });
  },
};

console.clear();
console.log(student.reportGrade1());
console.log(student.reportGrade2());












const sqr1 = function (x) {
  return x ** 2;
};
const sqr2 = (x) => x ** 2;
const sqr3 = (function (x) {
  return x ** 2;
})(3);
const sqr4 = ((x) => x ** 2)(4);

console.clear();
console.log(typeof sqr1, " | ", sqr1);
console.log(typeof sqr2, " | ", sqr2);
console.log(typeof sqr3, " | ", sqr3);
console.log(typeof sqr4, " | ", sqr4);