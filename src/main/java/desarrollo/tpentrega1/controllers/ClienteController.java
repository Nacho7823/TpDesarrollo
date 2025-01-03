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
    
    public ClienteController() {
    }
    
    public Cliente crearNuevoCliente(String id, String nombre, String cuit, String email, String direccion, Coordenada coordenada) {
        Cliente nuevoCliente = new Cliente(id, nombre, cuit, email, direccion, coordenada);
        try {
            clienteDAO.crearCliente(nuevoCliente);
        } catch (DAOException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevoCliente;
    }
    
    public Cliente crearNuevoCliente(String nombre, String cuit, String email, String direccion, Coordenada coordenada) {
        Cliente nuevoCliente = new Cliente(nombre, cuit, email, direccion, coordenada);
        try {
            clienteDAO.crearCliente(nuevoCliente);
        } catch (DAOException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevoCliente;
    }

    // Modificar un cliente existente
    public void modificarCliente(String id, String nombre, String cuit, String email, String direccion, Coordenada coordenada) {
        try {
            Cliente clienteExistente = clienteDAO.buscarCliente(id);

            if (clienteExistente != null) {
                clienteExistente.setNombre(nombre);
                clienteExistente.setCuit(cuit);
                clienteExistente.setEmail(email);
                clienteExistente.setDireccion(direccion);
                clienteExistente.setCoordenadas(coordenada);
                clienteDAO.actualizarCliente(clienteExistente);
                System.out.println("Cliente modificado: " + nombre);
            } else {
                System.out.println("Cliente no encontrado para modificar.");
            }
        } catch (DAOException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Eliminar un cliente por ID
    public void eliminarCliente(Cliente id) {
        try {
            clienteDAO.eliminarCliente(id.getId());
        } catch (DAOException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    // Buscar un cliente por ID
    public Cliente buscarCliente(String id) {
        try {
        Cliente cliente = clienteDAO.buscarCliente(id);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente.getNombre());
            return cliente;
        } else {
            System.out.println("Cliente no encontrado con ID: " + id);
            return null;
        }
        } catch (DAOException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    public Cliente buscarClientePorNombre(String nombre) {
        try {
            Cliente cliente = clienteDAO.buscarCliente(nombre);
            if (cliente != null) {
                System.out.println("Cliente encontrado: " + cliente.getNombre());
                return cliente;
            } else {
                System.out.println("Cliente no encontrado con nombre: " + nombre);
                return null;
            }
        } catch (DAOException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    public List<Cliente> obtenerListaClientes() {
        try {
            return clienteDAO.obtenerClientes();
        } catch (DAOException ex) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return new ArrayList<Cliente>();
    }
}
