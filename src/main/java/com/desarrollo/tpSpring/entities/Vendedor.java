
package com.desarrollo.tpSpring.entities;


import lombok.*;
import jakarta.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vendedor")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id_vendedor;
    
    @Basic
    @Column
    private String nombre;
    @Column
    private String direccion;
    @Column
    @ManyToOne
    private Coordenada coordenada;

  @ManyToMany
    @JoinTable(
        name = "vende",
        joinColumns = @JoinColumn(name = "vendedor_id"),
        inverseJoinColumns = @JoinColumn(name = "item_menu_id")
    )
    private Set<ItemMenu> items;
    
  public HashSet<ItemMenu> getItems(){
      return new HashSet<>(this.items);
  }
}
