package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.VendedorDAO;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


public class VendedorDAOSql extends DAO<Vendedor> implements VendedorDAO {


    @Override
    public void crearVendedor(Vendedor vendedor) throws DAOException {
        
        String sql = "INSERT INTO vendedor (id_vendedor, nombre, direccion, longitud, latitud) VALUES (?, ?, ?, ?, ?)";
        try {
            
            insertarModificarEliminar(sql, vendedor.getId(), vendedor.getNombre(),vendedor.getDireccion(), vendedor.getCoordenada().getLng(), vendedor.getCoordenada().getLat());
        } catch (Exception ex) {
            throw new DAOException("no se pudo crear el vendedor: \n" + ex.getMessage());
        }

    }

    @Override
    public void actualizarVendedor(Vendedor vendedor) throws DAOException {
        
        String sql = "UPDATE vendedor SET nombre = ?, direccion = ?, longitud = ?, latitud = ? WHERE id_vendedor = ?";
        
        try {
        
            insertarModificarEliminar(sql, 
            vendedor.getNombre(),       
            vendedor.getDireccion(),    
            vendedor.getCoordenada().getLng(),    
            vendedor.getCoordenada().getLat(),      
            vendedor.getId()     
        );
            
        } catch (Exception ex) {
            throw new DAOException("no se pudo actualizar el vendedor: \n" + ex.getMessage());
        }
    }

    @Override
    public void eliminarVendedor(Vendedor vendedor) throws DAOException {
     
        String sql = "DELETE FROM vendedor WHERE id_vendedor = ?";
        
        try {
        
        insertarModificarEliminar(sql, vendedor.getId()); 

        }catch (Exception ex) {
            throw new DAOException("no se pudo actualizar el vendedor: \n" + ex.getMessage());
        }
    }

    @Override
    public Vendedor buscarVendedor(String id) throws DAOException {
        
        String sql = "SELECT nombre, direccion, longitud, latitud FROM vendedor WHERE id_vendedor = ?";
        
        Vendedor vendedor= null;
        
        try{
        ConectarBase();
        PreparedStatement preparedStatement = conexion.prepareStatement(sql);
        preparedStatement.setString(1, id);  
        resultado = preparedStatement.executeQuery();

        
        if (resultado.next()) {
      
            vendedor.setId(resultado.getString("id_cliente"));
            vendedor.setNombre(resultado.getString("nombre"));
            vendedor.setDireccion(resultado.getString("direccion"));
            vendedor.setCoordenada(new Coordenada(resultado.getDouble("latitud"), resultado.getDouble("longitud")));
            
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

    return vendedor;
            
            
    }
    
    @Override
    public List<Vendedor> obtenerVendedores() throws DAOException {
       
            
        String sql = "SELECT id_vendedor, nombre, direccion, longitud, latitud FROM vendedor";
        List<Vendedor> listaVendedores = new ArrayList<>();

        try {
        
        consultarBase(sql);

       
        while (resultado.next()) {
            String id = resultado.getString("id_cliente");
            String nombre = resultado.getString("nombre");
            String direccion = resultado.getString("direccion");
            double longitud = resultado.getDouble("longitud");
            double latitud = resultado.getDouble("latitud");

            
            Coordenada coord = new Coordenada(latitud, longitud);
            Vendedor vendedor= new Vendedor(id, nombre, direccion, coord);

            
            listaVendedores.add(vendedor);
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

    return listaVendedores;
    }

}
