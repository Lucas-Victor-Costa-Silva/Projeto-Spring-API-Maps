# Sistema de Gerenciamento de Clientes
Este projeto é uma aplicação de gerenciamento de clientes que permite o cadastro, consulta, edição e exclusão de clientes, incluindo informações geográficas para precisas entregas. A aplicação é desenvolvida usando Java, Spring Boot, MySQL, HTML, CSS, JavaScript, Bootstrap e a API do Google Maps.

## Requisitos Funcionais
Cadastro de Clientes: É necessário fornecer o Nome e o CNPJ do cliente para cadastrar.

Endereço e Coordenadas: O endereço do cliente deve ser registrado e associado a coordenadas geográficas (latitude e longitude).

Validação de Cadastro: Um cliente só pode ser cadastrado se possuir nome, CNPJ e endereço com coordenadas válidas.

Exibição em Mapa: Os clientes cadastrados devem ser exibidos em um mapa utilizando a API do Google Maps.

## Requisitos Não Funcionais
Versões Utilizadas: A aplicação foi desenvolvida usando Java 20, Spring Boot 3, MySQL, HTML, CSS, JavaScript e Bootstrap.

Padrão MVC: A arquitetura segue o padrão Model-View-Controller para separação de responsabilidades.

Clean Code: O código é desenvolvido seguindo boas práticas de programação e organização.

Testes: São implementados testes automatizados para validar as regras de negócio.

## Funcionalidades Implementadas
Cadastro de Clientes: Cadastre novos clientes com nome, CNPJ e endereço.

Validação de Dados: O sistema valida CNPJ, latitude, longitude e outros campos para garantir dados válidos.

Consulta e Edição: Consulte e edite os detalhes dos clientes cadastrados.

Exclusão: Exclua clientes do sistema.

Exibição em Mapa: Visualize os clientes cadastrados em um mapa interativo.

## Instruções de Compilação e Execução
Certifique-se de ter o Java 20 e o Maven instalados.

Clone o repositório:

git clone https://github.com/Lucas-Victor-Costa-Silva/Projeto-Spring-API-Maps

Acesse a pasta do projeto:

cd Projeto-Spring-API-Maps

Configure as credenciais do MySQL no arquivo application.properties.

Observações

Certifique-se de ter uma conta do Google Cloud Platform e uma API Key para usar a API do Google Maps.

Adiciona essa Key no arquivo springboot\src\main\resources\templates\customers\detailCustomers.html no lugar de  <script src="https://maps.googleapis.com/maps/api/js?key=YOUR_API_KEY&callback=initMap" async defer></script>
YOUR_API_KEY

Compile o projeto:

Execute a aplicação:

Acesse a aplicação em http://localhost:8080/listCustomers.

Este documento fornece uma visão geral do sistema de gerenciamento de clientes e instruções básicas para compilar, executar e testar a aplicação. Certifique-se de seguir todas as etapas e ajustar as configurações conforme necessário para que a aplicação funcione corretamente em seu ambiente.

![Criar](https://github.com/Lucas-Victor-Costa-Silva/Projeto-Spring-API-Maps/assets/96890095/09e7a6c0-9799-48c3-8843-56661c9c19cc)


![Tabela-de-Clientes](https://github.com/Lucas-Victor-Costa-Silva/Projeto-Spring-API-Maps/assets/96890095/8d4e6fe9-a4e3-4dc8-bfc6-f7f8b3bcdd22)


![Editar](https://github.com/Lucas-Victor-Costa-Silva/Projeto-Spring-API-Maps/assets/96890095/93e8ceef-cc84-4e0a-b40c-5a58e440f345)


![Validações](https://github.com/Lucas-Victor-Costa-Silva/Projeto-Spring-API-Maps/assets/96890095/96922daf-8a0d-4ae7-8001-780402a32f99)


![Detalhes](https://github.com/Lucas-Victor-Costa-Silva/Projeto-Spring-API-Maps/assets/96890095/ada1f051-db72-4dc6-8671-7771d881bbcd)


![Mapas](https://github.com/Lucas-Victor-Costa-Silva/Projeto-Spring-API-Maps/assets/96890095/bf67c333-dfa7-45e2-91f0-06cf8fb6fda2)


