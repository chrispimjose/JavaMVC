import controller.ProdutoController;
import service.ProdutoService;
import view.ProdutoView;

public class App {
    public static void main(String[] args) throws Exception {
        
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
}
