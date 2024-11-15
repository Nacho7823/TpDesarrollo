
package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.PedidoDAO;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Pedido;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


public class PedidoDAOSql extends DAO<Pedido> implements PedidoDAO {

    @Override
    public void listarPedidos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public void crearPedido(Pedido pedido) throws DAOException{
    String sqlPedido = "INSERT INTO pedido (estado,id_cliente, id_vendedor, id_pago, total) VALUES (?, ?, ?, ?, ?)";
    String sqlItems = "INSERT INTO items_pedido (pedido_id, item_id,cantidad) VALUES (?, ?, ?)";
    
    PreparedStatement stmtItems = null;
    
    try {
       
        ConectarBase();
        conexion.setAutoCommit(false);
        
       
        insertarModificarEliminar(sqlPedido, pedido.getCliente().getId(), pedido.getVendedor().getId(), 
                                  pedido.getId(), pedido.getPago(), pedido.getTotal());
        
       
        stmtItems = conexion.prepareStatement(sqlItems);
        for (ItemMenu item : pedido.getItems()) {
            stmtItems.setString(1, (String) pedido.getId());
            stmtItems.setString(2, item.getId());
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
            if (stmtItems != null) stmtItems.close();
            desconectarBase();
        } catch (Exception ex) {
            throw new DAOException("Error al cerrar recursos: " + ex.getMessage());
        }
    }
}


    @Override
    public void actualizarPedido(Pedido pedido) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void eliminarPedido(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pedido buscarPedido(String id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void addItem(ItemMenu item, Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ItemMenu> getItems(Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
