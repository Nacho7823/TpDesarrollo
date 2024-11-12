package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.ClienteDAO;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Coordenada;
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

public class ClienteDAOSql implements ClienteDAO {

    private Connection connection;

    public ClienteDAOSql() throws SQLException {
        connection = ConnectionDB.getConnection();
    }

    @Override
    public void crearCliente(Cliente cliente) throws DAOException {
        try {
            
            String sql = "INSERT INTO cliente (id_cliente, nombre, cuit, email, direccion, longitud, latitud) VALUES (?, ?, ?, ?, ?, ?, ?)";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, Integer.parseInt(cliente.getId()));
            statement.setString(2, cliente.getNombre());
            statement.setString(3, cliente.getCuit());
            statement.setString(4, cliente.getEmail());
            statement.setString(5, cliente.getDireccion());
            statement.setDouble(6, cliente.getCoordenada().getLng());
            statement.setDouble(7, cliente.getCoordenada().getLat());
            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("no se pudo crear el cliente: \n" + ex.getMessage());
        }

    }

    @Override
    public void actualizarCliente(Cliente cliente) throws DAOException {
        try {
            String sql = "UPDATE cliente SET nombre = ?, cuit = ?, email = ?, direccion = ?, longitud = ?, latitud = ? WHERE id_cliente = ?";

            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, cliente.getNombre());
            statement.setString(2, cliente.getCuit());
            statement.setString(3, cliente.getEmail());
            statement.setString(4, cliente.getDireccion());
            statement.setDouble(5, cliente.getCoordenada().getLng());
            statement.setDouble(6, cliente.getCoordenada().getLat());
            statement.setDouble(7, Integer.parseInt(cliente.getId()));
        
            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("no se pudo actualizar el cliente: \n" + ex.getMessage());
        }
    }

    @Override
    public void eliminarCliente(Cliente cliente) throws DAOException {
        try {
            String sql = "DELETE FROM cliente WHERE id_cliente = ?";
            PreparedStatement statement = connection.prepareStatement(sql);
            
            statement.setInt(1, Integer.parseInt(cliente.getId()));
            statement.executeUpdate();

        } catch (SQLException ex) {
            throw new DAOException("no se pudo actualizar el cliente: \n" + ex.getMessage());
        }
    }

    @Override
    public Cliente buscarCliente(String id) throws DAOException {
        try {
            // (id_cliente, nombre, cuit, email, direccion, longitud, latitud) 
            String sql = "SELECT nombre, cuit, email, direccion, longitud, latitud FROM cliente WHERE id_cliente = ?";
            
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setInt(1, Integer.parseInt(id));
        
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String nombre = rs.getString("nombre");
                String cuit = rs.getString("cuit");
                String email = rs.getString("email");
                String direccion = rs.getString("direccion");
                double longitud = rs.getDouble("longitud");
                double latitud = rs.getDouble("latitud");
                Coordenada coord = new Coordenada(latitud, longitud);
                Cliente cliente = new Cliente(id, nombre, cuit, email, direccion, coord);
                return cliente;
            }
        } catch (SQLException ex) {
            throw new DAOException("no se pudo buscar el cliente: \n" + ex.getMessage());
        }
        return null;
    }
    
    @Override
    public List<Cliente> obtenerClientes() throws DAOException {
        try {
            // (id_cliente, nombre, cuit, email, direccion, longitud, latitud) 
            String sql = "SELECT id_cliente, nombre, cuit, email, direccion, longitud, latitud FROM cliente";

            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet rs = statement.executeQuery();

            ArrayList<Cliente> list = new ArrayList<Cliente>();
            while (rs.next()) {
                String id_cliente = rs.getString("id_cliente");
                String nombre = rs.getString("nombre");
                String cuit = rs.getString("cuit");
                String email = rs.getString("email");
                String direccion = rs.getString("direccion");
                double longitud = rs.getDouble("longitud");
                double latitud = rs.getDouble("latitud");
                Coordenada coord = new Coordenada(latitud, longitud);
                Cliente cliente = new Cliente(id_cliente, nombre, cuit, email, direccion, coord);
                
                list.add(cliente);
            }
            
            return list;
            
        } catch (SQLException ex) {
            throw new DAOException("no se pudo obtener los cliente: \n" + ex.getMessage());
        }
    }

}
