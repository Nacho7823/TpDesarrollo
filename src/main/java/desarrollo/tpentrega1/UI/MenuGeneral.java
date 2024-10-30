
package desarrollo.tpentrega1.UI;
import desarrollo.tpentrega1.controllers.ClienteController;
import desarrollo.tpentrega1.controllers.PedidoController;
import desarrollo.tpentrega1.controllers.VendedorController;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;

public class MenuGeneral extends JFrame{
    public MenuGeneral(ClienteController clienteController,VendedorController vendedorController){
        setTitle("Menu general");
        setSize(600,400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();


        tabbedPane.addTab("Cliente", new ClienteUI(clienteController));
        tabbedPane.addTab("Vendedor", new VendedorUI(vendedorController));

        add(tabbedPane);


    }
    }
