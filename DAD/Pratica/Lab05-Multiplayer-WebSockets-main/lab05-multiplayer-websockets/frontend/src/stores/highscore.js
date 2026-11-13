import { defineStore } from 'pinia'
import { ref, computed } from 'vue'

export const useHighScoreStore = defineStore('highscore', () => {
  const STORAGE_KEY = 'memory-game-scores'

  const highScoresArray = ref(undefined)

  const loadHighScores = () => {
    try {
      const stored = sessionStorage.getItem(STORAGE_KEY)
      highScoresArray.value = stored ? JSON.parse(stored) : []
      return true
    } catch (error) {
      console.error('Failed to load high scores:', error)
      highScoresArray.value = []
      return false
    }
  }

  const saveHighScores = () => {
    try {
      sessionStorage.setItem(STORAGE_KEY, JSON.stringify(highScoresArray.value))
      return true
    } catch (error) {
      console.error('Failed to save high scores:', error)
      return false
    }
  }

  const highScores = computed(() => {
    if (highScoresArray.value === undefined) {
      loadHighScores()
    }
    return highScoresArray.value ?? []
  })


  const addScore = (time) => {
    if (typeof time !== 'number' || !Number.isFinite(time)) return false
    const arr = highScores.value
    let insertionIndex = arr.length
    for (let i = arr.length - 1; i >= 0; i--) {
      if (time < arr[i]) {
        insertionIndex = i
      } else {
        break
      }
    }
    if (insertionIndex >= 3) {
      return false
    }
    arr.splice(insertionIndex, 0, time)
    highScoresArray.value = arr.slice(0,  3)
    saveHighScores()
    return insertionIndex
  }

  const cleanHighScores = () => {
    try {
      highScoresArray.value = undefined
      sessionStorage.removeItem(STORAGE_KEY)
      return true
    } catch (error) {
      console.error('Failed to clear scores:', error)
      return false
    }
  }

  return {
    highScores,
    addScore,
    cleanHighScores,
  }
})
