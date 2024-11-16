
package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.Connection ;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;



/**
 * DAO genérico para operaciones CRUD.
 *
 * @param <T> Tipo de entidad.
 */

public class DAO<T> {

        protected Connection conexion = null;
        protected ResultSet resultado = null;
        protected Statement sentencia = null;
        
        private final String USER = "root";
        private final String PASSWORD = "C0NTR4S3Ñ4";
        private final String DATABASE = "tienda";
        private final String DRIVER = "com.mysql.cj.jdbc.Driver";
        
        protected void ConectarBase() throws SQLException, ClassNotFoundException {
            try {
                Class.forName(DRIVER);
                String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false";
                conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
                System.out.println("Conexión exitosa");
                
            } catch (ClassNotFoundException | SQLException ex) {
                throw ex;
            }
        }
        
        protected void desconectarBase() throws Exception {
            try {
                if (resultado != null) {
                    resultado.close();
                    
                }
                if (sentencia != null) {
                    sentencia.close();
                }
                if (conexion != null) {
                    conexion.close();
                }
            } catch (Exception e) {
                throw e;
            }
        }
        
    protected void insertarModificarEliminar(String sql, Object... parametros) throws Exception {
    PreparedStatement preparedStatement = null;
    try {
       
        ConectarBase();
        
       
        preparedStatement = conexion.prepareStatement(sql);
        
        
        for (int i = 0; i < parametros.length; i++) {
            preparedStatement.setObject(i + 1, parametros[i]);  
        }
        
        
        preparedStatement.executeUpdate();
        
    } catch (ClassNotFoundException | SQLException ex) {
        
        throw new DAOException("Error al ejecutar la consulta: " + ex.getMessage());
    } finally {
        
        if (preparedStatement != null) {
            preparedStatement.close();
        }
        desconectarBase();
    }
}

        protected void consultarBase(String sql) throws Exception {
            try {
                ConectarBase();
                sentencia = conexion.createStatement();
                resultado = sentencia.executeQuery(sql);
                
            } catch (Exception e) {
                throw e;
            }
        }
        
 
}
