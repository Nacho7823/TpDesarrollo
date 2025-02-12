
package desarrollo.tpentrega1.entidades;

import desarrollo.tpentrega1.interfaces.Observador;
import desarrollo.tpentrega1.interfaces.FormaDePago;
import desarrollo.tpentrega1.enums.EstadoPedido;
import desarrollo.tpentrega1.exceptions.InvalidOrderException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Pedido {


    private Cliente cliente;
    private Vendedor vendedor;
    private int id;
    private Map<ItemMenu, Integer> items;   //TODO: cantidad?
    private Pago pago;
    private double total;
    private EstadoPedido estado;
    private List<Observador> observadores = new ArrayList<>();

    
    public Pedido(){
        items = new HashMap<>();
    }
    

    
    public Pedido(int id,Cliente cliente, Vendedor vendedor, Map<ItemMenu, Integer> items, Pago pago, EstadoPedido estado)throws InvalidOrderException {
//        if (!validarItemsUnVendedor(items, vendedor)) {
//            throw new InvalidOrderException("Los ítems deben pertenecer al mismo vendedor");
//        }
        this.id = id;
        this.cliente=cliente;
        this.vendedor = vendedor;
        this.estado = estado;
        this.pago = pago;
        this.items=items;
    }
    
    public Pedido(Cliente cliente, Vendedor vendedor, Map<ItemMenu, Integer> items, Pago pago, EstadoPedido estado)throws InvalidOrderException {
//        if (!validarItemsUnVendedor(items, vendedor)) {
//            throw new InvalidOrderException("Los ítems deben pertenecer al mismo vendedor");
//        }
        this.cliente=cliente;
        this.vendedor = vendedor;
        this.estado = estado;
        this.pago = pago;
        this.items = items;
    }
    
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    
    public Map<ItemMenu, Integer> getItems(){
        return items;
    }

    public void setItems(Map<ItemMenu, Integer> items) {
        this.items = items;
    }
    
    public void addItem(ItemMenu item){
        if (items.containsKey(item)){
            int v = items.get(item);
            v++;
            items.put(item, v);
        }
        else {
            items.put(item, 1);
        }
    }
    
    public void removeItem(ItemMenu item){
        if (items.containsKey(item)){
            int v = items.get(item);
            v--;
            if (v == 0) {
                items.remove(item);
            }
            else {
                items.put(item, v);
            }
        }
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
        double totalProductos = 0;
        for (ItemMenu it : items.keySet()){
            totalProductos += it.getPrecio() * items.get(it);
        }
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
