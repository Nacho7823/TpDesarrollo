/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.ItemMenu;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author florh
 */
public interface ItemPedido extends CrudRepository<ItemMenu, String>{
     public ItemMenu buscarPorNombre(String nombre);
    public List<ItemMenu> buscarDescripcion(String descripcion);
    public List<ItemMenu> buscarPrecioEntre(int precioMin, int precioMax);
    public List<ItemMenu> buscarPrecio(int precio);
    public List<ItemMenu> buscarCategoria(String categoria);
    public List<ItemMenu> buscarBebidas();
    public List<ItemMenu> buscarPlatos();

    // plato
    public List<ItemMenu> buscarComidaPeso(double peso);
    public List<ItemMenu> buscarCeliacos();
    public List<ItemMenu> buscarNoCeliacos();
    public List<ItemMenu> buscarVeganos();
    public List<ItemMenu> buscarNoVeganos();
    public List<ItemMenu> buscarComidaCalorias(int calorias);

    // bebida
    public List<ItemMenu> buscarBebidaTamaño(double tamaño);
    public List<ItemMenu> buscarBebidaGraduacion(double graduacion);

    public List<ItemMenu> buscarPorIdPedido(String id);
}
