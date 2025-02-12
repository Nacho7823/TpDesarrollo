package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.VendedorDAO;
import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Plato;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import desarrollo.tpentrega1.dao.ItemMenuDAO;

public class VendedorDAOSql extends DAO implements VendedorDAO {

    private ItemMenuDAO itemsMenuDAO = ItemMenuDAOSql.getInstance();
    private static VendedorDAOSql instance;

    public static VendedorDAOSql getInstance() {
        if (VendedorDAOSql.instance == null) {
            VendedorDAOSql.instance = new VendedorDAOSql();
        }
        return VendedorDAOSql.instance;
    }

    @Override
    public void crearVendedor(Vendedor vendedor) throws DAOException {

        try {

            String sql = "INSERT INTO vendedor (nombre, direccion, longitud, latitud) VALUES (?, ?, ?, ?)";

            int id = create(sql,
                    vendedor.getNombre(),
                    vendedor.getDireccion(),
                    vendedor.getCoordenada().getLng(),
                    vendedor.getCoordenada().getLat());

            vendedor.setId(id);

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public void actualizarVendedor(Vendedor vendedor) throws DAOException {
        try {

            String sql = "UPDATE vendedor SET nombre = ?, direccion = ?, longitud = ?, latitud = ? WHERE id_vendedor = ?";

            update(sql,
                    vendedor.getNombre(),
                    vendedor.getDireccion(),
                    vendedor.getCoordenada().getLng(),
                    vendedor.getCoordenada().getLat(),
                    vendedor.getId()
            );

        } catch (SQLException e) {
            System.out.println("vendedor: " + vendedor.toString());
            throw new DAOException("No se pudo actualizar el vendedor: \n" + e.getMessage());
        }
    }

    @Override
    public void eliminarVendedor(int id) throws DAOException {
        try {

            String sql = "DELETE FROM vendedor WHERE id_vendedor = ?";
            delete(sql, id);

        } catch (SQLException e) {
            throw new DAOException("No se pudo eliminar el vendedor: \n" + e.getMessage());
        }
    }

    @Override
    public Vendedor buscarVendedor(int id) throws DAOException {
        try {

            String sql = "SELECT nombre, direccion, longitud, latitud FROM vendedor WHERE id_vendedor = ?";

            search(sql, id);

            if (!resultado.next()) {
                throw new DAOException("vendedor not found");
            }
            return new Vendedor(
                    id,
                    resultado.getString("nombre"),
                    resultado.getString("direccion"),
                    new Coordenada(
                            resultado.getDouble("latitud"),
                            resultado.getDouble("longitud")
                    ));

        } catch (SQLException e) {
            throw new DAOException("No se pudo buscar el vendedor: \n" + e.getMessage());
        }
    }

    @Override
    public Vendedor buscarVendedorPorNombre(String nombre) throws DAOException {

        try {

            String sql = "SELECT id_vendedor, nombre, direccion, longitud, latitud FROM vendedor WHERE nombre = ?";

            search(sql, nombre);

            if (!resultado.next()) {
                throw new DAOException("vendedor not found");
            }
            return new Vendedor(
                    resultado.getInt("id_vendedor"),
                    resultado.getString("nombre"),
                    resultado.getString("direccion"),
                    new Coordenada(
                            resultado.getDouble("latitud"),
                            resultado.getDouble("longitud")
                    ));

        } catch (SQLException e) {
            throw new DAOException("No se pudo buscar el vendedor: \n" + e.getMessage());
        }
    }

    @Override
    public List<Vendedor> obtenerVendedores() throws DAOException {
        String sql = "SELECT * FROM vendedor";
        List<Vendedor> listaVendedores = new ArrayList<>();

        try {
            search(sql);

            while (resultado.next()) {
                int id = resultado.getInt("id_vendedor");
                String nombre = resultado.getString("nombre");
                String direccion = resultado.getString("direccion");
                Coordenada coord = new Coordenada(
                        resultado.getDouble("latitud"),
                        resultado.getDouble("longitud")
                );

                Vendedor vendedor = new Vendedor(id, nombre, direccion, coord);

                listaVendedores.add(vendedor);
            }
        } catch (SQLException e) {
            throw new DAOException("No se pudo obtener los vendedores: \n" + e.getMessage());
        }
        return listaVendedores;
    }

    @Override
    public List<ItemMenu> obtenerItemsDeVendedor(Vendedor vendedor) throws DAOException {
        String sql = "SELECT * FROM item_menu I "
                + "LEFT JOIN bebida B ON I.id_item_menu = B.id_item_menu "
                + "LEFT JOIN plato P ON I.id_item_menu = P.id_item_menu "
                + "WHERE EXISTS (SELECT 1 FROM vende V WHERE V.id_item_menu = I.id_item_menu "
                + "AND V.id_vendedor = ?)";

        List<ItemMenu> listaItemMenus = new ArrayList<>();

        try {
            search(sql, vendedor.getId());

            while (resultado.next()) {
                int id_item_menu = resultado.getInt("id_item_menu");
                String nombre = resultado.getString("nombre");
                String descripcion = resultado.getString("descripcion");
                double precio = resultado.getDouble("precio");
                String categoria = resultado.getString("categoria");

                ItemMenu itemMenu = null;

                if (categoria.equalsIgnoreCase("bebida")) {
                    double tamaño = resultado.getDouble("tamanio");
                    double graduacionAlcoholica = resultado.getDouble("graduacion_alcoholica");
                    itemMenu = new Bebida.Builder()
                            .id(id_item_menu)
                            .nombre(nombre)
                            .descripcion(descripcion)
                            .precio(precio)
                            .categoria(categoria)
                            .graduacionAlcoholica(graduacionAlcoholica)
                            .tamaño(tamaño)
                            .build();
                } else if (categoria.equalsIgnoreCase("plato")) {
                    double calorias = resultado.getDouble("calorias");
                    boolean aptoCeliaco = resultado.getBoolean("apto_celiaco");
                    boolean aptoVegano = resultado.getBoolean("apto_vegano");
                    double peso = resultado.getDouble("peso");
                    itemMenu = new Plato.Builder()
                            .id(id_item_menu)
                            .nombre(nombre)
                            .descripcion(descripcion)
                            .precio(precio)
                            .categoria(categoria)
                            .calorias(calorias)
                            .aptoCeliaco(aptoCeliaco)
                            .aptoVegano(aptoVegano)
                            .peso(peso)
                            .build();
                }

                listaItemMenus.add(itemMenu);
            }
            return listaItemMenus;
            
        } catch (SQLException ex) {
            throw new DAOException("No se pudo obtener los itemMenu: \n" + ex.getMessage());
        }
    }
    
    @Override
    public void setVende(int v, int i) throws DAOException {
        try {

            String sql = "INSERT INTO vende (id_vendedor, id_item_menu) VALUES (?, ?)";

            createNoKey(sql, v, i );

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }
    
    @Override
    public void eliminarVende(int v) throws DAOException {
        try {

            String sql = "DELETE FROM vende WHERE id_vendedor = ?";

            delete(sql, v);

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }
    
    @Override
    public List<ItemMenu> getVendeList(int v) throws DAOException {
        String sql = "SELECT * FROM vende WHERE id_vendedor = ?";
        List<ItemMenu> listaItems = new ArrayList<>();

        try {
            search(sql, v);

            while (resultado.next()) {
                int id = resultado.getInt("id_item_menu");
                ItemMenu it = ItemMenuDAOSql.getInstance().buscarItemMenu(id);
                listaItems.add(it);
            }
            closeSearch();
            return listaItems;
        } catch (SQLException e) {
            throw new DAOException("No se pudo obtener los vendedores: \n" + e.getMessage());
        }
    }
    
    @Override
    public boolean getVende(int v, int i) throws DAOException {
        String sql = "SELECT * FROM vende WHERE id_vendedor = ? AND id_item_menu = ?";

        try {
            search(sql, v, i);

            boolean res = resultado.next();
            closeSearch();
            return res;
        } catch (SQLException e) {
            throw new DAOException("No se pudo obtener los vendedores: \n" + e.getMessage());
        }
    }

}
