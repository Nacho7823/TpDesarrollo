
package desarrollo.tpentrega1.Memory;

import desarrollo.tpentrega1.dao.PedidoDAO;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Pedido;
import java.util.ArrayList;
import java.util.List;

public class PedidoMemory implements PedidoDAO{
 private static List<Pedido> pedidos = new ArrayList<>();
 
    public List<Pedido> getPedidos() {
        return pedidos;
    }
 
    @Override
    public void listarPedido(Pedido pedido) {
        for (Pedido p : pedidos) {
            System.out.println("ID: " + p.getId() + ", Estado: " + p.getEstado() +
                               ", Total: " + p.getTotal() +
                               ", Cliente: " + p.getCliente().getNombre());
        }
    }

    @Override
    public void crearPedido(Pedido pedido) {
        pedidos.add(pedido);
        // System.out.println("Pedido creado con ID: " + pedido.getId());
    }

    @Override
    public void actualizarPedido(Pedido pedido) {
        for (int i = 0; i < pedidos.size(); i++) {
            if (pedidos.get(i).getId().equals(pedido.getId())) {
                pedidos.set(i, pedido);
                
                return;
            }
        }
        
    }
    

    @Override
    public void eliminarPedido(String id) {
        boolean existe = pedidos.stream().anyMatch(p-> p.getId().equals(id));
        if(existe){
        pedidos.removeIf(p -> p.getId().equals(String.valueOf(id)));
        System.out.println("Pedido eliminado con ID: " + id);
    }}

    @Override
    public Pedido buscarPedido(String id) {
       for (Pedido pedido : pedidos) {
            if (pedido.getId().equals(id)) {
                
                return pedido;
            }
        }
      
        return null;  
    }
    
    public void addItem(ItemMenu item, Pedido p){
        p.addItem(item);
    }
    
    public List<ItemMenu> getItems(Pedido p){
        return p.getItems();
    }
}
