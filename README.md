# Cofrinho (Java)

Pequeno sistema que emula um cofrinho de moedas utilizando herança e polimorfismo.
Projeto educativo com implementação das classes: `Moeda` (abstrata), `Real`, `Dolar`, `Euro`, `Cofrinho` e `Principal`.

## Estrutura do projeto

- src/cofrinho/
  - Moeda.java
  - Real.java
  - Dolar.java
  - Euro.java
  - Cofrinho.java
  - Principal.java

## Requisitos

- JDK 11 ou superior
- Sistema Windows (instruções em PowerShell)

## Como compilar (PowerShell)

```powershell
javac -d out src\cofrinho\*.java
```

## Como executar (PowerShell)

```powershell
java -cp out cofrinho.Principal
```

