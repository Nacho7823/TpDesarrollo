/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.desarrollo.tpSpring.DAOs;

/**
 *
 * @author imsac
 */
import com.desarrollo.tpSpring.entities.Vendedor;
import com.desarrollo.tpSpring.exceptions.DAOException;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VendedorRepository extends CrudRepository<Vendedor, Long> {
    public void crearVendedor(Vendedor vendedor) throws DAOException;

    public void actualizarVendedor(Vendedor vendedor) throws DAOException;

    public void eliminarVendedor(Vendedor vendedor) throws DAOException;

    public Vendedor buscarVendedor(String id) throws DAOException;
    
    public List<Vendedor> obtenerVendedores() throws DAOException;
}
