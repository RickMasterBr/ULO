# ULO — Faculdade

Repositório com o material das aulas da faculdade, organizado por matéria.

## Estrutura

```
ULO/
├── AED/                          # Algoritmos e Estruturas de Dados
│   └── Pratica/
│       ├── Ficha Prática 1 - Recursividade.pdf
│       ├── Ficha Prática 2 - Análise de Complexidade de Algoritmos.pdf
│       ├── Ficha Prática 3 - Algoritmos de Ordenação e Pesquisa.pdf
│       └── Projeto Base AED/     # Projeto Java com todas as fichas
│
├── DAD/                          # Desenvolvimento de Aplicações Distribuídas
│   ├── Pratica/
│   │   ├── lab01-javascript/    # JavaScript & TypeScript
│   │   ├── lab02-devenv/        # Laravel + Vue (Dev Environment)
│   │   └── lab03-memorygame/    # Memory Game (Laravel + Vue)
│   └── Teorica/
│       ├── 01.Javascript.pdf
│       ├── 02.Distributed Applications.pdf
│       ├── 03.Web Application Models.pdf
│       ├── 04.Framework SPA.pdf
│       └── 05.Communication.pdf
│
├── IS/                           # Integração de Sistemas
│   ├── Pratica/
│   │   ├── W-1-SolutionOOP/     # OOP em C#
│   │   ├── W-2-SolutionExcelAutomation/  # Excel Automation (Avalonia)
│   │   ├── Worksheet-3-REST/    # REST APIs em C#
│   │   ├── Worksheet-4/         # XML & Schemas
│   │   └── Worksheet-5/         # Web Services (WCF/SOAP)
│   └── Teorica/
│       ├── 1-IS-BACKGROUND_KICK-OFF_SCENARIO.pdf
│       ├── 2-IS-INTEGRATION_PROBLEMS_APPROACHS AND TYPES.pdf
│       ├── 3-IS-INTRODUCING XML_AND_SCHEMAS.pdf
│       ├── 4-IS-SOA AND THE WEB SERVICES.pdf
│       ├── 5-IS-SOA AND RESTful_Web_Services.pdf
│       └── 6-IS-WEB SERVICES AND SOAP_WSDL_UDDI.pdf
│
└── PA/                           # Programação Avançada (Sistemas Operativos)
    └── Pratica/
        ├── ficha-01-processos/  # Processos (fork, exec, pipes)
        ├── ficha-02-sinais/     # Sinais (signal handling)
        ├── ficha-03/            # (pipes, IPC)
        └── ficha-04-threads/    # POSIX Threads & Sincronização
```

## Matérias

### AED — Algoritmos e Estruturas de Dados
- **Linguagem:** Java
- **Conteúdo:** Recursividade, análise de complexidade, algoritmos de ordenação e pesquisa, coleções (listas, filas, pilhas, árvores, tabelas hash), modelo de contactos/pessoas
- **Projeto Base:** Contém todas as fichas práticas num único projeto Java (jGRASP)

### DAD — Desenvolvimento de Aplicações Distribuídas
- **Linguagens:** JavaScript, TypeScript, PHP (Laravel), Vue.js
- **Conteúdo:** JavaScript (arrays, funções, objetos, async, modules, DOM), TypeScript, Laravel (API + Frontend Vue), WebSockets
- **Lab 02:** Ambiente de desenvolvimento completo (Laravel API + Vue frontend + WebSockets)
- **Lab 03:** Memory Game (Laravel + Vue)

### IS — Integração de Sistemas
- **Linguagem:** C# (.NET)
- **Conteúdo:** OOP, Excel Automation (Avalonia), REST APIs, XML & Schemas, Web Services (WCF/SOAP)
- **Nota:** Cada worksheet é incremental — o código evolui de uma para a seguinte

### PA — Programação Avançada
- **Linguagem:** C
- **Conteúdo:** Processos (fork, exec, pipes), Sinais, IPC, POSIX Threads & Sincronização
- **Nota:** Labs em C compilados com `make`

## Notas
- Arquivos de build (node_modules, vendor, bin, obj, .idea, etc.) são ignorados via `.gitignore`
- A VM do Lubuntu (usada em PA) foi movida para fora do repositório
- Material teórico está em PDFs na pasta `Teorica/` de cada matéria