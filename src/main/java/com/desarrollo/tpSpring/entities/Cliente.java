/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.entities;


import lombok.*;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "cliente")
public class Cliente {
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id_cliente;
    
    @Column
    private String nombre;
    
    @Column
    private String cuit;
            
    @Column
    private String email;
            
    @Column
    private String direccion;
            
    @Column
    private double longitud;
            
    @Column
    private double latitud;
}
