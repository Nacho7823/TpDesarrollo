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

            String sql = "INSERT INTO cliente (nombre, cuit, email, direccion, longitud, latitud) VALUES (?, ?, ?, ?, ?, ?)";
            int id = create(sql,
                    cliente.getNombre(),
                    cliente.getCuit(),
                    cliente.getEmail(),
                    cliente.getDireccion(),
                    cliente.getCoordenada().getLng(),
                    cliente.getCoordenada().getLat()
            );
            cliente.setId(id);

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public void actualizarCliente(Cliente cliente) throws DAOException {
        try {

            String sql = "UPDATE cliente SET nombre = ?, cuit = ?, email = ?, direccion = ?, longitud = ?, latitud = ? WHERE id_cliente = ?";
            update(sql,
                    cliente.getNombre(),
                    cliente.getCuit(),
                    cliente.getEmail(),
                    cliente.getDireccion(),
                    cliente.getCoordenada().getLng(),
                    cliente.getCoordenada().getLat(),
                    cliente.getId()
            );
        } catch (SQLException e) {
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
                    new Coordenada(resultado.getDouble("latitud"), resultado.getDouble("longitud")));

            closeSearch();

            return cliente;
        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public Cliente buscarClientePorNombre(String nombre) throws DAOException {
        try {
            String sql = "SELECT * FROM cliente WHERE nombre = ?";

            search(sql, nombre);

            if (!resultado.next()) {
                throw new DAOException("cliente not found");
            }

            Cliente cliente = new Cliente(
                    resultado.getInt("id_cliente"),
                    resultado.getString("nombre"),
                    resultado.getString("cuit"),
                    resultado.getString("email"),
                    resultado.getString("direccion"),
                    new Coordenada(resultado.getDouble("latitud"), resultado.getDouble("longitud")));

            closeSearch();

            return cliente;
        } catch (SQLException e) {
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
                double longitud = resultado.getDouble("longitud");
                double latitud = resultado.getDouble("latitud");

                Coordenada coord = new Coordenada(latitud, longitud);
                Cliente cliente = new Cliente(idCliente, nombre, cuit, email, direccion, coord);

                listaClientes.add(cliente);
            }

        } catch (SQLException e) {
            throw new DAOException("No se pudo obtener los clientes: \n" + e.getMessage());
        }
        return listaClientes;
    }

}
