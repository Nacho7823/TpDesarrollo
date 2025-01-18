package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.VendeDAO;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.SQLException;
import java.util.AbstractMap.SimpleEntry;
import java.util.ArrayList;
import java.util.List;

public class VendeDAOSql extends DAO implements VendeDAO {

    private static VendeDAOSql instance;

    public static VendeDAOSql getInstance() {
        if (instance == null) {
            instance = new VendeDAOSql();
        }
        return instance;
    }

    @Override
    public void crearVende(int id_vendedor, int id_item_menu) throws DAOException {
        try {

            String sql = "INSERT INTO vende (id_item_menu, id_vendedor) VALUES (?, ?)";
            createNoKey(sql, id_item_menu, id_vendedor);
            
        } catch(SQLException e){
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public void eliminarVende(int id_vendedor, int id_item_menu) throws DAOException {
        try {

            String sql = "DELETE FROM vende WHERE id_item_menu = ? AND id_vendedor = ?";

            update(sql, id_item_menu, id_vendedor);

        } catch (SQLException ex) {
            throw new DAOException("no se pudo actualizar la coordenada: \n" + ex.getMessage());
        }
    }

    @Override
    public boolean buscarVende(int id_vendedor, int id_item_menu) throws DAOException {
        try {

            String sql = "SELECT * FROM vende WHERE id_item_menu = ? AND id_vendedor = ?";
            search(sql, id_item_menu, id_vendedor);

            return resultado.next();
            
        } catch (SQLException e) {
            throw new DAOException("No se pudo buscar la coordenada: \n" + e.getMessage());
        }
    }

    @Override
    public List<SimpleEntry> obtenerVendes() throws DAOException {
        try {

            String sql = "SELECT * FROM vende";
            search(sql);

            List<SimpleEntry> vendes = new ArrayList<>();
            while (resultado.next()) {
                int id_vendedor = resultado.getInt("id_vendedor");
                int id_item_menu = resultado.getInt("id_item_menu");
                
                vendes.add(new SimpleEntry(id_vendedor, id_item_menu));
            }
            return vendes;
        } catch (SQLException e) {
            throw new DAOException("No se pudo buscar la coordenada: \n" + e.getMessage());
        }
    }

    @Override
    public List<Integer> buscarItemsOfVendedor(int id_vendedor) throws DAOException {
        try {

            String sql = "SELECT * FROM vende WHERE id_vendedor = ?";
            search(sql, id_vendedor);

            List<Integer> items = new ArrayList<>();
            while (resultado.next()) {
                int id_item_menu = resultado.getInt("id_item_menu");
                
                items.add(id_item_menu);
            }
            return items;
            
        } catch (SQLException e) {
            throw new DAOException("No se pudo buscar la coordenada: \n" + e.getMessage());
        }
    }
    
    

   

}
