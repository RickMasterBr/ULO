var x = 1 // function scope
let y = 2 // block scope
const z = 3 // block scope, não pode ser redeclarada

console.log(x);
console.log(y);
console.log(z);

let a = "21"
let b = 21

console.log(a, b);

if (a !== b) console.log(a, b, "são diferentes");
if (a == b) console.log(a, b, "são iguais");

c = null

d = c ?? 'default'
console.log(d);