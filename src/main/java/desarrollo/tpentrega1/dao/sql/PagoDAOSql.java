
package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.PagoDAO;
import desarrollo.tpentrega1.entidades.MercadoPago;
import desarrollo.tpentrega1.entidades.Pago;
import desarrollo.tpentrega1.entidades.Transferencia;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.List;

public class PagoDAOSql extends DAO implements PagoDAO{
         private static PagoDAOSql instance;
     
    public static PagoDAOSql getInstance(){
        if(PagoDAOSql.instance == null)PagoDAOSql.instance =  new PagoDAOSql();
        return PagoDAOSql.instance;
    }

    @Override
    public void crearPago(Pago pago) throws DAOException {
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
            throw new DAOException("no se pudo crear el ItemMenu: \n" + ex.getMessage());
        }
                if (pago instanceof MercadoPago) {
            crearMercadoPago((MercadoPago) pago);
        } else {
            crearPlato((Transferencia) pago);
        }
    }
    public void crearMercadoPago(MercadoPago mp){
        
    }
    public void crearPlato(Transferencia transferencia){
        
    }

    @Override
    public void eliminarPedido(String id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public Pago buscarPago(String id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<Pago> obtenerPagos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    
    
}
