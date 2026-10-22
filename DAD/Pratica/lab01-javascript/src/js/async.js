"use strict";

showArrayOnTable('data-table-1', [])
showArrayOnTable('data-table-2', [])

/*
console.log("start");

const fetchStudents = () => {
    const filterCourse = "Computer Science" // variável do escopo de fetchStudents
    simulateHttpRequest("students")
        .then((response) => {
            const students = response.data.filter(
                (element) => element.grade >= 10 && element.course === filterCourse, // usa filterCourse, que não é parâmetro
            )
            console.log("Students: ", students)
        })
        .catch((error) => {
            console.log("Caught an error: " + error.message)
        })
}

fetchStudents();

console.log("end");

console.clear();
*/





/*
const getPersonObject = () => {
    let firstName = "John" // dados privados, fora do objeto devolvido
    let lastName = "Doe"
    let dateOfBirth = new Date(1995, 8, 20)

    return {
        fullName: () => `${firstName} ${lastName}`, // método que lê as variáveis da closure
        age: () => {
            const today = new Date()
            let age = today.getFullYear() - dateOfBirth.getFullYear() // diferença de anos
            let deltaM = today.getMonth() - dateOfBirth.getMonth() // diferença de meses
            if (deltaM < 0 || (deltaM === 0 && today.getDate() < dateOfBirth.getDate())) {
                age-- // ainda não fez anos este ano
            }
            return age
        },
    }
}

const person = getPersonObject();
console.log(person.fullName());
console.log(person.age());

*/

console.clear();

/*
console.log("START")

const promise = simulateHttpRequest("students") // dispara o pedido e devolve logo uma Promise

promise.then((response) => { // corre se a Promise for resolvida (sucesso)
    const students = response.data // os dados vêm em response.data
    console.log("Students: ", students)
    showArrayOnTable("data-table-1", students) // mostra na tabela
})
  
console.log("AFTER simulateHttpRequest call") // aparece antes da resposta
*/






/*
const fetchStudents = async () => { // async: a função devolve sempre uma Promise
    try {
        const request = await simulateHttpRequest("students") // espera a Promise resolver antes de seguir
        const student = request.data // dados da resposta
        console.log("Students: ", student)
        showArrayOnTable("data-table-1", student)
        return student // vira o valor com que a Promise da função resolve
    } catch (error) { // se a Promise for rejeitada, cai aqui
        console.log("Caught an error: " + error.message)
    }
}

const resultOfAsyncFunction = fetchStudents() // sem await: devolve uma Promise, não o array
console.log("Result of fetchStudents async function: ", resultOfAsyncFunction)
console.log("AFTER fetchStudents call") // executa antes de fetchStudents terminar
*/

/*

let price = null
let finalPrice = null

simulateHttpRequest("price", null, 200) // demora 200ms
  .then((response) => {
    price = response.data // só preenche price quando a resposta chega
  })

simulateHttpRequest("addtaxes", price) // corre já, price ainda é null
  .then((response) => {
    finalPrice = response.data
  })
    */






    
void (async () => {
    try {
        let response = await simulateHttpRequest("something?a=1&b=2", null, 190) // espera 190ms
        console.log("something?a=1&b=2", response.data)

        response = await simulateHttpRequest("students?size=50", null, 200) // só começa depois do anterior: +200ms
        console.log("students?size=50", response.data)

        response = await simulateHttpRequest("anotherthing", null, 130) // só começa depois: +130ms
        console.log("anotherthing", response.data)
    } catch (error) {
        console.log("Caught an error on step: " + error.message)
    }
})()