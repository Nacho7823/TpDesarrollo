
package com.desarrollo.tpSpring.services;

import com.desarrollo.tpSpring.DAOs.ItemsPedidoRepository;
import com.desarrollo.tpSpring.entities.ItemsPedido;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;


@Service
public class ItemPedidoService {
    private final ItemsPedidoRepository itemPedidoRepository;
  

    public ItemPedidoService(ItemsPedidoRepository itemPedidoRepository, com.desarrollo.tpSpring.DAOs.ItemMenuRepository itemMenuRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
     
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
