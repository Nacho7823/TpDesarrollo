
package desarrollo.tpentrega1.dao;
import desarrollo.tpentrega1.entidades.ItemMenu;
import java.util.List;

public interface ItemsMenuDAO {
public void listarItemsMenu(List<ItemMenu> itemsMenu);
public void crearItemsMenu(List<ItemMenu> itemsMenu);
public void actualizarItemsMenu(List<ItemMenu> itemsMenu);
public void eliminarItemsMenu(int id);
public void buscarItemsMenu(int id);
}
