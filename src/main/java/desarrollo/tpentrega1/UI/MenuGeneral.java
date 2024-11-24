
package desarrollo.tpentrega1.UI;
import desarrollo.tpentrega1.controllers.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;

public class MenuGeneral extends JFrame{
    public MenuGeneral(ClienteController clienteController,VendedorController vendedorController,ItemsMenuController itemsMenuController, PedidoController pedidoController){
        this.setTitle("Menu general");
        this.setSize(800,600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon= new ImageIcon("pedidosya-logo.png");
        this.setIconImage(icon.getImage());

        JTabbedPane tabbedPane = new JTabbedPane();

        PedidoUI pedidoUI =new PedidoUI(pedidoController,clienteController, vendedorController, itemsMenuController);
        VendedorUI vendedorUI = new VendedorUI(vendedorController);
        ClienteUI clienteUI = new ClienteUI(clienteController);
        ItemMenuUI itemMenuUI = new ItemMenuUI(itemsMenuController, vendedorController);
        
        tabbedPane.addTab("Cliente",clienteUI );
        tabbedPane.addTab("Vendedor", vendedorUI);
        tabbedPane.addTab("ItemMenu",itemMenuUI);
        tabbedPane.addTab("Pedido",pedidoUI);
        
        tabbedPane.addChangeListener((ChangeEvent e) -> {
            int selectedIndex = tabbedPane.getSelectedIndex();
            switch (selectedIndex) {
                case 0 -> clienteUI.update();
                case 1 -> vendedorUI.update();
                case 2 -> itemMenuUI.update();
                case 3 -> pedidoUI.update();
                default -> {
                }
            }
        });
        

        this.add(tabbedPane);


    }
    }
