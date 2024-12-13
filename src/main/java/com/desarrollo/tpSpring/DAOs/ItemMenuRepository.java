
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.ItemMenu;
import com.desarrollo.tpSpring.exceptions.DAOException;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemMenuRepository extends CrudRepository<ItemMenu, String>{
//    public void crearItemMenu(ItemMenu itemMenu) throws DAOException;

//    public void actualizarItemMenu(ItemMenu itemMenu) throws DAOException;

//    public void eliminarItemMenu(String id) throws DAOException;

//    public ItemMenu buscarItemMenu(String id) throws DAOException;
    

//    public List<ItemMenu> obtenerItemsMenuDeVendedor(String id) throws DAOException;
    
    @Query("SELECT i FROM ItemMenu i WHERE TYPE(i) = Bebida")
List<ItemMenu> findAllBebidas();

@Query("SELECT i FROM ItemMenu i WHERE TYPE(i) = Plato")
List<ItemMenu> findAllPlatos();
}
