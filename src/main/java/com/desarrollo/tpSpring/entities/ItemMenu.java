
package com.desarrollo.tpSpring.entities;

import jakarta.persistence.*;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "item_menu")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class ItemMenu {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private int id_item_menu;
    @Basic   
    @Column
    private String nombre;
    @Column
    private String descripcion;
    @Column
    private double precio;
    @Column
    private String categoria; 
    
   @ManyToMany(mappedBy = "itemMenu")
    private Set<Vendedor> vendedores;
   @OneToMany(mappedBy = "itemMenu", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<ItemsPedido> itemsPedido;
    

    
    
    
    protected ItemMenu(Builder<?> builder) {
        this.id_item_menu = builder.id;
        this.nombre = builder.nombre;
        this.descripcion = builder.descripcion;
        this.precio = builder.precio;
        this.categoria = builder.categoria;
    }


    public static abstract class Builder<T extends Builder<T>> {
        private int id;
        private String nombre;
        private String descripcion;
        private double precio;
        private String categoria;

        public T id(int id) { this.id = id; return self(); }
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
