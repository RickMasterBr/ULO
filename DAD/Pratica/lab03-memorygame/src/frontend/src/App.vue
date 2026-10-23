<template>
<nav class="max-w-full p-5 flex flex-row justify-between align-middle">
    <div class="align-middle text-xl">
    <!-- TODO: Replace with router link to Home page -->
    <RouterLink to="/"> 🧠 Memory Game </RouterLink>
    </div>
    <NavigationMenu>
    <NavigationMenuList class="justify-around gap-20">
        <NavigationMenuItem>
        <NavigationMenuTrigger>Games</NavigationMenuTrigger>
        <NavigationMenuContent>
            <li>
            <NavigationMenuLink as-child>
                <!-- TODO: Replace with router link to Single Player Game page -->
                 <RouterLink :to="{name: 'singleplayer'}">
                   SinglePlayer Game
                 </RouterLink>
            </NavigationMenuLink>
            <NavigationMenuLink>
                MultiPlayer Game
            </NavigationMenuLink>
            </li>
        </NavigationMenuContent>
        </NavigationMenuItem>
        <NavigationMenuItem>
        <NavigationMenuLink>
          <!-- TODO: Replace with router link to About page -->
          <RouterLink to="/about">
            About
          </RouterLink>
        </NavigationMenuLink>
        </NavigationMenuItem>
    </NavigationMenuList>
    </NavigationMenu>
</nav>
<div>
    <main>
    <!-- TODO: Add Router View -->
     <RouterView/>
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
import { RouterLink, RouterView } from 'vue-router'
</script>

<style></style>