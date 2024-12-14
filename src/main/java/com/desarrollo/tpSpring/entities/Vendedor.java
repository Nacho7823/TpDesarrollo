package com.desarrollo.tpSpring.entities;

import lombok.*;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vendedor")
public class Vendedor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_vendedor")
    private int id_vendedor;

    @Basic
    @Column(name = "nombre")
    private String nombre;
    
    @Column
    private String direccion;
    
    @ManyToOne
    @JoinColumn(name = "id_coordenada", nullable = false)
    private Coordenada coordenada;

    @ManyToMany
    @JoinTable(
            name = "vende",
            joinColumns = @JoinColumn(name = "id_vendedor"),
            inverseJoinColumns = @JoinColumn(name = "id_item_menu")
    )
    private Set<ItemMenu> items;

    public HashSet<ItemMenu> getItems() {
        return new HashSet<>(this.items);
    }


}
