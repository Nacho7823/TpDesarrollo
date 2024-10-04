/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1.entidades;

import java.util.List;

/**
 *
 * @author Flor Hiembuchner
 */
public class Pedido {
    private PedidoDetalle pedidoDetalle;
    private FormaDePago formaDePago;
    private double total;
    private EstadoPedido estado;

    public Pedido(PedidoDetalle pedidoDetalle, FormaDePago formaDePago, Vendedor vendedor) throws InvalidOrderException {
        if (!validarItemsUnVendedor(pedidoDetalle, vendedor)) {
            throw new InvalidOrderException("Los ítems deben pertenecer al mismo vendedor");
        }
        this.pedidoDetalle = pedidoDetalle;
        this.formaDePago = formaDePago;
        this.total = calcularTotal();
        this.estado = EstadoPedido.RECIBIDO;
    }

    private boolean validarItemsUnVendedor(PedidoDetalle pedidoDetalle, Vendedor vendedor) {
        List<ItemMenu> itemsVendedor = vendedor.getItemMenu();

        for (ItemMenu item : pedidoDetalle.getItems()) 
            if(!itemsVendedor.contains(item)) 
                return false;
        return true;
    }

    private double calcularTotal() {
        double totalProductos = pedidoDetalle.getItems().stream().mapToDouble(ItemMenu::getPrecio).sum();
        return totalProductos + formaDePago.aplicarRecargo(totalProductos);
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    public double getTotal() {
        return total;
    }

    public PedidoDetalle getPedidoDetalle() {
        return pedidoDetalle;
    }

}
