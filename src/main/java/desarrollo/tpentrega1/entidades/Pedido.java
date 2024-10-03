/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1.entidades;

import java.util.List;

/**
 *
 * @author Flor Hiembuchner
 */
public class Pedido {
    private List<ItemMenu> items;
    private FormaDePago formaDePago;
    private double total;
    private EstadoPedido estado;
  

    public Pedido(List<ItemMenu> items, FormaDePago formaDePago) throws InvalidOrderException {
        if (!validarItemsUnVendedor(items)) {
        throw new InvalidOrderException("Los ítems deben pertenecer al mismo vendedor");
        }   
        this.items = items;
        this.formaDePago = formaDePago;
        this.total = calcularTotal();
        this.estado = EstadoPedido.RECIBIDO;
    }
    
    private boolean validarItemsUnVendedor(List<ItemMenu> items) {
        Vendedor vendedor=new Vendedor();
        vendedor = items.getFirst().getVendedor();
     for (ItemMenu item : items) {
            if (!item.getVendedor().getId().equals(vendedor.getId())) {
                return false; // Si encontramos un ítem que no pertenece al mismo vendedor, retornamos false
            }
        }
        return true;
    }
    private double calcularTotal() {
        double totalProductos = items.stream().mapToDouble(ItemMenu::getPrecio).sum();
        return totalProductos + formaDePago.aplicarRecargo(totalProductos);
    }

    public EstadoPedido getEstado() {
        return estado;
    }
}
