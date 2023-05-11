# Exercício Conta Bancária

Este exercício é dado na parte de revisão de Conceitos Básicos de Orientação a Objetos da disciplina GAC106 - Práticas de Programação Orientada a Objetos.

Basta seguir os passos relatados a seguir.

## Passo 1 - Representando uma conta bancária

Esse e os próximos exercícios se referem às operações de uma conta bancária.
Nesse primeiro passo, crie uma classe para representar uma conta bancária, que atenda às necessidades abaixo.
Lembre-se de usar adequadamente os modificadores de visibilidade (`public` ou `private`) dos atributos e métodos.

- As contas devem possuir um saldo e um limite.
- Deve existir um método para consultar o saldo.
- Devem existir métodos para saque e para depósito de valores na conta.
- A conta pode ter saldo negativo no máximo até o limite estabelecido.
- A classe não deve ter nenhuma interação com o usuário (ou seja, dentro dela não deve existir exibição de mensagens, nem leitura de dados).

## Passo 2 - Representando um caixa eletrônico

Crie também uma outra classe que represente um Caixa Eletrônico.
Nesta classe, por enquanto, crie um atributo para guardar uma única conta.
Em seguida implemente um menu com as opções abaixo (implemente métodos separados para tratar cada opção).

```
1. Criar Conta
2. Consultar Saldo
3. Depositar
4. Sacar
5. Sair
```

Por fim, altere a classe que tem o método `main`, para que nele seja criado um objeto da classe que representa o caixa eletrônico e dispare a execução do menu.

- Dica 1: lembre-se de há um exemplo de implementação de menu no gabarito do exercício prático da aula passada.
- Dica 2: repare que se o usuário acessar as opções que alteram a conta, antes da conta ser criada, ocorrerá um erro de `NullPointerException`. Podemos facilmente evitar esse problema, verificando primeiro se o atributo que representa a conta é diferente de `null` (e informando apropriadamente ao usuário).

Teste suas implementações!

## Passo 3 - Representando um cliente

A classe que representa as contas passará a ter os dados do seu titular.
Para isso, vamos primeiro criar uma nova classe para representar um cliente.
Tal classe deve ter:

- Atributos nome e CPF (podem ser do tipo `String` mesmo).
- Métodos para consultar o nome e o CPF do cliente.
- Lembrando que esta classe também não deve ter nenhuma interação com o usuário.

## Passo 4 - Tratando titular da conta

Altere a classe que representa a conta bancária para que ela tenha um atributo do tipo cliente, e altere o construtor da classe de forma que ele receba um objeto cliente por parâmetro.

Por fim, altere a classe que representa o caixa eletrônico para que:

- Na criação de contas, obtenha do usuário o nome e o CPF do cliente, crie o objeto correspondente, e utilize-o para criar a conta.
- Na opção de consultar saldo, seja exibido o nome do titular da conta junto com o saldo.

Teste suas implementações!

## Passo 5 - Construtores

Altere a classe que representa as contas bancárias de forma que ela passe a ter dois construtores.

- Os dois construtores devem receber o cliente e o valor do limite da conta.
- E apenas um deles deve receber o valor do saldo inicial da conta. Portanto, no outro construtor o saldo deve ser inicializado com zero.

Altere então a classe do caixa eletrônico para que existam duas opções diferentes de criação de contas.

- Uma que pede para o usuário o saldo inicial e outra que não pede.
- Cada opção deve chamar o construtor correspondente.

Como o operador `this` poderia ser utilizado em um dos construtores para evitar replicação de código? (Dica: veja os slides de revisão dos conceitos de OO).

Teste suas implementações!

#TODO : Parei aqui D:
## Passo 6 - Numeração das contas

Neste passo, a ideia é que as contas bancárias tenham um novo atributo para guardar o número da conta e um método que retorne essa informação.

Nós poderíamos receber o número de cada conta no construtor e deixar a classe do caixa eletrônico definir a numeração.
Mas é mais interessante se a própria classe que representa as contas tratar automaticamnete a numeração, utilizando o conceito de atributo estático.

Para isso, crie um atributo estático na classe que representa as contas para guardar o número da última conta criada (inicialmente ele deve ter o valor 100).
Repare que são dois atributos diferentes:

- Um é o número da conta que é diferente para cada conta (atributo comum).
- E o outro é um atributo estático que indica o número da última conta criada (atibuto estático, que tem o mesmo valor para todas as contas).

No construtor da classe que representa as contas o atributo estático deve ser incrementado, e o seu valor deve ser usado como número da conta que está sendo criada.

## Passo 7 - Tratando mais de uma conta

Na classe que trata o caixa eletrônico, crie mais um atributo para que ela passe então a tratar duas contas bancárias.

- Na opção de menu de criar contas, trate para que o usuário forneça os dados das duas contas.
- Após a criação de cada conta, o programa deve exibir o número gerado para cada conta de forma que o usuário saiba o número que deve usar nas demais operações.

Lembre-se também de alterar as demais opções de menu (consultar saldo, saque e depósito), pois o usuário terá agora que informar o número da conta com a qual ele quer tratar.

Teste suas implementações!

## Passo 8 - Transferência entre contas

Agora que conseguimos criar contas diferentes, podemos fazer transferências entre elas.
Crie um método na classe que representa as contas para realizar a transferência entre duas contas.

- O método deve receber por parâmetro o valor a ser transferido e o objeto da conta de destino.
- O método não deve alterar diretamente o saldo da conta e sim chamar os métodos de saque e depósito apropriadamente.
- Lembre-se que a conta não deve permitir a transferência se o valor solicitado estiver além do limite da conta de origem.

Na classe que representa o caixa eletrônico, crie uma opção de menu para transferência entre contas.

- O usuário deverá escolher qual será a conta de origem e qual será a conta de destino (de acordo com os números das contas).

Teste suas implementações!

## (Opcional) Passo 9 - Rendimento na conta

Suponha que nossa conta é especial e possui um rendimento periódico.
Para tratá-lo faça o seguinte:

- Na classe que representa as contas, crie um atributo estático para guardar o valor da taxa de rendimento (percentual).
- Crie um método `render` que aplica a taxa de rendimento ao saldo da conta. Avalie se tal método deve ser estático ou não.
- Pro fim, crie uma opção de menu na classe que representa o caixa eletrônico para que o usuário possa fazer a conta render.

## (Opcional) Passo 10 - Alterando rendimento

Crie um método na classe que representa as contas para alterar a taxa de rendimento da conta (e crie uma opção de menu para o usuário informar a nova taxa).

Avalie se o método deve ser estático ou não.
