# 📘 **README -- Como Executar o Projeto pelo CMD**

Este guia explica passo a passo como rodar o projeto
**Projeto_Missoes_Lunares** usando o **Maven** diretamente pelo **CMD
(Prompt de Comando)**.

------------------------------------------------------------------------

## 🚀 **1. Abra o CMD na pasta do projeto**

Entre na pasta raiz onde está o arquivo `pom.xml`:

``` bash
cd C:\Users\joaom\Downloads\trabalhos\Projeto_Missoes_Lunares
```

------------------------------------------------------------------------

## 🧹 **2. Limpar arquivos antigos**

Remove arquivos compilados anteriormente:

``` bash
mvn clean
```

------------------------------------------------------------------------

## 📦 **3. Instalar dependências e compilar tudo**

Baixa as dependências (Nitrite, etc.) e compila o código:

``` bash
mvn install
```

------------------------------------------------------------------------

## 🛠️ **4. Gerar o pacote JAR**

Cria o arquivo `.jar` dentro da pasta `target/`:

``` bash
mvn package
```

------------------------------------------------------------------------

## ▶️ **5. Executar o programa**

Roda o sistema de missões lunares com o menu interativo:

``` bash
mvn exec:java
```

------------------------------------------------------------------------

## ✔️ **Pronto!**

Se todos os comandos forem executados com sucesso, o menu principal do
sistema abrirá no CMD.

