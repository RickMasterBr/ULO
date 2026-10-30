<template>
    <div>
        <!-- 1. Reatividade básica com ref e reactive -->
        <h1>{{ hello }}</h1>
        <p>Contador: {{ counter.value }}</p>
        <button v-on:click="increase">Aumentar (+)</button>
        <button @click="decrease">Diminuir (-)</button>
        
        <!-- 2. Dados obtidos da API Laravel -->
        <div>
            <h2>API: {{ APIMetadata.name }}</h2>
            <h2>Versão: {{ APIMetadata.version }}</h2>
        </div>

        <hr>

        <!-- 3. Seção WebSockets -->
        <div>
            <h1>WebSockets</h1>
            <p><strong>Connection: </strong>{{ isConnected ? 'Connected' : 'Disconnected' }}</p>
            <p>
                <strong>Message: </strong>
                <!-- v-model sincroniza o input diretamente com a variável reativa 'message' -->
                <Input v-model="message" type="text" placeholder="Digite uma mensagem..."></Input>
                <!-- @click chama a função sendMessage() ao clicar -->
                <Button @click="sendMessage">Send</Button>
            </p>
            <!-- Exibe o que o servidor Node.js devolveu via evento 'echo' -->
            <p><strong>Received: </strong>{{ received }}</p>
        </div>
    </div>
</template>

<script setup>

import Button from "@/components/ui/button/Button.vue"
import Input from "@/components/ui/input/Input.vue"

import { ref, reactive, inject, onMounted } from "vue"

// ==========================================
// 1. REATIVIDADE BÁSICA (VUE)
// ==========================================
const hello = ref("Hello World") 
const counter = reactive({ value: 0 }) 

const increase = () => {
    counter.value++
}

const decrease = () => {
    counter.value--
}

// ==========================================
// 2. INTEGRAÇÃO REST (LARAVEL)
// ==========================================
const APIMetadata = ref({})

onMounted(async () => {
    try {
        const response = await fetch("http://localhost:8000/api/metadata", {
            headers: {
                'Accept': 'application/json'
            }
        })
        const json = await response.json()

        // response.ok verifica se o status HTTP foi 200-299
        if (response.ok) {
            APIMetadata.value = json
        } else {
            APIMetadata.value = { name: `Erro no servidor: ${json.message || response.status}` }
        }
    } catch (error) {
        // O catch só dispara se o servidor estiver desligado ou cair a rede
        APIMetadata.value = { name: `Falha de rede/conexão: ${error.message}` }
    }
})

// ==========================================
// 3. WEBSOCKETS (SOCKET.IO)
// ==========================================
// Injeta a instância do socket criada lá no main.js
const socket = inject("socket")

const message = ref("Hello from VueJS")
const received = ref("")
const isConnected = ref(socket?.connected || false)

// Atualiza o estado da conexão quando o socket conectar ou desconectar
if (socket) {
    socket.on('connect', () => {
        isConnected.value = true
    })

    socket.on('disconnect', () => {
        isConnected.value = false
    })

    // OUVE o evento 'echo' vindo do servidor Node.js e guarda o valor recebido
    socket.on('echo', (msg) => {
        received.value = msg
    })
}

// TRANSMITE o evento 'echo' com o texto digitado quando clicamos em 'Send'
const sendMessage = () => {
    if (socket) {
        socket.emit('echo', message.value)
    }
}
</script>