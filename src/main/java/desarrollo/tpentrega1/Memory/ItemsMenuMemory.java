package desarrollo.tpentrega1.Memory;

import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.dao.ItemsMenuDAO;
import java.util.ArrayList;
import java.util.List;

public class ItemsMenuMemory implements ItemsMenuDAO {
    private static List<ItemMenu> itemsMenu = new ArrayList<>();

    
    public static List<ItemMenu> getItemsMenu() {
        return itemsMenu;
    }
    
    @Override
    public void listarItemsMenu() {
        for (ItemMenu item : itemsMenu) {
            System.out.println(item.toString());
        }
    }

    @Override
    public void crearItemsMenu(ItemMenu item) {
        itemsMenu.add(item);
        System.out.println("Item de menú creado: " + item.getNombre());
    }

    @Override
    public void actualizarItemsMenu(ItemMenu item) {
        for (int i = 0; i < itemsMenu.size(); i++) {
            if (itemsMenu.get(i).getId().equals(item.getId())) {
                itemsMenu.set(i, item);
                System.out.println("Item de menú actualizado: " + item.getNombre());
                return;
            }
        }
        System.out.println("Item de menú no encontrado para actualizar.");
    }

    @Override
    public void eliminarItemsMenu(String id) {
        boolean existe= itemsMenu.stream().anyMatch(c -> c.getId().equals(String.valueOf(id)));
        if(existe){
        itemsMenu.removeIf(item -> item.getId().equals(id));
        System.out.println("Item de menú eliminado con ID: " + id);
    }}

    @Override
    public ItemMenu buscarItemsMenu(String id) {
        for (ItemMenu item : itemsMenu) {
            if (item.getId().equals(id)) {
                
                return item;
            }
        }
        
        return null;
    }

    
}

