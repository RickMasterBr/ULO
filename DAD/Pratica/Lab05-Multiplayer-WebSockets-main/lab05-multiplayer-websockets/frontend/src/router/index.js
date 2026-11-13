import { createRouter, createWebHistory } from 'vue-router'
import HomePage from '@/pages/home/HomePage.vue'
import SinglePlayerGamePage from '@/pages/game/SinglePlayerGamePage.vue'
import AboutPage from '@/pages/about/AboutPage.vue'
import LoginPage from '@/pages/login/LoginPage.vue'
import MultiPlayerLobbyPage from '@/pages/game/MultiPlayerLobbyPage.vue'
import MultiPlayerGamePage from '@/pages/game/MultiPlayerGamePage.vue'
import { useAuthStore } from '@/stores/auth'
import { toast } from 'vue-sonner'

const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  routes: [
    {
      path: '/',
      name: 'home',
      component: HomePage,
    },
    {
      path: '/games',
      children: [
        {
          path: 'singleplayer',
          name: 'singleplayer',
          component: SinglePlayerGamePage,
        },
        {
        path: 'lobby',
        name: 'multiplayer-lobby',
        component: MultiPlayerLobbyPage,
        meta: { requiresAuth: true },
    },
    {
        path: 'multiplayer',
        name: 'multiplayer',
        component: MultiPlayerGamePage,
        meta: { requiresAuth: true },
    },    
      ],
    },
    {
      path: '/about',
      name: 'about',
      component: AboutPage,
    },
    {
      path: '/login',
      name: 'login',
      component: LoginPage,
    },
  ],
})

router.beforeEach((to) => {
    const authStore = useAuthStore()
    if (to.meta.requiresAuth && !authStore.isLoggedIn) {
        toast.error('This navigation requires authentication')
        return({ name: 'login' })
    } else {
        return 
    }
})

export default router
