/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.Memory.ItemsMenuMemory;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Plato;
import desarrollo.tpentrega1.entidades.Bebida;
import java.util.List;
import java.util.UUID;

public class ItemsMenuController {

    private ItemsMenuMemory itemMenuDAO = new ItemsMenuMemory();

    public ItemsMenuController(ItemsMenuMemory itemsMenuMemory){
        this.itemMenuDAO=itemsMenuMemory;
    }
    public List<ItemMenu> obtenerListaItemsMenu(){
        return itemMenuDAO.getItemsMenu();
    }
    
    // Mostrar lista de todos los ítems de menú
    public void mostrarListaItemsMenu() {
        System.out.println("Lista de Ítems de Menú:");
        itemMenuDAO.listarItemsMenu();
    }

    // Crear un nuevo plato
    
    
    
    public void crearNuevoPlato(String id,String nombre, String descripcion, double precio, String categoria,
                                double calorias, boolean aptoCeliaco, boolean aptoVegano, double peso) {
        //String id = UUID.randomUUID().toString(); // Generación automática de ID
        Plato nuevoPlato = new Plato(id, nombre, descripcion, precio, categoria, calorias, aptoCeliaco, aptoVegano, peso);
        itemMenuDAO.crearItemsMenu(nuevoPlato);
    }

    // Crear una nueva bebida
    public void crearNuevaBebida(String id,String nombre, String descripcion, double precio, String categoria,
                                 double tamaño, double graduacionAlcoholica) {
        //String id = UUID.randomUUID().toString(); // Generación automática de ID
        Bebida nuevaBebida = new Bebida(id, nombre, descripcion, precio, categoria, tamaño, graduacionAlcoholica);
        itemMenuDAO.crearItemsMenu(nuevaBebida);
    }

    // Modificar un ítem de menú existente
    public void modificarItemsMenu(String id, String nombre, String descripcion, double precio, String categoria) {
        ItemMenu itemExistente = itemMenuDAO.buscarItemsMenu(id);
        if (itemExistente != null) {
            itemExistente.setNombre(nombre);
            itemExistente.setDescripcion(descripcion);
            itemExistente.setPrecio(precio);
            itemExistente.setCategoria(categoria);
            itemMenuDAO.actualizarItemsMenu(itemExistente);
            System.out.println("Item de menú modificado: " + nombre);
        } else {
            System.out.println("Item de menú no encontrado para modificar.");
        }
    }
    
    public void modificarPlato(Plato plato) {
        itemMenuDAO.actualizarItemsMenu(plato);
    }
    
    public void modificarBebida(Bebida bebida) {
        itemMenuDAO.actualizarItemsMenu(bebida);
    }

    // Eliminar un ítem de menú por ID
    public void eliminarItemsMenu(String id) {
        itemMenuDAO.eliminarItemsMenu(id);
        
    }

    // Buscar un ítem de menú por ID
    public ItemMenu buscarItemsMenu(String id) {
        ItemMenu item = itemMenuDAO.buscarItemsMenu(id);
        if (item != null) {
            System.out.println("Item de menú encontrado: " + item.getNombre());
                    return item;
        } else {
            System.out.println("Item de menú no encontrado con ID: " + id);
                    return null;
        }
    }
}
