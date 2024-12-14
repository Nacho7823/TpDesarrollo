
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.ItemsPedido;
import com.desarrollo.tpSpring.entities.ItemsPedidoID;
import com.desarrollo.tpSpring.entities.Pedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemsPedidoRepository extends JpaRepository<ItemsPedido, ItemsPedidoID>{
    
    public List<ItemsPedido> findByPedido(Pedido pedido);

  // public List<ItemsPedido> findByIdPedido(int idPedido);
   
   /*    @Query("SELECT ip FROM ItemPedido ip WHERE ip.itemMenu.id = :idItemMenu")
    List<ItemsPedido> findByIdItemMenu(@Param("idItemMenu") int idItemMenu);*/
   
   public List<ItemsPedido> findByCantidad(int cantidad);
   
   

}
