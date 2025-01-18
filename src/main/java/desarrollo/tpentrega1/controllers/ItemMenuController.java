package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.dao.ItemMenuDAO;
import desarrollo.tpentrega1.dao.VendeDAO;
import desarrollo.tpentrega1.dao.sql.ItemMenuDAOSql;
import desarrollo.tpentrega1.dao.sql.VendeDAOSql;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemMenuController {

    private ItemMenuDAO itemMenuDAO = ItemMenuDAOSql.getInstance();
    private VendeDAO vendeDAO = VendeDAOSql.getInstance();

    private static ItemMenuController instance;

    public static ItemMenuController getInstance() {
        if (instance == null) {
            instance = new ItemMenuController();
        }

        return instance;
    }

    private ItemMenuController() {
    }

    public List<ItemMenu> obtenerItemMenusDeVendedor(int id_vendedor) {
        try {
            List<Integer> itemsId = vendeDAO.buscarItemsOfVendedor(id_vendedor);
            
            List<ItemMenu> items = new ArrayList<>();
            
            for (int i = 0; i < itemsId.size(); i++) {
                ItemMenu it = itemMenuDAO.buscarItemMenu(itemsId.get(i));
                items.add(it);
            }
            
            return items;
            
            
        } catch (DAOException e) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e.getMessage());
        }
    }

    //crearNuevoItem no contempla agregarlo a la lista de items de un vendedor, eso deberia hacerse luego de llamar este metodo
    public void crearItemMenu(ItemMenu item) {
        try {

            itemMenuDAO.crearItemMenu(item);

        } catch (DAOException e) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public void modificarItemMenu(ItemMenu item) {
        try {
            itemMenuDAO.actualizarItemMenu(item);

        } catch (DAOException e) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public void eliminarItemMenu(ItemMenu item) {
        try {
            
            itemMenuDAO.eliminarItemMenu(item.getId());
            
        } catch (DAOException e) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e.getMessage());
        }

    }

    public ItemMenu buscarItemMenu(int id) {
        try {
            return itemMenuDAO.buscarItemMenu(id);
            
        } catch (DAOException e) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e.getMessage());
        }
    }
    
    public List<ItemMenu> obtenerItemMenus() {
        
        try {
            return itemMenuDAO.obtenerItemMenus();
            
        } catch (DAOException e) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
