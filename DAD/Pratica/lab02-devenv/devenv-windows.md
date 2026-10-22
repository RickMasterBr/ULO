<img src="media/logo.png" alt="ULO Logo" width="400px">

#

# Dev Env - Windows

## Objective

This worksheet will help you install all the necessary tools for the
Distributed Application Development course. We\'ll be building
applications using Laravel (API), Vue.js (Frontend), and Socket.IO
(Real-time communication), other tech stacks and and should be explored
but this is out of scope for this worksheet.

Required Tools

You will need to install the following tools:
****
- Git -- version control system.

- Node.js (v20 of higher) -- JavaScript runtime for frontend and
  real-time services.

- PHP (v8.4 or higher) -- Backend language for Laravel

- Composer -- PHP Dependency manager

- Code Editor -- VS Code recommended

- Docker -- Container solution for deployment

- Windows Subsystem for Linux -- Linux on Windows

# Installation for Windows

Let\'s start by checking if you already have the necessary components.

\# Run in powershell

```powershell

git --version\
node --version\
php --version\
composer --help\
docker --version\
wsl \--version
```

If any of the commands do not exist follow the instructions to install
them.

## Chocolatey

As an alternative to the individual instructions bellow, we can use a
package manager like Chocolatey (<https://chocolatey.org/>) to install
these components. The benefit is that we can manage (install, remove,
update) all from one tool.

```powershell
\# Run in an Adminstrator Powershell\
\
Set-ExecutionPolicy Bypass -Scope Process -Force;
\[System.Net.ServicePointManager\]::SecurityProtocol =
\[System.Net.ServicePointManager\]::SecurityProtocol -bor 3072; iex
((New-Object
System.Net.WebClient).DownloadString(\'https://community.chocolatey.org/install.ps1\'))\
\
\# Search for a package / Install a package

choco search \<package\>\
choco install \<package\>\
\
\# Update packages

choco upgrade all
```

## Git

Download the installer from the official website
<https://git-scm.com/downloads/win> and run it. The default options
presented by the install wizard are OK for our purposes.\
In addition we can consider any of these (or other) GUI options:

- Github Desktop: <https://git-scm.com/downloads/win>

- GitKraken Desktop: <https://www.gitkraken.com/>

## Node

Download the installer from the official website,
<https://nodejs.org/en/download>. Be aware that the website suggests
using tools like Chocolatey, to download the installer the instructions
appear bellow.

Run the installer with the default options.

In addition, we can consider other CLI tools that help with performance
/ resource management, like:

- YARN: <https://yarnpkg.com/>

- PNPN: <https://pnpm.io/>

- Bun: <https://bun.com/>

## PHP / Composer / Laravel

In an Administrator PowerShell run this command. It installs PHP,
Composer and the Laravel CLI:

```powershell

# Run as administrator...

Set-ExecutionPolicy Bypass -Scope Process -Force; [System.Net.ServicePointManager]::SecurityProtocol = [System.Net.ServicePointManager]::SecurityProtocol -bor 3072; iex ((New-Object System.Net.WebClient).DownloadString('https://php.new/install/windows/8.5'))

```

In addition, we can consider using a GUI tool like Laravel Herd,
<https://herd.laravel.com/windows>. This tool allows us to graphically
manage Laravel projects. The only downside is that it only manages
Laravel, so the rest of our toolset needs different management
workflows.

## Code Editor

The recommend code editor for our project is Visual Studio Code. We can
install it from the official website,
<https://code.visualstudio.com/download>.

The advantage of using a tool like VSCode is its ecosystem, the
following are recommended extensions that will help with our development
efforts:

- Laravel:
  <https://marketplace.visualstudio.com/items?itemName=laravel.vscode-laravel>

- Vue (Official):
  <https://marketplace.visualstudio.com/items?itemName=Vue.volar>

- PHP Intelephense:
  <https://marketplace.visualstudio.com/items?itemName=bmewburn.vscode-intelephense-client>

- ESLint:
  <https://marketplace.visualstudio.com/items?itemName=dbaeumer.vscode-eslint>

- Prettier:
  <https://marketplace.visualstudio.com/items?itemName=esbenp.prettier-vscode>

In addition, we can look at other IDEs like:

- JetBrains PHP Storm: <https://www.jetbrains.com/phpstorm/>

- JetBrains Web Storm: <https://www.jetbrains.com/webstorm/>

We can access JetBrains products for education here:
<https://www.jetbrains.com/academy/student-pack/>

## Docker

Download the installer from the official website,
<https://docs.docker.com/desktop/setup/install/windows-install/>, and
run the installer with the default options.

Sometimes there are technology components that do not exist for Windows,
one way to circumvent this limitation is to use Windows Subsystem for
Linux (WLS). Later in the course we will need this for the project
deployment.\
Follow the instructions on the official documentation:
<https://learn.microsoft.com/en-us/windows/wsl/install>
