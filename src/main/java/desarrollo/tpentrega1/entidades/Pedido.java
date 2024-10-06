
package desarrollo.tpentrega1.entidades;

import java.util.List;

public class Pedido {


    private Cliente cliente;
    private PedidoDetalle pedidoDetalle;
    private FormaDePago formaDePago;
    private double total;
    private EstadoPedido estado;

    public Pedido(Cliente cliente,PedidoDetalle pedidoDetalle, FormaDePago formaDePago, Vendedor vendedor) throws InvalidOrderException {
        if (!validarItemsUnVendedor(pedidoDetalle, vendedor)) {
            throw new InvalidOrderException("Los ítems deben pertenecer al mismo vendedor");
        }
        this.cliente=cliente;
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
    
    public Cliente getCliente() {
        return cliente;
    }

}
