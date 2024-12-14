
package com.desarrollo.tpSpring.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Entity;


import jakarta.persistence.*;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity(name="detalle_pedido")
@AllArgsConstructor
@NoArgsConstructor
@IdClass(ItemsPedidoID.class)
public class ItemsPedido {

    @Id
    @ManyToOne
    @JoinColumn(name = "id_pedido", nullable = false)
    @JsonBackReference 
    private Pedido pedido;

    @Id
    @ManyToOne
    @JoinColumn(name = "id_item_menu", nullable = false)
    @JsonProperty("id_item_menu")
    private ItemMenu itemMenu;

    @Column(name="cantidad")
    private int cantidad;
    
    
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ItemsPedido that = (ItemsPedido) o;
        return pedido.getId_pedido() == that.getPedido().getId_pedido() && 
                itemMenu.getId_item_menu() == that.getItemMenu().getId_item_menu();
    }

    @Override
    public int hashCode() {
        return Objects.hash("" + pedido.getId_pedido() + itemMenu.getId_item_menu());
    }

}