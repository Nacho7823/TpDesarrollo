
package desarrollo.tpentrega1.entidades;

import java.util.ArrayList;
import java.util.List;

public class Pedido {


    private Cliente cliente;
    private Vendedor vendedor;
    private String id;
    private PedidoDetalle pedidoDetalle;
    private FormaDePago formaDePago;
    private double total;
    private EstadoPedido estado;
    private List<Observador> observadores = new ArrayList<>();
    
    public Pedido(String id, EstadoPedido estadoInicial,Cliente cliente, Vendedor vendedor) {
        this.id = id;
        this.estado = estadoInicial;
        this.total=0;
        this.cliente=cliente;
        this.vendedor=vendedor;
        this.vendedor.addPedido(this);
    }

    
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    public void setEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
        notificarObservadores();
    }

    public EstadoPedido getEstado() {
        return estado;
    }

    private void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar(this);
        }
    }
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
