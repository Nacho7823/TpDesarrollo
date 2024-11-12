
package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.Memory.PedidoMemory;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Pedido;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.enums.EstadoPedido;
import desarrollo.tpentrega1.exceptions.InvalidOrderException;
import desarrollo.tpentrega1.interfaces.FormaDePago;
import java.util.List;


public class PedidoController {
    private PedidoMemory pedidoDAO = new PedidoMemory();

    public PedidoController(PedidoMemory pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    // Mostrar lista de todos los pedidos
    public void mostrarListaPedidos() {
        System.out.println("Lista de Pedidos:");
        pedidoDAO.listarPedido();
    }
    
    public void newPedido(String id,Cliente cliente, Vendedor vendedor, List<ItemMenu> items, FormaDePago formaDePago, EstadoPedido estado) {
        try {
        Pedido nuevoPedido = new Pedido(id,cliente, vendedor, items, formaDePago, estado);
        pedidoDAO.crearPedido(nuevoPedido);
        } catch (InvalidOrderException e) {
            System.out.println("Error al crear el pedido: " + e.getMessage());
        }
    }

    // Modificar un pedido existente (cambia su estado)
    public void modificarPedidoEstado(String id, EstadoPedido nuevoEstado) {
        Pedido pedidoExistente = pedidoDAO.buscarPedido(id);
        if (pedidoExistente != null) {
            pedidoExistente.setEstado(nuevoEstado);
            pedidoDAO.actualizarPedido(pedidoExistente);
            System.out.println("Estado del pedido modificado a: " + nuevoEstado);
        } else {
            System.out.println("Pedido no encontrado para modificar.");
        }
    }

    // Eliminar un pedido por ID
    public void eliminarPedido(String id) {
        pedidoDAO.eliminarPedido(id);
        
    }

    // Buscar un pedido por ID
    public void buscarPedido(String id) {
        Pedido pedido = pedidoDAO.buscarPedido(id);
        if (pedido != null) {
            System.out.println("Pedido encontrado con ID: " + pedido.getId());
        } else {
            System.out.println("Pedido no encontrado con ID: " + id);
        }
    }
    public Pedido buscarYDevolverPedido(String id){
        return pedidoDAO.buscarPedido(id);
    }
    //public void editarPedido(int id, )
    public List<Pedido> obtenerListaPedidos() {
        return pedidoDAO.getPedidos();
    }
    
    public void addItem(ItemMenu item, Pedido p){
        pedidoDAO.addItem(item, p);
    }
    
    public List<ItemMenu> getItems(Pedido p){
        return pedidoDAO.getItems(p);
    }
    
    public void removeItem(ItemMenu item, Pedido p){
        pedidoDAO.removeItem(item,p);
    }
}
