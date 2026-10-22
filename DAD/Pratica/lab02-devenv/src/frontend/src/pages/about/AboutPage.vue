<template>
    <div>
        <h1>{{ hello }}</h1>
        <p>{{ counter.value }}</p>
        <button v-on:click="increase">increase</button>
        <button @click="decrease">decrease</button>
        
        <div>
            <h2>{{ APIMetadata.name }}</h2>
            <h2>{{ APIMetadata.version }}</h2>
        </div>

         <hr>
    <div>
    <h1>WebSockets</h1>
    <p><strong>Connection: </strong>{{ socket.connected ? 'Connected' : 'Disconnected' }}</p>
    <p>
        <strong>Message: </strong>
        <input v-model="message" type="text" value="Message to Send">
        <button @click="message">Send</button>
    </p>
    <p><strong>Received: </strong>{{ message }}</p>
    </div>

    </div>
</template>

<script setup>

import {ref, reactive, inject} from "vue"
import { onMounted } from 'vue'

//"Hello World" is the inital value of hello reactive variable
const hello = ref("Hello World") 

const socket = inject("socket")

const APIMetadata = ref({});

const message = ref("");


//{value: 0} is the inital reactive object (with the value property)
const counter = reactive({value: 0}) 

const increase = () => {
    counter.value++
}

const decrease = () => {
    counter.value--
}

const sendMessage = () => {
    socket.emit('event-name', param);
}

onMounted(async () =>  {

    try{

        
        const response = await fetch("http://localhost:8000/api/metadata")
        const json = await response.json()
        APIMetadata.value = json
        console.log(json)
    }
    catch(error){

        APIMetadata.value = {name: error.message} 

    }

});

</script>