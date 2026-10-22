<img src="media/logo.png" alt="ULO Logo" width="400px">

#

# Project Set Up                                        

## Objective

This worksheet will help us set up a new project with all the components
we will use in the semester

## Prerequisite

Install all the required components, as defined on development environment tutorials ([Windows](devenv-windows.md), [MacOS](devenv-macos.md), [Linux](devenv-linux.md)) 

# Architecture Overview

Our projects will use the following tech stack:

- API / Backend: `Laravel`

- Frontend: `VueJS`

- Reat-time: NodeJS with `Socket.IO`

This is the suggestion for the application structure, that includes a minimum of 3 projects:

```
/<application>/ ← Monorepo root
├── api/ ← Laravel API (Port 8000)
│ ├── app/
│ ├── database/
│ ├── routes/
│ └── .env
├── frontend/ ← Vue.js Frontend (Port 5173)
│ ├── src/
│ ├── public/
│ └── .env
├── websockets/ ← Socket.IO Server (Port 3000)
│ ├── src/
│ ├── package.json
│ └── .env
├── .gitignore ← Root gitignore
└── README.md ← Project documentation
```

# Create Monorepo Structure

Choose a folder on your hard drive to serve as the root folder for the application (which will contain all three projects). If you are solving a worksheet, you can use the provided repository as your root folder. Open a terminal in that directory (PowerShell, Bash, or Zsh) and run the following commands, keeping these options in mind:


#### For Laravel choose:

- No starter kit (**ATTENTION: do not choose Vue in this step, we'll
  install it separately**). 

- Choose no frontend stack, or `Blade` if that option is not available 

- If asked, choose `Pest` for testing

- If asked, choose `Sqlite` for the database

- No need to `run npm build` or `run npm dev` because we'll use Laravel just for the API (no frontend resources needed)

#### For Vue choose:

- Name the project -\> **frontend**

- Use `TypeScript` = **No**: during classes we'll not use TypeScript, but students are free to explore this option - in this case, Use `TypeScript` = **Yes**

- Select features: `Router` and `Pinia`

- (Optional) Select features: `Linter` and `Prettier`

- Select yes on "Skip all example code and start with a blank Vue
  project"

### Commands:

``` sh
# Initialize a Git repository 
# Skip this step if you are using the provided worksheet repository, 
# as it is already a Git repository.
git init

# create the Laravel application for the "api" 
laravel new api

# create "frontend" folder with base Vue application
npm create vue@latest

# change to the "frontend" folder with Vue application
cd frontend

# Install dependencies for the Vue application
npm install

# Create WebSocket server project (implemented with Node.js)
cd ..      # change back to the application root folder
mkdir websockets
cd websockets
npm init -y
npm install --save socket.io
```

## Run all projects
To test the setup, we must run each of our components. Open a new terminal tab for each component (the integrated VS Code terminal works perfectly) and execute their specific commands.

### Laravel

To run the Laravel application (API) use the following commands:

```sh
cd api
composer run dev
```

You can now navigate to <a href="http://localhost:8000">http://localhost:8000</a> in your browser to view the Laravel homepage. If it fails to load, port 8000 might be in use by another application. Alternatively, you can start the server on a different port by changing the APP_URL variable on the `.env` file:

### Vue

To run the Vue application use the following commands:

```sh
cd frontend
npm run dev
```

You can now visit <a href="http://localhost:5173">http://localhost:5173</a> in your browser to view the base Vue application. Note that the port number might vary if 5173 is already in use, so always verify the address shown in your terminal.

### Web Sockets

To run the Web Sockets application, we need a starter file, follow these
steps.

- Create a new file called `index.js` on the websockets folder and add this content to that file:

```js
import { Server } from "socket.io";

const io = new Server(3000, {
  cors:{
    origin: "*"
  }
});

io.on("connection", (socket) => {
  socket.on("echo",(msg) => {
    socket.emit("echo", msg);
  });
});
```

- Open the `package.json` and add this lines:

```js
  "scripts": {
    // ...
    "dev": "node index.js"
  },

  "type": "module",
```

- Run these commands

```sh
cd websockets\
npm run dev
```

Since this component does not have a UI, our only check for now is to ensure that the command ran successfully.

## Preparing Laravel for API development

By default, Laravel is configured for Server-Side Rendering (SSR) applications, so we need to set it up for API development. Run the following commands:

```sh
cd api
php artisan install:api
```

Open the file at `api/routes/api.php` and add the following lines:

```php
Route::get('metadata', function (Request $request) {
  return [
    "name" => "DAD Worksheet API",
    "version" => "0.0.1"
  ];
});
```

You can now navigate to <a href="http://localhost:8000/api/metadata">http://localhost:8000/api/metadata</a> in your browser to view the metadata. Additionally, run the following command to list all currently available API routes:

```sh
php artisan route:list --path=api
```
