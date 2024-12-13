
package com.desarrollo.tpSpring.entities;

import com.desarrollo.tpSpring.exceptions.InvalidOrderException;
import com.desarrollo.tpSpring.enums.EstadoPedido;
import com.desarrollo.tpSpring.interfaces.Observador;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Transient;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
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
    @Column
    private int id_pedido;
    
//    @Column
    @ManyToOne
    private Cliente cliente;
//    @Column
    @ManyToOne
    private Vendedor vendedor;
//    @Column
    @OneToOne
    private Pago pago;
    
    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval=true)
    private Set<ItemsPedido> items;
    @Column
    private double total;
    @Column
    private EstadoPedido estado;
//    @Column
    @Transient
    private List<Observador> observadores = new ArrayList<>();
    
    
    

    
    public Pedido(int id,Cliente cliente, Vendedor vendedor, Set<ItemsPedido> items, Pago pago, EstadoPedido estado)throws InvalidOrderException {
        if (!validarItemsUnVendedor(items, vendedor)) {
            throw new InvalidOrderException("Los ítems deben pertenecer al mismo vendedor");
        }
        this.id_pedido = id;
        this.cliente=cliente;
        this.vendedor = vendedor;
        this.estado = estado;
        this.pago = pago;
        this.items=new HashSet(items);
    }

     private boolean validarItemsUnVendedor(Set<ItemsPedido> items, Vendedor vendedor) {
        HashSet<ItemMenu> itemsVendedor = vendedor.getItems();

        for (ItemsPedido item : items) 
            if(!itemsVendedor.contains(item.getItemMenu())) 
                return false;
        return true;
    }
    
 
}
