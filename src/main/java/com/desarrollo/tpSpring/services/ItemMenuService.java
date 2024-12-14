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
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author florh
 */
@Service
public class ItemMenuService {
    public final ItemMenuRepository itemMenuRepository;
    public final PlatoRepository platoRepository;
    public final BebidaRepository bebidaRepository;

    public ItemMenuService(ItemMenuRepository itemMenuRepository, com.desarrollo.tpSpring.DAOs.PlatoRepository platoRepository, com.desarrollo.tpSpring.DAOs.BebidaRepository bebidaRepository) {
        this.itemMenuRepository = itemMenuRepository;
        this.platoRepository = platoRepository;
        this.bebidaRepository = bebidaRepository;
    }
    
    


    

    public List<ItemMenu> obtenerItemsMenu() { 
        return itemMenuRepository.findAll() ;
    }
    @Transactional
    public void crearItemsMenu(ItemMenu item) {
        try {
            itemMenuRepository.save(item);
            System.out.println("Item creado exitosamente");
          
        } catch (Exception e) {
            System.err.println("Error inesperado al crear el item: " + e.getMessage());
        }
    }
    @Transactional
    public void actualizarItemMenu(ItemMenu item){
        try {
                itemMenuRepository.save(item);
            System.out.println("Item actualizado exitosamente"); 
        } catch (Exception e) {
            System.err.println("Error al acceder a la base de datos: " + e.getMessage());
        }
        
    }
    @Transactional
    public void eliminarItemMenu(Integer id) {
         try {
                itemMenuRepository.deleteById(id);
                System.out.println("Item eliminado exitosamente: " + id); 
            
            
            
            
        } catch (Exception e) {
            System.err.println("Error al acceder a la base de datos: " + e.getMessage());
        }
    }
    
    public ItemMenu buscarItemMenu(Integer id) {
         return itemMenuRepository.findById(id).get();
    }
    
    public ItemMenu buscarItemPorNombre(String nombre){
        return itemMenuRepository.findByNombre(nombre);
    }
    
    public List<ItemMenu> buscarPorDescripcionItemMenus(String descripcion){
        return itemMenuRepository.findByDescripcion(descripcion);
    }
    
    public List<ItemMenu> buscarPorPrecioEntre(int precioMin, int precioMax){
        return itemMenuRepository.findByPrecioBetween(precioMin, precioMax);
    }
    public List<ItemMenu> buscarPorPrecio(int precio){
          return  itemMenuRepository.findByPrecio(precio);
    
    }
    public List<ItemMenu> buscarBebidas(){
        return (List<ItemMenu>) itemMenuRepository.findAllBebida();
    }
    public List<ItemMenu> buscarPlatos(){
        return (List<ItemMenu>) itemMenuRepository.findAllPlato();
    }
    
    public List<Plato> encontrarPorPeso(double peso){
        return platoRepository.findByPeso(peso);
    }
   public List<Plato> esAptoCeliaco(boolean apto){
       return platoRepository.findByAptoCeliaco(apto);
   }
    public List<Plato> esAptoVegano(boolean apto){
        return platoRepository.findByAptoVegano(apto);
    }
    public List<Plato> encontrarPorCalorias(int calorias){
        return  platoRepository.findByCalorias(calorias);
    }
    
    public List<Bebida> encontrarPorTamanio(double tamanio){
        return bebidaRepository.findByTamanio(tamanio);
    }
      public List<Bebida> findByGraduacion_alcoholica(double graduacion_alcoholica){
          return bebidaRepository.findByGraduacion_alcoholica(graduacion_alcoholica);
      }
}
