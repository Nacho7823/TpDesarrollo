package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.dao.sql.ClienteDAOSql;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteController {
    private ClienteDAOSql clienteDAO=ClienteDAOSql.getInstance();
    
    private static ClienteController instance;
    
    public static ClienteController getInstance() {
        if (instance == null) {
            instance = new ClienteController();
        }
        return instance;
    }
    
    private ClienteController() {
    }
    
    public void crearNuevoCliente(Cliente cliente) throws Exception {
        clienteDAO.crearCliente(cliente);
    }
    
    public void modificarCliente(Cliente cliente) throws Exception {
        clienteDAO.actualizarCliente(cliente);
    }

    public void eliminarCliente(int id) throws Exception {
        clienteDAO.eliminarCliente(id);
    }

    // Buscar un cliente por ID
    public Cliente buscarCliente(int id) throws Exception {
        return clienteDAO.buscarCliente(id);
    }
    
    public Cliente buscarClientePorNombre(String nombre) throws Exception {
        return clienteDAO.buscarClientePorNombre(nombre);
    }

    public List<Cliente> obtenerListaClientes() throws Exception {
        return clienteDAO.obtenerClientes();
    }
}
