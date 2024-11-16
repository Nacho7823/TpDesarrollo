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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoDAOSql extends DAO<Pedido> implements PedidoDAO {
    private VendedorDAO vendedorDAO = VendedorDAOSql.getInstance();
    private ClienteDAO clienteDAO = ClienteDAOSql.getInstance();
    private PagoDAO pagoDAO = PagoDAOSql.getInstance(); 
    private ItemsPedidoDAO itemsPedidoDAO= ItemsPedidoDAOSql.getInstance();
     private static PedidoDAOSql instance;
     
    public static PedidoDAOSql getInstance(){
        if(PedidoDAOSql.instance == null)PedidoDAOSql.instance =  new PedidoDAOSql();
        return PedidoDAOSql.instance;}
    
    
    @Override
    public void crearPedido(Pedido pedido) throws DAOException {

        String sqlPedido = "insert into pedido (estado,id_cliente, id_vendedor, id_pago, total) VALUES (?, ?, ?, ?, ?)";
        String sqlItems = "insert into items_pedido (pedido_id, item_id,cantidad) VALUES (?, ?, ?)";

        PreparedStatement stmtItems = null;

        try {
            Pago pago = pedido.getPago();
            pagoDAO.crearPago(pago);
            pedido.setPago(pago);

         try (PreparedStatement stmt = conexion.prepareStatement(sqlPedido, Statement.RETURN_GENERATED_KEYS)) {
            ConectarBase();
            stmt.setString(1,pedido.getEstado().toString());
            stmt.setInt(2,Integer.parseInt(pedido.getCliente().getId()));
            stmt.setInt(3,Integer.parseInt(pedido.getVendedor().getId()));
            stmt.setInt(4,Integer.parseInt(pago.getId()));
            stmt.setDouble(5, pedido.getTotal());
        
            stmt.executeUpdate();
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idPedido = generatedKeys.getInt(1);
                    
                   pedido.setId(String.valueOf(idPedido));
                    
                }
                }
                    
                } catch (Exception ex) {
            throw new DAOException("no se pudo crear el Pago: \n" + ex.getMessage());
        }

            stmtItems = conexion.prepareStatement(sqlItems);
            for (ItemMenu item : pedido.getItems()) {
                stmtItems.setInt(1, Integer.parseInt(pedido.getId()));
                stmtItems.setInt(2, Integer.parseInt(item.getId()));
                stmtItems.addBatch();
            }
            stmtItems.executeBatch();

        } catch (SQLException ex) {

            throw new DAOException("No se pudo crear el pedido: " + ex.getMessage());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Cerrar los recursos
                if (stmtItems != null) {
                    stmtItems.close();
                }
                desconectarBase();
            } catch (Exception ex) {
                throw new DAOException("Error al cerrar recursos: " + ex.getMessage());
            }
        }
    }

    @Override
    public void actualizarPedido(Pedido pedido) throws DAOException {

        String sqlPedido = "update pedido set estado = ?, id_cliente = ?, id_vendedor = ?,id_pago = ?"
                + ",total= ? where id_pedido = ?;";
        String sqlItems = "update items_pedido set item_id = ? where pedido_id = ?;"; //cantidad a implementar

        PreparedStatement stmtItems = null;

        try {

            ConectarBase();
            conexion.setAutoCommit(false);

            insertarModificarEliminar(sqlPedido,
                    pedido.getEstado().toString(),
                    Integer.parseInt(pedido.getCliente().getId()),
                    Integer.parseInt(pedido.getVendedor().getId()),
                    pedido.getPago().getId(),
                    pedido.getTotal(),
                    Integer.valueOf(pedido.getId()));

            stmtItems = conexion.prepareStatement(sqlItems);
            for (ItemMenu item : pedido.getItems()) {
                stmtItems.setInt(1, Integer.parseInt(item.getId()));
                stmtItems.setInt(2, Integer.parseInt(pedido.getId()));
                stmtItems.addBatch();
            }
            stmtItems.executeBatch();

            conexion.commit();

        } catch (SQLException ex) {

            try {
                if (conexion != null) {
                    conexion.rollback();
                }
            } catch (SQLException e) {
                throw new DAOException("Error al hacer rollback: " + e.getMessage());
            }
            throw new DAOException("No se pudo crear el pedido: " + ex.getMessage());

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(PedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(PedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                // Cerrar los recursos
                if (stmtItems != null) {
                    stmtItems.close();
                }
                desconectarBase();
            } catch (Exception ex) {
                throw new DAOException("Error al cerrar recursos: " + ex.getMessage());
            }
        }

    }

    @Override
    public void eliminarPedido(String id) throws DAOException {
         String sql = "DELETE FROM pedido WHERE id_pedido = ?";
        try {
            insertarModificarEliminar(sql, id);
            System.out.println("Pedido con ID " + id + " eliminado exitosamente.");
        } catch (Exception e) {
            System.err.println("Error al eliminar el pedido con ID " + id + ": " + e.getMessage());
        }
    }

    @Override
    public Pedido buscarPedido(String id) {
    Pedido pedido = null;
    String sql = "SELECT * FROM pedido WHERE id_pedido = ?";
    
    
    try {
        ConectarBase();
        PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        preparedStatement.setString(1, id); 
        resultado = preparedStatement.executeQuery();

        if (resultado.next()) {
       
            String clienteId = resultado.getString("cliente_id");
            String vendedorId = resultado.getString("vendedor_id");
            String estadoStr = resultado.getString("estado");
          
            
            Cliente cliente = clienteDAO.buscarCliente(clienteId);
            Vendedor vendedor = vendedorDAO.buscarVendedor(vendedorId);
            EstadoPedido estado = EstadoPedido.valueOf(estadoStr); 
            List<ItemMenu> items = itemsPedidoDAO.buscarPorIdPedido(id);
            Pago pago = pagoDAO.; //buscarPagoPorPedidoId(id); //terminar de implementar cuando esté listo el pagoDAOSql
            
            pedido = new Pedido(id, cliente, vendedor, items, pago, estado);
        }
    } catch (Exception e) {
        System.err.println("Error al buscar el pedido con ID " + id + ": " + e.getMessage());
    } finally {
        try {
            desconectarBase();
        } catch (Exception e) {
            System.err.println("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    return pedido;
}

    @Override
public List<Pedido> obtenerPedidos() throws DAOException {
    List<Pedido> pedidos = new ArrayList<>();
    String sql = "SELECT * FROM Pedidos";

    try {
        ConectarBase();
        Statement statement = conexion.createStatement();
        ResultSet rs = statement.executeQuery(sql);

        ClienteDAOSql clienteDAOSql = new ClienteDAOSql();
        VendedorDAOSql vendedorDAOSql = new VendedorDAOSql();
        ItemMenuDAOSql itemMenuDAOSql = new ItemMenuDAOSql();

        while (rs.next()) {
            String id = rs.getString("id");
            String clienteId = rs.getString("cliente_id");
            String vendedorId = rs.getString("vendedor_id");
            String estadoStr = rs.getString("estado");

            Cliente cliente = clienteDAOSql.buscarCliente(clienteId);
            Vendedor vendedor = vendedorDAOSql.buscarVendedor(vendedorId);
            EstadoPedido estado = EstadoPedido.valueOf(estadoStr);
            List<ItemMenu> items = itemMenuDAOSql.obtenerItemsMenuDeVendedor(vendedor.getId());
            Pago pago = null; //buscarPagoPorPedidoId(id);  //terminar de implementar cuando esté listo el pagoDAOSql

            Pedido pedido = new Pedido(id, cliente, vendedor, items, pago, estado);
            pedidos.add(pedido);
        }
    } catch (Exception e) {
        throw new DAOException("Error al obtener pedidos: " + e.getMessage());
    } finally {
        try {
            desconectarBase();
        } catch (Exception e) {
            throw new DAOException("Error al cerrar la conexión: " + e.getMessage());
        }
    }

    return pedidos;
}

    public void removeItem(ItemMenu item, Pedido p) throws DAOException {
        String sql = "DELETE FROM items_pedido WHERE pedido_id = ? AND item_id = ?";

    try {
        ConectarBase();
        insertarModificarEliminar(sql, p.getId(), item.getId());
    } catch (Exception e) {
        throw new DAOException("Error al eliminar ítem del pedido: " + e.getMessage());
    } finally {
        try {
            desconectarBase();
        } catch (Exception e) {
            throw new DAOException("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    }

    public void addItem(ItemMenu item, Pedido p) throws DAOException {
         String sql = "INSERT INTO items_pedido (pedido_id, item_id, cantidad) VALUES (?, ?, ?)";

    try {
        ConectarBase();
        insertarModificarEliminar(sql, p.getId(), item.getId(), 1); // Suponiendo cantidad = 1
    } catch (Exception e) {
        throw new DAOException("Error al añadir ítem al pedido: " + e.getMessage());
    } finally {
        try {
            desconectarBase();
        } catch (Exception e) {
            throw new DAOException("Error al cerrar la conexión: " + e.getMessage());
        }
    }
    }


    

}
