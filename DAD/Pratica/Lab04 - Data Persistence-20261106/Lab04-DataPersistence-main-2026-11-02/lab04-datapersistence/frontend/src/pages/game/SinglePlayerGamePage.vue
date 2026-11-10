<template>
    <div class="space-y-6">
        <GameBoard :cards="gameStore.cards" @flipCard="handleFlipCard"></GameBoard>
        <p class="m-auto pt-4 text-center text-base">
          Difficulty Level: <strong>{{ gameStore.difficulty }}</strong>
        </p>
    </div>
</template>

<script setup>
  import { onMounted, watch } from 'vue'
  import GameBoard from '@/components/game/GameBoard.vue'
  import { useGameStore } from '@/stores/game'
  import {toast} from 'vue-sonner'

  const gameStore = useGameStore()

  const handleFlipCard = (card) => {
    console.log('Event flipCard', card)
    gameStore.flipCard(card)
  }

  watch(
() => gameStore.isGameComplete,
(isComplete) => {
    if (isComplete) {
        gameStore.saveGame()
        toast.success(`Game completed in ${gameStore.totalTimeSeconds} seconds and ${gameStore.moves} moves.`)
        if (gameStore.latestGameHighScore) {
            toast.success(`Congratulations, you've made it to the local high score leaderboard at position ${gameStore.latestGameHighScore + 1}.`)
        }
    }
})

  onMounted(() => {
    gameStore.setBoard()
  })

</script>
