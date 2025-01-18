
package desarrollo.tpentrega1.dao;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.AbstractMap;
import java.util.List;

public interface VendeDAO {

    public void crearVende(int id_vendedor, int id_item_menu) throws DAOException;

    public void eliminarVende(int id_vendedor, int id_item_menu) throws DAOException;

    public boolean buscarVende(int id_vendedor, int id_item_menu) throws DAOException;
    
    public List<AbstractMap.SimpleEntry> obtenerVendes() throws DAOException;
    
    public List<Integer> buscarItemsOfVendedor(int id_vendedor) throws DAOException;
}
