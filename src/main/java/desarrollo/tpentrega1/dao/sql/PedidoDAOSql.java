package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.PedidoDAO;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.MercadoPago;
import desarrollo.tpentrega1.entidades.Pago;
import desarrollo.tpentrega1.entidades.Pedido;
import desarrollo.tpentrega1.entidades.Transferencia;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PedidoDAOSql extends DAO<Pedido> implements PedidoDAO {

    @Override
    public void crearPedido(Pedido pedido) throws DAOException {
        String sqlPago = "insert into pago (monto, fecha) VALUES (?, ?);";
        String sqlPago2 = "select id_pago from pago where ";
        String sqlMp = "insert into mercado_pago (id_pago, alias) VALUES (?, ?);";
        String sqlTransferencia = "insert into transferencia (id_pago, cuit, cvu) VALUES (?, ?, ?);";

        String sqlPedido = "insert into pedido (estado,id_cliente, id_vendedor, id_pago, total) VALUES (?, ?, ?, ?, ?)";
        String sqlItems = "insert into items_pedido (pedido_id, item_id,cantidad) VALUES (?, ?, ?)";

        PreparedStatement stmtItems = null;

        try {

            ConectarBase();
//            conexion.setAutoCommit(false);
            Pago pago = pedido.getPago();
            PreparedStatement stmt = conexion.prepareStatement(sqlPago, Statement.RETURN_GENERATED_KEYS);
            stmt.setDouble(0, pago.getMonto());
            Date date = Date.from(pago.getFecha().atStartOfDay(ZoneId.systemDefault()).toInstant());
            stmt.setDate(1, (java.sql.Date) date);

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            int idPago;
            if (!generatedKeys.next()) {
                throw new DAOException("no se pudo cargar el pago");
            }
            idPago = generatedKeys.getInt(1);

            if (pago instanceof MercadoPago) {
                MercadoPago mp = (MercadoPago) pago;
                insertarModificarEliminar(sqlMp, idPago, mp.getAlias());
            } else {
                Transferencia t = (Transferencia) pago;
                insertarModificarEliminar(sqlTransferencia, t.getCuit(), t.getCvu());
            }

            insertarModificarEliminar(sqlPedido,
                    pedido.getEstado(),
                    pedido.getCliente().getId(),
                    pedido.getVendedor().getId(),
                    idPago,
                    pedido.getTotal());

            stmtItems = conexion.prepareStatement(sqlItems);
            for (ItemMenu item : pedido.getItems()) {
                stmtItems.setString(1, (String) pedido.getId());
                stmtItems.setString(2, item.getId());
                stmtItems.addBatch();
            }
            stmtItems.executeBatch();

//            conexion.commit();
        } catch (SQLException ex) {

//            try {
//                if (conexion != null) {
//                    conexion.rollback();
//                }
//            } catch (SQLException e) {
//                throw new DAOException("Error al hacer rollback: " + e.getMessage());
//            }
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
        //update pedido set estado = ?, id_cliente = ?, id_pago = ?, id_vendedor = ? where id_pedido = ?;
        //update pedido_detalle set id_item_menu = ? where id_pedido = ?;
        String sqlPedido = "update pedido set estado = ?, id_cliente = ?, id_pago = ?, id_vendedor = ? where id_pedido = ?;";
        String sqlItems = "update items_pedido set item_id = ?, cantidad = ? where pedido_id = ?;";

        PreparedStatement stmtItems = null;

        try {

            ConectarBase();
            conexion.setAutoCommit(false);

            insertarModificarEliminar(sqlPedido,
                    Integer.valueOf(pedido.getCliente().getId()), Integer.valueOf(pedido.getVendedor().getId()),
                    Integer.valueOf(pedido.getId()), pedido.getPago(), pedido.getTotal());

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

    }

    @Override
    public Pedido buscarPedido(String id) {
        return null;
    }

    @Override
    public List<Pedido> obtenerPedidos() throws DAOException {
        return null;
    }

    public List<Pedido> getPedidos() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public List<ItemMenu> getItems(Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void addItem(ItemMenu item, Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public void removeItem(ItemMenu item, Pedido p) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
