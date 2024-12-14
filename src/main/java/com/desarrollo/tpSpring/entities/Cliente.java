
package com.desarrollo.tpSpring.entities;


import lombok.*;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_cliente")
    private int id_cliente;
    @Basic
    
    @Column(name = "nombre") 
    private String nombre;
    
    @Column
    private String cuit;
            
    @Column
    private String email;
            
    @Column
    private String direccion;
    
    @ManyToOne
    @JoinColumn(name = "id_coordenada", nullable = false)
    private Coordenada coordenada;

    
}
