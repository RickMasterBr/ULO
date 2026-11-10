<template>
    
    <div>
        <GameBoard :cards = "gameStore.cards" @play="handlePlay"/>
        <p v-if="gameStore.isGameComplete" class="pt-4 m-auto text-center text-2xl">Game Ended in 
   <strong>{{ gameStore.moves }} moves</strong></p>
<p v-else class="pt-4 m-auto text-center text-xl">Game is playing: 
   <strong>move {{ gameStore.moves }}</strong></p>
        <p class="m-auto pt-4 text-center text-md">
            
    Difficulty Level: <strong>{{ gameStore.difficulty }}</strong>
</p>
    </div>
</template>

<script setup>

import GameBoard from '@/components/game/GameBoard.vue';
import { useGameStore } from '@/stores/game';
import { onMounted, watch } from 'vue';

const gameStore = useGameStore();

const handlePlay = (card) => {
    gameStore.flipCard(card)
}

watch(() => gameStore.isGameComplete, () => {
    alert(`Game Comple  ted in ${gameStore.moves} moves`)
})

onMounted(() => {
    gameStore.setBoard();
})

</script>