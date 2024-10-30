/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.Memory.PedidoMemory;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Pedido;
import desarrollo.tpentrega1.entidades.PedidoDetalle;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.enums.EstadoPedido;
import desarrollo.tpentrega1.exceptions.InvalidOrderException;
import desarrollo.tpentrega1.interfaces.FormaDePago;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author florh
 */
public class PedidoController {
    private PedidoMemory pedidoDAO = new PedidoMemory();

    public PedidoController(PedidoMemory pedidoDAO) {
        this.pedidoDAO = pedidoDAO;
    }

    // Mostrar lista de todos los pedidos
    public void mostrarListaPedidos() {
        System.out.println("Lista de Pedidos:");
        pedidoDAO.listarPedido(null);
    }

    // Crear un nuevo pedido con generación automática de ID
    public void crearNuevoPedido(Cliente cliente, PedidoDetalle pedidoDetalle, FormaDePago formaDePago, Vendedor vendedor) {
        try {
            String id = UUID.randomUUID().toString(); // Generación automática de ID
            Pedido nuevoPedido = new Pedido(cliente, pedidoDetalle, formaDePago, vendedor);
            pedidoDAO.crearPedido(nuevoPedido);
            
        } catch (InvalidOrderException e) {
            System.out.println("Error al crear el pedido: " + e.getMessage());
        }
    }

    // Modificar un pedido existente (cambia su estado)
    public void modificarPedidoEstado(String id, EstadoPedido nuevoEstado) {
        Pedido pedidoExistente = pedidoDAO.buscarPedido(Integer.parseInt(id));
        if (pedidoExistente != null) {
            pedidoExistente.setEstado(nuevoEstado);
            pedidoDAO.actualizarPedido(pedidoExistente);
            System.out.println("Estado del pedido modificado a: " + nuevoEstado);
        } else {
            System.out.println("Pedido no encontrado para modificar.");
        }
    }

    // Eliminar un pedido por ID
    public void eliminarPedido(int id) {
        pedidoDAO.eliminarPedido(id);
        
    }

    // Buscar un pedido por ID
    public void buscarPedido(int id) {
        Pedido pedido = pedidoDAO.buscarPedido(id);
        if (pedido != null) {
            System.out.println("Pedido encontrado con ID: " + pedido.getId());
        } else {
            System.out.println("Pedido no encontrado con ID: " + id);
        }
    }

    public List<Pedido> obtenerListaPedidos() {
        return pedidoDAO.getPedidos();
    }
}
