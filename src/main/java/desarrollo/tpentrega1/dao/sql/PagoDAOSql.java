
package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.PagoDAO;
import desarrollo.tpentrega1.entidades.MercadoPago;
import desarrollo.tpentrega1.entidades.Pago;
import desarrollo.tpentrega1.entidades.Transferencia;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class PagoDAOSql extends DAO implements PagoDAO{
         private static PagoDAOSql instance;
     
    public static PagoDAOSql getInstance(){
        if(PagoDAOSql.instance == null)PagoDAOSql.instance =  new PagoDAOSql();
        return PagoDAOSql.instance;
    }

    @Override
    public void crearPago(Pago pago) throws DAOException,Exception {
                String sql = "INSERT INTO pago (monto, fecha) VALUES (?, ?)";
         try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ConectarBase();
            stmt.setDouble(1, pago.getMonto());
            stmt.setDate(2, java.sql.Date.valueOf(pago.getFecha()));
        
            stmt.executeUpdate();
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idItemMenu = generatedKeys.getInt(1);
                    
                   pago.setId(String.valueOf(idItemMenu));
                    
                }
                }
                    
                } catch (Exception ex) {
            throw new DAOException("no se pudo crear el Pago: \n" + ex.getMessage());
        }
                if (pago instanceof MercadoPago) {
            crearMercadoPago((MercadoPago) pago);
        } else {
            crearTransferencia((Transferencia) pago);
        }
    }
    public void crearMercadoPago(MercadoPago mp)throws DAOException,Exception {
        
        String sql = "INSERT INTO mercado_pago (id_pago,alias) VALUES ( ?, ?)";
        try {

            insertarModificarEliminar(sql,
                    Integer.valueOf(mp.getId()),
                    mp.getAlias());

        } catch (Exception ex) {
            throw new DAOException("no se pudo crear el pago de MercadoPago: \n" + ex.getMessage());
        }
        desconectarBase();
    }
    public void crearTransferencia(Transferencia transferencia)throws DAOException,Exception{
        
        String sql = "INSERT INTO transferencia (id_pago, cvu, cuit) VALUES (?, ?, ?)";
        try {

            insertarModificarEliminar(sql,
                    Integer.valueOf(transferencia.getId()),
                    transferencia.getCvu(),
                    transferencia.getCuit());

        } catch (Exception ex) {
            throw new DAOException("no se pudo crear el plato: \n" + ex.getMessage());
        }
        desconectarBase();
    }

    @Override
    public void eliminarPago(String id) throws DAOException {
        
        String sql = "DELETE FROM pago WHERE id_pago = ?";

        try {
            insertarModificarEliminar(sql, Integer.valueOf(id));
        } catch (Exception ex) {
            throw new DAOException("no se pudo eliminar el itemMenu: \n" + ex.getMessage());
        }
    }

    @Override
    public Pago buscarPago(String id) throws DAOException {
               
        String sql = "SELECT * FROM pago P LEFT JOIN mercado_pago MP ON P.id_pago=MP.id_pago LEFT JOIN transferencia T ON"
                + " P.id_pago=T.id_pago WHERE P.id_pago= ?";
        Pago pago = null;

         try {
            ConectarBase();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(id));
            resultado = preparedStatement.executeQuery();

            if(resultado.next()) {
                double monto = resultado.getDouble("monto");
                LocalDate fecha = resultado.getDate("fecha").toLocalDate();
                
                
                if(resultado.getString("alias")!= null){
                String alias= resultado.getString("alias");
                pago = new MercadoPago(alias,monto);
                pago.setId(id);
                pago.setFecha(fecha);
                }
                else if(resultado.getString("cvu")!= null){
                    String cuit= resultado.getString("cuit");
                    String cvu=resultado.getString("cvu");
                    pago= new Transferencia(cuit,cvu,monto);
                    pago.setId(id);
                    pago.setFecha(fecha);
                }
            }
        } catch (Exception ex) {
            throw new DAOException("No se pudo obtener los itemMenu: \n" + ex.getMessage());
        } finally {
            try {

                desconectarBase();
            } catch (Exception e) {
                throw new DAOException("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return pago;
    }

    @Override
    public List<Pago> obtenerPagos() throws DAOException {
        
        String sql = "SELECT * FROM pago P LEFT JOIN mercado_pago MP ON P.id_pago=MP.id_pago LEFT JOIN transferencia T ON"
                + " P.id_pago=T.id_pago";
        List<Pago> listaPagos = new ArrayList<>();

        try {
            ConectarBase();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                String id_pago = String.valueOf(resultado.getInt("id_pago"));
                double monto = resultado.getDouble("monto");
                LocalDate fecha = resultado.getDate("fecha").toLocalDate();

                Pago pago= null;
                
                if(resultado.getString("alias")!=null){
                    String alias= resultado.getString("alias");
                pago = new MercadoPago(alias,monto);
                pago.setId(id_pago);
                pago.setFecha(fecha);
                }
                else if(resultado.getString("cuit")!=null){
                    String cuit= resultado.getString("cuit");
                    String cvu=resultado.getString("cvu");
                    pago= new Transferencia(cuit,cvu,monto);
                    pago.setId(id_pago);
                    pago.setFecha(fecha);
                }
                

                listaPagos.add(pago);
            }
        } catch (Exception ex) {
            throw new DAOException("No se pudo obtener los itemMenu: \n" + ex.getMessage());
        } finally {
            try {

                desconectarBase();
            } catch (Exception e) {
                throw new DAOException("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return listaPagos;
    }
    
    
    
}
