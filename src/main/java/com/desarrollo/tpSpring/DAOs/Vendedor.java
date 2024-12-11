/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.DAOs;


import lombok.*;
import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vendedor")
public class Vendedor {
    @Id
    @Column
    private int id_vendedor;
    
    @Column
    private String nombre;
    
    @Column
    private String direccion;
            
    @Column
    private double longitud;
            
    @Column
    private double latitud;
}
