/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.desarrollo.tpSpring.DAOs;

/**
 *
 * @author imsac
 */
import com.desarrollo.tpSpring.entities.Cliente;
import com.desarrollo.tpSpring.exceptions.DAOException;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends CrudRepository<Cliente, Long> {
    public void crearCliente(Cliente cliente) throws DAOException;

    public void actualizarCliente(Cliente cliente) throws DAOException;

    public void eliminarCliente(String id) throws DAOException;

    public Cliente buscarCliente(String id) throws DAOException;
    
    public List<Cliente> obtenerClientes() throws DAOException;
    
}
