package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.ClienteDAO;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClienteDAOSql extends DAO implements ClienteDAO {

    private static ClienteDAOSql instance;

    public static ClienteDAOSql getInstance() {
        if (ClienteDAOSql.instance == null) {
            ClienteDAOSql.instance = new ClienteDAOSql();
        }
        return ClienteDAOSql.instance;
    }

    @Override
    public void crearCliente(Cliente cliente) throws DAOException {
        try {

            String sql = "INSERT INTO cliente (nombre, cuit, email, direccion, id_coordenada) VALUES (?, ?, ?, ?, ?)";
            int id = create(sql,
                    cliente.getNombre(),
                    cliente.getCuit(),
                    cliente.getEmail(),
                    cliente.getDireccion(),
                    cliente.getCoordenada().getId_coordenada());
            cliente.setId(id);
            
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }

    }

    @Override
    public void actualizarCliente(Cliente cliente) throws DAOException {
        try {

            String sql = "UPDATE cliente SET nombre = ?, cuit = ?, email = ?, direccion = ?, id_coordenada = ? WHERE id_cliente = ?";
            update(sql,
                cliente.getNombre(),
                cliente.getCuit(),
                cliente.getEmail(),
                cliente.getDireccion(),
                cliente.getCoordenada().getId_coordenada(),
                cliente.getId()
        );
        } catch(SQLException e) {
            throw new DAOException(e.getMessage());
        }

    }

    @Override
    public void eliminarCliente(int id) throws DAOException {
        try {
            
            String sql = "DELETE FROM cliente WHERE id_cliente = ?";
            delete(sql, id);
        
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public Cliente buscarCliente(int id) throws DAOException {
        try {
            String sql = "SELECT * FROM cliente WHERE id_cliente = ?";
        
            search(sql, id);

            if (!resultado.next()) {
                throw new DAOException("cliente not found");
            }
            
            Cliente cliente = new Cliente(id,
                        resultado.getString("nombre"),
                        resultado.getString("cuit"),
                        resultado.getString("email"),
                        resultado.getString("direccion"),
                        new Coordenada(resultado.getInt("id_coordenada"),0,0));
            
            closeSearch();
            
            return cliente;
        }
        catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public List<Cliente> obtenerClientes() throws DAOException {
        String sql = "SELECT * FROM cliente";
        List<Cliente> listaClientes = new ArrayList<>();

        try {

            search(sql);

            while (resultado.next()) {
                int idCliente = resultado.getInt("id_cliente");
                String nombre = resultado.getString("nombre");
                String cuit = resultado.getString("cuit");
                String email = resultado.getString("email");
                String direccion = resultado.getString("direccion");
                int idCoordenada = resultado.getInt("id_coordenada");

                Coordenada coord = new Coordenada(idCoordenada, 0, 0);
                Cliente cliente = new Cliente(idCliente, nombre, cuit, email, direccion, coord);

                listaClientes.add(cliente);
            }

        } catch (SQLException e) {
            throw new DAOException("No se pudo obtener los clientes: \n" + e.getMessage());
        }
        return listaClientes;
    }

}
