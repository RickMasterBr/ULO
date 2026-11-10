<template>
  <div class="relative w-30 h-40 leading-40 cursor-pointer
        border-2 border-slate-600 text-2xl text-center"
        :class="{ 'cursor-not-allowed': card.matched }"
    @click="handleClick">
      <div v-if="!card.flipped" class=" bg-purple-600   hover:bg-violet-400">
          <span class="text-3xl text-white font-bold">?</span>
      </div>
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

  const emits = defineEmits(['play'])

  const handleClick = () => {
    console.log('Event click on Card')
    if (!props.card.flipped) {
      emits('play', props.card)
    }
  }
</script>

<style scoped></style>
