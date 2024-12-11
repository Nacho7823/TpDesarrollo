/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author florh
 */
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "plato")
public class Plato extends ItemMenu{
    @Column
    private double calorias;
    @Column
    private boolean aptoCeliaco;
    @Column
    private boolean aptoVegano;
    @Column
    private double peso;

    public boolean isAptoCeliaco() {
        return aptoCeliaco;
    }

    public boolean isAptoVegano() {
        return aptoVegano;
    }

    public double getPeso() {
        return peso;
    }
    
    
    
    private Plato(Builder builder) {
        super(builder);
        this.calorias = builder.calorias;
        this.aptoCeliaco = builder.aptoCeliaco;
        this.aptoVegano = builder.aptoVegano;
        this.peso = builder.peso;
    }

    @Override
    public double getGraduacionAlcoholica() {
        return 0;
    }

    @Override
    public void setGraduacionAlcoholica(double graduacionAlcoholica) {}

    @Override
    public double getTamaño() {
    return 0;    
    }

    @Override
    public void setTamaño(double tamaño) {}

    public static class Builder extends ItemMenu.Builder<Builder> {
        private double calorias;
        private boolean aptoCeliaco;
        private boolean aptoVegano;
        private double peso;

        public Builder calorias(double calorias) { this.calorias = calorias; return this; }
        public Builder aptoCeliaco(boolean aptoCeliaco) { this.aptoCeliaco = aptoCeliaco; return this; }
        public Builder aptoVegano(boolean aptoVegano) { this.aptoVegano = aptoVegano; return this; }
        public Builder peso(double peso) { this.peso = peso; return this; }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Plato build() {
            return new Plato(this);
        }
    }


    // getters / setters

    @Override
    public double getCalorias() {
        return calorias;
    }

    @Override
    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    @Override
    public void setAptoCeliaco(boolean apto) {
        this.aptoCeliaco = apto;
    }

    @Override
    public void setAptoVegano(boolean apto) {
        this.aptoVegano = apto;
    }

    @Override
    public void setPeso(double peso) {
        this.peso = peso;
    }

    // funcs

    @Override
    public double peso() {
        return (peso + ((peso * 10) / 100));
    };

    @Override
    public boolean aptoVegano() { // consultar método
        return aptoVegano;
    };
    
    @Override
    public boolean aptoCeliaco() { 
        return aptoCeliaco;
    };

    @Override
    public boolean esBebida() {
        return false;
    };

    @Override
    public boolean esComida() {
        return true;
    };

    @Override
    public String toString() {
    return "Plato{" +
            "calorias=" + calorias +
            ", aptoCeliaco=" + aptoCeliaco +
            ", aptoVegano=" + aptoVegano +
            ", peso=" + peso +
            ", nombre=" + getNombre() +
            ", descripcion=" + getDescripcion() +
            ", precio=" + getPrecio() +
            '}';
}
}
