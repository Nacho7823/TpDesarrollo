
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.Pedido;
import com.desarrollo.tpSpring.enums.EstadoPedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Integer>{
   
    List<Pedido> findByTotal(double total);
    
   /*   @Query("SELECT p FROM Pedido p WHERE p.cliente.id_cliente = :id_cliente")
    List<Pedido> findByClienteIdCliente(@Param("id_cliente") int id_cliente);

    @Query("SELECT p FROM Pedido p WHERE p.cliente.nombre = :nombre")
    List<Pedido> findByClienteNombre(@Param("nombre") String nombre);

    @Query("SELECT p FROM Pedido p WHERE p.vendedor.id_vendedor = :id_vendedor")
    List<Pedido> findByVendedorId_vendedor(@Param("id_vendedor") int id_vendedor);

@Query("SELECT p FROM Pedido p JOIN p.vendedor v WHERE v.nombre = :nombre")
List<Pedido> findByVendedorNombre(@Param("nombre") String nombre);

    @Query("SELECT p FROM Pedido p WHERE p.estado = :estadoPedido")
    List<Pedido> findByEstado(@Param("estadoPedido") EstadoPedido estadoPedido);

    /*@Query("SELECT p FROM Pedido p WHERE p.pago.id_pago = :id_pago")
    List<Pedido> findByPagoId_pago(@Param("id_pago") int id_pago);*/


}
