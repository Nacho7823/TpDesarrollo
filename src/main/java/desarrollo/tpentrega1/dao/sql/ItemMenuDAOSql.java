package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Plato;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import desarrollo.tpentrega1.dao.ItemMenuDAO;

public class ItemMenuDAOSql extends DAO implements ItemMenuDAO {

    private static ItemMenuDAOSql instance = null;

    public static ItemMenuDAOSql getInstance() {
        if (instance == null) {
            instance = new ItemMenuDAOSql();
        }
        return instance;
    }

    @Override
    public void crearItemMenu(ItemMenu itemMenu) throws DAOException {
        try {
            String sql = "INSERT INTO item_menu (nombre, descripcion, precio, categoria) VALUES (?, ?, ?, ?)";

            int id = create(sql,
                    itemMenu.getNombre(),
                    itemMenu.getDescripcion(),
                    itemMenu.getPrecio(),
                    itemMenu.getCategoria());

            itemMenu.setId(id);
        } catch (SQLException e) {
            throw new DAOException("no se pudo crear el ItemMenu: \n" + e.getMessage());
        }

        if (itemMenu instanceof Bebida) {
            crearBebida((Bebida) itemMenu);
        } else {
            crearPlato((Plato) itemMenu);
        }
    }

    private void crearBebida(Bebida bebida) throws DAOException {
        try {

            String sql = "INSERT INTO bebida (id_item_menu, graduacion_alcoholica, tamanio) VALUES (?, ?, ?)";

            createNoKey(sql,
                    bebida.getId(),
                    bebida.getGraduacionAlcoholica(),
                    bebida.getTamaño());

        } catch (SQLException e) {
            throw new DAOException("no se pudo crear la bebida: \n" + e.getMessage());
        }
    }

    private void crearPlato(Plato plato) throws DAOException {
        try {

            String sql = "INSERT INTO plato (id_item_menu, calorias, apto_celiaco, apto_vegano, peso) VALUES (?, ?, ?, ?, ?)";

            createNoKey(sql,
                    plato.getId(),
                    plato.getCalorias(),
                    plato.aptoCeliaco(),
                    plato.aptoVegano(),
                    plato.getPeso());

        } catch (SQLException e) {
            throw new DAOException("no se pudo crear el plato: \n" + e.getMessage());
        }
    }

    @Override
    public void actualizarItemMenu(ItemMenu itemMenu) throws DAOException {
        try {

            String sql = "UPDATE item_menu SET nombre = ?, descripcion = ?, precio = ?, categoria = ? WHERE id_item_menu = ?";

            update(sql,
                    itemMenu.getNombre(),
                    itemMenu.getDescripcion(),
                    itemMenu.getPrecio(),
                    itemMenu.getCategoria(),
                    itemMenu.getId());

        } catch (SQLException e) {
            throw new DAOException("no se pudo actualizar el item_menu: \n" + e.getMessage());
        }

        if (itemMenu instanceof Bebida) {
            actualizarBebida(((Bebida) itemMenu));
        } else {
            actualizarPlato(((Plato) itemMenu));
        }
    }

    public void actualizarBebida(Bebida bebida) throws DAOException {
        try {

            String sql = "UPDATE bebida SET graduacion_alcoholica = ?, tamanio = ? WHERE id_item_menu = ?";
            update(sql,
                    bebida.getGraduacionAlcoholica(),
                    bebida.getTamaño(),
                    bebida.getId());

        } catch (SQLException e) {
            throw new DAOException("no se pudo actualizar la bebida: \n" + e.getMessage());
        }
    }

    public void actualizarPlato(Plato plato) throws DAOException {
        try {

            String sql = "UPDATE plato SET calorias = ?, apto_celiaco = ?, apto_vegano = ?, peso = ? WHERE id_item_menu = ?";
            update(sql,
                    plato.getCalorias(),
                    plato.aptoCeliaco(),
                    plato.aptoVegano(),
                    plato.getPeso(),
                    plato.getId());

        } catch (SQLException e) {
            throw new DAOException("no se pudo actualizar el plato: \n" + e.getMessage());
        }
    }

    @Override
    public void eliminarItemMenu(int id) throws DAOException {
        try {

            String sql = "DELETE FROM item_menu WHERE id_item_menu = ?";
            delete(sql, id);

            String sqlp = "DELETE FROM plato WHERE id_item_menu = ?";
            delete(sqlp, id);

            String sqlb = "DELETE FROM bebida WHERE id_item_menu = ?";
            delete(sqlb, id);

        } catch (SQLException e) {
            throw new DAOException("no se pudo eliminar el itemMenu: \n" + e.getMessage());
        }

    }

    @Override
    public ItemMenu buscarItemMenu(int id) throws DAOException {
        try {

            String sql = "SELECT * FROM item_menu I LEFT JOIN bebida B ON I.id_item_menu=B.id_item_menu LEFT JOIN plato P ON"
                    + " I.id_item_menu=P.id_item_menu WHERE I.id_item_menu= ?";

            search(sql, id);

            if (!resultado.next()) {
                throw new DAOException("itemMenu not found");
            }

            ItemMenu itemMenu = null;
            String nombre = resultado.getString("nombre");
            String descripcion = resultado.getString("descripcion");
            double precio = resultado.getDouble("precio");
            String categoria = resultado.getString("categoria");

            if (categoria.equalsIgnoreCase("bebida")) {
                double tamaño = resultado.getDouble("tamanio");
                double graduacionAlcoholica = resultado.getDouble("graduacion_alcoholica");
                itemMenu = new Bebida.Builder()
                        .id(id)
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
                        .id(id)
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

            closeSearch();
            return itemMenu;

        } catch (SQLException e) {
            throw new DAOException("No se pudo obtener los itemMenu: \n" + e.getMessage());
        }
    }

    @Override
    public ItemMenu buscarItemMenuPorNombre(String nombre) throws DAOException {
        try {

            String sql = "SELECT * FROM item_menu I LEFT JOIN bebida B ON I.id_item_menu=B.id_item_menu LEFT JOIN plato P ON"
                    + " I.id_item_menu=P.id_item_menu WHERE I.nombre= ?";

            search(sql, nombre);

            if (!resultado.next()) {
                throw new DAOException("itemMenu not found");
            }

            ItemMenu itemMenu = null;
            int id = resultado.getInt("id_item_menu");
//            String nombre = resultado.getString("nombre");
            String descripcion = resultado.getString("descripcion");
            double precio = resultado.getDouble("precio");
            String categoria = resultado.getString("categoria");

            if (categoria.equalsIgnoreCase("bebida")) {
                double tamaño = resultado.getDouble("tamanio");
                double graduacionAlcoholica = resultado.getDouble("graduacion_alcoholica");
                itemMenu = new Bebida.Builder()
                        .id(id)
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
                        .id(id)
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

            closeSearch();
            return itemMenu;

        } catch (SQLException e) {
            throw new DAOException("No se pudo obtener los itemMenu: \n" + e.getMessage());
        }
    }

    @Override
    public List<ItemMenu> obtenerItemMenusDeVendedor(int id) throws DAOException {

        try {
            String sql = "SELECT * FROM item_menu I "
                + "LEFT JOIN bebida B ON I.id_item_menu = B.id_item_menu "
                + "LEFT JOIN plato P ON I.id_item_menu = P.id_item_menu "
                + "WHERE EXISTS (SELECT 1 FROM vende V WHERE V.id_item_menu = I.id_item_menu "
                + "AND V.id_vendedor = ?)";

            List<ItemMenu> listaItemMenus = new ArrayList<>();

            search(sql, id);

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
            
            
            closeSearch();
            return listaItemMenus;

        } catch (SQLException e) {
            throw new DAOException("No se pudo obtener los itemMenu: \n" + e.getMessage());
        }
    }

    @Override
    public List<ItemMenu> obtenerItemMenus() throws DAOException {
        try {
            String sql = "SELECT * FROM item_menu I LEFT JOIN bebida B ON I.id_item_menu=B.id_item_menu LEFT JOIN plato P ON"
                    + " I.id_item_menu=P.id_item_menu";

            search(sql);

            List<ItemMenu> items = new ArrayList<>();

            while (resultado.next()) {
                ItemMenu itemMenu = null;
                int id = resultado.getInt("id_item_menu");
                String nombre = resultado.getString("nombre");
                String descripcion = resultado.getString("descripcion");
                double precio = resultado.getDouble("precio");
                String categoria = resultado.getString("categoria");

                if (categoria.equalsIgnoreCase("bebida")) {
                    double tamaño = resultado.getDouble("tamanio");
                    double graduacionAlcoholica = resultado.getDouble("graduacion_alcoholica");
                    itemMenu = new Bebida.Builder()
                            .id(id)
                            .nombre(nombre)
                            .descripcion(descripcion)
                            .precio(precio)
                            .categoria(categoria)
                            .graduacionAlcoholica(graduacionAlcoholica)
                            .tamaño(tamaño)
                            .build();
                } 
                else if (categoria.equalsIgnoreCase("plato")) {
                    double calorias = resultado.getDouble("calorias");
                    boolean aptoCeliaco = resultado.getBoolean("apto_celiaco");
                    boolean aptoVegano = resultado.getBoolean("apto_vegano");
                    double peso = resultado.getDouble("peso");
                    itemMenu = new Plato.Builder()
                            .id(id)
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
                
                items.add(itemMenu);
            }
            closeSearch();
            return items;

        } catch (SQLException e) {
            throw new DAOException("No se pudo obtener los itemMenu: \n" + e.getMessage());
        }
    }
}
