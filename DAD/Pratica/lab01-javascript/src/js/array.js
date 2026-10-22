
// declarando variavel com let (está fora de escopo, existe em todo o arquivo)
let array = []

for (let i = 0; i < 100; i++) {

    // push = metodo de array que adiciona um elemento no final dele
    // Math.random = gera um numero entre 0 e 1
    // Math.floor = arredonda a multiplicação pra baixo, o resultado vira entre 0 e 20
    array.push(Math.floor(Math.random() * 21))

}

// item 1 = adicionar Z no final do Array

array.push("Z")

// item 2 = adicionar A no inicio do array

array.unshift("A")

// Item 3 =  remover o elemento na terceria posição (Indice 2)

array.splice(2, 1) // remove 1 elemento a partir do indice 2. (3° posição)

// Item 4 = imprimir no console o tamanho do array

console.log(array.length)

// item 5 = imprimir o valor do ultimo elemento e removê-lo

console.log(array.pop()) // ele remove o ultimo elemento e retornar o valor removido

// item 6 = imprimir o valor do primeiro elemento e removê-lo do array

console.log(array.shift()) // remove o primeiro elemento e também retornar o valor do mesmo

// item 7 = converte o array numa string com 3 formatos diferentes de separador (se nao passar nada, usa virgula por padrão)

console.log(array.join()) // 2,5,7,23,...
console.log(array.join(", ")) // 2, 5, 7, 23, ...
console.log(array.join(" -- ")) // 2 -- 5 -- 7 -- 23 -- ...

// item 8 = imprime o indice do primeiro elemento cujo valor é 20, testando de varias formas.

console.log(array.indexOf(20)) // versão normal
console.log(array.indexOf('20')) // vai retornar false (-1), pois é comparação estrita (===), e '20' é string
console.log(array.indexOf(23)) // depende de ter numero 23 no array
console.log(array.indexOf(0)) // depende se existe 0 no array

// item 9 = imprime o indice do ultimo elemento cujo valor é 20, testando de varias formas.

console.log(array.lastIndexOf(20))
console.log(array.lastIndexOf('20')) // -1 — mesma questão de igualdade estrita do item 8
console.log(array.lastIndexOf(23))
console.log(array.lastIndexOf(0))

// item 10 = criar 3 novos array com conteudo copiado do original, o slice corta e retornar um novo array

const copy1 = array.slice(5, 15)
const copy2 = array.slice(30, 35)
const copy3 = array.slice(80, 90)

console.log(array)
console.log(copy1)
console.log(copy2)
console.log(copy3)

// item 11 = juntar os 3 arrays do item anterior em 1 só, com 25 elementos, de duas formas diferentes

// item 11.1 = com concat(): metodo que junta arrays retornando um novo array, sem alterar os originais

const merged1 = copy1.concat(copy2, copy3)
console.log(merged1)

//item 11.2 = com spread syntax (...): espalha os elementos de um array dentro de um novo, NÃO embaralha apenas desempacota
const merged2 = [...copy1, ...copy2, ...copy3]
console.log(merged2)

// item 12 = criar um novo array igual ao original (numeros entre 0-20), mas só com 20 elemntos
// depois, substituir 5 elementos a partir do indice 3, pelos elementos 'a' 'b' 'c'

let array2 = []
for (let i = 0; i < 20; i++) {
    array2.push(Math.floor(Math.random() * 21))
}

array2.splice(3, 5, 'a', 'b', 'c') // remove 5 itens a partir do indice 3, e insere os 3 elementos no lugar
console.log(array2)

// item 13 = remove 7 elementos a partir do indice 4 do array anterior

array2.splice(4, 7)
console.log(array2)
console.log(array2.length)

// Ponto 13/14 = array de 100 estudantes + achar índice do primeiro com uma grade específica

let arrStudents = createArrayOfStudents(100)
showArrayOnTable("data-table-1", arrStudents)
console.log(arrStudents)

// versão 1: for loop tradicional
const findFirstIndexByGrade1 = (array, grade) => {
    for (let index = 0; index < array.length; index++) {
        const student = array[index]        // colchetes, não parênteses
        if (student.grade === grade) {      // === em vez de ==
            return index
        }
    }
    return -1
}

// versão 2: estilo funcional, usando findIndex com callback
const findFirstIndexByGrade2 = (array, grade) => {
    return array.findIndex((student) => student.grade === grade)
}

console.log(findFirstIndexByGrade1(arrStudents, 15))
console.log(findFirstIndexByGrade2(arrStudents, 15))


console.clear();






const mappedStudents = arrStudents.map(student=>{

    const newStudent = {...student};
    student.status = student.grade >=10 ? "aproved" : "not aproved";
    return student;
})







