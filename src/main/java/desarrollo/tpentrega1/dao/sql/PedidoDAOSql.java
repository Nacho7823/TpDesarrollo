package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.ClienteDAO;
import desarrollo.tpentrega1.dao.ItemsPedidoDAO;
import desarrollo.tpentrega1.dao.PagoDAO;
import desarrollo.tpentrega1.dao.PedidoDAO;
import desarrollo.tpentrega1.dao.VendedorDAO;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Pago;
import desarrollo.tpentrega1.entidades.Pedido;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.enums.EstadoPedido;
import desarrollo.tpentrega1.exceptions.DAOException;
import desarrollo.tpentrega1.exceptions.InvalidOrderException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class PedidoDAOSql extends DAO implements PedidoDAO {

    private ClienteDAO clienteDAO = ClienteDAOSql.getInstance();
    private VendedorDAO vendedorDAO = VendedorDAOSql.getInstance();
    private PagoDAO pagoDAO = PagoDAOSql.getInstance();
    private ItemsPedidoDAO itemsPedidoDAO = ItemsPedidoDAOSql.getInstance();

    private static PedidoDAOSql instance;

    public static PedidoDAOSql getInstance() {
        if (instance == null) {
            instance = new PedidoDAOSql();
        }
        return PedidoDAOSql.instance;
    }

    @Override
    public void crearPedido(Pedido pedido) throws DAOException {
        try {

            String sqlPedido = "insert into pedido (estado,id_cliente, id_vendedor, id_pago, total) VALUES (?, ?, ?, ?, ?)";
            String sqlItems = "insert into detalle_pedido (id_pedido, id_item_menu, cantidad) VALUES (?, ?, ?)";

            Pago pago = pedido.getPago();
            pagoDAO.crearPago(pago);
            pedido.setPago(pago);
            

            int id = create(sqlPedido,
                    pedido.getEstado().ordinal(),
                    pedido.getCliente().getId(),
                    pedido.getVendedor().getId(),
                    pago.getId(),
                    pedido.getTotal()
            );

            pedido.setId(id);

            itemsPedidoDAO.crearItemsPedido(pedido.getId(), pedido.getItems());

        } catch (SQLException ex) {
            throw new DAOException("no se pudo crear el Pedido: \n" + ex.getMessage());
        }

    }

    @Override
    public void actualizarPedido(Pedido pedido) throws DAOException {
        try {

            String sqlPedido = "update pedido set estado = ?, id_cliente = ?, id_vendedor = ?,id_pago = ?"
                    + ",total= ? where id_pedido = ?;";

            Pago pago = pedido.getPago();
            pagoDAO.actualizarPago(pago);
            pedido.setPago(pago);
            
            update(sqlPedido,
                    pedido.getEstado().ordinal(),
                    pedido.getCliente().getId(),
                    pedido.getVendedor().getId(),
                    pedido.getPago().getId(),
                    pedido.getTotal(),
                    pedido.getId());

            
            itemsPedidoDAO.actualizarItemsPedido(pedido.getId(), pedido.getItems());

        } catch (SQLException ex) {
            throw new DAOException("no se pudo actualizar el Pedido: \n" + ex.getMessage());
        }
    }

    @Override
    public void eliminarPedido(int id) throws DAOException {
        try {
            itemsPedidoDAO.eliminarItemsPedido(id);
            
            String sql2 = "DELETE FROM pedido WHERE id_pedido = ?";
            delete(sql2, id);
        } catch (SQLException ex) {
            throw new DAOException("no se pudo eliminar el Pedido: \n" + ex.getMessage());
        }
    }

    @Override
    public Pedido buscarPedido(int id) throws DAOException {
        try {
            String sql = "SELECT * FROM pedido WHERE id_pedido = ?";

            search(sql, id);

            if (!resultado.next()) {
                throw new DAOException("pedido not found");
            }

            int clienteId = resultado.getInt("id_cliente");
            int vendedorId = resultado.getInt("id_vendedor");
            int estadoInt = resultado.getInt("estado");

            Cliente cliente = clienteDAO.buscarCliente(clienteId);
            Vendedor vendedor = vendedorDAO.buscarVendedor(vendedorId);
            EstadoPedido estado = EstadoPedido.values()[estadoInt];
            Map<ItemMenu, Integer> items = itemsPedidoDAO.buscarPorIdPedido(id);
            Pago pago = pagoDAO.buscarPagoPorIdPedido(id);

            if (pago == null) {
                throw new DAOException("No se encontró un pago asociado al pedido con ID " + id);
            }
            closeSearch();
            return new Pedido(id, cliente, vendedor, items, pago, estado);

        } catch (SQLException ex) {
            throw new DAOException("no se pudo buscar el Pedido: \n" + ex.getMessage());
        } 
        catch (InvalidOrderException ex) {
            throw new DAOException("el pedido es inconsistente InvalidOrderException: \n" + ex.getMessage());
        }
    }

    @Override
    public List<Pedido> obtenerPedidos() throws DAOException {
        try {
            List<Pedido> pedidos = new ArrayList<>();
            String sql = "SELECT * FROM Pedido";

            search(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id_pedido");
                int clienteId = resultado.getInt("id_cliente");
                int vendedorId = resultado.getInt("id_vendedor");
                int estadoInt = resultado.getInt("estado");

                Cliente cliente = clienteDAO.buscarCliente(clienteId);
                Vendedor vendedor = vendedorDAO.buscarVendedor(vendedorId);
                EstadoPedido estado = EstadoPedido.values()[estadoInt];

                Map<ItemMenu, Integer> items = itemsPedidoDAO.buscarPorIdPedido(id);

                Pago pago = pagoDAO.buscarPagoPorIdPedido(id);

                Pedido pedido = new Pedido(id, cliente, vendedor, items, pago, estado);
                pedidos.add(pedido);
            }
            return pedidos;
        } catch (SQLException ex) {
            throw new DAOException("no se pudo buscar el Pedido: \n" + ex.getMessage());
        } 
        catch (InvalidOrderException ex) {
            throw new DAOException("el pedido es inconsistente InvalidOrderException: \n" + ex.getMessage());
        }

    }

    @Override
    public void removeItem(ItemMenu item, Pedido p) throws DAOException {
        try {
            String sql = "DELETE FROM items_pedido WHERE id_pedido = ? AND id_item_menu = ?";
            update(sql, p.getId(), item.getId());   //TODO: ir a dao y unir delete con update
        } catch (SQLException ex) {
            throw new DAOException("no se pudo eliminar el item del Pedido: \n" + ex.getMessage());
        }
    }

    @Override
    public void addItem(ItemMenu item, Pedido p) throws DAOException {
        try {
            String sql = "INSERT INTO items_pedido (id_pedido, id_item_menu, cantidad) VALUES (?, ?, ?)";
            update(sql, p.getId(), item.getId(), 1); // Suponiendo cantidad = 1
        } catch (SQLException ex) {
            throw new DAOException("no se pudo agregar el item al Pedido: \n" + ex.getMessage());
        }
    }

}
