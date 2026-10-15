# JavaMVC

Projeto didático desenvolvido em Java com o objetivo de demonstrar, de forma simples e prática, a implementação do padrão arquitetural **MVC (Model-View-Controller)** sem o uso de frameworks.

O projeto utiliza uma aplicação em console para exemplificar a separação de responsabilidades entre as camadas da aplicação, permitindo compreender como os dados, a interface, o controle do fluxo e as regras de negócio podem ser organizados de forma independente.

## Objetivos do projeto

Este projeto foi criado para trabalhar conceitos fundamentais de desenvolvimento em Java, como:

- criação e organização de packages;
- definição de classes e objetos;
- uso de atributos, construtores e métodos;
- encapsulamento com getters;
- utilização de `Scanner` para entrada de dados;
- criação de menus com `do / while`;
- uso de vetores de objetos;
- aplicação do padrão MVC;
- separação da lógica de negócio em uma camada `Service`;
- simulação de persistência de dados sem banco de dados real.

## Estrutura do projeto

```text
JavaMVC
│
└── src
    ├── app
    │   └── App.java
    │
    ├── controller
    │   └── ProdutoController.java
    │
    ├── model
    │   └── Produto.java
    │
    ├── service
    │   └── ProdutoService.java
    │
    └── view
        └── ProdutoView.java
```

## Organização das camadas

O fluxo principal da aplicação segue a estrutura:

```text
View
  ↓
Controller
  ↓
Service
  ↓
Model
```

## Model

A classe `Produto` representa os dados da aplicação.

Ela contém:

- código;
- nome;
- preço;
- quantidade.

A função do **Model** é representar os dados e manter a estrutura das entidades utilizadas pelo sistema.

Exemplo:

```java
package model;

public class Produto {

    private int codigo;
    private String nome;
    private double preco;
    private int quantidade;

    public Produto(int codigo, String nome, double preco, int quantidade) {
        this.codigo = codigo;
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }
}
```

## View

A classe `ProdutoView` é responsável pela interação com o usuário.

Ela realiza:

- exibição do menu;
- leitura dos dados pelo teclado;
- apresentação das mensagens;
- exibição dos produtos cadastrados.

A **View** não deve conter regras de negócio. Sua responsabilidade é receber dados do usuário e apresentar informações.

## Controller

A classe `ProdutoController` controla o fluxo da aplicação.

Ela recebe as ações realizadas pelo usuário na `View` e direciona as operações para a camada `Service`.

O Controller funciona como intermediário entre a interface e as regras da aplicação.

O fluxo pode ser representado assim:

```text
Usuário
   ↓
ProdutoView
   ↓
ProdutoController
   ↓
ProdutoService
   ↓
Produto
```

## Service

A classe `ProdutoService` concentra as operações relacionadas aos produtos.

Neste projeto, ela também utiliza um vetor de objetos:

```java
Produto[] produtos = new Produto[10];
```

Esse vetor funciona como um simulacro de banco de dados, armazenando os objetos enquanto o programa está em execução.

Essa solução é propositalmente simplificada para fins didáticos.

Em uma aplicação maior, essa camada poderia trabalhar com:

```text
DAO
Repository
Banco de Dados
API
Arquivo
```

## Fluxo de cadastro

O processo de cadastro de um produto segue o fluxo:

```text
Usuário
   ↓
View
   ↓
Controller
   ↓
Service
   ↓
Model
```

A `View` recebe os dados do usuário.

O `Controller` coordena a operação.

O `Service` executa a lógica de cadastro.

O `Model` representa os dados armazenados.

## Responsabilidade de cada camada

```text
Model
    Representa os dados

View
    Entrada e saída de informações

Controller
    Controla o fluxo da aplicação

Service
    Executa regras e operações

App
    Inicializa o sistema
```

## Armazenamento dos dados

Neste projeto, os produtos são armazenados em um vetor:

```java
Produto[] produtos = new Produto[10];
```

Isso significa que o sistema pode armazenar até **10 produtos** durante a execução.

Cada posição do vetor armazena uma referência para um objeto do tipo `Produto`.

Representação simplificada:

```text
produtos

[0] → Produto
[1] → Produto
[2] → Produto
[3] → null
[4] → null
...
[9] → null
```

Como o vetor possui tamanho fixo, é necessário controlar a quantidade de posições utilizadas.

Exemplo:

```java
private int contador;
```

No momento do cadastro:

```java
produtos[contador] = produto;

contador++;
```

## Scanner

A entrada de dados é realizada na camada `View` utilizando a classe `Scanner`.

Exemplo:

```java
Scanner teclado = new Scanner(System.in);
```

Ao final da execução do programa, o recurso pode ser fechado:

```java
public void fecharScanner() {
    teclado.close();
}
```

## Tecnologias utilizadas

```text
Java 21
Visual Studio Code
Programação Orientada a Objetos
MVC
Aplicação em Console
```

## Objetivo didático

Este projeto serve como base para compreender como uma aplicação Java pode ser organizada em camadas.

Os principais conceitos trabalhados são:

```text
Classes
Objetos
Atributos
Construtores
Métodos
Encapsulamento
Vetores
Packages
MVC
Service
Scanner
Entrada e saída de dados
```

## Possíveis evoluções do projeto

A partir desta estrutura, o projeto pode evoluir para incluir:

- alteração de produtos;
- exclusão de produtos;
- validação de código duplicado;
- uso de `ArrayList`;
- criação de uma camada `DAO`;
- criação de uma camada `Repository`;
- persistência em banco de dados;
- tratamento de exceções;
- interface gráfica;
- integração com APIs;
- testes automatizados.

Uma possível evolução da arquitetura seria:

```text
View
  ↓
Controller
  ↓
Service
  ↓
DAO / Repository
  ↓
Banco de Dados
```

## Execução

A classe responsável por iniciar o sistema é a classe `App`.

```java
public static void main(String[] args) {

    ProdutoView view =
            new ProdutoView();

    ProdutoService service =
            new ProdutoService();

    ProdutoController controller =
            new ProdutoController(
                    view,
                    service
            );

    controller.executar();

    view.fecharScanner();
}
```

## Finalidade

O projeto **JavaMVC** foi desenvolvido para fins educacionais e demonstra como aplicar conceitos de organização de software, orientação a objetos e separação de responsabilidades utilizando Java puro e sem dependência de frameworks.
