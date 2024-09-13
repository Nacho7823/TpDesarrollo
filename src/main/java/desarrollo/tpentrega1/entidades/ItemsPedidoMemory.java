package desarrollo.tpentrega1.entidades;

import java.util.function.Predicate;
import java.util.stream.Stream;

public class ItemsPedidoMemory implements ItemsPedidoDao {
    Stream<ItemMenu> items;


    @Override
    public void buscarPorNombre(String nombre) {
        items.filter(item -> item.getNombre().equals(nombre));
    }

    @Override
    public void buscarDescripcion(String descripcion) {
        items.filter(item -> item.getDescripcion().equals(descripcion));
    }

    @Override
    public void buscarPrecioEntre(int precioMin, int precioMax){
        items.filter(item -> (item.getPrecio() >= precioMin && item.getPrecio() <= precioMax));
    }

    public void buscarPrecio(int precio){
        items.filter(item -> item.getPrecio() == precio);
    }
    public void buscarCategoria(String categoria){}

    public void buscarBebidas(){}
    public void buscarPlatos(){}

    // plato
    public void buscarComidaPeso(double peso){}
    public void buscarCeliacos(){}
    public void buscarNoCeliacos(){}
    public void buscarVeganos(){}
    public void buscarNoVeganos(){}
    public void buscarComidaCalorias(int calorias){}

    // bebida
    public void buscarBebidaTamaño(double tamaño){}
    public void buscarBebidaGraduacion(double graduacion){}

    //Filtrado
    //Ordenar por criterios
    //Búsqueda por rango de precios.
    //Buscar por restaurante
    //Cuando no se encuentre un dato lanzará un “ItemNoEncontradoException”.


}