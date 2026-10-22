import simulatedFetch from "./modules/simulateHttpRequest.js" // import do default: sem chaves, e o nome é escolhido aqui
import { showArrayOnTable } from "./modules/tables.js" // import nomeado: com chaves

// Limpa as tabelas HTML
showArrayOnTable("data-table-1", [])
showArrayOnTable("data-table-2", [])

const fetchStudents = async () => {
    try {
        const request = await simulatedFetch("students") // chama o default importado, que devolve uma Promise
        const student = request.data // dados da resposta
        console.log("Students: ", student)
        showArrayOnTable("data-table-1", student) // mostra na tabela
        return student
    } catch (error) {
        console.log("Caught an error: " + error.message)
    }
}

console.clear()
fetchStudents()