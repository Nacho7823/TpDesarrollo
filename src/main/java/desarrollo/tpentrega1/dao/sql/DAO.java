package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DAO {

    protected Connection conexion = null;
    protected ResultSet resultado = null;
    protected Statement sentencia = null;
    protected PreparedStatement preparedStatement;

    private final String USER = "root";
    private final String PASSWORD = "root";
    private final String DATABASE = "tienda";
    private final String DRIVER = "com.mysql.cj.jdbc.Driver";
    String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE;
//    String urlBaseDeDatos = "jdbc:mysql://localhost:3306/" + DATABASE + "?useSSL=false&allowPublicKeyRetrieval=true";

    protected void ConectarBase() throws SQLException {
        try {
            Class.forName(DRIVER);
            conexion = DriverManager.getConnection(urlBaseDeDatos, USER, PASSWORD);
            System.out.println("Conexión exitosa");

        } catch (ClassNotFoundException e) {
            throw new SQLException("no se pudo cargar el driver");
        }
    }

    protected void desconectarBase() throws SQLException {
        if (resultado != null) {
            resultado.close();
        }
        if (sentencia != null) {
            sentencia.close();
        }
        if (conexion != null) {
            conexion.close();
        }
    }

    protected int create(String sql, Object... parametros) throws SQLException {

        ConectarBase();

        preparedStatement = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        int ps = parametros.length;

        for (int i = 0; i < ps; i++) {
            preparedStatement.setObject(i + 1, parametros[i]);
        }

        preparedStatement.executeUpdate();
        ResultSet generatedKeys = preparedStatement.getGeneratedKeys();

        if (generatedKeys.next()) {
            int key = generatedKeys.getInt(1);
            generatedKeys.close();
            preparedStatement.close();
            desconectarBase();
            return key;
        } else {
            generatedKeys.close();
            preparedStatement.close();
            desconectarBase();
            throw new SQLException("no se pudo crear el cliente, no se genero ningun id");
        }

    }
    
    protected void createNoKey(String sql, Object... parametros) throws SQLException{

        ConectarBase();
        preparedStatement = conexion.prepareStatement(sql);

        for (int i = 0; i < parametros.length; i++) {
            preparedStatement.setObject(i + 1, parametros[i]);
        }

        preparedStatement.executeUpdate();

        if (preparedStatement != null) {
            preparedStatement.close();
        }
        desconectarBase();
    }
    

    protected void update(String sql, Object... parametros) throws SQLException {

        ConectarBase();
        preparedStatement = conexion.prepareStatement(sql);

        for (int i = 0; i < parametros.length; i++) {
            preparedStatement.setObject(i + 1, parametros[i]);
        }

        preparedStatement.executeUpdate();

        if (preparedStatement != null) {
            preparedStatement.close();
        }
        desconectarBase();
    }

    protected void delete(String sql, int id) throws SQLException {
        ConectarBase();
        preparedStatement = conexion.prepareStatement(sql);

        preparedStatement.setObject(1, id);

        preparedStatement.executeUpdate();

        if (preparedStatement != null) {
            preparedStatement.close();
        }
        desconectarBase();
    }
    
    protected void search(String sql, Object... parametros) throws SQLException {
        
        ConectarBase();
        preparedStatement = conexion.prepareStatement(sql);
        
        for (int i = 0; i < parametros.length; i++) {
            preparedStatement.setObject(i + 1, parametros[i]);
        }
        
        resultado = preparedStatement.executeQuery();

    }
    
    protected void closeSearch() throws SQLException{
        
        preparedStatement.close();
        desconectarBase();
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

        } catch (SQLException ex) {

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
