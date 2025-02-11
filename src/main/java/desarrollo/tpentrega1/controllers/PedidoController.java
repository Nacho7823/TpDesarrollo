package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.dao.PedidoDAO;
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
    private PedidoDAOSql pedidoDAO=PedidoDAOSql.getInstance();

    private static PedidoController instance;
    
    public static PedidoController getInstance() {
        if (instance == null) {
            instance = new PedidoController();
        }
        return instance;
    }

    private PedidoController() {
     
    }

    public void newPedido(Pedido pedido) throws Exception {
        pedidoDAO.crearPedido(pedido);
    }
    
    public void modificarPedidoEstado(int id, EstadoPedido nuevoEstado) throws Exception {
        Pedido pedidoExistente = pedidoDAO.buscarPedido(id);
        pedidoExistente.setEstado(nuevoEstado);
        pedidoDAO.actualizarPedido(pedidoExistente);
    }

    public void eliminarPedido(int id) throws Exception {
        pedidoDAO.eliminarPedido(id);
        
    }

    public Pedido buscarPedido(int id)throws Exception{
        return pedidoDAO.buscarPedido(id);
    }

    public List<Pedido> obtenerListaPedidos() throws Exception {
        return pedidoDAO.obtenerPedidos();
    }
    
    public void addItem(ItemMenu item, Pedido p) throws Exception{
        pedidoDAO.addItem(item, p);
    }
    
    public void removeItem(ItemMenu item, Pedido p) throws Exception{
        pedidoDAO.removeItem(item,p);
    }
    
}
