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
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
    @ManyToOne
    @Column
    private Cliente cliente;
    @ManyToOne
    @Column
    private Vendedor vendedor;
    @Column
    private List<ItemMenu> items;
    @OneToOne
    @Column
    private Pago pago;
    @Column
    private double total;
    @Column
    private EstadoPedido estado;
    @Column
    private List<Observador> observadores = new ArrayList<>();
    
    
    

    
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

     private boolean validarItemsUnVendedor(List<ItemMenu> items, Vendedor vendedor) {
        List<ItemMenu> itemsVendedor = vendedor.getItemsMenu();

        for (ItemMenu item : items) 
            if(!itemsVendedor.contains(item)) 
                return false;
        return true;
    }
    
 
}
