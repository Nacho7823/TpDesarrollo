
package com.desarrollo.tpSpring.entities;

import jakarta.persistence.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="items_pedido")
@AllArgsConstructor
@NoArgsConstructor
public class ItemsPedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @Column(name="cantidad")
    private int cantidad;
    
    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    private Pedido pedido;

    @ManyToOne
    @JoinColumn(name = "id_item_menu", nullable = false)
    private ItemMenu itemMenu;

    
    public ItemMenu getItemMenu() {
        return itemMenu;
    }

}