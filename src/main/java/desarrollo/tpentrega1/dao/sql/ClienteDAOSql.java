package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.ClienteDAO;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class ClienteDAOSql extends DAO<Cliente> implements ClienteDAO {

  

    

    @Override
   public void crearCliente(Cliente cliente) throws DAOException {
    String sql = "INSERT INTO cliente (id_cliente, nombre, cuit, email, direccion, longitud, latitud) VALUES (?, ?, ?, ?, ?, ?, ?)";
    
    try {
        insertarModificarEliminar(sql, cliente.getId(), cliente.getNombre(), cliente.getCuit(), cliente.getEmail(), cliente.getDireccion(), cliente.getCoordenada().getLng(), cliente.getCoordenada().getLat());
    } catch (Exception ex) {
        throw new DAOException("No se pudo crear el cliente: \n" + ex.getMessage());
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
            cliente.getId()     
        );

        } catch (Exception ex) {
            throw new DAOException("no se pudo actualizar el cliente: \n" + ex.getMessage());
   
        }
    }

    @Override
    public void eliminarCliente(Cliente cliente) throws DAOException {
        String sql = "DELETE FROM cliente WHERE id_cliente = ?";
    
        try {
        
        insertarModificarEliminar(sql, cliente.getId());  
        } catch (Exception ex) {
        throw new DAOException("No se pudo eliminar el cliente: \n" + ex.getMessage());
    }
    }

    @Override
    public Cliente buscarCliente(String id) throws DAOException {
    String sql = "SELECT id_cliente, nombre, cuit, email, direccion, longitud, latitud FROM cliente WHERE id_cliente = ?";
    Cliente cliente = null;

    try {
        ConectarBase();
        PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        preparedStatement.setString(1, id);  
        resultado = preparedStatement.executeQuery();

        
        if (resultado.next()) {
            cliente = new Cliente(
                    resultado.getString("id_cliente"), 
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
    String sql = "SELECT id_cliente, nombre, cuit, email, direccion, longitud, latitud FROM cliente";
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
