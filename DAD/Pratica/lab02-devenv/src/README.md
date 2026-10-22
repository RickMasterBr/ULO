<img src="./media/logo.png" alt="ULO Logo" width="400px">

#

# Lab 02 - Development Environment

# Objective

This worksheet will help us get started with the basics of all the tech stack components

## Prerequisite

Install all the components specified on the development environment tutorials ([Windows](devenv-windows.md), [MacOS](devenv-macos.md), [Linux](devenv-linux.md)) and perform the setup specified on the [Project Setup](setup.md)

# VueJS

Starting with Vue.js, we will create the first UI elements using a combination of HTML, JS, and CSS files.

1.  Let's begin by reviewing what was generated for us by the Vue setup. Open and review the code in the:

    1.  `/vite.config` (the aliases section)
    2.  `/package.json` (the scripts object)
    3.  `/index.html file` (the ID on the HTML)
    4.  `/src/main.js` (the createApp function)
    5.  `/src/App.vue` (App.vue is the root/main Vue component)


## About Page

2.  Create the first component of our Vue.js application inside a new `pages/about` folder (you will need to create the pages folder inside the existing src folder). Name the file `AboutPage.vue`.

    **Note**: Vue.js supports using standard .js files, but Vite does not by default. If you are interested in how this works, check out the extra exercises at the end of this worksheet.

    1. Create a `<template></template>` section and include:

        1.  A root `<div>`

        2.  A `<h1>` element that displays the value of the reactive variable named `hello`. In Vue.js, we use the `{{ variable }}` syntax, known as **text interpolation**, to output a variable's value in the template.
        
        3.  A paragraph tag (`<p>`) that displays the value of a reactive variable named `counter`

        4.  Two buttons:

            1.  One with the event listener of the click event set to the component method `increase` using the `v-on:<event>` attribute

            2.  One with the event listener of the click event set to the component method `decrease` using the `@<event>` attribute

    2.  Create a `<script setup></script>` section and include the following code:

        ```js
        import {ref, reactive } from "vue"

        //"Hello World" is the inital value of hello reactive variable
        const hello = ref("Hello World") 

        //{value: 0} is the inital reactive object (with the value property)
        const counter = reactive({value: 0}) 

        const increase = () => {
            counter.value++
        }

        const decrease = () => {
            counter.value--
        }
        ```

3.  Analise the code, in particular:

    1.  The `ref` / `reactive` functions imports

    2.  The way those functions (`ref()`and `reactive()`) are used in the code.

4.  Change the `main.js` to look like this and test the application

    ```js
    import { createApp } from 'vue'
    //import { createPinia } from 'pinia'

    //import App from './App.vue'
    //import router from './router'

    import AboutPage from '@/pages/about/AboutPage.vue'

    const app = createApp(AboutPage)

    //app.use(createPinia())
    //app.use(router)

    app.mount('#app')
    ```

5.  Compile the application by executing the command `npm run dev` in the frontend root folder, and open the provided URL (usually `http://localhost:5173/`) in the browser to test the application.

6. Try to increase or decrease the counter by clicking the buttons.

7. Answer the following questions:

    1. What is the use of the `'#app'` parameter passed to the app `mount()` function?
    
    2. When you increase or decrease the counter, does the entire page refresh, or is there only a partial refresh of the counter value?

# Connect to Laravel


Let's connect our Laravel API to our VueJS application. In the [Laravel API setup exercise](setup.md#preparing-laravel-for-api-development) from the Project Setup worksheet, we implemented a simple API endpoint that responds to HTTP GET requests with the URL: `/api/metadata`.

8. Update the `AboutPage.vue` file from the previous exercise to call the metadata endpoint and display the API version on the page.

    1.  Import the `onMounted()` function to hook into the mounted
        VueJS lifecycle event

        1.  See more information on VueJS lifecycle events at
        <https://vuejs.org/guide/essentials/lifecycle.html>

    2.  Use the `async` / `await` syntax to handle the asynchronous call

    3.  Use the `fetch API` to make the HTTP request

        1.  See more information about fetch API at
            <https://developer.mozilla.org/en-US/docs/Web/API/Fetch_API>

    4.  Ensure the HTTP request includes the `'Accept': 'application/json'` header. This informs the server that the client expects JSON responses, prompting Laravel to treat the request as an API call.

    5.  Test the Application:

        1. Ensure that the API server is running. If it is not, run the command `php artisan serve` in the `api` folder.

        2.  Refresh the page on the browser and check if the data
            from the API is showing on the page. The API section of the about page should look similar to the following image:

            <!-- ![Screenshot of API section when the server returns the expected data.](./media/image3.png) -->

            <img src="./media/image3.png" alt="Screenshot of API section when the server returns the expected data." style="padding: 20px; border: 1px solid">
            
        3.  In the browser development tools, on the Network tab, look for the REST API request and check the response payload


    6.  Simulate fetch and API errors:

        1.  On the `routes/api.php` file (Laravel project) add -
            `abort(500, 'Something went wrong');` - before the
            return statement.

        2. Check the browser's developer tools to see what the server returns to the client.

        3. Modify the fetch request code in AboutPage.vue to handle server errors. Use the response object's `ok` property, which indicates whether the request was successful.

        4. Update the AboutPage.vue code so that when the server returns an error, the message is displayed in red text. The API section of the About page should look similar to the following image:

            <!-- ![Screenshot of API section when the server returns an error with status code 500.](./media/image4.png)     -->
            <img src="./media/image4.png" alt="Screenshot of API section when the server returns an error with status code 500." style="padding: 20px; border: 1px solid">


        5. Update the AboutPage.vue code so that if the client fetch request fails, the error message is also displayed on the page. To implement this, use a `try...catch` block and ensure that the error object's message property is rendered on the screen.
        
        6. Change the request URL to an invalid one and test the application. The API section of the About page should look similar to the following image:

            <!-- ![Screenshot of API section when the fetch (on the client) fails.](./media/image5.png)     -->

            <img src="./media/image5.png" alt="Screenshot of API section when the fetch (on the client) fails." style="padding: 20px; border: 1px solid">


9.  Answer the following questions:

    1. What does the `onMounted()` function do?

    2. What is the difference between the `mounted` and `created` lifecycle hooks?

        (Read more about this in the Vue.js Official Documentation - Lifecycle Hooks:  <https://vuejs.org/guide/essentials/lifecycle.html>)

    3. Using the Fetch API, what is the difference between server-related errors (where the server returns an HTTP response with an error status code, like 500) and client-related errors (where the fetch request fails at the network or browser level, meaning no valid HTTP response is ever handed back to the client)?


# Connect to Web Sockets

Our next step is to connect our VueJS application with our Web Socket
server.

10.  Connect VueJs to the Web Sockets Server
        1.  Install the `Socket.io` client package by executing the following command on the frontend folder: 

            ```sh
            npm install socket.io-client
            ```

        2.  Import the package in the `main.js` file, connect to the web
            socket server on port 3000 and use the provide() method to
            expose the socket object to the VueJS application.

            ```js
            import { io } from 'socket.io-client'
            //...
            // after the createApp call
            const socket = io('http://localhost:3000')

            app.provide('socket', socket)
            ```

11.  On the AboutPage component import the inject function and use to
    inject the socket

        1.  See more information about the `provide` / `inject` mechanism here:

            <https://vuejs.org/api/composition-api-dependency-injection.html>

        2. Add the folllowing html code at the end of the AboutPage.vue template:
            ```html
                <hr>
                <div>
                <h1>WebSockets</h1>
                <p><strong>Connection: </strong>Not Connected</p>
                <p>
                    <strong>Message: </strong>
                    <input type="text" value="Message to Send">
                    <button>Send</button>
                </p>
                <p><strong>Received: </strong>Message Received</p>
                </div>
            </div>
            </template>
            ```
        3. The WebSocket section of the page should look like this:

            <img src="./media/image6.png" alt="Screenshot of the WebSocket section." style="padding: 20px; border: 1px solid">

12.  Define a click event listener on the 'Send' button to emit a message to the WebSocket server. Emit an 'echo' event containing the value of the `message` reactive variable (to be created).

        1. For more information about the emit function, see:
        https://socket.io/docs/v4/emitting-events/

        2. Use the special Vue.js `v-model` directive to implement two-way binding between the message reactive variable and the `<input>` element.

            For more information about two-way binding with v-model, see:
            https://vuejs.org/guide/components/v-model.html


13.  Change the content of the "Connection:" to use the connected property of the socket:
        ```js
        {{ socket.connected ? 'Connected' : 'Disconnected' }}
        ```

14.  Register a listener on the socket for the 'echo' event and assign the received value to the `received` component variable.

15. Test the application. At this point it should look like this and have the "echo" functionality working. If not check the developer tools (Console, and Network) for debug information. WebSocket section should look similar to:

    <img src="./media/image7.png" alt="Screenshot of API section when the fetch (on the client) fails." style="padding: 20px; border: 1px solid">


# Add Shadcn

The default look and feel of HTML is a bit lackluster, lets improve the UI by using one UI framework that can provide us with better defaults. There are several frameworks for this purpose, we will be using one that aligns well with the composable ethos of VueJS, called Shadcn (<https://www.shadcn-vue.com/>). This framework was originally built for the React ecosystem, but it's since been ported to VueJS as well. Among other characteristics, one that is interesting for our purposes is that we don't import the full framework, instead we choose individual components and download them to our own codebase for possible extension.
This framework is built on the CSS framework tailwind (<https://tailwindcss.com/>), also popular due to its composability.

16.  Set up Tailwind CSS and Shadcn for vite (more info: <https://www.shadcn-vue.com/docs/installation/vite.html>)

        1.  Add tailwind by running: 
            ```sh
            npm install tailwindcss @tailwindcss/vite
            ```

        2.  Create a file called `index.css` on the src folder with this content:             

            ```css
            @import "tailwindcss";
            ```

        3.  Add this tag after the `<meta>` section (inside the `<head></head>`) of `index.html`: 
            ```html
            <link rel="stylesheet" href="/src/index.css">
            ```
        4.  Change the `vite.config.js` file to include tailwind:

            ```js

            import { fileURLToPath, URL } from 'node:url'

            import { defineConfig } from 'vite'
            import tailwindcss from '@tailwindcss/vite'     // <- ADD
            import vue from '@vitejs/plugin-vue'
            import vueDevTools from 'vite-plugin-vue-devtools'

            // https://vite.dev/config/
            export default defineConfig({
            plugins: [
                vue(),
                vueDevTools(),
                tailwindcss(),                               // <- ADD
              ],
            resolve: {
                alias: {
                    '@': fileURLToPath(new URL('./src', import.meta.url)),
                },
              },
            })

            ```
17.  Initialize the **shadcn-vue** framework by running the following command (accept all the default options):

        ```sh
        npx shadcn-vue@latest init
        ```

18. From this point on, we can install any components we need. Check out the available components here: <https://www.shadcn-vue.com/docs/components>

19.  Install the Shadcn `button` by executing: 
        ```sh
        npx shadcn-vue@latest add button
        ```

20.  Install the Shadcn `input` by executing: 
        ```sh
        npx shadcn-vue@latest add input
        ```

21.  Replace the standard `<input>` and 'Send' `<button>`, which are used to type and send messages to the WebSocket server, with their shadcn-vue alternatives (`<Input>` and `<Button>`).

        <img src="./media/image8.png" alt="Screenshot of the WebSocket section." style="padding: 20px; border: 1px solid">


22.  Update the AboutPage component to enhance its appearance using the following code:
        ```js
        <script setup>
        import { Button } from '@/components/ui/button'
        import { Input } from '@/components/ui/input'
        import { ref, onMounted, inject } from 'vue'

        const socket = inject('socket')
        const api = ref({})
        const apiErrorMessage = ref('')
        const received = ref('')
        const message = ref('Hello from VueJS')

        const sendMsg = () => {
            socket.emit('echo', message.value)
        }

        socket.on('echo', msg => received.value = msg)

        onMounted(async () => {
            const url = 'http://localhost:8000/api/metadata'
            try
            {
                const response = await fetch(url, {
                    method: 'GET',
                    headers: {
                        'Accept': 'application/json'
                    }
                })
                const responseData = await response.json()
                if (response.ok) {
                    api.value = responseData
                } else {
                    apiErrorMessage.value = responseData.message
                }
            }
            catch (e) {
                apiErrorMessage.value = e.message
            }
        })
        </script>
        ```
        ```html
        <template>
        <div class="min-h-screen bg-gradient-to-br from-slate-50 to-slate-100 py-12 px-4 sm:px-6 lg:px-8">
            <div class="max-w-4xl mx-auto space-y-8">

            <div class="text-center space-y-2">
                <h1 class="text-4xl font-bold text-slate-900 tracking-tight">
                Distributed Application Development
                </h1>
                <p class="text-lg text-slate-600">
                Worksheet 2 - About Page
                </p>
            </div>

            <div class="bg-white rounded-lg shadow-sm border border-slate-200 p-6">
                <p class="text-slate-700 leading-relaxed">
                This is the about page for Worksheet 2, where we will be exploring the basics of
                <span class="font-semibold text-emerald-600">VueJS</span>,
                <span class="font-semibold text-red-600">Laravel</span>, and
                <span class="font-semibold text-blue-600">SocketIO</span>.
                </p>
            </div>

            <section class="bg-white rounded-lg shadow-sm border border-slate-200 overflow-hidden">
                <div class="bg-gradient-to-r from-emerald-500 to-emerald-600 px-6 py-4">
                <h3 class="text-xl font-semibold text-white flex items-center gap-2">
                    <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" d="M13 10V3L4 14h7v7l9-11h-7z" />
                    </svg>
                    REST API
                </h3>
                </div>
                <div class="p-6 space-y-4">
                <div v-if="apiErrorMessage" class="flex items-center justify-between py-3 border-b border-slate-100">
                    <span class="text-sm font-medium text-red-600">{{ apiErrorMessage }}</span>
                </div>

                <div class="flex items-center justify-between py-3 border-b border-slate-100">
                    <span class="text-sm font-medium text-slate-600">API Name</span>
                    <span class="text-base font-semibold text-slate-900 bg-slate-100 px-3 py-1 rounded-md">
                    {{ api.name }}
                    </span>
                </div>
                <div class="flex items-center justify-between py-3">
                    <span class="text-sm font-medium text-slate-600">API Version</span>
                    <span
                    class="inline-flex items-center px-3 py-1 rounded-full text-sm font-medium bg-emerald-100 text-emerald-800">
                    v{{ api.version }}
                    </span>
                </div>
                </div>
            </section>

            <section class="bg-white rounded-lg shadow-sm border border-slate-200 overflow-hidden">
                <div class="bg-gradient-to-r from-blue-500 to-blue-600 px-6 py-4">
                <h3 class="text-xl font-semibold text-white flex items-center gap-2">
                    <svg class="w-6 h-6" fill="none" stroke="currentColor" viewBox="0 0 24 24">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2"
                        d="M8.111 16.404a5.5 5.5 0 017.778 0M12 20h.01m-7.08-7.071c3.904-3.905 10.236-3.905 14.141 0M1.394 9.393c5.857-5.857 15.355-5.857 21.213 0" />
                    </svg>
                    Web Socket
                </h3>
                </div>
                <div class="p-6 space-y-6">

                <div class="flex items-center justify-between py-3 border-b border-slate-100">
                    <span class="text-sm font-medium text-slate-600">Connection Status</span>
                    <span :class="[
                    'inline-flex items-center gap-2 px-3 py-1 rounded-full text-sm font-medium',
                    socket.connected
                        ? 'bg-green-100 text-green-800'
                        : 'bg-red-100 text-red-800'
                    ]">
                    <span :class="[
                        'w-2 h-2 rounded-full',
                        socket.connected ? 'bg-green-500 animate-pulse' : 'bg-red-500'
                    ]"></span>
                    {{ socket.connected ? 'Connected' : 'Disconnected' }}
                    </span>
                </div>

                <div class="space-y-4">
                    <div>
                    <label for="message" class="block text-sm font-medium text-slate-700 mb-2">
                        Send Message
                    </label>
                    <div class="flex gap-3">
                        <Input id="message" v-model="message" type="text" placeholder="Type your message..." class="flex-1" />
                        <Button type="button" @click="sendMsg">
                        Send
                        </Button>
                    </div>
                    </div>

                    <div v-if="received" class="bg-slate-50 border border-slate-200 rounded-lg p-4">
                    <p class="text-xs font-medium text-slate-500 mb-1">Received Message:</p>
                    <p class="text-slate-900 font-medium">{{ received }}</p>
                    </div>
                </div>
                </div>
            </section>
            </div>
        </div>
        </template>
        ```

32. Review the replaced code and test the application. It should look
    like this now:

    <img src="./media/image9.png" alt="Screenshot of the WebSocket section.">


# Optional 1 - Options API vs Composition API  

These exercises are optional but provide an opportunity to better
understand the frameworks we will be using.

VueJS supports two approaches to writing components:

- The **Options API**: relies on each component having an "options" object
  that holds its state, behavior and even its template. This was the
  only approach available in VueJS version 2

- The **Composition API**: uses a single setup() function per component and
  supports the concept of composition by allowing the import of features
  via composable functions.

  - With this approach (Composition API) we also have two alternatives
    to create a component -- as \"plain\" JavaScript (.js) files or
    using .vue files (also called Single File Components \[SFC\]).
    We\'ve been using the later.\
    With the .js files we write plain JavaScript code that must
    adhere to the respective API specification. With the .vue files we
    can segment our code in three sections: \<template\>, \<script\> and
    \<style\>, that hold the HTML, JS, and CSS respectively. We need to
    keep in mind that while these files use HTML like syntax for the
    sections, their contents are not interpretable by a browser, and we
    need a builder (Vite in our case) to transpile its code to proper JS
    files.

    See more information

- More information on the Options API here:
  <https://vuejs.org/guide/introduction.html#options-api>

- More information on the Composition API here:
  <https://vuejs.org/api/composition-api-setup.html>

- More information on Vue SFC format here:
  <https://vuejs.org/api/sfc-spec.html#sfc-syntax-specification>

For all worksheets and projects in this course, we will primarily use
the Composition API in SFC format. However, in the following exercises,
we will also experiment with the other two alternatives: the Options API
and the Composition API using JavaScript only.

33.  Create a "static" VueJS application

        1.  Copy the HTML file from the VueJS Application into a new empty
        folder outside of the worksheet project.

        2.  Create a new JS file and reference it in the HTML

        3.  Following the VueJS Options API add the same elements we have on
        this worksheet (hello and counter variables and functionality)

        4.  Test the application (vite is not required)

        5.  Refactor the application to follow the Composition API. Since we
        don't want to use Vite, we need to use the explicit setup()
        function

        6.  Test the application

34.  Answer the following questions

        1.  Why does the data() function, in the Options API, need to return
        an object?

        2.  How does the \"this\" keywork in the methods option (Options
        API) work?

        3.  What are the differences between the \<script setup\> method of
        the Single-File Component formal and the explicit setup()
        function?

# Optional 2 - TypeScript

Implement all exercises using **TypeScript** instead of plain JavaScript for the Frontend and WebSockets projects.

