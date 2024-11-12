package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.VendedorDAO;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendedorDAOSql implements VendedorDAO {

    private Connection connection;

    public VendedorDAOSql() throws SQLException {
        connection = ConnectionDB.getConnection();
    }

    @Override
    public void crearVendedor(Vendedor vendedor) throws DAOException {
        try {
            String sql = "INSERT INTO vendedor (id_vendedor, nombre, direccion, longitud, latitud) VALUES (?, ?, ?, ?, ?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, Integer.parseInt(vendedor.getId()));
            statement.setString(2, vendedor.getNombre());
            statement.setString(3, vendedor.getDireccion());
            statement.setDouble(4, vendedor.getCoordenada().getLng());
            statement.setDouble(5, vendedor.getCoordenada().getLat());
            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("no se pudo crear el vendedor: \n" + ex.getMessage());
        }

    }

    @Override
    public void actualizarVendedor(Vendedor vendedor) throws DAOException {
        try {
            String sql = "UPDATE vendedor SET nombre = ?, direccion = ?, longitud = ?, latitud = ? WHERE id_vendedor = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, vendedor.getNombre());
            statement.setString(2, vendedor.getDireccion());
            statement.setDouble(3, vendedor.getCoordenada().getLng());
            statement.setDouble(4, vendedor.getCoordenada().getLat());
            statement.setInt(5, Integer.parseInt(vendedor.getId()));
        
            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("no se pudo actualizar el vendedor: \n" + ex.getMessage());
        }
    }

    @Override
    public void eliminarVendedor(Vendedor vendedor) throws DAOException {
        try {
            String sql = "DELETE FROM vendedor WHERE id_vendedor = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, Integer.parseInt(vendedor.getId()));
            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("no se pudo actualizar el vendedor: \n" + ex.getMessage());
        }
    }

    @Override
    public Vendedor buscarVendedor(String id) throws DAOException {
        try {
            String sql = "SELECT nombre, direccion, longitud, latitud FROM vendedor WHERE id_vendedor = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(id));
        
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                double longitud = rs.getDouble("longitud");
                double latitud = rs.getDouble("latitud");
                Coordenada coord = new Coordenada(latitud, longitud);
                Vendedor vendedor = new Vendedor(id, nombre, direccion, coord);
                return vendedor;
            }
        } catch (SQLException ex) {
            throw new DAOException("no se pudo buscar el vendedor: \n" + ex.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Vendedor> obtenerVendedores() throws DAOException {
        try {
            
            String sql = "SELECT id_vendedor, nombre, direccion, longitud, latitud FROM vendedor";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            ArrayList<Vendedor> list = new ArrayList<Vendedor>();
            while (rs.next()) {
                String id_vendedor = rs.getString("id_vendedor");
                String nombre = rs.getString("nombre");
                String direccion = rs.getString("direccion");
                double longitud = rs.getDouble("longitud");
                double latitud = rs.getDouble("latitud");
                Coordenada coord = new Coordenada(latitud, longitud);
                Vendedor vendedor = new Vendedor(id_vendedor, nombre, direccion, coord);
                
                list.add(vendedor);
            }
            
            return list;
            
        } catch (SQLException ex) {
            throw new DAOException("no se pudo obtener los vendedores: \n" + ex.getMessage());
        }
    }

}
