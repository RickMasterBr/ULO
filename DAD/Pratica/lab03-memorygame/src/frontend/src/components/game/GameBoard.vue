<template>
    <div class="m-auto pt-10 grid gap-10 p-4 max-w-lg grid-cols-4">
        <MemoryCard v-for="card in cards" v-bind:card="card" :key="card.id" @play="handPlay"/>
    </div>
</template>

<script setup>
import { ref } from 'vue';
    import MemoryCard from './MemoryCard.vue';

    const props = defineProps(["cards"])

    const emit = defineEmits(["play"])

    const handPlay = (card) => {
        emit("play", card)
    }

</script>