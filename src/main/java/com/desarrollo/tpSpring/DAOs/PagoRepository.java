
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.Pago;
import com.desarrollo.tpSpring.exceptions.DAOException;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PagoRepository extends CrudRepository<Pago, String> {    
//    public void crearPago(Pago pago) throws DAOException,Exception;

//    public void eliminarPago(String id) throws DAOException;

//    public Pago buscarPago(String id) throws DAOException;
    
//    public List<Pago> obtenerPagos() throws DAOException;

//    public Pago buscarPagoPorIdPedido(String id)throws DAOException; 
}
