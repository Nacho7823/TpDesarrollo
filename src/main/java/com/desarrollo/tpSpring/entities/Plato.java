
package com.desarrollo.tpSpring.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "plato")
@PrimaryKeyJoinColumn(name = "id_item_menu")
public class Plato extends ItemMenu{
    @Basic
    @Column
    private double calorias;
    @Column
    private boolean apto_celiaco;
    @Column
    private boolean apto_vegano;
    @Column
    private double peso;

    public boolean isAptoCeliaco() {
        return apto_celiaco;
    }

    public boolean isAptoVegano() {
        return apto_vegano;
    }

    public double getPeso() {
        return peso;
    }
    
    
    
    private Plato(Builder builder) {
        super(builder);
        this.calorias = builder.calorias;
        this.apto_celiaco = builder.aptoCeliaco;
        this.apto_vegano = builder.aptoVegano;
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
        this.apto_celiaco = apto;
    }

    @Override
    public void setAptoVegano(boolean apto) {
        this.apto_vegano = apto;
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
        return apto_vegano;
    };
    
    @Override
    public boolean aptoCeliaco() { 
        return apto_celiaco;
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
            ", aptoCeliaco=" + apto_celiaco +
            ", aptoVegano=" + apto_vegano +
            ", peso=" + peso +
            ", nombre=" + getNombre() +
            ", descripcion=" + getDescripcion() +
            ", precio=" + getPrecio() +
            '}';
}
}
