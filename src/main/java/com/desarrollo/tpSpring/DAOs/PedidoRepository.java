
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.ItemMenu;
import com.desarrollo.tpSpring.entities.Pedido;
import com.desarrollo.tpSpring.exceptions.DAOException;
import java.util.List;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoRepository extends CrudRepository<Pedido, String>{
//    public void crearPedido(Pedido pedido) throws DAOException;

//    public void actualizarPedido(Pedido pedido) throws DAOException;

//    public void eliminarPedido(String id) throws DAOException;

//    public Pedido buscarPedido(String id) throws DAOException;
    
//    public List<Pedido> obtenerPedidos() throws DAOException;

//    public void addItem(ItemMenu item, Pedido p) throws DAOException;

//    public void removeItem(ItemMenu item, Pedido p) throws DAOException;
}
