const formulario = document.querySelector("#formulario");
const inputId = document.querySelector("#usuario-id");
const botaoBuscar = document.querySelector("#botao-buscar");
const mensagem = document.querySelector("#mensagem");
const resultado = document.querySelector("#resultado");
const nome = document.querySelector("#nome");
const email = document.querySelector("#email");

async function getUser(id) {
    const response = await fetch(`/api/usuarios/${id}`)

    const dados = await response.json()

    if (!responde.ok){
        throw new Error(dados.mensagem || "não foi possivel encontrar o usuario")
    }

    return dados;
}