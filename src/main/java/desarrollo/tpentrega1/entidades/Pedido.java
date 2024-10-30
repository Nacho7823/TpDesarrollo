
package desarrollo.tpentrega1.entidades;

import desarrollo.tpentrega1.interfaces.Observador;
import desarrollo.tpentrega1.interfaces.FormaDePago;
import desarrollo.tpentrega1.enums.EstadoPedido;
import desarrollo.tpentrega1.exceptions.InvalidOrderException;
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

    public Pedido(Cliente cliente,PedidoDetalle pedidoDetalle, FormaDePago formaDePago, Vendedor vendedor) throws InvalidOrderException {
        if (!validarItemsUnVendedor(pedidoDetalle, vendedor)) {
            throw new InvalidOrderException("Los ítems deben pertenecer al mismo vendedor");
        }
        this.cliente=cliente;
        this.agregarObservador(cliente);
        this.pedidoDetalle = pedidoDetalle;
        this.formaDePago = formaDePago;
        this.total = calcularTotal();
        this.estado = EstadoPedido.RECIBIDO;
        this.vendedor=vendedor;
        this.vendedor.addPedido(this);
    }

    private boolean validarItemsUnVendedor(PedidoDetalle pedidoDetalle, Vendedor vendedor) {
        List<ItemMenu> itemsVendedor = vendedor.getItemsMenu();

        for (ItemMenu item : pedidoDetalle.getItems()) 
            if(!itemsVendedor.contains(item)) 
                return false;
        return true;
    }

    private double calcularTotal() {
        double totalProductos = pedidoDetalle.getItems().stream().mapToDouble(ItemMenu::getPrecio).sum();
        return totalProductos + formaDePago.aplicarRecargo(totalProductos);
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

    public double getTotal() {
        return total;
    }

    public PedidoDetalle getPedidoDetalle() {
        return pedidoDetalle;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public Object getId() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
