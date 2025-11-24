# 🚀 Guia de Execução do Projeto – Missões Lunares

Este arquivo contém apenas as instruções de execução.  
Todos os comandos estão comentados para evitar execução acidental.

---

## ✅ 1. Pré-requisitos

É necessário ter instalado:

### ✔ Java 17 ou superior  
Para verificar:
```bash
# java -version
```

### ✔ Maven  
Para verificar:
```bash
# mvn -version
```

---

## 📁 2. Abrir o projeto no CMD

Entre na pasta onde o projeto foi extraído.  
Para abrir o CMD diretamente nela:

- Abra a pasta no Explorer  
- Clique na barra de endereço  
- Digite **cmd**  
- Pressione ENTER

Ou manualmente:
```bash
# cd C:\caminho\para\missoes_lunares_project
```

---

## 🔧 3. Compilar o projeto

Use o Maven para compilar:

```bash
# mvn compile
```

---

## ▶️ 4. Executar o projeto

Executar com Maven:

```bash
# mvn exec:java -Dexec.mainClass="br.unochapeco.missoes.view.Main"
```

Se o plugin exec não estiver instalado, use:

```bash
# mvn org.codehaus.mojo:exec-maven-plugin:3.1.0:java -Dexec.mainClass="br.unochapeco.missoes.view.Main"
```

---

## 💡 5. Executar sem Maven (opção alternativa)

Após compilar:

```bash
# java -cp target/classes br.unochapeco.missoes.view.Main
```

---

## 🎉 6. Resultado esperado

Ao executar, você verá uma missão de teste sendo criada e listada:

```
Cadastro rápido de missão:
[Missao M1 - Teste]
```

O arquivo `missoes.bin` será criado automaticamente, armazenando as missões.

---

## ✔ Pronto!

O programa já está completamente executável.
