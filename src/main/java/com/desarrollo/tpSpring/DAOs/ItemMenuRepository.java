package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.ItemMenu;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMenuRepository extends JpaRepository<ItemMenu, String> {

    
      public ItemMenu findByNombre(String nombre);
      public List<ItemMenu> findByDescripcion(String descripcion);
      public List<ItemMenu> findByPrecioBetween(int precioMin, int precioMax);
      public List<ItemMenu> findByPrecio(int precio);

      @Query("SELECT i FROM item_menu i WHERE TYPE(i) = com.desarrollo.tpSpring.entities.Bebida")
      Set<ItemMenu> findAllBebida();

     @Query("SELECT i FROM item_menu i WHERE TYPE(i) = com.desarrollo.tpSpring.entities.Plato")
     Set<ItemMenu> findAllPlato();
}
