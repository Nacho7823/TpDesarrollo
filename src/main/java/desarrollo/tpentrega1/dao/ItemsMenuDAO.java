
package desarrollo.tpentrega1.dao;
import desarrollo.tpentrega1.entidades.ItemMenu;
import java.util.List;

public interface ItemsMenuDAO {
public void listarItemsMenu();
public void crearItemsMenu(ItemMenu item);
public void actualizarItemsMenu(ItemMenu item);
public void eliminarItemsMenu(String id);
public ItemMenu buscarItemsMenu(String id);
}
