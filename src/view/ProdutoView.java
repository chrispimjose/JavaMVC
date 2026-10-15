package view;

import java.util.Scanner;
import model.Produto;

public class ProdutoView {

    private Scanner teclado;

    public ProdutoView() {

        teclado = new Scanner(System.in);
    }

    public int mostrarMenu() {

        System.out.println();
        System.out.println("=========================");
        System.out.println("      SISTEMA MVC");
        System.out.println("=========================");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Consultar produto");
        System.out.println("3 - Listar produtos");
        System.out.println("0 - Sair");
        System.out.println("=========================");
        System.out.print("Escolha uma opção: ");

        return teclado.nextInt();
    }

    public int lerCodigo() {

        System.out.print("Código: ");

        return teclado.nextInt();
    }

    public String lerNome() {

        teclado.nextLine();

        System.out.print("Nome: ");

        return teclado.nextLine();        
    }

    public double lerPreco() {

        System.out.print("Preço: ");

        return teclado.nextDouble();
    }

    public int lerQuantidade() {

        System.out.print("Quantidade: ");

        return teclado.nextInt();
    }

    public void mostrarMensagem(String mensagem) {

        System.out.println();
        System.out.println(mensagem);
    }

    public void mostrarProduto(
            Produto produto,
            double total) {

        System.out.println();
        System.out.println("-------------------------");
        System.out.println("Código: " + produto.getCodigo());
        System.out.println("Nome: " + produto.getNome());
        System.out.println("Preço: R$ " + produto.getPreco());
        System.out.println("Quantidade: " + produto.getQuantidade());
        System.out.println("Valor em estoque: R$ " + total);
        System.out.println("-------------------------");
    }   

    public void fecharScanner() {
        teclado.close();
    }

    
}