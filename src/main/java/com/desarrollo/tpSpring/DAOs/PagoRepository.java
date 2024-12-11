/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.Pago;
import com.desarrollo.tpSpring.exceptions.DAOException;
import java.util.List;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author florh
 */
public interface PagoRepository extends CrudRepository<Pago, String> {    
    public void crearPago(Pago pago) throws DAOException,Exception;

    public void eliminarPago(String id) throws DAOException;

    public Pago buscarPago(String id) throws DAOException;
    
    public List<Pago> obtenerPagos() throws DAOException;

    public Pago buscarPagoPorIdPedido(String id)throws DAOException; 
}
