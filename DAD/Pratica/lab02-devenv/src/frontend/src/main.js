import { createApp } from 'vue'
import { io } from 'socket.io-client'
// import App from './App.vue'
import router from './router'
import AboutPage from './pages/about/AboutPage.vue'
import NewAboutPage from './pages/newAboutPage/NewAboutPage.vue'

const socket = io('http://localhost:3000')

const app = createApp(NewAboutPage)

app.provide('socket', socket)

app.use(router)

app.mount('#app')
