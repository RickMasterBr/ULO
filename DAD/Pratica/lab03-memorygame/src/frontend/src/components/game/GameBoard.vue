<template>
    <div class="m-auto pt-10 grid gap-10 p-4 max-w-lg grid-cols-4">
        <MemoryCard v-for="card in board" v-bind:card="card" :key="card"/>
    </div>
</template>

<script setup>
import { ref } from 'vue';
    import MemoryCard from './MemoryCard.vue';

    const board = ref([1,2,3,4,5,6,7,8]);
</script>