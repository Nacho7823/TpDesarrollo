package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.dao.ClienteDAO;
import desarrollo.tpentrega1.dao.CoordenadaDAO;
import desarrollo.tpentrega1.dao.sql.ClienteDAOSql;
import desarrollo.tpentrega1.dao.sql.CoordenadaDAOSql;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ClienteController {

    private ClienteDAO clienteDAO = ClienteDAOSql.getInstance();
    private CoordenadaDAO coordenadaDAO = CoordenadaDAOSql.getInstance();

    
    private static ClienteController instance;
    
    public static ClienteController getInstance() {
        if (instance == null) 
            instance = new ClienteController();
        
        return instance;
    }
    private ClienteController() {
    }

    public void crearNuevoCliente(Cliente cliente) {
        try {
            coordenadaDAO.crearCoordenada(cliente.getCoordenada());
            clienteDAO.crearCliente(cliente);

        } catch (DAOException e) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e.getMessage());
        }
    }

    // Modificar un cliente existente
    public void modificarCliente(Cliente cliente) {
        try {
            coordenadaDAO.actualizarCoordenada(cliente.getCoordenada());
            clienteDAO.actualizarCliente(cliente);

        } catch (DAOException e) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e.getMessage());
        }
    }

    // Eliminar un cliente por ID
    public void eliminarCliente(Cliente cliente) {
        try {
            coordenadaDAO.eliminarCoordenada(cliente.getCoordenada().getId_coordenada());
            clienteDAO.eliminarCliente(cliente.getId());

        } catch (DAOException e) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e.getMessage());
        }

    }

    // Buscar un cliente por ID
    public Cliente buscarCliente(int id) {
        try {
            Cliente cliente = clienteDAO.buscarCliente(id);
            Coordenada coord = coordenadaDAO.buscarCoordenada(cliente.getCoordenada().getId_coordenada());
            cliente.setCoordenadas(coord);
            return cliente;

        } catch (DAOException e) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Cliente> obtenerListaClientes() {
        try {
            List<Cliente> list = clienteDAO.obtenerClientes();

            for (int i = 0; i < list.size(); i++) {

                Coordenada coord = coordenadaDAO.buscarCoordenada(list.get(i).getCoordenada().getId_coordenada());
                Cliente cliente = list.get(i);
                cliente.setCoordenadas(coord);
                System.out.println("cliente coor: " + list.get(i).getCoordenada().getId_coordenada());
                list.set(i, cliente);
            }

            return list;
        } catch (DAOException e) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e.getMessage());
        }
    }
}
