/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.entities;

import com.desarrollo.tpSpring.exceptions.InvalidOrderException;
import com.desarrollo.tpSpring.enums.EstadoPedido;
import com.desarrollo.tpSpring.interfaces.Observador;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author florh
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String id;
    @Column
    private Cliente cliente;
    @Column
    private Vendedor vendedor;
    @Column
    private List<ItemMenu> items;
    @Column
    private Pago pago;
    @Column
    private double total;
    @Column
    private EstadoPedido estado;
    @Column
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
