package desarrollo.tpentrega1.dao;

import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Plato;
import java.util.List;


public interface ItemsPedidoDao {

    public ItemMenu buscarPorNombre(String nombre);
    public List<ItemMenu> buscarDescripcion(String descripcion);
    public List<ItemMenu> buscarPrecioEntre(int precioMin, int precioMax);
    public List<ItemMenu> buscarPrecio(int precio);
    public List<ItemMenu> buscarCategoria(String categoria);
    public List<ItemMenu> buscarBebidas();
    public List<ItemMenu> buscarPlatos();

    // plato
    public List<ItemMenu> buscarComidaPeso(double peso);
    public List<ItemMenu> buscarCeliacos();
    public List<ItemMenu> buscarNoCeliacos();
    public List<ItemMenu> buscarVeganos();
    public List<ItemMenu> buscarNoVeganos();
    public List<ItemMenu> buscarComidaCalorias(int calorias);

    // bebida
    public List<ItemMenu> buscarBebidaTamaño(double tamaño);
    public List<ItemMenu> buscarBebidaGraduacion(double graduacion);

    
}