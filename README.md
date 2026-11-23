# Employee Management System — Java

Sistema de gerenciamento de funcionários desenvolvido em Java, com foco na aplicação prática dos conceitos de Programação Orientada a Objetos (POO).

O projeto simula um sistema de Recursos Humanos, permitindo realizar operações de cadastro, consulta e gerenciamento de funcionários por meio de uma interface no terminal.

## Funcionalidades

- Cadastro de funcionários com geração automática de IDs
- Listagem de funcionários cadastrados
- Busca de funcionários pelo ID
- Aumento salarial por percentual
- Remoção de funcionários com confirmação
- Cálculo da folha salarial total
- Validação de dados e entradas numéricas

## Tecnologias utilizadas

- Java
- Programação Orientada a Objetos
- Java Collections (`ArrayList` e `List`)
- Scanner
- IntelliJ IDEA
- Git e GitHub

## Estrutura do projeto

**Employee.java — entities**

Representa um funcionário, contendo seus atributos, métodos de acesso, geração automática de ID e cálculo de reajuste salarial.

**EmployeeService.java — service**

Responsável pelas regras de negócio, incluindo cadastro, busca, remoção, reajuste salarial e cálculo da folha salarial.

**Program.java — app**

Responsável pela interface no terminal e pela interação com o usuário.

## Como executar

1. Clone este repositório.
2. Abra o projeto no IntelliJ IDEA.
3. Configure um JDK compatível.
4. Execute o método `main()` da classe `Program`.
5. Utilize o menu do terminal para acessar as funcionalidades.

## Objetivo do projeto

Este projeto foi desenvolvido para praticar os conhecimentos adquiridos durante meus estudos em Java, especialmente encapsulamento, construtores, métodos, coleções, validações e separação de responsabilidades.

## Observações

O sistema armazena os funcionários em memória. Os dados não são persistidos após o encerramento do programa.

## Licença

Este projeto está disponibilizado sob a licença MIT.