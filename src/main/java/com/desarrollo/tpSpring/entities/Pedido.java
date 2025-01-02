
package com.desarrollo.tpSpring.entities;

import com.desarrollo.tpSpring.exceptions.InvalidOrderException;
import com.desarrollo.tpSpring.enums.EstadoPedido;
import com.desarrollo.tpSpring.interfaces.Observador;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="pedido")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_pedido;
    
    @ManyToOne
    @JoinColumn(name = "id_cliente", referencedColumnName = "id_cliente")
    @JsonProperty("id_cliente")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "id_vendedor")
    @JsonProperty("id_vendedor")
    private Vendedor vendedor;

    @OneToOne
    @JoinColumn(name = "id_pago", referencedColumnName = "id_pago")
    private Pago pago;
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval=true)
    @JsonManagedReference   
    private Set<ItemsPedido> items;
    //@Column
    private double total;
    //@Column
    @Enumerated(EnumType.ORDINAL)
    private EstadoPedido estado;
//    @Column
    @Transient
    private List<Observador> observadores = new ArrayList<>();
    
    
    

    
    public Pedido(int id, Cliente cliente, Vendedor vendedor, Set<ItemsPedido> items, Pago pago, EstadoPedido estado)throws InvalidOrderException {
//        if (!validarItemsUnVendedor(items, vendedor)) {
//            throw new InvalidOrderException("Los ítems deben pertenecer al mismo vendedor");
//        }
        this.id_pedido = id;
        this.cliente=cliente;
        this.vendedor = vendedor;
        this.estado = estado;
        this.pago = pago;
        this.items=new HashSet(items);
    }

//     private boolean validarItemsUnVendedor(Set<ItemsPedido> items, Vendedor vendedor) {
     private boolean validarItemsUnVendedor(Set<ItemsPedido> items, List<ItemMenu> itemsVendedor) {

        for (ItemsPedido item : items) 
            if(!itemsVendedor.contains(item.getItemMenu())) 
                return false;
        return true;
    }
    
     
     @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pedido pedido = (Pedido) o;
        return id_pedido == pedido.id_pedido;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id_pedido);
    }
 
    public double calcularTotal() {
        double totalProductos = items.stream().mapToDouble(item ->item.getItemMenu().getPrecio()).sum();
        this.total = totalProductos + pago.aplicarRecargo(totalProductos);
        return this.total;
    }
}
