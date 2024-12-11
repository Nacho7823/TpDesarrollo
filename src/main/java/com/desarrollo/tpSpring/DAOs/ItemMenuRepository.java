/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.ItemMenu;
import com.desarrollo.tpSpring.exceptions.DAOException;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author florh
 */
public interface ItemMenuRepository extends CrudRepository<ItemMenu, String>{
    public void crearItemMenu(ItemMenu itemMenu) throws DAOException;

    public void actualizarItemMenu(ItemMenu itemMenu) throws DAOException;

    public void eliminarItemMenu(String id) throws DAOException;

    public ItemMenu buscarItemMenu(String id) throws DAOException;
    
    public List<ItemMenu> obtenerItemsMenuDeVendedor(String id) throws DAOException;
}
