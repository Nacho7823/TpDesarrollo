
package desarrollo.tpentrega1.UI;
import desarrollo.tpentrega1.controllers.*;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class MenuGeneral extends JFrame{
    public MenuGeneral(ClienteController clienteController,VendedorController vendedorController,ItemsMenuController itemsMenuController, PedidoController pedidoController){
        setTitle("Menu general");
        setSize(800,600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JTabbedPane tabbedPane = new JTabbedPane();

        PedidoUI pedidoUI =new PedidoUI(pedidoController,clienteController, vendedorController, itemsMenuController);
        VendedorUI vendedorUI = new VendedorUI(vendedorController);
        ClienteUI clienteUI = new ClienteUI(clienteController);
        ItemMenuUI itemMenuUI = new ItemMenuUI(itemsMenuController);
        
        tabbedPane.addTab("Cliente",clienteUI );
        tabbedPane.addTab("Vendedor", vendedorUI);
        tabbedPane.addTab("ItemMenu",itemMenuUI);
        tabbedPane.addTab("Pedido",pedidoUI);
        
        tabbedPane.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                int selectedIndex = tabbedPane.getSelectedIndex();
                System.out.println(""+ selectedIndex);
                if (selectedIndex == 0)
                    clienteUI.update();
                else if (selectedIndex == 1)
                    vendedorUI.update();
                else if (selectedIndex == 2)
                    itemMenuUI.update();
                else if (selectedIndex == 3)
                    pedidoUI.update();
            }
        });
        

        add(tabbedPane);


    }
    }
