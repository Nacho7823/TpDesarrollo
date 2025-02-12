package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.PagoDAO;
import desarrollo.tpentrega1.entidades.MercadoPago;
import desarrollo.tpentrega1.entidades.Pago;
import desarrollo.tpentrega1.entidades.Transferencia;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PagoDAOSql extends DAO implements PagoDAO {

    private static PagoDAOSql instance;

    public static PagoDAOSql getInstance() {
        if (PagoDAOSql.instance == null) {
            PagoDAOSql.instance = new PagoDAOSql();
        }
        return PagoDAOSql.instance;
    }

    @Override
    public void crearPago(Pago pago) throws DAOException {
        String sql = "INSERT INTO pago (monto, fecha) VALUES (?, ?)";

        try {

            int id = create(sql, pago.getMonto(), java.sql.Date.valueOf(pago.getFecha()));
            pago.setId(id);

            if (pago instanceof MercadoPago) {
                crearMercadoPago((MercadoPago) pago);
            } else {
                crearTransferencia((Transferencia) pago);
            }

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    public void crearMercadoPago(MercadoPago mp) throws DAOException {

        String sql = "INSERT INTO mercado_pago (id_pago,alias) VALUES ( ?, ?)";
        try {

            createNoKey(sql,
                    mp.getId(),
                    mp.getAlias());

        } catch (SQLException ex) {
            throw new DAOException("no se pudo crear el pago de MercadoPago: \n" + ex.getMessage());
        }

    }

    public void crearTransferencia(Transferencia transferencia) throws DAOException {
        String sql = "INSERT INTO transferencia (id_pago, cvu, cuit) VALUES (?, ?, ?)";
        try {

            createNoKey(sql,
                    transferencia.getId(),
                    transferencia.getCvu(),
                    transferencia.getCuit());

        } catch (SQLException ex) {
            throw new DAOException("no se pudo crear el pago de transferencia: \n" + ex.getMessage());
        }
    }
    
    @Override
    public void actualizarPago(Pago pago) throws DAOException {
        // TODO: fix
        eliminarPago(pago.getId());
        crearPago(pago);
    }

    @Override
    public void eliminarPago(int id) throws DAOException {

        String sql1 = "DELETE FROM pago WHERE id_pago = ?";
        String sql2 = "DELETE FROM transferencia WHERE id_pago = ?";
        String sql3 = "DELETE FROM mercado_pago WHERE id_pago = ?";

        try {
            delete(sql1, id);
            delete(sql2, id);
            delete(sql3, id);
        } catch (SQLException ex) {
            throw new DAOException("no se pudo eliminar el pago: \n" + ex.getMessage());
        }
    }

    @Override
    public Pago buscarPago(int id) throws DAOException {

        String sql = "SELECT * FROM pago P LEFT JOIN mercado_pago MP ON P.id_pago=MP.id_pago LEFT JOIN transferencia T ON"
                + " P.id_pago=T.id_pago WHERE P.id_pago= ?";

        try {
            search(sql, id);

            if (!resultado.next()) {
                throw new DAOException("pago not found");
            }

            double monto = resultado.getDouble("monto");
            LocalDate fecha = resultado.getDate("fecha").toLocalDate();

            Pago pago = null;
            if (resultado.getString("alias") != null) {
                String alias = resultado.getString("alias");
                pago = new MercadoPago(alias, monto);
                pago.setId(id);
                pago.setFecha(fecha);
            } else if (resultado.getString("cvu") != null) {
                String cuit = resultado.getString("cuit");
                String cvu = resultado.getString("cvu");
                pago = new Transferencia(cuit, cvu, monto);
                pago.setId(id);
                pago.setFecha(fecha);
            }
            closeSearch();
            return pago;

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public Pago buscarPagoPorIdPedido(int id) throws DAOException {

        String sql = "SELECT * FROM pago P LEFT JOIN pedido PE ON PE.id_pago=P.id_pago LEFT JOIN mercado_pago MP ON P.id_pago=MP.id_pago LEFT JOIN transferencia T ON"
                + " P.id_pago=T.id_pago WHERE PE.id_pedido= ?";

        try {
            search(sql, id);

            if (!resultado.next()) {
                throw new DAOException("pago not found");
            }

            double monto = resultado.getDouble("monto");
            LocalDate fecha = resultado.getDate("fecha").toLocalDate();

            Pago pago = null;
            if (resultado.getString("alias") != null) {
                String alias = resultado.getString("alias");
                pago = new MercadoPago(alias, monto);
                pago.setId(id);
                pago.setFecha(fecha);
            } else if (resultado.getString("cvu") != null) {
                String cuit = resultado.getString("cuit");
                String cvu = resultado.getString("cvu");
                pago = new Transferencia(cuit, cvu, monto);
                pago.setId(id);
                pago.setFecha(fecha);
            }

            closeSearch();
            return pago;

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public List<Pago> obtenerPagos() throws DAOException {
        try {

            String sql = "SELECT * FROM pago P LEFT JOIN mercado_pago MP ON P.id_pago=MP.id_pago LEFT JOIN transferencia T ON"
                + " P.id_pago=T.id_pago";

            List<Pago> listaPagos = new ArrayList<>();

            search(sql);

            while (resultado.next()) {
                int id_pago = resultado.getInt("id_pago");
                double monto = resultado.getDouble("monto");
                LocalDate fecha = resultado.getDate("fecha").toLocalDate();

                Pago pago = null;

                if (resultado.getString("alias") != null) {
                    String alias = resultado.getString("alias");
                    pago = new MercadoPago(alias, monto);
                    pago.setId(id_pago);
                    pago.setFecha(fecha);
                } else if (resultado.getString("cuit") != null) {
                    String cuit = resultado.getString("cuit");
                    String cvu = resultado.getString("cvu");
                    pago = new Transferencia(cuit, cvu, monto);
                    pago.setId(id_pago);
                    pago.setFecha(fecha);
                }

                listaPagos.add(pago);
            }

            closeSearch();
            return listaPagos;
            
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
        
    }
}
