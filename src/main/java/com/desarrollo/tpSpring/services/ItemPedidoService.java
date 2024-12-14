/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.services;

import com.desarrollo.tpSpring.DAOs.ItemsPedidoRepository;
import com.desarrollo.tpSpring.entities.ItemMenu;
import com.desarrollo.tpSpring.entities.ItemsPedido;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author florh
 */
@Service
public class ItemPedidoService {
    private final ItemsPedidoRepository itemPedidoRepository;

    public ItemPedidoService(ItemsPedidoRepository itemPedidoRepository) {
        this.itemPedidoRepository = itemPedidoRepository;
    }
    
    
    
   
    public ItemMenu buscarPorNombre(String nombre) {
        ItemMenu item = null;
        
        return item;
    }

    public List<ItemMenu> buscarDescripcion(String descripcion) {
        try {
           
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<ItemMenu> buscarPrecioEntre(int precioMin, int precioMax) {
        try {
            
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<ItemMenu> buscarPrecio(int precio) {
        try {
            
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<ItemMenu> buscarCategoria(String categoria) {
        try {
            
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<ItemMenu> buscarBebidas() {
        try {
            
            
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<ItemMenu> buscarPlatos() {
        try {
            
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<ItemMenu> buscarComidaPeso(double peso) {
        try {
           
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<ItemMenu> buscarCeliacos() {
        try {
            
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<ItemMenu> buscarNoCeliacos() {
        try {
           
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<ItemMenu> buscarVeganos() {
        try {
            
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<ItemMenu> buscarNoVeganos() {
        try {
            
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<ItemMenu> buscarComidaCalorias(int calorias) {
        try {
            
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<ItemMenu> buscarBebidaTamaño(double tamaño) {
        try {
            
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    public List<ItemMenu> buscarBebidaGraduacion(double graduacion) {
        try {
            
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
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

    
}
