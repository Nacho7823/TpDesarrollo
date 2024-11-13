
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
    private List<ItemMenu> items;
    private FormaDePago formaDePago;
    private double total;
    private EstadoPedido estado;
    private List<Observador> observadores = new ArrayList<>();
    

    
    public Pedido(String id,Cliente cliente, Vendedor vendedor, List<ItemMenu> items, FormaDePago formaDePago, EstadoPedido estado)throws InvalidOrderException {
        if (!validarItemsUnVendedor(items, vendedor)) {
            throw new InvalidOrderException("Los ítems deben pertenecer al mismo vendedor");
        }
        this.id = id;
        this.cliente=cliente;
        this.vendedor = vendedor;
        this.vendedor.addPedido(this);
        this.estado = estado;
        this.formaDePago = formaDePago;
        this.items=items;
    }
    private boolean validarItemsUnVendedor(List<ItemMenu> items, Vendedor vendedor) {
        List<ItemMenu> itemsVendedor = vendedor.getItemsMenu();

        for (ItemMenu item : items) 
            if(!itemsVendedor.contains(item)) 
                return false;
        return true;
    }

    private double calcularTotal() {
        double totalProductos = items.stream().mapToDouble(ItemMenu::getPrecio).sum();
        this.total = totalProductos + formaDePago.aplicarRecargo(totalProductos);
        return this.total;
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
        return this.calcularTotal();
    }
    
    public Vendedor getVendedor(){
        return this.vendedor;
    }
    
    public FormaDePago getFormaDePago(){
        return this.formaDePago;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemMenu> getItems(){
        return items;
    }
    
    public void addItem(ItemMenu item){
        this.items.add(item);
    }
    
    public Object getId() {
        return this.id;
    }
    
    public void removeItem(ItemMenu item){
        this.items.remove(item);
    }

    public Iterable<Observador> getObservadores() {
        return observadores;
    }

}
