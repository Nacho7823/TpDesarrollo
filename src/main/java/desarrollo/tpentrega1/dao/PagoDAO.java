package desarrollo.tpentrega1.dao;

import desarrollo.tpentrega1.entidades.Pago;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.List;

public interface PagoDAO {

    public void crearPago(Pago pago) throws DAOException;
    
    public void actualizarPago(Pago pago) throws DAOException;

    public void eliminarPago(int id) throws DAOException;

    public Pago buscarPago(int id) throws DAOException;

    public List<Pago> obtenerPagos() throws DAOException;

    public Pago buscarPagoPorIdPedido(int id) throws DAOException;
}
