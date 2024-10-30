
package desarrollo.tpentrega1.dao;
import desarrollo.tpentrega1.entidades.Pedido;

public interface PedidoDAO {
    public void listarPedido(Pedido pedido);
    public void crearPedido(Pedido pedido);
    public void actualizarPedido(Pedido pedido);
    public void eliminarPedido(int id);
    public Pedido buscarPedido(int id);
}
