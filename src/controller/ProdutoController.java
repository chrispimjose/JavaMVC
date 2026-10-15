package controller;

import model.Produto;
import service.ProdutoService;
import view.ProdutoView;

public class ProdutoController {

    private ProdutoView view;
    private ProdutoService service;

    public ProdutoController(
            ProdutoView view,
            ProdutoService service) {

        this.view = view;
        this.service = service;
    }

    public void executar() {

        int opcao;

        do {

            opcao = view.mostrarMenu();

            switch (opcao) {

                case 1:
                    cadastrarProduto();
                    break;

                case 2:
                    consultarProduto();
                    break;

                case 3:
                    listarProdutos();
                    break;

                case 0:
                    view.mostrarMensagem(
                            "Programa encerrado."
                    );
                    break;

                default:
                    view.mostrarMensagem(
                            "Opção inválida."
                    );
            }

        } while (opcao != 0);
    }

    private void cadastrarProduto() {

        int codigo = view.lerCodigo();

        String nome = view.lerNome();

        double preco = view.lerPreco();

        int quantidade = view.lerQuantidade();

        boolean resultado = service.cadastrar(
                codigo,
                nome,
                preco,
                quantidade
        );

        if (resultado) {

            view.mostrarMensagem(
                    "Produto cadastrado com sucesso."
            );

        } else {

            view.mostrarMensagem(
                    "Não foi possível cadastrar."
            );
        }
    }

    private void consultarProduto() {

        int codigo = view.lerCodigo();

        Produto produto =
                service.buscarPorCodigo(codigo);

        if (produto == null) {

            view.mostrarMensagem(
                    "Produto não encontrado."
            );

            return;
        }

        double total =
                service.calcularValorEstoque(produto);

        view.mostrarProduto(
                produto,
                total
        );
    }

    private void listarProdutos() {

        Produto[] produtos =
                service.listarTodos();

        int quantidade =
                service.getQuantidadeCadastrada();

        if (quantidade == 0) {

            view.mostrarMensagem(
                    "Nenhum produto cadastrado."
            );

            return;
        }

        for (int i = 0; i < quantidade; i++) {

            double total =
                    service.calcularValorEstoque(
                            produtos[i]
                    );

            view.mostrarProduto(
                    produtos[i],
                    total
            );
        }
    }
}