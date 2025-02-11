package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.dao.sql.ItemMenuDAOSql;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Plato;
import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemMenuController {

    private ItemMenuDAOSql itemMenuDAO = ItemMenuDAOSql.getInstance();

    private static ItemMenuController instance;

    public static ItemMenuController getInstance() {
        if (instance == null) {
            instance = new ItemMenuController();
        }
        return instance;
    }

    private ItemMenuController() {

    }

    public List<ItemMenu> obtenerItemsMenuDeVendedor(int id) throws Exception {
        return itemMenuDAO.obtenerItemMenusDeVendedor(id);
    }

    public void crearNuevoItem(ItemMenu item) throws Exception {
        itemMenuDAO.crearItemMenu(item);
    }

    public void modificarItemsMenu(ItemMenu item) throws Exception {
        itemMenuDAO.actualizarItemMenu(item);
    }

    public void eliminarItemsMenu(int id) throws Exception {
        itemMenuDAO.eliminarItemMenu(id);
    }

    public ItemMenu buscarItemsMenu(int id) throws Exception {
        return itemMenuDAO.buscarItemMenu(id);
    }

    public ItemMenu buscarItemMenuPorNombre(String nombre) throws Exception {
        return itemMenuDAO.buscarItemMenuPorNombre(nombre);
    }

    public List<ItemMenu> obtenerItems() throws Exception {
        return itemMenuDAO.obtenerItemMenus();
    }

}
