
package desarrollo.tpentrega1.dao;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Pedido;
import java.util.List;

public interface PedidoDAO {
    public void listarPedido();
    public void crearPedido(Pedido pedido);
    public void actualizarPedido(Pedido pedido);
    public void eliminarPedido(String id);
    public Pedido buscarPedido(String id);
    public void addItem(ItemMenu item, Pedido p);
    public List<ItemMenu> getItems(Pedido p);
}
