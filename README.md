# Projeto – Sistema de Controle de Missões Lunares

Este trabalho consiste no desenvolvimento de um sistema em Java para simular o controle básico de missões espaciais direcionadas à Lua, dentro de uma agência fictícia chamada *Lunar Systems. O objetivo é aplicar conceitos de **Orientação a Objetos, **encapsulamento, **herança, **regras de negócio* e *persistência de dados*.

---

## 🎯 Objetivo Geral
Criar um sistema capaz de registrar, organizar e consultar informações sobre missões lunares, astronautas e naves espaciais, utilizando boas práticas de modelagem e programação orientada a objetos.

---

## 🧩 Componentes Principais do Sistema

### ✔ Missão
Representa uma viagem com destino à Lua.  
Deve armazenar:
- código único  
- nome  
- datas de lançamento e retorno  
- destino  
- objetivo  
- resultado científico  
- nave utilizada  
- lista de astronautas participantes  

Também deve permitir calcular a *duração da missão*.

---

### ✔ Astronauta
Representa um profissional da missão, contendo:
- nome  
- idade  
- especialidade  
- horas de voo  

*Regra obrigatória:* apenas astronautas com *21 anos ou mais* podem participar de missões.

---

### ✔ Nave
Veículo espacial utilizado.  
O trabalho permite uso de *herança*, por exemplo:
- Nave Tripulada  
- Nave Cargueira  

Deve conter:
- ID  
- modelo  
- capacidade máxima de tripulantes  

É obrigatório validar se a nave suporta o número de astronautas escolhido.

---

## 📚 Regras de Negócio
O sistema deve obrigatoriamente respeitar:

1. *Código único* para cada missão.  
2. Astronautas devem ter *idade mínima de 21 anos*.  
3. A nave deve comportar a quantidade de tripulantes.  
4. As datas devem ser válidas (retorno não pode ser antes do lançamento).  
5. O sistema deve permitir:
   - registrar missão  
   - listar missões  
   - buscar astronauta  
   - registrar resultado científico  
6. Todas as missões devem armazenar seu resultado.

---

## 💾 Persistência de Dados
O PDF indica duas possibilidades:

- Serialização Java  
- NitriteDB  

Pode ser utilizada apenas *serialização*, desde que exista persistência funcional.

---

## 🗂 Organização do Projeto

O trabalho deve seguir a divisão em camadas/pacotes:

- *model:* classes principais (Missao, Astronauta, Nave...)  
- *repository:* persistência de dados  
- *service:* regras de negócio e validações  
- *view:* interface simples em modo texto  

---

## 🧪 Entrega e Avaliação

Segundo as orientações do professor:

- A entrega deve ser feita via *GitHub ou GitLab*  
- Todos os integrantes devem possuir *commits próprios*  
- Devem existir arquivos .md explicando:
  - como executar o projeto  
  - o que foi implementado como bônus



## 🛰 Resumo
O trabalho “Viagem à Lua” exige o desenvolvimento de um sistema orientado a objetos, organizado em camadas, persistindo dados e validando regras específicas de missões lunares. A entrega deve ser documentada e versionada através de Git, com participação de todos os integrantes
