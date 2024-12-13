
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.Pedido;
import com.desarrollo.tpSpring.enums.EstadoPedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, String>{
   public List<Pedido> buscarPorIdCliente(int idCliente);
   public List<Pedido> buscarPorNombreCliente(String nombreCliente);
  
   public List<Pedido> buscarPorIdVendedor(int idVendedor);
   public List<Pedido> buscarPorNombreVendedor(String nombreVendedor);
   
   public List<Pedido> buscarPorEstado(EstadoPedido estadoPedido);
   
   public List<Pedido> buscarPorIdPago(int idPago);
   
   public List<Pedido> buscarPorTotal(double total);
}
