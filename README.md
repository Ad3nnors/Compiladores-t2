# Construção de Compiladores

Trabalho 2 de Construção de Compiladores, matéria ministrada por professor Daniel Lucredio.

Autores: 
- Anderson H. Giacomini RA: 769720
- Sophia S. Schuster RA: 760936

## Conteúdo
- [Descrição](#descricao)
- [Implementação](#implementacao)
- [Como executar](#como)
- [Observações](#obs)

*******

<div id='descricao'>

## Descrição

O trabalho 2 (T2) da disciplina consiste na implementação de um analisador semantico para a linguagem LA (Linguagem Algorítmica) desenvolvida pelo prof. Jander, no âmbito do DC/UFSCar. O analisador sintático deve ler um programa-fonte e apontar onde existe erro sintático, indicando a linha e o lexema que causou a detecção do erro.
  
Os erros léxicos detectados no T1 devem continuar sendo detectados corretamente. Link T1.

<div id='implementacao'>

## Implementação

Para a implementação do trabalho foi utilizado a ferramenta ANTLR (antlr.org) no ambiente Netbeans juntamente com o Maven. As informações de como trabalhar com ANTLR no maven encontram-se em https://www.antlr.org/api/maven-plugin/latest/usage.html

<div id='como'>

## Como rodar

<strike>Após importar e compilar o projeto, será gerado uma pasta target com o arquivo .jar já com todas dependencias.</strike>
  
O analisador pode ser executado em linha de comando (windows, mac ou linux), com DOIS ARGUMENTOS OBRIGATORIAMENTE:
  
Argumento 1: arquivo de entrada (caminho completo)<br>
Argumento 2: arquivo de saída (caminho completo)

Exemplo de como rodar o analisador:

```
java -jar C:\compiladorest1\target\compiladorest1-1.0-SNAPSHOT-jar-with-dependencies.jar C:\compiladorest1\casos-de-teste\1.casos_teste_t1\entrada\20-algoritmo_7-3_apostila_LA.txt C:\compiladorest1\saida.txt
```

Como resultado, seu compilador deve ler a entrada de C:\compiladorest1\casos-de-teste\1.casos_teste_t1\entrada\20-algoritmo_7-3_apostila_LA.txt e salvar a saída no arquivo C:\compiladorest1\saida.txt

<div id='obs'>

## Observações

Encontram-se também nesse projeto:
  
Os casos de teste <br>
O compilador automático 

Todo esse conteúdo foi disponibilizado pelo professor. 

