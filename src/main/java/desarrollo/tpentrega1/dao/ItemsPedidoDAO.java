package desarrollo.tpentrega1.dao;

import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.List;
import java.util.Map;


public interface ItemsPedidoDAO {

    public ItemMenu buscarPorNombre(String nombre) throws DAOException;
    public List<ItemMenu> buscarDescripcion(String descripcion) throws DAOException;
    public List<ItemMenu> buscarPrecioEntre(int precioMin, int precioMax) throws DAOException;
    public List<ItemMenu> buscarPrecio(int precio) throws DAOException;
    public List<ItemMenu> buscarCategoria(String categoria) throws DAOException;
    public List<ItemMenu> buscarBebidas() throws DAOException;
    public List<ItemMenu> buscarPlatos() throws DAOException;

    // plato
    public List<ItemMenu> buscarComidaPeso(double peso) throws DAOException;
    public List<ItemMenu> buscarCeliacos() throws DAOException;
    public List<ItemMenu> buscarNoCeliacos() throws DAOException;
    public List<ItemMenu> buscarVeganos() throws DAOException;
    public List<ItemMenu> buscarNoVeganos() throws DAOException;
    public List<ItemMenu> buscarComidaCalorias(int calorias) throws DAOException;

    // bebida
    public List<ItemMenu> buscarBebidaTamaño(double tamaño) throws DAOException;
    public List<ItemMenu> buscarBebidaGraduacion(double graduacion) throws DAOException;

    public Map<ItemMenu, Integer> buscarPorIdPedido(int id) throws DAOException;
    public void crearItemsPedido(int id_pedido, Map<ItemMenu, Integer> itemsPedido) throws DAOException;
    public void actualizarItemsPedido(int id_pedido, Map<ItemMenu, Integer> itemsPedido) throws DAOException;
    public void eliminarItemsPedido(int id_pedido) throws DAOException;

    
}