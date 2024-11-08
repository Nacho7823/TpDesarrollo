
package desarrollo.tpentrega1.UI;
import desarrollo.tpentrega1.controllers.*;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MenuGeneral extends JFrame{
    public MenuGeneral(ClienteController clienteController,VendedorController vendedorController,ItemsMenuController itemsMenuController, PedidoController pedidoController){
        setTitle("Menu general");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();


        tabbedPane.addTab("Cliente", new ClienteUI(clienteController));
        tabbedPane.addTab("Vendedor", new VendedorUI(vendedorController));
        tabbedPane.addTab("ItemMenu",new ItemMenuUI(itemsMenuController));
        tabbedPane.addTab("Pedido",new PedidoUI(pedidoController, vendedorController, clienteController));

        add(tabbedPane);


    }
    }
