/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.Memory.ClienteMemory;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Coordenada;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author florh
 */
public class ClienteController {
     private ClienteMemory clienteDAO = new ClienteMemory();

    public ClienteController(ClienteMemory c) {
        this.clienteDAO=c;
    }

    
    // Mostrar lista de todos los clientes
    public void mostrarListaClientes() {
        System.out.println("Lista de Clientes:");
        clienteDAO.listarCliente(null); // null ya que listarCliente no necesita parámetro
    }

    // Crear un nuevo cliente con generación automática de ID
    public void crearNuevoCliente(String nombre, String cuit, String email, String direccion, Coordenada coordenada) {
        String id = UUID.randomUUID().toString(); // Generación automática de ID
        Cliente nuevoCliente = new Cliente(id, nombre, cuit, email, direccion, coordenada);
        clienteDAO.crearCliente(nuevoCliente);
    }

    // Modificar un cliente existente
    public void modificarCliente(String id, String nombre, String cuit, String email, String direccion, Coordenada coordenada) {
        Cliente clienteExistente = clienteDAO.buscarCliente(Integer.parseInt(id));
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
    public void eliminarCliente(int id) {
        clienteDAO.eliminarCliente(id);
        
    }

    // Buscar un cliente por ID
    public Cliente buscarCliente(int id) {
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
