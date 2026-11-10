<template>
    <!-- Contentor principal da carta -->
    <div class="relative w-30 h-40 leading-40 cursor-pointer border-2 border-slate-600 text-2xl text-center" 
         :class="{ 'cursor-not-allowed': card.matched }"
         @click="handleClick">

        <!-- 1. Se NÃO estiver virada, mostra o '?' -->
        <div v-if="!card.flipped" class="bg-purple-600 hover:bg-violet-400">
            <span class="text-3xl text-white font-bold">?</span>
        </div>

        <!-- 2. Senão (está virada), mostra o valor da face -->
        <div v-else>
            {{ card.face }}
        </div>

    </div>
</template>

<script setup>
const props = defineProps({
    card: {
        type: Object,
        required: true
    }
})

const emit = defineEmits(["play"])

const handleClick = () => {
    emit("Play",  props.card)
}

</script>

<style scoped></style>