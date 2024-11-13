/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.PedidoDAO;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Pedido;
import desarrollo.tpentrega1.exceptions.DAOException;
import desarrollo.tpentrega1.interfaces.Observador;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author florh
 */
public class PedidoDAOSql extends DAO<Pedido> implements PedidoDAO {

    @Override
    public void listarPedido() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    @Override
    public void crearPedido(Pedido pedido) throws DAOException{
    String sqlPedido = "INSERT INTO pedido (cliente, vendedor, id, formaDePago, total) VALUES (?, ?, ?, ?, ?)";
    String sqlItems = "INSERT INTO pedido_items (pedido_id, item_id) VALUES (?, ?)";
    String sqlObservadores = "INSERT INTO pedido_observadores (pedido_id, observador_id) VALUES (?, ?)";
    
    PreparedStatement stmtItems = null;
    PreparedStatement stmtObservadores = null;
    
    try {
       
        ConectarBase();
        conexion.setAutoCommit(false);
        
       
        insertarModificarEliminar(sqlPedido, pedido.getCliente().getId(), pedido.getVendedor().getId(), 
                                  pedido.getId(), pedido.getFormaDePago(), pedido.getTotal());
        
       
        stmtItems = conexion.prepareStatement(sqlItems);
        for (ItemMenu item : pedido.getItems()) {
            stmtItems.setString(1, (String) pedido.getId());
            stmtItems.setString(2, item.getId());
            stmtItems.addBatch();
        }
        stmtItems.executeBatch();
        
        
        stmtObservadores = conexion.prepareStatement(sqlObservadores);
        for (Observador observador : pedido.getObservadores()) {
            stmtObservadores.setString(1, (String) pedido.getId());
            stmtObservadores.setString(2, ((Cliente)observador).getId());
            stmtObservadores.addBatch();
        }
        stmtObservadores.executeBatch();
        
        
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
            if (stmtObservadores != null) stmtObservadores.close();
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
