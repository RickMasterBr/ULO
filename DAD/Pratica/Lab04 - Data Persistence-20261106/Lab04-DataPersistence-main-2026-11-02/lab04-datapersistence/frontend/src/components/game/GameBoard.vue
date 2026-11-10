<template>
    <div class="m-auto pt-10 grid gap-10 p-4 max-w-lg grid-cols-4">
        <MemoryCard v-for="card in cards" :card="card" :key="card.id" @play="handleCardPlay"/>
    </div>
</template>

<script setup>
  import MemoryCard from './MemoryCard.vue'

  const emits = defineEmits(['flipCard'])

  const props = defineProps({
      cards: {
          type: Array,
          required: true
      }
  })

  const handleCardPlay = (card) => {
    console.log('Event play', card)
    emits('flipCard', card)
  }

</script>
