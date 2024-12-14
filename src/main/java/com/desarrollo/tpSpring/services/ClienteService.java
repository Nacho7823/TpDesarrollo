/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.services;

import com.desarrollo.tpSpring.DAOs.ClienteRepository;
import com.desarrollo.tpSpring.entities.Cliente;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author florh
 */
@Service
public class ClienteService {
    private final ClienteRepository clienteRepository;
    
    @Autowired
    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }
    
    public List<Cliente> obtenerClientes(){
        return (List<Cliente>) clienteRepository.findAll();
    }
    
    public void crearCliente(Cliente cliente) {
        try {
            clienteRepository.save(cliente);
            System.out.println("Cliente creado exitosamente");
          
        } catch (Exception e) {
            System.err.println("Error inesperado al crear el cliente: " + e.getMessage());
        }
    }
    
    public void actualizarCliente(Cliente cliente){
        try {
            clienteRepository.save(cliente);
            System.out.println("Cliente actualizado exitosamente: " + cliente.getId_cliente()); 
        } catch (Exception e) {
            System.err.println("Error al acceder a la base de datos: " + e.getMessage());
        }
        
    }
    public void eliminarCliente(long id) {
         try {
            clienteRepository.deleteById(id);
            System.out.println("Cliente eliminado exitosamente: " + id); 
        } catch (Exception e) {
            System.err.println("Error al acceder a la base de datos: " + e.getMessage());
        }
    }
    
    public Cliente buscarCliente(long id) {
        return clienteRepository.findById(id).get();
    }
    
     
}
