
package com.desarrollo.tpSpring.services;

import com.desarrollo.tpSpring.DAOs.ItemMenuRepository;
import com.desarrollo.tpSpring.DAOs.ItemsPedidoRepository;
import com.desarrollo.tpSpring.entities.ItemMenu;
import com.desarrollo.tpSpring.entities.ItemsPedido;
import com.desarrollo.tpSpring.exceptions.ItemNoEncontradoException;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


@Service
public class ItemPedidoService {
    private final ItemsPedidoRepository itemPedidoRepository;
    private final ItemMenuRepository itemMenuRepository;

    public ItemPedidoService(ItemsPedidoRepository itemPedidoRepository, com.desarrollo.tpSpring.DAOs.ItemMenuRepository itemMenuRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
        this.itemMenuRepository = itemMenuRepository;
    }
    
    
    
    
   
    public List<ItemMenu> buscarPorNombre(String nombre) {
        
        return null;
    }

    public List<ItemMenu> buscarDescripcion(String descripcion) {
        return null;
    }

    public List<ItemMenu> buscarPrecioEntre(int precioMin, int precioMax) {
       return null;
    }

    public List<ItemMenu> buscarPrecio(int precio) {
        return null;
    }

    public List<ItemMenu> buscarCategoria(String categoria) {
        return null;
    }

    public List<ItemMenu> buscarBebidas() {
        return null;
    }

    public List<ItemMenu> buscarPlatos() {
       return null;
        
    }

    public List<ItemMenu> buscarComidaPeso(double peso) {
        
           return null;
        
    }

    public List<ItemMenu> buscarCeliacos() {
        return null;
    }

    public List<ItemMenu> buscarNoCeliacos() {
        return null;
    }

    public List<ItemMenu> buscarVeganos() {
       return null; 
    }

    public List<ItemMenu> buscarNoVeganos() {
       return null;
    }

    public List<ItemMenu> buscarComidaCalorias(int calorias) {
       return null;
    }

    public List<ItemMenu> buscarBebidaTamaño(double tamaño) {
      return null;  
    }

    public List<ItemMenu> buscarBebidaGraduacion(double graduacion) {
        
     return null;       
        
    }
    
    public List<ItemsPedido> obtenerItems(){
        return itemPedidoRepository.findAll();
    }
    
    @Transactional
    public void crearItemPedido(@Validated ItemsPedido item){
        itemPedidoRepository.save(item);
    }
    @Transactional
    public void actualizarItemPedido(@Validated ItemsPedido item){
        itemPedidoRepository.save(item);
    }
    @Transactional
    public void eliminarItemPedido(@Validated ItemsPedido item){
        itemPedidoRepository.delete(item);
    }

    public List<ItemsPedido> encontrarPorCantidad(int cantidad){
        return itemPedidoRepository.findByCantidad(cantidad);
    }

}
