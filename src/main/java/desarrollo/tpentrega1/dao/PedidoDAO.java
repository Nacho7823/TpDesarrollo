
package desarrollo.tpentrega1.dao;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Pedido;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.List;

public interface PedidoDAO {
    
    public void crearPedido(Pedido pedido) throws DAOException;

    public void actualizarPedido(Pedido pedido) throws DAOException;

    public void eliminarPedido(int id) throws DAOException;

    public Pedido buscarPedido(int id) throws DAOException;
    
    public List<Pedido> obtenerPedidos() throws DAOException;

    public void addItem(ItemMenu item, Pedido p) throws DAOException;

    public void removeItem(ItemMenu item, Pedido p) throws DAOException;
}
