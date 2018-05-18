### UnB - Universidade de Brasilia
### FGA - Faculdade do Gama
### DAS - Desenvolvimento Avançado de Software
------

### Avaliação 2 
#### Refatoração

##### Instruções da avaliacao:  
* Avaliação individual e sem consulta
* Os catálogos de refatoração disponibilizados na página da disciplina poderão ser consultados. 
* Para cada resolução de questão o aluno deverá realizar um _commit_. Exemplo: resolução da questão 1 --> commit 1; resolução da questão 2 --> commit 2, e assim por diante. 
* Ao final da avaliação, o envio das questões será realizado através de um único pull-request.
* O entendimento das questões faz parte da prova.  
* Prazo final de entrega: 18/05/2018, 17:50hs.
* Boa sorte!

----


Considere o seguinte cenário: 

Para todo e qualquer tipo de financiamento é necessário informar o valor a ser financiado (PV - _present value_), a taxa de juros _i_ (_interest_) e o número _n_ de parcelas. Com base nesses valores é possível estabelecer dois tipos de financiamento: PRICE e SAC (sistema de amortização constante). Um financiamento que segue o modelo PRICE caracteriza-se por apresentar parcelas fixas, mas com composição variável. Cada parcela price (_pmt_) é formada pela amortização (_amort_) do valor financiado _PV_ e o valor de juros pagos para aquela parcela. Parcelas iniciais caracterizam-se por ter juros maiores e amortizações menores do que parcelas finais. Vide tabela abaixo:

|n| Valor Parcela | Juros    | Amortização |
|-|:-------------:|:--------:|:-----------:|
|1| R$ 1113,26    | R$ 200,00|  R$ 913,26  |
|2| R$ 1113,26    | R$ 181,73|  R$ 931,53  |
|3| R$ 1113,26    | R$ 163,10|  R$ 950,16  |
|4| R$ 1113,26    | R$ 144,10|  R$ 969,16  |
|5| R$ 1113,26    | R$ 124,71|  R$ 988,54  |
|6| R$ 1113,26    | R$ 104,94|  R$ 1008,31 |
|7| R$ 1113,26    | R$ 84,78 |  R$ 1028,48 |
|8| R$ 1113,26    | R$ 64,21 |  R$ 1049,05 |
|9| R$ 1113,26    | R$ 43,22 |  R$ 1070,03 |
|10|R$ 1113,26    | R$ 21,82 |  R$ 1091,43 |


O código presente no [repositório da avaliação][repositorio] contem uma simulação, sob a forma de testes, de 4 financiamentos PRICE para o valor de PV = R$10000,00, mas com diferentes prazos e taxas de juros. Esses testes podem ser executados através da suite de testes presente na classe _tst.AllTests.java_. Com base nessa suíte de testes, faça o que se pede a seguir:

1) aplique a operação de refatoração _Dividir variável temporária_ no método *Price.calcularPrestacoes()* de modo a dividir a variável temp em em três variáveis distintas. (Valor: 25 pontos).   
2) aplique a operação de refatoração _Extrair método objeto_ no método refatorado *Price.calcularPrestacoes()* de modo que tal método seja representado por um objeto. (Valor: 40 pontos).   
3) aplique a operação de refatoração _Remover homem do meio_ no método *Modalidade.calcularTotalJuros* de modo a extrair a indireção presente nesse método. (Valor: 35 pontos).

[repositorio]:https://github.com/andrelanna/avaliacao2DAS.git
