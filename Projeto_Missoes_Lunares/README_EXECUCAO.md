
# Projeto_Missoes_Lunares

Projeto em Java (Maven) que implementa um sistema de controle de missões lunares. 
Cumpre os requisitos obrigatórios do enunciado: entidades `Missao`, `Astronauta`, `Nave`,
persistência via **Serialização binária** e **NitriteDB**, validações e um **menu interativo** em modo texto.

## Como compilar e executar

Requisitos:
- Java 11+
- Maven

Para compilar:
```
mvn -q -DskipTests package
```

Para executar (via plugin exec):
```
mvn -q exec:java -Dexec.mainClass="br.unochapeco.missoes.view.Main"
```

## Estrutura do projeto
- `src/main/java/br/unochapeco/missoes`
  - `model` - classes de domínio (Missao, Astronauta, Nave, subclasses)
  - `repository` - classes para persistência (.bin e Nitrite)
  - `service` - regras de negócio
  - `view` - menu interativo (Main)

## Observações
- A persistência Nitrite exige a dependência declarada no `pom.xml`.
- Arquivos de serialização são salvos em `data/missions.bin`.
- Banco Nitrite é criado em `data/nitrite.db`.

