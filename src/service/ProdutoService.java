package service;

import model.Produto;

public class ProdutoService {

    private Produto[] produtos;
    private int contador;

    public ProdutoService() {

        produtos = new Produto[10];

        contador = 0;
    }

    public boolean cadastrar(
            int codigo,
            String nome,
            double preco,
            int quantidade) {

        if (contador >= produtos.length) {
            return false;
        }

        Produto produto = new Produto(
                codigo,
                nome,
                preco,
                quantidade
        );

        produtos[contador] = produto;

        contador++;

        return true;
    }

    public Produto buscarPorCodigo(int codigo) {

        for (int i = 0; i < contador; i++) {

            if (produtos[i].getCodigo() == codigo) {
                return produtos[i];
            }
        }

        return null;
    }

    public Produto[] listarTodos() {

        return produtos;
    }

    public int getQuantidadeCadastrada() {

        return contador;
    }

    public double calcularValorEstoque(Produto produto) {

        return produto.getPreco()
                * produto.getQuantidade();
    }
}