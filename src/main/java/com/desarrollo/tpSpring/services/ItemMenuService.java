/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.services;

import com.desarrollo.tpSpring.DAOs.BebidaRepository;
import com.desarrollo.tpSpring.DAOs.ItemMenuRepository;
import com.desarrollo.tpSpring.DAOs.PlatoRepository;
import com.desarrollo.tpSpring.entities.Bebida;
import com.desarrollo.tpSpring.entities.ItemMenu;
import com.desarrollo.tpSpring.entities.Plato;
import java.util.Collection;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author florh
 */
@Service
public class ItemMenuService {
    public final PlatoRepository platoRepository;
    public final BebidaRepository bebidaRepository;

    public ItemMenuService(PlatoRepository platoRepository, BebidaRepository bebidaRepository) {
        this.platoRepository = platoRepository;
        this.bebidaRepository = bebidaRepository;
    }

    

    public List<ItemMenu> obtenerItemsMenu() {
        List<ItemMenu> items =  (List<ItemMenu>) (Collection<? extends ItemMenu>) platoRepository.findAll();
        items.addAll((Collection<? extends ItemMenu>) bebidaRepository.findAll());
        
        return items ;
    }
    
    public void crearItemsMenu(ItemMenu item) {
        try {
            
            if(item.esComida()){
                platoRepository.save((Plato)item);
            }
            if(item.esBebida()){
               bebidaRepository.save((Bebida)item);
            }
            System.out.println("Item creado exitosamente");
          
        } catch (Exception e) {
            System.err.println("Error inesperado al crear el item: " + e.getMessage());
        }
    }
    
    public void actualizarItemMenu(ItemMenu item){
        try {
            if(item.esComida()){
                platoRepository.save((Plato)item);
            }
            if(item.esBebida()){
               bebidaRepository.save((Bebida)item);
            }
            System.out.println("Item actualizado exitosamente"); 
        } catch (Exception e) {
            System.err.println("Error al acceder a la base de datos: " + e.getMessage());
        }
        
    }
    
    public void eliminarItemMenu(String id) {
         try {
            Bebida b= bebidaRepository.findById(id).get();
            if(b == null){
                platoRepository.deleteById(id);
                System.out.println("Item eliminado exitosamente: " + id); 
            }else{
                bebidaRepository.deleteById(id);
                System.out.println("Item eliminado exitosamente: " + id); 
            }
            
            
            
        } catch (Exception e) {
            System.err.println("Error al acceder a la base de datos: " + e.getMessage());
        }
    }
    
    public ItemMenu buscarItemMenu(String id) {
         Bebida b= bebidaRepository.findById(id).get();
            if(b == null){
                return (Plato) platoRepository.findById(id).get();
              
            }
            return b;
    }
}
