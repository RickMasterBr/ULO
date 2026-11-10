import { defineStore } from 'pinia'
import axios from 'axios'
import { inject } from 'vue'
import { ref } from 'vue'

export const useAPIStore = defineStore('api', () => {
    const API_BASE_URL = inject('apiBaseURL')
    const token = ref()

    const postGame = (game) => {
        return axios.post(`${API_BASE_URL}/games`, game)
    }

    const getGames = () => {
        return axios.get(`${API_BASE_URL}/games`)
    }

    const postLogin = async (credentials) => {
        const response = await axios.post(`${API_BASE_URL}/login`, credentials)
        token.value = response.data.token
        axios.defaults.headers.common['Authorization'] = `Bearer ${token.value}`
    }

    const postLogout = async () => {
        await axios.post(`${API_BASE_URL}/logout`)
        token.value = undefined
        delete axios.defaults.headers.common['Authorization']
    }

    const getAuthUser = () => {
        return axios.get(`${API_BASE_URL}/users/me`)
    }

    return {
        postGame,
        getGames,
        postLogin,
        postLogout,
        getAuthUser
    }
})