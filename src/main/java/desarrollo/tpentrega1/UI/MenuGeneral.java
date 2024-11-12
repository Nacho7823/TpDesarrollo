
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

        PedidoUI interfazPedido=new PedidoUI(pedidoController,clienteController, vendedorController, itemsMenuController);
        VendedorUI vendedorUI = new VendedorUI(vendedorController, interfazPedido);
        ClienteUI clienteUI = new ClienteUI(clienteController, interfazPedido);
        
        tabbedPane.addTab("Cliente",clienteUI );
        tabbedPane.addTab("Vendedor", vendedorUI);
        tabbedPane.addTab("ItemMenu",new ItemMenuUI(itemsMenuController));
        tabbedPane.addTab("Pedido",interfazPedido);

        add(tabbedPane);


    }
    }
