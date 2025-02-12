
package desarrollo.tpentrega1.Memory;

import desarrollo.tpentrega1.dao.PedidoDAO;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Pedido;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;

public class PedidoMemory implements PedidoDAO{
 private static List<Pedido> pedidos = new ArrayList<>();
 
    public List<Pedido> getPedidos() {
        return pedidos;
    }
 
    public void listarPedidos() {
        for (Pedido p : pedidos) {
            System.out.println("ID: " + p.getId() + ", Estado: " + p.getEstado() +
                               ", Total: " + p.getTotal() +
                               ", Cliente: " + p.getCliente().getNombre());
        }
    }

    @Override
    public void crearPedido(Pedido pedido) {
        pedidos.add(pedido);
    }

    @Override
    public void actualizarPedido(Pedido pedido) {
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getId()==(pedido.getId())) {
                pedidos.set(i, pedido);
                
                return;
            }
        }
        
    }
    

    @Override
    public void eliminarPedido(int id) {
        boolean existe = pedidos.stream().anyMatch(p-> p.getId()==(id));
        if(existe){
        pedidos.removeIf(p -> p.getId()==(id));
        System.out.println("Pedido eliminado con ID: " + id);
    }}

    @Override
    public Pedido buscarPedido(int id) {
       for (Pedido pedido : pedidos) {
            if (pedido.getId()==(id)) {
                
                return pedido;
            }
        }
      
        return null;  
    }
    
    public void addItem(ItemMenu item, Pedido p){
        p.addItem(item);
    }
    
//    public List<ItemMenu> getItems(Pedido p){
//        return p.getItems().keySet();
//    }
    
    public void removeItem(ItemMenu item, Pedido p){
        p.removeItem(item);
    }

    @Override
    public List<Pedido> obtenerPedidos() throws DAOException {
        return pedidos;
    }
}
