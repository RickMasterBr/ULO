<template>
  <div class="flex flex-row justify-center items-stretch gap-5 mt-10">
    <Card class="w-full max-w-md">
      <CardHeader>
        <CardTitle class="text-3xl font-bold text-center">
          Single Player
        </CardTitle>
        <CardDescription class="text-center">
          Test your memory by finding matching pairs!
        </CardDescription>
      </CardHeader>
      <CardContent class="space-y-6">

        <div class="space-y-2">
          <label class="text-sm font-medium">Choose Difficulty</label>
          <div class="grid grid-cols-3 gap-2">
            <Button v-for="level in gameStore.difficulties" :key="level.value"
              class="flex flex-col py-3 h-16"
              size="sm"
              :variant="selectedDifficulty === level.value ? 'default' : 'outline'"
              @click="selectedDifficulty = level.value">
              <span class="font-semibold">{{ level.label }} </span>
              <span class="text-xs opacity-70">{{ level.description}}</span>
            </Button>
          </div>
        </div>

        <div class="flex justify-center pb-8">
          <Button size="lg" variant="secondary" class="hover:bg-purple-500 hover:text-slate-200"
            @click="startSinglePlayerGame">
            Start Game
          </Button>
        </div>

        <div class="flex space-x-4">
          <div class="space-y-2 grow">
            <label class="text-sm font-medium">Local High Scores</label>
            <div class="rounded-lg border bg-card text-card-foreground shadow-sm  mt-2">
              <div class="max-h-64 overflow-y-auto">
                <div v-if="highScoreStore.highScores.length === 0" class="p-6 text-center text-sm text-muted-foreground">
                  No local high scores yet.<br>Be the first!
                </div>
                <div v-else class="divide-y">
                  <div v-for="(time, index) in highScoreStore.highScores" :key="index"
                      class="flex items-center justify-between p-3 hover:bg-muted/50 transition-colors">
                    <div class="flex items-center gap-3">
                      <div class="flex h-8 w-8 items-center justify-center rounded-full text-xs font-bold"
                        :class="{
                          'bg-yellow-100 text-yellow-700 dark:bg-yellow-900 dark:text-yellow-300': index === 0,
                          'bg-gray-100 text-gray-700 dark:bg-gray-800 dark:text-gray-300': index === 1,
                          'bg-orange-100 text-orange-700 dark:bg-orange-900 dark:text-orange-300': index === 2,
                          'bg-muted text-muted-foreground': index > 2
                        }">
                        {{ index + 1 }}
                      </div>
                      <div class="text-muted-foreground text-xs">
                        {{ Intl.NumberFormat('en-US').format(time) }} sec.
                      </div>
                    </div>
                  </div>
                </div> <!-- v-else -->
              </div>
            </div>
          </div>

          <div class="space-y-2 grow">
            <label class="text-sm font-medium">Global High Scores</label>
            <div class="rounded-lg border bg-card text-card-foreground shadow-sm mt-2">
              <div class="max-h-64 overflow-y-auto">
                <div v-if="globalHighScores.length === 0"
                  class="p-6 text-center text-sm text-muted-foreground">
                  No global high scores yet.<br>Be the first!
                </div>
                <div v-else class="divide-y">
                  <div v-for="(score, index) in globalHighScores" :key="index"
                      class="flex items-center justify-between p-3 hover:bg-muted/50 transition-colors">
                    <div class="flex items-center gap-3">
                      <div class="flex h-8 w-8 items-center justify-center rounded-full text-xs font-bold"
                        :class="{
                          'bg-yellow-100 text-yellow-700 dark:bg-yellow-900 dark:text-yellow-300': index === 0,
                          'bg-gray-100 text-gray-700 dark:bg-gray-800 dark:text-gray-300': index === 1,
                          'bg-orange-100 text-orange-700 dark:bg-orange-900 dark:text-orange-300': index === 2,
                          'bg-muted text-muted-foreground': index > 2
                        }">
                        {{ index + 1 }}
                      </div>
                      <div>
                        <div class="font-medium text-sm">{{ score.moves }} Moves</div>
                        <div class="text-xs text-muted-foreground">
                          {{ Intl.NumberFormat('en-US').format(score.time) }} sec.
                        </div>
                        <div v-if="score.player1Name" class="text-xs font-medium text-blue-500">
                          {{ score.player1Name }}
                        </div>
                        <div v-else class="text-xs text-muted-foreground">
                          Anonymous
                        </div>
                      </div>
                    </div>
                  </div>
                </div> <!-- v-else -->
              </div>
            </div>
          </div>
        </div>
      </CardContent>
    </Card>
    <Card class="w-full max-w-md">
      <CardHeader>
        <CardTitle class="text-3xl font-bold text-center">
          MultiPlayer
        </CardTitle>
        <CardDescription class="text-center">
          Comming Soon!!
        </CardDescription>
      </CardHeader>
      <CardContent class="space-y-6">
      </CardContent>
    </Card>
  </div>
</template>

<script setup>
import { Button } from '@/components/ui/button'
import {
  Card,
  CardContent,
  CardDescription,
  CardHeader,
  CardTitle
} from '@/components/ui/card'
import { ref, onMounted } from 'vue'
import { useRouter } from 'vue-router'
import { useGameStore } from '@/stores/game'
import { useHighScoreStore } from '@/stores/highscore'
import { useAPIStore } from '@/stores/api'

const router = useRouter()
const gameStore = useGameStore()
const highScoreStore = useHighScoreStore()
const apiStore = useAPIStore()

const selectedDifficulty = ref('medium')
const globalHighScores = ref( [] )

const startSinglePlayerGame = () => {
  gameStore.difficulty = selectedDifficulty.value
  router.push({name: 'singleplayer'})
}

onMounted(async () => {
  const response = await apiStore.getGames()
  globalHighScores.value = response.data.data
  .map(item => ({
    moves: item.player1_moves,
    time: item.total_time,
    player1Name: item.player1?.name ?? ''
  }))
  .sort((a, b) => a.time - b.time == 0 ? a.moves - b.moves : a.time - b.time)
  .slice(0, 3)
})

</script>
