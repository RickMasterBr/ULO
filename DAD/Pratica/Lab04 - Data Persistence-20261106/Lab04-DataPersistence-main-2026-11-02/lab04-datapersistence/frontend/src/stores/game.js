import { defineStore } from 'pinia'
import { ref, computed, watch } from 'vue'
import { useHighScoreStore } from '@/stores/highscore'
import { useAPIStore } from './api'
import { toast } from 'vue-sonner'
import { useAuthStore } from '@/stores/auth'


export const useGameStore = defineStore('game', () => {
  const highScoreStore = useHighScoreStore()
  const apiStore = useAPIStore()

  const difficulties = [
    { value: 'easy', label: 'Easy', description: '4x2 grid' },
    { value: 'medium', label: 'Medium', description: '4x3 grid' },
    { value: 'hard', label: 'Hard', description: '4x4 grid' },
  ]

  const difficulty = ref('medium')

  // -------------------------------------
  // game logic
  // -------------------------------------

  const options = [1, 2, 3, 4, 5, 6, 7, 8].map((i) => {
    return { face: i, matched: false, flipped: false }
  })

  const cards = ref([])
  const flippedCards = ref([])
  const matchedPairs = ref([])
  const moves = ref(0)
  const beganAt = ref(undefined)
  const endedAt = ref(undefined)
  const latestGameHighScore = ref(false)
  const authStore = useAuthStore()

  const isGameComplete = computed(() => {
    if (cards.value.length === 0) return false
    return matchedPairs.value.length === cards.value.length
  })

  watch(isGameComplete, (value) => {
    if (value) {
      endedAt.value = new Date()
      latestGameHighScore.value = highScoreStore.addScore(totalTime.value)
    }
  })

  // totalTime Unit = ms
  const totalTime = computed(() => !isGameComplete.value ? undefined : Math.ceil((endedAt.value - beganAt.value)))
  const totalTimeSeconds = computed(() => new Intl.NumberFormat('en-US').format(totalTime.value))

  const setBoard = () => {
    cards.value = []
    moves.value = 0
    flippedCards.value = []
    matchedPairs.value = []

    let numPairs = 4
    if (difficulty.value === 'medium') numPairs = 6
    if (difficulty.value === 'hard') numPairs = 8

    const boardOptions = options.slice(0, numPairs)

    let idCounter = 0
    boardOptions.forEach((option) => {
      cards.value.push({ id: idCounter++, ...option })
      cards.value.push({ id: idCounter++, ...option })
    })

    for (let i = cards.value.length - 1; i > 0; i--) {
      const j = Math.floor(Math.random() * (i + 1))
        ;[cards.value[i], cards.value[j]] = [cards.value[j], cards.value[i]]
    }
    latestGameHighScore.value = false
    beganAt.value = undefined
  }

  const flipCard = (card) => {
    if (flippedCards.value.includes(card.id)) return
    if (matchedPairs.value.includes(card.id)) return
    if (flippedCards.value.length >= 2) return

    // First flipCard
    if (moves.value === 0 && flippedCards.value.length === 0) {
      beganAt.value = new Date()
      console.log('********* start time')
    }
    flippedCards.value.push(card.id)
    card.flipped = true
    if (flippedCards.value.length == 2) {
      checkForMatch()
    }
  }

  const checkForMatch = () => {
    if (flippedCards.value.length !== 2) return

    const [first, second] = flippedCards.value
    const firstCard = cards.value.find((c) => c.id === first)
    const secondCard = cards.value.find((c) => c.id === second)

    moves.value++

    if (firstCard.face === secondCard.face) {
      matchedPairs.value.push(first, second)
      firstCard.matched = true
      secondCard.matched = true
      flippedCards.value = []
    } else {
      setTimeout(() => {
        firstCard.flipped = false
        secondCard.flipped = false
        flippedCards.value = []
      }, 1000)
    }
  }

  const saveGame = async () => {
    const game = {
      player1_id: authStore.currentUser ? authStore.currentUser.id : undefined,
      type: 'S',
      status: 'E',
      player1_moves: moves.value,
      began_at: beganAt.value,
      ended_at: endedAt.value,
      total_time: Math.ceil((endedAt.value - beganAt.value)),
    }
    toast.promise(apiStore.postGame(game), {
      loading: 'Sending data to API...',
      success: () => {
        return `[API] Game saved successfully`
      },
      error: (data) => `[API] Error saving game - ${data?.response?.data?.message}`,
    })
  }


  // -----------------------------
  // What the store exposes to components
  // -----------------------------
  return {
    difficulties,
    difficulty,

    // Game logic:
    // state:
    cards,
    moves,
    latestGameHighScore,

    // computed:
    isGameComplete,
    totalTime,
    totalTimeSeconds,

    // actions (functions):
    setBoard,
    flipCard,
    checkForMatch,
    saveGame
  }
})
