/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.services;

import com.desarrollo.tpSpring.DAOs.PagoRepository;
import com.desarrollo.tpSpring.entities.MercadoPago;
import com.desarrollo.tpSpring.entities.Pago;
import jakarta.transaction.Transactional;
import java.time.LocalDate;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author florh
 */
@Service
public class PagoService {
    public final PagoRepository pagoRepository;

    public PagoService(PagoRepository pagoRepository) {
        this.pagoRepository = pagoRepository;
    }
    
    public List<Pago> encontrarPagoPorFecha(LocalDate fecha){
        return pagoRepository.findByFecha(fecha);
    }
    
    public List<Pago> encontrarPorMontoMinimo(double monto){
        return pagoRepository.findByMonto(monto);
    }
    
    public List<Pago> encontrarPagosRealizadosPorMercadoPago(){
        return pagoRepository.findAllMercadoPago();
    }
    public List<Pago> encontrarPagosRealizadosPorTransferencia(){
        return pagoRepository.findAllTransferencia();
    }
    public List<MercadoPago> encontrarPagosPorAlias(String alias){
        return pagoRepository.findMercadoPagoByAlias(alias);
    }
    
    public List<Pago> encontrarPagos(){
        return pagoRepository.findAll();
    }
    
    public Pago buscarPagoPorId(Integer id){
        return pagoRepository.findById(id).get();
    }
    
    @Transactional
    public void crearPago(Pago p){
        try{
        p.setMonto(p.aplicarRecargo(p.getMonto()));
        pagoRepository.save(p);
        }catch(Exception e){
            System.err.println("No se puedo crear el pago"+ e.getMessage());
        }
    }
    @Transactional
    public void actualizarPago(Pago p){
        p.setMonto(p.aplicarRecargo(p.getMonto()));
        try{
        pagoRepository.save(p);
        }catch(Exception e){
            System.err.println("No se puedo actualizar el pago"+ e.getMessage());
        }
    }
    @Transactional
    public void eliminarPago(Pago p){
        try{
        pagoRepository.delete(p);
        }catch(Exception e){
            System.err.println("No se puedo eliminar el pago"+ e.getMessage());
        }
    }
    @Transactional
    public void eliminarPagoPorId(Integer id){
        try{
        pagoRepository.deleteById(id);
        }catch(Exception e){
            System.err.println("No se puedo eliminar el pago"+ e.getMessage());
        }
    }
    
    
}
