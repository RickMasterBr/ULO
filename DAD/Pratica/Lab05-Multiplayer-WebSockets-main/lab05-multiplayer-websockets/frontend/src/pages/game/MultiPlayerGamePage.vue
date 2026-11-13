<template>
<div class="space-y-6">
    <div class="flex justify-between items-center p-4 bg-slate-50 rounded-lg border border-slate-200">
        <div>
            <p class="text-sm text-slate-600">Game ID</p>
            <p class="text-lg font-semibold text-slate-900">
                {{ gameStore.multiplayerGame.id }} -- {{ gameStatus }}
                <span v-if="gameStore.multiplayerGame.complete">Winner {{ gameStore.multiplayerGame.winner }}</span>
            </p>
        </div>
        <div>
            <p class="text-sm text-slate-600">Current Player</p>
            <p class="text-lg font-semibold text-slate-900">
                {{ gameStore.multiplayerGame.currentPlayer }}
                <span v-if="myTurn">Your Turn</span>
            </p>
        </div>
    </div>
    <GameBoard :cards="gameStore.multiplayerGame.cards" @flip-card="flipCard"></GameBoard>
</div>
</template>

<script setup>
import { toast } from "vue-sonner"
import { computed, watch } from 'vue'
import { useGameStore } from '@/stores/game';
import GameBoard from '@/components/game/GameBoard.vue'
import { useSocketStore } from "@/stores/socket";
import { useAuthStore } from "@/stores/auth";

const gameStore = useGameStore()
const socketStore = useSocketStore()
const authStore = useAuthStore()

const myTurn = computed(() => {
    return gameStore.multiplayerGame.currentPlayer == authStore.currentUserID
})

const gameStatus = computed(() => {
    return gameStore.multiplayerGame.complete ? 'Ended' : 'Playing'
})

const flipCard = (card) => {
    if (!myTurn.value) return
    if (card.flipped) return
    socketStore.emitFlipCard(gameStore.multiplayerGame.id, card)

}

watch(gameStatus, () => {
    if (gameStore.multiplayerGame.winner == authStore.currentUserID) {
        toast.success("You Won!!")
    } else {
        toast.error("You Lose!!")
    }
})
</script>

<style scoped></style>