/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author florh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "itemmenu")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ItemMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column
    private String id;
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private double precio;
    @Column
    private String categoria; 
    

    
    
    
    protected ItemMenu(Builder<?> builder) {
        this.id = builder.id;
        this.nombre = builder.nombre;
        this.descripcion = builder.descripcion;
        this.precio = builder.precio;
        this.categoria = builder.categoria;
    }


    public static abstract class Builder<T extends Builder<T>> {
        private String id;
        private String nombre;
        private String descripcion;
        private double precio;
        private String categoria;

        public T id(String id) { this.id = id; return self(); }
        public T nombre(String nombre) { this.nombre = nombre; return self(); }
        public T descripcion(String descripcion) { this.descripcion = descripcion; return self(); }
        public T precio(double precio) { this.precio = precio; return self(); }
        public T categoria(String categoria) { this.categoria = categoria; return self(); }

        protected abstract T self();

        public abstract ItemMenu build();
    }
    public abstract boolean esComida();
    public abstract boolean esBebida();
    public abstract boolean aptoVegano();
    public abstract double peso();
    public abstract double getCalorias();
    public abstract boolean aptoCeliaco();
    public  abstract void setCalorias(double calorias);
    public abstract void setAptoCeliaco(boolean apto) ;
    public abstract void setAptoVegano(boolean apto) ;
    public abstract void setPeso(double peso) ;
    public abstract double getGraduacionAlcoholica();
    public abstract void setGraduacionAlcoholica(double graduacionAlcoholica);
    public abstract double getTamaño();
    public abstract void setTamaño(double tamaño);
 
}
