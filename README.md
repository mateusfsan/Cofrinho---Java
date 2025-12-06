# Cofrinho (Java)

Pequeno sistema que emula um cofrinho de moedas utilizando herança e polimorfismo.
Projeto educativo com implementação das classes: `Moeda` (abstrata), `Real`, `Dolar`, `Euro`, `Cofrinho`, `ConversorMoeda` (API de cotação) e `Principal`.

## Estrutura do projeto

- src/cofrinho/
  - Moeda.java
  - Real.java
  - Dolar.java
  - Euro.java
  - Cofrinho.java
  - ConversorMoeda.java
  - Principal.java

## Requisitos

- JDK 11 ou superior
- Sistema Windows (instruções em PowerShell)
- Conexão com a internet para obter cotações atualizadas via [ExchangeRate-API](https://www.exchangerate-api.com/)

## Como compilar (PowerShell)

```powershell
javac -d out src\cofrinho\*.java
```

## Como executar (PowerShell)

```powershell
java -cp out cofrinho.Principal
```

## Sobre a integração com a API de cotação

O projeto utiliza a [ExchangeRate-API](https://www.exchangerate-api.com/) para buscar cotações atualizadas de moedas estrangeiras (Dólar, Euro, etc) para Real.  
A classe `ConversorMoeda.java` faz requisições HTTP e realiza o parse manual do JSON retornado, sem dependências externas.

