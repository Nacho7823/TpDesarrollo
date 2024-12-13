package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.Bebida;
import com.desarrollo.tpSpring.entities.ItemMenu;
import com.desarrollo.tpSpring.entities.Plato;
import java.util.List;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMenuRepository extends JpaRepository<ItemMenu, String> {

    
      public ItemMenu buscarPorNombre(String nombre);
      public List<ItemMenu> buscarDescripcion(String descripcion);
      public List<ItemMenu> buscarPrecioEntre(int precioMin, int precioMax);
      public List<ItemMenu> buscarPrecio(int precio);
      public List<ItemMenu> buscarCategoria(String categoria);

      @Query("SELECT i FROM ItemMenu i WHERE TYPE(i) = Bebida")
      Set<Bebida> ObtenerBebidas();

     @Query("SELECT i FROM ItemMenu i WHERE TYPE(i) = Plato")
     Set<Plato> ObtenerPlatos();
}
