
package com.desarrollo.tpSpring.entities;

import jakarta.persistence.Entity;


import jakarta.persistence.*;

@Entity(name="items_pedido")
public class ItemsPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private int cantidad;
    
    @ManyToOne
    @JoinColumn(name = "pedido_id", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "item_menu_id", nullable = false)
    private ItemMenu itemMenu;

    
    public ItemMenu getItemMenu() {
        return itemMenu;
    }

}