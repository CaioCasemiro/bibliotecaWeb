# Sistema de Biblioteca Web

Projeto desenvolvido por **Caio Casemiro e Kaio Mourato**

## Índice
- [Introdução](#introdução)
- [Funcionalidades](#funcionalidades)
  - [Cadastro e Autenticação](#cadastro-e-autenticação)
  - [Catálogo de Livros](#catálogo-de-livros)
  - [Empréstimo e Devolução](#empréstimo-e-devolução)
  - [Interação e Avaliação](#interação-e-avaliação)
  - [Notificações por E-mail](#notificações-por-e-mail)
  - [Funcionalidades Administrativas](#funcionalidades-administrativas)
  - [Funcionalidades Extras](#funcionalidades-extras)
- [Tecnologias e Dependências](#tecnologias-e-dependências)
- [Instalação e Configuração](#instalação-e-configuração)

---

## Introdução

Este projeto visa desenvolver um sistema web para gerenciamento de biblioteca, permitindo que:
- **Usuários Comuns** possam visualizar o catálogo, solicitar empréstimos, devolver livros, comentar e avaliar.
- **Administradores** possam gerenciar livros, usuários, gerar relatórios e configurar notificações.

---

## Funcionalidades

### Cadastro e Autenticação
- **Registro de Usuário:** Formulário com campos como nome, e-mail, senha e confirmação de senha.
  - **Tecnologias:**  
    - **Backend:** Spring Boot, Spring Web, Spring Data JPA, Spring Security e BCrypt para criptografia.
    - **Frontend:** Thymeleaf (ou API REST consumida via HTML/CSS/JavaScript).
  - **Endpoint Exemplo:** `POST /api/usuarios/cadastrar`
  
- **Login e Logout:**  
  - **Objetivo:** Autenticar usuários e gerenciar sessões de forma segura.
  - **Tecnologias:**  
    - **Spring Security:** Configuração de filtros e redirecionamento baseado em roles.
  - **Endpoint Exemplo:** `POST /api/usuarios/login`
  
- **Recuperação de Senha:**  
  - **Objetivo:** Permitir a recuperação de senha via e-mail.
  - **Tecnologias:**  
    - **Spring Boot Starter Mail** para envio de e-mails.
  - **Endpoint Exemplo:** `POST /api/usuarios/recuperar-senha`

---

### Catálogo de Livros
- **Listagem de Livros:**  
  - **Objetivo:** Exibir uma lista ou grid de livros disponíveis com filtros (título, autor, gênero).
  - **Tecnologias:**  
    - **Backend:** Spring Boot com Spring Data JPA (utilizando `Pageable` e `Sort`).
    - **Frontend:** Thymeleaf e/ou JavaScript (AJAX) com frameworks CSS como Bootstrap ou Tailwind CSS.
  - **Endpoint Exemplo:** `GET /api/livros`
  
- **Detalhes do Livro:**  
  - **Objetivo:** Exibir informações detalhadas (sinopse, autor, imagem de capa, disponibilidade).
  - **Endpoint Exemplo:** `GET /api/livros/{id}`

---

### Empréstimo e Devolução
- **Solicitação de Empréstimo:**  
  - **Objetivo:** Permitir que o usuário solicite o empréstimo de um livro, verificando sua disponibilidade.
  - **Endpoint Exemplo:** `POST /api/emprestimos/solicitar`
  
- **Devolução do Livro:**  
  - **Objetivo:** Registrar a devolução e atualizar o status do livro.
  - **Endpoint Exemplo:** `PUT /api/emprestimos/devolver/{id}`
  
- **Controle de Datas e Multas:**  
  - **Objetivo:** Calcular multas automaticamente para devoluções atrasadas.
  - **Tecnologias:**  
    - **Backend:** Lógica de serviço para comparação de datas e cálculo da multa diária.
    - **Agendamento:** Spring Boot Scheduling para verificação periódica.

---

### Interação e Avaliação
- **Sistema de Comentários:**  
  - **Objetivo:** Permitir que usuários deixem comentários e feedback sobre os livros.
  - **Endpoint Exemplo:** `POST /api/livros/{id}/comentarios`
  
- **Avaliação dos Livros:**  
  - **Objetivo:** Permitir que usuários avaliem os livros (ex.: de 1 a 5 estrelas) e calcular a média.
  - **Endpoint Exemplo:** `POST /api/livros/{id}/avaliacoes`

---

### Notificações por E-mail
- **Confirmação de Operações:**  
  - **Objetivo:** Enviar e-mails para confirmar empréstimos, devoluções e alterações cadastrais.
  - **Tecnologias:**  
    - **Spring Boot Starter Mail** com templates em Thymeleaf.
  
- **Alertas e Lembretes:**  
  - **Objetivo:** Enviar lembretes sobre datas de devolução e alertas em caso de atraso.
  - **Agendamento:** Utilização do Spring Boot Scheduling.

---

### Funcionalidades Administrativas
- **Gerenciamento de Livros (CRUD):**  
  - **Objetivo:** Permitir que administradores adicionem, editem, removam e listem livros.
  - **Tecnologias:**  
    - **Endpoints REST** protegidos por Spring Security.
    - **Upload de Imagens:** Utilização do Commons FileUpload.
  - **Endpoint Exemplo:** `POST /api/admin/livros`
  
- **Gerenciamento de Usuários:**  
  - **Objetivo:** Visualizar e atualizar perfis de usuários e gerenciar roles.
  - **Endpoint Exemplo:** `PUT /api/admin/usuarios/{id}`
  
- **Relatórios e Estatísticas:**  
  - **Objetivo:** Gerar dashboards com dados de empréstimos, devoluções e multas.
  - **Frontend:** Integração com bibliotecas de gráficos (Chart.js, Google Charts).
  - **Endpoint Exemplo:** `GET /api/admin/relatorios`
  
- **Administração de Notificações:**  
  - **Objetivo:** Configurar templates de e-mail e gerenciar notificações.

---

### Funcionalidades Extras
- **Sistema de Reserva:**  
  - **Objetivo:** Permitir que usuários reservem livros emprestados e sejam notificados quando disponíveis.
  - **Endpoint Exemplo:** `POST /api/livros/{id}/reservar`
  
- **Painel de Feedback:**  
  - **Objetivo:** Permitir o envio de sugestões e reportar problemas por meio de um sistema de tickets.
  
- **Integração com API Externa:**  
  - **Objetivo:** Buscar informações complementares dos livros (ex.: capa em alta resolução, dados bibliográficos).
  - **Exemplo:** API da Open Library (`https://openlibrary.org/api/books?bibkeys=ISBN:{isbn}&format=json`)
  
- **Sistema de Multas Automatizado:**  
  - **Objetivo:** Calcular multas automaticamente para devoluções com atraso.
  - **Agendamento:** Utilização do Spring Boot Scheduling.

---

## Tecnologias e Dependências

- **Backend:**  
  - Spring Boot (Starter Web, Data JPA, Security, Mail, Thymeleaf, Test, Actuator, Scheduling)  
  - Hibernate/JPA  
  - Commons FileUpload

- **Frontend:**  
  - HTML5, CSS3, JavaScript  
  - Thymeleaf  
  - Framework CSS: Bootstrap ou Tailwind CSS

- **Banco de Dados:**  
  - PostgreSQL, MySQL ou outro serviço remoto

- **Outros:**  
  - Docker para conteinerização  
  - Ferramentas de integração contínua (GitHub Actions)

