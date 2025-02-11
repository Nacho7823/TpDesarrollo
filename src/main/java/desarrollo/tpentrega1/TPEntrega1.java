package desarrollo.tpentrega1;

import desarrollo.tpentrega1.controllers.ClienteController;
import desarrollo.tpentrega1.controllers.PedidoController;
import desarrollo.tpentrega1.controllers.VendedorController;
import desarrollo.tpentrega1.UI.MenuGeneral;
import desarrollo.tpentrega1.controllers.ItemMenuController;
import desarrollo.tpentrega1.dao.ClienteDAO;
import desarrollo.tpentrega1.dao.ItemsPedidoDAO;
import desarrollo.tpentrega1.dao.PedidoDAO;
import desarrollo.tpentrega1.dao.VendedorDAO;
import desarrollo.tpentrega1.dao.sql.ClienteDAOSql;
import desarrollo.tpentrega1.dao.sql.ItemMenuDAOSql;
import desarrollo.tpentrega1.dao.sql.ItemsPedidoDAOSql;
import desarrollo.tpentrega1.dao.sql.PedidoDAOSql;
import desarrollo.tpentrega1.dao.sql.VendedorDAOSql;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;

import javax.swing.*;
import desarrollo.tpentrega1.dao.ItemMenuDAO;

public class TPEntrega1 {

    public static void main(String[] args) throws DAOException {

        // Configurar UI de Cliente y Vendedor
        SwingUtilities.invokeLater(() -> {
            MenuGeneral menu = new MenuGeneral();
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
        });
    }
}
