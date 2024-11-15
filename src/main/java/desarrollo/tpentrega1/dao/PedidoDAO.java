
package desarrollo.tpentrega1.dao;
import desarrollo.tpentrega1.entidades.Pedido;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.List;

public interface PedidoDAO {
    
    public void crearPedido(Pedido pedido) throws DAOException;

    public void actualizarPedido(Pedido pedido) throws DAOException;

    public void eliminarPedido(Pedido pedido) throws DAOException;

    public Pedido buscarPedido(String id) throws DAOException;
    
    public List<Pedido> obtenerPedidos() throws DAOException;
}
