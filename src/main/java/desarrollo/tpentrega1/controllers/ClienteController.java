
package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.Memory.ClienteMemory;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Coordenada;
import java.util.List;


public class ClienteController {
     private ClienteMemory clienteDAO = new ClienteMemory();

    public ClienteController(ClienteMemory c) {
        this.clienteDAO=c;
    }

    
    // Mostrar lista de todos los clientes
//    public void mostrarListaClientes() {
//        System.out.println("Lista de Clientes:");
//        clienteDAO.listarCliente();
//    }

    public void crearNuevoCliente(String id,String nombre, String cuit, String email, String direccion, Coordenada coordenada) {
        Cliente nuevoCliente = new Cliente(id, nombre, cuit, email, direccion, coordenada);
        clienteDAO.crearCliente(nuevoCliente);
    }

    // Modificar un cliente existente
    public void modificarCliente(String id, String nombre, String cuit, String email, String direccion, Coordenada coordenada) {
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
    }

    // Eliminar un cliente por ID
    public void eliminarCliente(Cliente id) {
        clienteDAO.eliminarCliente(id);
        
    }

    // Buscar un cliente por ID
    public Cliente buscarCliente(String id) {
        Cliente cliente = clienteDAO.buscarCliente(id);
        if (cliente != null) {
            System.out.println("Cliente encontrado: " + cliente.getNombre());
            return cliente;
        } else {
            System.out.println("Cliente no encontrado con ID: " + id);
            return null;
        }
    }

    public List<Cliente> obtenerListaClientes() {
        return clienteDAO.getClientes();
    }
}
