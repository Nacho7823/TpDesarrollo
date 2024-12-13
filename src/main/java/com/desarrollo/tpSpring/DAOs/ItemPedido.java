
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.ItemMenu;
import com.desarrollo.tpSpring.entities.ItemsPedido;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemPedido extends JpaRepository<ItemMenu, String>{

   public List<ItemsPedido> buscarPorIdPedido(int idPedido);
   public List<ItemsPedido> buscarPorIdItemMenu(int idItem);
   
   public List<ItemsPedido> buscarPorCantidad(int cantidad);

}
