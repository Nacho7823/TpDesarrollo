/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.services;

import com.desarrollo.tpSpring.DAOs.PagoRepository;
import com.desarrollo.tpSpring.DAOs.PedidoRepository;
import com.desarrollo.tpSpring.entities.Pago;
import com.desarrollo.tpSpring.entities.Pedido;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

/**
 *
 * @author florh
 */
@Service
public class PedidoService {
    @Autowired
    private PedidoRepository pedidoRepository;
    @Autowired
    private PagoRepository pagoRepository;

    public PedidoService(PedidoRepository pedidoRepository) {
    }
    
    @Transactional
    public void crearPedido(@Validated Pedido pedido){
        
        Pago pago = pedido.getPago();
        pagoRepository.save(pago);
        pedido.setPago(pago);
        if(pedido.getPago() != null){
            pedidoRepository.save(pedido);
           
        }
    }
    
    public List<Pedido> obtenerPedidos(){
        return pedidoRepository.findAll();
    }
    
    public Pedido buscarPedidoPorId(int id){
        return pedidoRepository.findById(id).get();
    }
    
    @Transactional
    public void actualizarPedido(@Validated Pedido pedido){
        if(pedido.getPago() != null){
            pedidoRepository.save(pedido);
           
        }
    }
    
    @Transactional
    public void eliminarPedido(@Validated Pedido pedido){
        pedidoRepository.delete(pedido);
    }
    
    public List<Pedido> encontrarPorTotal(double total){
        return pedidoRepository.findByTotal(total);
    }
    
    
}
