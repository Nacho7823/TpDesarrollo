
package desarrollo.tpentrega1.dao;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.List;

public interface ItemsMenuDAO {
    
    public void crearItemMenu(ItemMenu itemMenu) throws DAOException;

    public void actualizarItemMenu(ItemMenu itemMenu) throws DAOException;

    public void eliminarItemMenu(int id) throws DAOException;

    public ItemMenu buscarItemMenu(int id) throws DAOException;
    
//    public List<ItemMenu> obtenerItemsMenuDeVendedor(int id) throws DAOException;
    
    
    
}
