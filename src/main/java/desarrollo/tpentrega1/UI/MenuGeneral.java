package desarrollo.tpentrega1.UI;

import desarrollo.tpentrega1.controllers.*;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JTabbedPane;
import javax.swing.event.ChangeEvent;

public class MenuGeneral extends JFrame {

    public MenuGeneral() {
        this.setTitle("Menu general");
        this.setSize(1000, 700);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        ImageIcon icon = new ImageIcon("pedidosya-logo.png");
        this.setIconImage(icon.getImage());

        JTabbedPane tabbedPane = new JTabbedPane();

        PedidoUI pedidoUI = new PedidoUI();
        VendedorUI vendedorUI = new VendedorUI();
        ClienteUI clienteUI = new ClienteUI();
        ItemMenuUII itemMenuUI = new ItemMenuUII();

        tabbedPane.addTab("Cliente", clienteUI);
        tabbedPane.addTab("Vendedor", vendedorUI);
        tabbedPane.addTab("ItemMenu", itemMenuUI);
        tabbedPane.addTab("Pedido", pedidoUI);

        tabbedPane.addChangeListener((ChangeEvent e) -> {
            int selectedIndex = tabbedPane.getSelectedIndex();
            switch (selectedIndex) {
                case 0 ->
                    clienteUI.update();
                case 1 ->
                    vendedorUI.update();
                case 2 ->
                    itemMenuUI.update();
                case 3 ->
                    pedidoUI.update();
                default -> {
                }
            }
        });

        this.add(tabbedPane);

    }
}
