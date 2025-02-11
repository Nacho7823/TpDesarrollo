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

    public List<ItemMenu> obtenerItemsMenuDeVendedor(int id) {
        try {
            return itemMenuDAO.obtenerItemMenusDeVendedor(id);
        } catch (DAOException ex) {
            Logger.getLogger(ItemMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }

    //crearNuevoItem no contempla agregarlo a la lista de items de un vendedor, 
    // eso deberia hacerse luego de llamar este metodo
    public Plato crearNuevoItem(String nombre, String descripcion, double precio, String categoria,
            double calorias, boolean aptoCeliaco, boolean aptoVegano, double peso) throws Exception {
        Plato p = new Plato.Builder()
                .nombre(nombre)
                .descripcion(descripcion)
                .precio(precio)
                .categoria(categoria)
                .calorias(calorias)
                .aptoCeliaco(aptoCeliaco)
                .aptoVegano(aptoVegano)
                .build();

        this.itemMenuDAO.crearItemMenu(p);
        return p;
    }

    // Crear una nueva bebida
    public Bebida crearNuevaBebida(String nombre, String descripcion, double precio, String categoria, Vendedor vendedor,
            double tamaño, double graduacionAlcoholica) throws Exception {
        Bebida nuevaBebida = new Bebida.Builder()
                .nombre(nombre)
                .descripcion(descripcion)
                .precio(precio)
                .categoria(categoria)
                .tamaño(tamaño)
                .graduacionAlcoholica(graduacionAlcoholica)
                .build();
        vendedor.addItemMenu(nuevaBebida);
        VendedorController.getInstance().modificarVendedor(vendedor);
        itemMenuDAO.crearItemMenu(nuevaBebida);
        return nuevaBebida;
    }

    public Bebida crearNuevaBebida(String nombre, String descripcion, double precio, String categoria,
            double tamaño, double graduacionAlcoholica) throws Exception {
        Bebida nuevaBebida = new Bebida.Builder()
                .nombre(nombre)
                .descripcion(descripcion)
                .precio(precio)
                .categoria(categoria)
                .tamaño(tamaño)
                .graduacionAlcoholica(graduacionAlcoholica)
                .build();
        itemMenuDAO.crearItemMenu(nuevaBebida);
        return nuevaBebida;
    }

    // Modificar un ítem de menú existente
    public void modificarItemsMenu(int id, String nombre, String descripcion, double precio, String categoria) {
        try {
            ItemMenu itemExistente;
            itemExistente = itemMenuDAO.buscarItemMenu(id);
            if (itemExistente != null) {
                itemExistente.setNombre(nombre);
                itemExistente.setDescripcion(descripcion);
                itemExistente.setPrecio(precio);
                itemExistente.setCategoria(categoria);
                itemMenuDAO.actualizarItemMenu(itemExistente);
                System.out.println("Item de menú modificado: " + nombre);
            } else {
                System.out.println("Item de menú no encontrado para modificar.");//deberia ser exception
            }
        } catch (DAOException ex) {
            Logger.getLogger(ItemMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarPlato(Plato plato) {
        try {
            itemMenuDAO.actualizarItemMenu(plato);
        } catch (DAOException ex) {
            Logger.getLogger(ItemMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarBebida(Bebida bebida) {
        try {
            itemMenuDAO.actualizarItemMenu(bebida);
        } catch (DAOException ex) {
            Logger.getLogger(ItemMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Eliminar un ítem de menú por ID
    public void eliminarItemsMenu(ItemMenu id) {
        try {
            itemMenuDAO.eliminarItemMenu(id.getId());
        } catch (DAOException ex) {
            Logger.getLogger(ItemMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Buscar un ítem de menú por ID
    public ItemMenu buscarItemsMenu(int id) {
        try {
            ItemMenu item;
            item = itemMenuDAO.buscarItemMenu(id);
            if (item != null) {
                System.out.println("Item de menú encontrado: " + item.getNombre());
                return item;
            } else {
                System.out.println("Item de menú no encontrado con ID: " + id);
                return null;
            }
        } catch (DAOException ex) {
            Logger.getLogger(ItemMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public ItemMenu buscarItemMenuPorNombre(String nombre) {
        try {
            ItemMenu item;
            item = itemMenuDAO.buscarItemMenuPorNombre(nombre);
            if (item != null) {
                System.out.println("Item de menú encontrado: " + item.getNombre());
                return item;
            } else {
                System.out.println("Item de menú no encontrado con nombre: " + nombre);
                return null;
            }
        } catch (DAOException ex) {
            Logger.getLogger(ItemMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<ItemMenu> obtenerItems() throws DAOException {
        List<ItemMenu> lista = new ArrayList();

        try {
            lista = itemMenuDAO.obtenerItemMenus();
        } catch (DAOException ex) {
            Logger.getLogger(ItemMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

}
