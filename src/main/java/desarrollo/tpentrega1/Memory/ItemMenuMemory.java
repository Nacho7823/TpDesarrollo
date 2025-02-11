
package desarrollo.tpentrega1.Memory;

import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;
import desarrollo.tpentrega1.dao.ItemMenuDAO;


public class ItemMenuMemory implements ItemMenuDAO {

    private static List<ItemMenu> itemsMenu = new ArrayList<ItemMenu>();
//    private List<ItemMenu> itemsMenu;

    public ItemMenuMemory() {
//        itemsMenu = new ArrayList<ItemMenu>();
    }

    @Override
    public void crearItemMenu(ItemMenu itemMenu) throws DAOException {
        itemsMenu.add(itemMenu);
        System.out.println("Item de menú creado: " + itemMenu.getNombre());
    }

    @Override
    public void actualizarItemMenu(ItemMenu itemMenu) throws DAOException {
        for (int i = 0; i < itemsMenu.size(); i++) {
            if (itemsMenu.get(i).getId()==(itemMenu.getId())) {
                itemsMenu.set(i, itemMenu);
                System.out.println("Item de menú actualizado: " + itemMenu.getNombre());
                return;
            }
        }
        System.out.println("Item de menú no encontrado para actualizar.");
        throw new DAOException("Item de menú no encontrado para actualizar.");
    }

    @Override
    public void eliminarItemMenu(int id) throws DAOException {
        boolean existe= itemsMenu.stream().anyMatch(c -> c.getId()==(id));
        if(existe){
        itemsMenu.removeIf(item -> item.getId()==(id));
        System.out.println("Item de menú eliminado con ID: " + id);
       }
    }

    @Override
    public ItemMenu buscarItemMenu(int id) throws DAOException {
        for (ItemMenu item : itemsMenu) {
            if (item.getId()==(id)) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<ItemMenu> obtenerItemMenusDeVendedor(int id) throws DAOException {
        
        return itemsMenu;
    }

    @Override
    public ItemMenu buscarItemMenuPorNombre(String nombre) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public List<ItemMenu> obtenerItemMenus() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
