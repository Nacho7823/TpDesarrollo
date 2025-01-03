package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.ItemsMenuDAO;
import desarrollo.tpentrega1.dao.VendedorDAO;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendedorDAOSql extends DAO<Vendedor> implements VendedorDAO {
    private ItemsMenuDAO itemsMenuDAO = ItemMenuDAOSql.getInstance();
    private static VendedorDAOSql instance;
    
    public static VendedorDAOSql getInstance() {
        if (VendedorDAOSql.instance == null) {
            VendedorDAOSql.instance = new VendedorDAOSql();
        }
        return VendedorDAOSql.instance;
    }
    
    @Override
    public void crearVendedor(Vendedor vendedor) throws DAOException {
        String sql = "INSERT INTO vendedor (nombre, direccion, longitud, latitud) VALUES (?, ?, ?, ?)";
        try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ConectarBase();
            stmt.setString(1, vendedor.getNombre());
            stmt.setString(2, vendedor.getDireccion());
            stmt.setDouble(3, vendedor.getCoordenada().getLng());
            stmt.setDouble(4, vendedor.getCoordenada().getLat());
        
            stmt.executeUpdate();
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idVendedor = generatedKeys.getInt(1);
                    vendedor.setId(String.valueOf(idVendedor));
                }
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DAOException("No se pudo crear el vendedor: \n" + ex.getMessage());
        } finally {
            try {
                desconectarBase(); 
            } catch (Exception e) {
                throw new DAOException("Error al desconectar la base de datos: " + e.getMessage());
            }
        }
    }

    @Override
    public void actualizarVendedor(Vendedor vendedor) throws DAOException {
        String sql = "UPDATE vendedor SET nombre = ?, direccion = ?, longitud = ?, latitud = ? WHERE id_vendedor = ?";
        try {
            ConectarBase();
            insertarModificarEliminar(sql,
                    vendedor.getNombre(),
                    vendedor.getDireccion(),
                    vendedor.getCoordenada().getLng(),
                    vendedor.getCoordenada().getLat(),
                    Integer.valueOf(vendedor.getId())
            );
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DAOException("No se pudo actualizar el vendedor: \n" + ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(VendedorDAOSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                desconectarBase();
            } catch (Exception e) {
                throw new DAOException("Error al desconectar la base de datos: " + e.getMessage());
            }
        }
    }

    @Override
    public void eliminarVendedor(Vendedor vendedor) throws DAOException {
        String sql = "DELETE FROM vendedor WHERE id_vendedor = ?";
        try {
            ConectarBase();
            insertarModificarEliminar(sql, Integer.valueOf(vendedor.getId()));
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DAOException("No se pudo eliminar el vendedor: \n" + ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(VendedorDAOSql.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                desconectarBase(); 
            } catch (Exception e) {
                throw new DAOException("Error al desconectar la base de datos: " + e.getMessage());
            }
        }
    }

@Override
public Vendedor buscarVendedor(String id) throws DAOException {
    String sql = "SELECT nombre, direccion, longitud, latitud FROM vendedor WHERE id_vendedor = ?";
    Vendedor vendedor = null;

    try {
        ConectarBase();
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setInt(1, Integer.parseInt(id));
            resultado = preparedStatement.executeQuery();
            
            if (resultado.next()) {
                vendedor = new Vendedor(
                        id,
                        resultado.getString("nombre"),
                        resultado.getString("direccion"),
                        new Coordenada(resultado.getDouble("latitud"), resultado.getDouble("longitud")),
                        itemsMenuDAO.obtenerItemsMenuDeVendedor(id)
                );
                //System.out.println("Vendedor encontrado: " + vendedor.getNombre());
            } else {
                System.out.println("No se encontró un vendedor con el ID " + id);
            }
        }
    } catch (SQLException | ClassNotFoundException ex) {
        throw new DAOException("No se pudo buscar el vendedor: \n" + ex.getMessage());
    } finally {
        try {
            desconectarBase();  // Asegúrate de cerrar la conexión después de la consulta
        } catch (Exception e) {
            throw new DAOException("Error al desconectar la base de datos: " + e.getMessage());
        }
    }

    return vendedor;
}

@Override
public Vendedor buscarVendedorPorNombre(String nombre) throws DAOException {
    String sql = "SELECT id_vendedor, nombre, direccion, longitud, latitud FROM vendedor WHERE nombre = ?";
    Vendedor vendedor = null;

    try {
        ConectarBase();
        try (PreparedStatement preparedStatement = conexion.prepareStatement(sql)) {
            preparedStatement.setString(1, nombre);
            resultado = preparedStatement.executeQuery();
            
            if (resultado.next()) {
                vendedor = new Vendedor(
                        String.valueOf(resultado.getInt("id_vendedor")),
                        resultado.getString("nombre"),
                        resultado.getString("direccion"),
                        new Coordenada(resultado.getDouble("latitud"), resultado.getDouble("longitud")),
                        itemsMenuDAO.obtenerItemsMenuDeVendedor(String.valueOf(resultado.getInt("id_vendedor")))
                );
                //System.out.println("Vendedor encontrado: " + vendedor.getNombre());
            } else {
                System.out.println("No se encontró un vendedor con el nombre " + nombre);
            }
        }
    } catch (SQLException | ClassNotFoundException ex) {
        throw new DAOException("No se pudo buscar el vendedor: \n" + ex.getMessage());
    } finally {
        try {
            desconectarBase();  // Asegúrate de cerrar la conexión después de la consulta
        } catch (Exception e) {
            throw new DAOException("Error al desconectar la base de datos: " + e.getMessage());
        }
    }

    return vendedor;
}

    @Override
    public List<Vendedor> obtenerVendedores() throws DAOException {
        String sql = "SELECT * FROM vendedor";
        List<Vendedor> listaVendedores = new ArrayList<>();
        
        try {
            ConectarBase();
            consultarBase(sql);

            while (resultado.next()) {
                String id = String.valueOf(resultado.getInt("id_vendedor"));
                String nombre = resultado.getString("nombre");
                String direccion = resultado.getString("direccion");
                double longitud = resultado.getDouble("longitud");
                double latitud = resultado.getDouble("latitud");

                Coordenada coord = new Coordenada(latitud, longitud);
                Vendedor vendedor = new Vendedor(id, nombre, direccion, coord);

                listaVendedores.add(vendedor);
            }
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DAOException("No se pudo obtener los vendedores: \n" + ex.getMessage());
        } catch (Exception ex) {
            Logger.getLogger(VendedorDAOSql.class.getName()).log(Level.SEVERE, null, ex);
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
