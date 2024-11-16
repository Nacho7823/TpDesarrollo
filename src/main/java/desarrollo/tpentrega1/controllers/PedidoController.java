
package desarrollo.tpentrega1.controllers;


import desarrollo.tpentrega1.dao.sql.PedidoDAOSql;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Pago;
import desarrollo.tpentrega1.entidades.Pedido;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.enums.EstadoPedido;
import desarrollo.tpentrega1.exceptions.DAOException;
import desarrollo.tpentrega1.exceptions.InvalidOrderException;
import java.util.List;




public class PedidoController {
    private PedidoDAOSql pedidoDAO = null;

    public PedidoController(PedidoDAOSql pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    public void newPedido(String id,Cliente cliente, Vendedor vendedor, List<ItemMenu> items, Pago pago, EstadoPedido estado) throws DAOException {
        try {
        Pedido nuevoPedido = new Pedido(id,cliente, vendedor, items, pago, estado);
        pedidoDAO.crearPedido(nuevoPedido);
        } catch (InvalidOrderException e) {
            System.out.println("Error al crear el pedido: " + e.getMessage());
        }
    }

    // Modificar un pedido existente (cambia su estado)
    public void modificarPedidoEstado(String id, EstadoPedido nuevoEstado) throws DAOException {
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
    public void eliminarPedido(String id) throws DAOException {
        pedidoDAO.eliminarPedido(id);
        
    }

    // Buscar un pedido por ID
    public Pedido buscarPedido(String id) {
        Pedido pedido = pedidoDAO.buscarPedido(id);
        if (pedido != null) {
            System.out.println("Pedido encontrado con ID: " + pedido.getId());
        } else {
            System.out.println("Pedido no encontrado con ID: " + id);
        }
        return pedido;
    }
    public Pedido buscarYDevolverPedido(String id){
        return pedidoDAO.buscarPedido(id);
    }
    //public void editarPedido(int id, )
    public List<Pedido> obtenerListaPedidos() throws DAOException {
        return pedidoDAO.obtenerPedidos();
    }
    
    public void addItem(ItemMenu item, Pedido p) throws DAOException{
        pedidoDAO.addItem(item, p);
    }
    
    public List<ItemMenu> getItems(Pedido p){
        return p.getItems();
    }
    
    public void removeItem(ItemMenu item, Pedido p) throws DAOException{
        pedidoDAO.removeItem(item,p);
    }
}
