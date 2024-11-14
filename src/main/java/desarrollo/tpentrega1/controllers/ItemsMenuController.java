/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.Memory.ItemsMenuMemory;
import desarrollo.tpentrega1.dao.ItemsMenuDAO;
import desarrollo.tpentrega1.dao.sql.ItemMenuDAOSql;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Plato;
import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemsMenuController {

    private ItemsMenuDAO itemMenuDAO;
    private VendedorController vendedorController;

    public ItemsMenuController(ItemsMenuMemory itemsMenuMemory, VendedorController vendedorController) {
//        this.itemMenuDAO = itemsMenuMemory;
//        this.itemMenuDAO =  new ItemsMenuMemory();
        this.itemMenuDAO =  new ItemMenuDAOSql();
        this.vendedorController = vendedorController;
    }

    public List<ItemMenu> obtenerListaItemsMenu() {
        try {
            return itemMenuDAO.obtenerItemMenus(vendedorController.getVendedorDAO());
        } catch (DAOException ex) {
            Logger.getLogger(ItemsMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<ItemMenu>();
    }

    public Plato crearNuevoPlato(String id, String nombre, String descripcion, double precio, String categoria, Vendedor vendedor,
            double calorias, boolean aptoCeliaco, boolean aptoVegano, double peso) {
//        Plato nuevoPlato = new Plato(id, nombre, descripcion, precio, categoria, calorias, aptoCeliaco, aptoVegano, peso);
        Plato nuevoPlato = new Plato(id, nombre, descripcion, precio, categoria, vendedor, calorias, aptoCeliaco, aptoVegano, peso);
        vendedor.addItemMenu(nuevoPlato);
        vendedorController.modificarVendedor(vendedor);
        try {
            itemMenuDAO.crearItemMenu(nuevoPlato);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevoPlato;
    }

    // Crear una nueva bebida
    public Bebida crearNuevaBebida(String id, String nombre, String descripcion, double precio, String categoria, Vendedor vendedor,
            double tamaño, double graduacionAlcoholica) {
//        Bebida nuevaBebida = new Bebida(id, nombre, descripcion, precio, categoria, tamaño, graduacionAlcoholica);
        Bebida nuevaBebida = new Bebida(id, nombre, descripcion, precio, categoria, vendedor, tamaño, graduacionAlcoholica);
        vendedor.addItemMenu(nuevaBebida);
        vendedorController.modificarVendedor(vendedor);
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
            itemExistente = itemMenuDAO.buscarItemMenu(id, vendedorController.getVendedorDAO());
            if (itemExistente != null) {
                itemExistente.setNombre(nombre);
                itemExistente.setDescripcion(descripcion);
                itemExistente.setPrecio(precio);
                itemExistente.setCategoria(categoria);
                itemMenuDAO.actualizarItemMenu(itemExistente);
                System.out.println("Item de menú modificado: " + nombre);
            } else {
                System.out.println("Item de menú no encontrado para modificar.");
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
            itemMenuDAO.eliminarItemMenu(id);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Buscar un ítem de menú por ID
    public ItemMenu buscarItemsMenu(String id) {
        try {
            ItemMenu item;
            item = itemMenuDAO.buscarItemMenu(id, vendedorController.getVendedorDAO());
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
}
