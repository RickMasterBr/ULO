import { createRouter, createWebHistory } from 'vue-router'

import HomePage from '@/pages/home/HomePage.vue'
import SinglePlayerGamePage from '@/pages/game/SinglePlayerGamePage.vue'
import AboutPage from '@/pages/about/AboutPage.vue'



const router = createRouter({
  history: createWebHistory(import.meta.env.BASE_URL),
  // ...
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
      ],
    },
    {
      path: '/about',
      name: 'about',
      component: AboutPage,
    },
  ],
})

export default router
