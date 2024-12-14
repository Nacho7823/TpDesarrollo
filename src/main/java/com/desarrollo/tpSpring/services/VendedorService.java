/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.services;

import com.desarrollo.tpSpring.DAOs.CoordenadaRepository;
import com.desarrollo.tpSpring.DAOs.VendedorRepository;
import com.desarrollo.tpSpring.entities.Vendedor;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author florh
 */
@Service
public class VendedorService {
    public final VendedorRepository vendedorRepository;
    public final CoordenadaRepository coordenadaRepository;

    public VendedorService(VendedorRepository vendedorRepository,CoordenadaRepository coordenadaRepository) {
        this.vendedorRepository = vendedorRepository;
        this.coordenadaRepository=coordenadaRepository;
    }
    
    public List<Vendedor> obtenerVendedores() {
        return (List<Vendedor>) vendedorRepository.findAll();
    }
    
    @Transactional
    public void crearVendedor(Vendedor vendedor) {
        try {
            vendedorRepository.save(vendedor);
            System.out.println("Vendedor creado exitosamente");
          
        } catch (Exception e) {
            System.err.println("Error inesperado al crear el vendedor: " + e.getMessage());
        }
    }
    
    @Transactional
    public void actualizarVendedor(Vendedor vendedor){
        try {
            coordenadaRepository.save(vendedor.getCoordenada());
            vendedorRepository.save(vendedor);
            System.out.println("Vendedor actualizado exitosamente: " + vendedor.getId_vendedor()); 
        } catch (Exception e) {
            System.err.println("Error al acceder a la base de datos: " + e.getMessage());
        }
        
    }
    @Transactional
    public void eliminarVendedor(long id) {
         try {
            vendedorRepository.deleteById(id);
            System.out.println("Vendedor eliminado exitosamente: " + id); 
        } catch (Exception e) {
            System.err.println("Error al acceder a la base de datos: " + e.getMessage());
        }
    }
    
    public Vendedor buscarVendedor(long id) {
        return vendedorRepository.findById(id).get();
    }
    
    
}
