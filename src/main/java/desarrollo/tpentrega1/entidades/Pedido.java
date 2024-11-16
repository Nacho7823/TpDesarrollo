
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
    private Pago pago;
    private double total;
    private EstadoPedido estado;
    private List<Observador> observadores = new ArrayList<>();

    public Pedido(){
        
    }
    

    
    public Pedido(String id,Cliente cliente, Vendedor vendedor, List<ItemMenu> items, Pago pago, EstadoPedido estado)throws InvalidOrderException {
        if (!validarItemsUnVendedor(items, vendedor)) {
            throw new InvalidOrderException("Los ítems deben pertenecer al mismo vendedor");
        }
        this.id = id;
        this.cliente=cliente;
        this.vendedor = vendedor;
        this.estado = estado;
        this.pago = pago;
        this.items=items;
    }
    
    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
    
    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
    
    public Vendedor getVendedor(){
        return this.vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }
    
    public EstadoPedido getEstado() {
        return estado;
    }
    
    public void setEstado(EstadoPedido nuevoEstado) {
        this.estado = nuevoEstado;
        notificarObservadores();
    }
    
    public Pago getPago(){
        return this.pago;
    }

    public void setPago(Pago pago) {
        this.pago = pago;
    }
    
    public List<ItemMenu> getItems(){
        return items;
    }

    public void setItems(List<ItemMenu> items) {
        this.items = items;
    }
    
    public void addItem(ItemMenu item){
        this.items.add(item);
    }
    
    public void removeItem(ItemMenu item){
        this.items.remove(item);
    }
    
    public void agregarObservador(Observador observador) {
        observadores.add(observador);
    }

    public void eliminarObservador(Observador observador) {
        observadores.remove(observador);
    }

    public Iterable<Observador> getObservadores() {
        return observadores;
    }
    
    private void notificarObservadores() {
        for (Observador observador : observadores) {
            observador.actualizar(this);
        }
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
        this.total = totalProductos + pago.aplicarRecargo(totalProductos);
        return this.total;
    }
    
    public double getTotal() {
        return this.calcularTotal();
    }
    
    public void generarPago(String alias) {
            this.pago= new MercadoPago(alias,this.calcularTotal()); 
    }
    
    public void generarPago(String cuit,String cvu) {
            this.pago= new Transferencia(cuit,cvu,this.calcularTotal()); 
    }
    

}
