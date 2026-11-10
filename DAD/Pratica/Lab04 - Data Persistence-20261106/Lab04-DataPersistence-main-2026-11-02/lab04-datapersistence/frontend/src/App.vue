<template>
<Toaster />
<nav class="max-w-full p-5 flex flex-row justify-between align-middle">
    <div class="align-middle text-xl">
  <RouterLink to="/"> 🧠 Memory Game </RouterLink>
  <span class="text-xs" v-if="authStore.currentUser">&nbsp;&nbsp;&nbsp; 
        ({{ authStore.currentUser?.name }})
  </span>
</div>    
    <NavigationMenu>
    <NavigationMenuList class="justify-around gap-20">
        <NavigationMenuItem>
        <NavigationMenuTrigger>Games</NavigationMenuTrigger>
        <NavigationMenuContent>
            <li>
            <NavigationMenuLink as-child>
                <RouterLink :to="{name:'singleplayer'}">
                SinglePlayer Game
                </RouterLink>
            </NavigationMenuLink>
            <NavigationMenuLink as-child>
                <RouterLink to="/">MultiPlayer</RouterLink>
            </NavigationMenuLink>
            </li>
        </NavigationMenuContent>
        </NavigationMenuItem>
        <NavigationMenuItem>
        <NavigationMenuLink>
            <RouterLink to="/about">About</RouterLink>
        </NavigationMenuLink>
        </NavigationMenuItem>
        <NavigationMenuItem v-if="!authStore.isLoggedIn">
    <NavigationMenuLink>
        <RouterLink to="/login">Login</RouterLink>
    </NavigationMenuLink>
</NavigationMenuItem>
<NavigationMenuItem v-else>
    <NavigationMenuLink>
    <a @click.prevent="logout">Logout</a>
    </NavigationMenuLink>
</NavigationMenuItem>
    </NavigationMenuList>
    </NavigationMenu>
</nav>
<div>
    <main>
    <RouterView />
    </main>
</div>
</template>

<script setup>
import {
NavigationMenu,
NavigationMenuContent,
NavigationMenuItem,
NavigationMenuLink,
NavigationMenuList,
NavigationMenuTrigger,
} from '@/components/ui/navigation-menu'
import { Toaster } from '@/components/ui/sonner'
import 'vue-sonner/style.css'
import { RouterLink, RouterView } from 'vue-router';
import { useAuthStore } from '@/stores/auth'
import { toast } from 'vue-sonner'

const authStore = useAuthStore()

const logout = () => {
    toast.promise(authStore.logout(), {
        loading: 'Calling API',
        success: () => {
            return 'Logout Sucessfull '
        },
        error: (data) => `[API] Error saving game - ${data?.response?.data?.message}`,
    })
}
</script>

<style></style>