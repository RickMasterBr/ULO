import { defineStore } from 'pinia'
import { ref, computed } from 'vue'
import { useAPIStore } from './api'
import { useSocketStore } from './socket'

export const useAuthStore = defineStore('auth', () => {
  const apiStore = useAPIStore()
  const socketStore = useSocketStore()
  const currentUser = ref(undefined)

  const isLoggedIn = computed(() => {
    return currentUser.value !== undefined
  })

  const currentUserID = computed(() => {
    return currentUser.value?.id
  })

  const login = async (credentials) => {
    await apiStore.postLogin(credentials)
    const response = await apiStore.getAuthUser()
    currentUser.value = response.data
    socketStore.emitJoin(currentUser.value)
    return response.data
  }

  const logout = async () => {
    await apiStore.postLogout()
    socketStore.emitLeave()
    currentUser.value = undefined
  }

  return {
    currentUser,
    isLoggedIn,
    currentUserID,
    login,
    logout,
  }
})
