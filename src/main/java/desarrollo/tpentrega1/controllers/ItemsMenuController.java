
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

public class ItemsMenuController {

    private ItemMenuDAOSql itemMenuDAO=ItemMenuDAOSql.getInstance();
    private VendedorController vendedorController;

    public ItemsMenuController(VendedorController vendedorController) {

        this.vendedorController = vendedorController;
    }

    public List<ItemMenu> obtenerItemsMenuDeVendedor(String id) {
        try {
            return itemMenuDAO.obtenerItemsMenuDeVendedor(id);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<>();
    }
    
    //crearNuevoItem no contempla agregarlo a la lista de items de un vendedor, eso deberia hacerse luego de llamar este metodo
    public Plato crearNuevoItem(String nombre, String descripcion, double precio, String categoria,
            double calorias, boolean aptoCeliaco, boolean aptoVegano, double peso) {
        Plato p = new Plato.Builder()
                .nombre(nombre)
                .descripcion(descripcion)
                .precio(precio)
                .categoria(categoria)
                .calorias(calorias)
                .aptoCeliaco(aptoCeliaco)
                .aptoVegano(aptoVegano)
                .build();
        
        try {
            this.itemMenuDAO.crearItemMenu(p);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    // Crear una nueva bebida
    public Bebida crearNuevaBebida(String nombre, String descripcion, double precio, String categoria, Vendedor vendedor,
            double tamaño, double graduacionAlcoholica) {        
        Bebida nuevaBebida = new Bebida.Builder()
                .nombre(nombre)
                .descripcion(descripcion)
                .precio(precio)
                .categoria(categoria)
                .tamaño(tamaño)
                .graduacionAlcoholica(graduacionAlcoholica)
                .build();
        vendedor.addItemMenu(nuevaBebida);
        vendedorController.modificarVendedor(vendedor);
        try {
            itemMenuDAO.crearItemMenu(nuevaBebida);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevaBebida;
    }
    public Bebida crearNuevaBebida(String nombre, String descripcion, double precio, String categoria,
            double tamaño, double graduacionAlcoholica) {        
        Bebida nuevaBebida = new Bebida.Builder()
                .nombre(nombre)
                .descripcion(descripcion)
                .precio(precio)
                .categoria(categoria)
                .tamaño(tamaño)
                .graduacionAlcoholica(graduacionAlcoholica)
                .build();
        try {
            itemMenuDAO.crearItemMenu(nuevaBebida);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevaBebida;
    }

    // Modificar un ítem de menú existente
    public void modificarItemsMenu(String id, String nombre, String descripcion, double precio, String categoria) {
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
            Logger.getLogger(ItemsMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarPlato(Plato plato) {
        try {
            itemMenuDAO.actualizarItemMenu(plato);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void modificarBebida(Bebida bebida) {
        try {
            itemMenuDAO.actualizarItemMenu(bebida);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Eliminar un ítem de menú por ID
    public void eliminarItemsMenu(ItemMenu id) {
        try {
            itemMenuDAO.eliminarItemMenu(id.getId());
        } catch (DAOException ex) {
            Logger.getLogger(ItemsMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Buscar un ítem de menú por ID
    public ItemMenu buscarItemsMenu(String id) {
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
            Logger.getLogger(ItemsMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public ItemMenu buscarItemMenuPorNombre(String nombre){
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
            Logger.getLogger(ItemsMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
}
