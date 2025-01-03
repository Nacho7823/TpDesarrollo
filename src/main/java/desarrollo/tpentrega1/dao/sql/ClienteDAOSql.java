package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.ClienteDAO;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteDAOSql extends DAO<Cliente> implements ClienteDAO {
private static ClienteDAOSql instance;
     
    public static ClienteDAOSql getInstance(){
        if(ClienteDAOSql.instance == null)ClienteDAOSql.instance =  new ClienteDAOSql();
        return ClienteDAOSql.instance;
    }

   @Override
   public void crearCliente(Cliente cliente) throws DAOException {
        String sql = "INSERT INTO cliente (nombre, cuit, email, direccion, longitud, latitud) VALUES (?, ?, ?, ?, ?, ?)";
    try {
        ConectarBase();
    } catch (SQLException ex) {
        Logger.getLogger(ClienteDAOSql.class.getName()).log(Level.SEVERE, null, ex);
    } catch (ClassNotFoundException ex) {
        Logger.getLogger(ClienteDAOSql.class.getName()).log(Level.SEVERE, null, ex);
    }
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, cliente.getNombre());
            stmt.setString(2, cliente.getCuit());
            stmt.setString(3, cliente.getEmail());
            stmt.setString(4, cliente.getDireccion());
            stmt.setDouble(5, cliente.getCoordenada().getLng());
            stmt.setDouble(6, cliente.getCoordenada().getLat());
            stmt.executeUpdate();
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idCliente = generatedKeys.getInt(1);
                    cliente.setId(String.valueOf(idCliente));
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            throw new DAOException("no se pudo crear el cliente: \n" + ex.getMessage());
        }
    }

    @Override
    public void actualizarCliente(Cliente cliente) throws DAOException {
        String sql = "UPDATE cliente SET nombre = ?, cuit = ?, email = ?, direccion = ?, longitud = ?, latitud = ? WHERE id_cliente = ?";

        try {
        
            insertarModificarEliminar(sql, 
            cliente.getNombre(),       
            cliente.getCuit(),       
            cliente.getEmail(),        
            cliente.getDireccion(),   
            cliente.getCoordenada().getLng(),     
            cliente.getCoordenada().getLat(),     
            Integer.valueOf(cliente.getId())     
            );

        } catch (Exception ex) {
            throw new DAOException("no se pudo actualizar el cliente: \n" + ex.getMessage());
        }
    }

    @Override
    public void eliminarCliente(String id) throws DAOException {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
        try {
            insertarModificarEliminar(sql,Integer.valueOf(id));  
        } catch (Exception ex) {
            throw new DAOException("No se pudo eliminar el cliente: \n" + ex.getMessage());
        }
    }

    @Override
    public Cliente buscarCliente(String id) throws DAOException {
    String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
    Cliente cliente = null;

    try {
        ConectarBase();
        PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        preparedStatement.setString(1, id);  
        resultado = preparedStatement.executeQuery();

        
        if (resultado.next()) {
            cliente = new Cliente(id, 
                    resultado.getString("nombre"), 
                    resultado.getString("cuit"), 
                    resultado.getString("email"), 
                    resultado.getString("direccion"), 
                    new Coordenada(resultado.getDouble("latitud"), resultado.getDouble("longitud")));
        }

        preparedStatement.close();
    } catch (SQLException | ClassNotFoundException ex) {
        throw new DAOException("No se pudo buscar el cliente: \n" + ex.getMessage());
    } finally {
        try {
            desconectarBase();
        } catch (Exception e) {
            throw new DAOException("Error al desconectar la base de datos: " + e.getMessage());
        }
    }

    return cliente;
    }
    
    @Override
    public Cliente buscarClientePorNombre(String nombre) throws DAOException {
        String sql = "SELECT * FROM cliente WHERE nombre = ?";
        Cliente cliente = null;

        try {
            ConectarBase();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, nombre);
            resultado = preparedStatement.executeQuery();

            if (resultado.next()) {
                cliente = new Cliente(resultado.getString("id_cliente"), 
                        resultado.getString("nombre"), 
                        resultado.getString("cuit"), 
                        resultado.getString("email"), 
                        resultado.getString("direccion"), 
                        new Coordenada(resultado.getDouble("latitud"), resultado.getDouble("longitud")));
            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DAOException("No se pudo buscar el cliente: \n" + ex.getMessage());
        } finally {
            try {
                desconectarBase();
            } catch (Exception e) {
                throw new DAOException("Error al desconectar la base de datos: " + e.getMessage());
            }
        }
        return cliente;
    }

    @Override
    public List<Cliente> obtenerClientes() throws DAOException {
        String sql = "SELECT * FROM cliente";
        List<Cliente> listaClientes = new ArrayList<>();

        try {

            consultarBase(sql);

            while (resultado.next()) {
                String idCliente = resultado.getString("id_cliente");
                String nombre = resultado.getString("nombre");
                String cuit = resultado.getString("cuit");
                String email = resultado.getString("email");
                String direccion = resultado.getString("direccion");
                double longitud = resultado.getDouble("longitud");
                double latitud = resultado.getDouble("latitud");


                Coordenada coord = new Coordenada(latitud, longitud);
                Cliente cliente = new Cliente(idCliente, nombre, cuit, email, direccion, coord);


                listaClientes.add(cliente);
            }

        } catch (Exception ex) {
            throw new DAOException("No se pudo obtener los clientes: \n" + ex.getMessage());
        } finally {
            try {

                desconectarBase();
            } catch (Exception e) {
                throw new DAOException("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return listaClientes;
    }

}