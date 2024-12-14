
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
@Entity(name = "bebida")
@PrimaryKeyJoinColumn(name = "id_item_menu")
public class Bebida extends ItemMenu{
    
    @Column
    private double tamanio;
    @Column
    private double graduacion_alcoholica;
    
    private Bebida(Builder builder) {
        super(builder);
        this.graduacion_alcoholica = builder.graduacion_alcoholica;
        this.tamanio = builder.tamanio;
    }

    

    public static class Builder extends ItemMenu.Builder<Builder> {
        private double graduacion_alcoholica;
        private double tamanio;

        public Builder graduacionAlcoholica(double graduacion_alcoholica) { 
            this.graduacion_alcoholica = graduacion_alcoholica; 
            return this; 
        }

        public Builder tamaño(double tamaño) { 
            this.tamanio = tamaño; 
            return this; 
        }

        @Override
        protected Builder self() {
            return this;
        }

        @Override
        public Bebida build() {
            return new Bebida(this);
        }
    }
    
    @Override
    public double getCalorias() {
        return 0;
    }

    @Override
    public boolean aptoCeliaco() {
        return false;
    }

    @Override
    public void setCalorias(double calorias) {}

    @Override
    public void setAptoCeliaco(boolean apto) {}

    @Override
    public void setAptoVegano(boolean apto) {}

    @Override
    public void setPeso(double peso) {}

    @Override
    public double peso() {
        double p;
        if (graduacion_alcoholica == 0)
            p = (tamanio * 1.04 + ((tamanio * 20) / 100));
        else
            p = (tamanio * 0.99 + ((tamanio * 20) / 100));
        return p;
    };

    @Override
    public boolean aptoVegano() {
        return false;
    };

    @Override
    public boolean esBebida() {
        return true;
    };

    @Override
    public boolean esComida() {
        return false;
    };
    @Override
    public String toString() {
    return "Bebida{" +
            "tamaño=" + this.tamanio +
            ", graduacionAlcoholica=" + this.graduacion_alcoholica +
            ", nombre=" + this.getNombre() +
            ", descripcion=" + this.getDescripcion() +
            ", precio=" + this.getPrecio() +
            '}';
    }
    @Override
    public double getGraduacionAlcoholica() {
        return graduacion_alcoholica;
    }

    @Override
    public void setGraduacionAlcoholica(double graduacionAlcoholica) {
        this.graduacion_alcoholica = graduacionAlcoholica;
    }

    @Override
    public double getTamaño() {
        return tamanio;
    }

    @Override
    public void setTamaño(double tamaño) {
        this.tamanio = tamaño;
    }
}
