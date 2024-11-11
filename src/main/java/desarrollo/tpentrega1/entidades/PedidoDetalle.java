package desarrollo.tpentrega1.entidades;

import java.util.List;

public class PedidoDetalle {
    private List<ItemMenu> items;

    public PedidoDetalle(List<ItemMenu> items) {
        this.items = items;
    }

    public List<ItemMenu> getItems() {
        return items;
    }

    public void setItems(List<ItemMenu> items) {
        this.items = items;
    }

    public void addItem(ItemMenu item){
        this.items.add(item);
    }
    
    public void removeItem(ItemMenu item){
        this.items.remove(item);
    }
}
