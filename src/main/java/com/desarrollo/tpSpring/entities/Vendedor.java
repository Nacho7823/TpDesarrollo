/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.entities;


import lombok.*;
import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "vendedor")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    private List<ItemMenu> itemsMenu;
    
    public ArrayList<ItemMenu> getItemsMenu(){
        return (ArrayList)this.itemsMenu;
    }

    
    
    
    
    
}
