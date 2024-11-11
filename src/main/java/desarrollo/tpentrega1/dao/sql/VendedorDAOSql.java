package desarrollo.tpentrega1.dao.sql;


import desarrollo.tpentrega1.dao.VendedorDAO;
import desarrollo.tpentrega1.dao.sql.ConnectionDB;
import desarrollo.tpentrega1.entidades.Vendedor;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendedorDAOSql implements VendedorDAO {

    private Connection connection;

    public VendedorDAOSql() {
        try {
            connection = ConnectionDB.getConnection();
        } catch (SQLException ex) {
            throw new RuntimeException("Cant connect to DB");
        }
    }

//    @Override
//    public void listarVendedor(Vendedor vendedor) {
//
//    }

    private int insert(String sql, ArrayList<String> elements) throws SQLException {
//        String sql = "INSERT INTO vendedor (nombre, direccion, longitud, latitud) VALUES (?)";
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        for (int i = 1; i <= elements.size(); i++) {
            statement.setString(i, elements.get(i));
        }
        int f = statement.executeUpdate();

        if (f > 0) {
            ResultSet generated = statement.getGeneratedKeys();
            if (generated.next()) {
                return generated.getInt(1);
            }
        }
        return -1;
    }
    
    public void update(String sql, ArrayList<String> elements) throws SQLException {
        PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        for (int i = 1; i <= elements.size(); i++) {
            statement.setString(i, elements.get(i));
        }
        statement.executeUpdate();
    }

    @Override
    public void crearVendedor(Vendedor vendedor) {
        try {
            //INSERT INTO vendedor (id_vendedor, nombre, direccion, longitud, latitud) VALUES
            //(0, 'Lila Mussin', 'bv galvez 3124', 0.234, 0.634),
            
            String sql = "INSERT INTO vendedor (nombre, direccion, longitud, latitud) VALUES (?)";
            ArrayList<String> ar = new ArrayList<String>();
            ar.add(vendedor.getNombre());
            ar.add(vendedor.getDireccion());
            ar.add(vendedor.getCoordenada().getLng() + "");
            ar.add(vendedor.getCoordenada().getLat() + "");
            int id = insert(sql, ar);
            vendedor.setId(id + "");
        } catch (SQLException ex) {
            // TODO
        }
    }

    @Override
    public void actualizarVendedor(Vendedor vendedor) {
        String sql = "UPDATE vendedor SET nombre = ?, direccion = ?, lognitud = ?, latitud = ? WHERE id_vendedor = ?";
            ArrayList<String> ar = new ArrayList<String>();
            ar.add(vendedor.getNombre());
            ar.add(vendedor.getDireccion());
            ar.add(vendedor.getCoordenada().getLng() + "");
            ar.add(vendedor.getCoordenada().getLat() + "");
            int id = insert(sql, ar);
            vendedor.setId(id + "");
    }

    @Override
    public void eliminarVendedor(String id) {
        
    }

    @Override
    public Vendedor buscarVendedor(String id) {
        return null;
    }
    
    @Override
    public List<Vendedor> getVendedores() {
        return null;
    }

}
