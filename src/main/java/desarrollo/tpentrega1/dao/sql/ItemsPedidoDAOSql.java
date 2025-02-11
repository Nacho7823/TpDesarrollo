package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.ItemsPedidoDAO;
import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Plato;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemsPedidoDAOSql extends DAO implements ItemsPedidoDAO {

    private static ItemsPedidoDAOSql instance;

    public static ItemsPedidoDAOSql getInstance() {

        if (instance == null) {
            instance = new ItemsPedidoDAOSql();
        }

        return ItemsPedidoDAOSql.instance;
    }

    private ItemsPedidoDAOSql() {

    }

    private ItemMenu mapearItemMenu(ResultSet rs) throws SQLException, DAOException {
        int id = rs.getInt("id");
        String nombre = rs.getString("nombre");
        String descripcion = rs.getString("descripcion");
        double precio = rs.getDouble("precio");
        String categoria = rs.getString("categoria");

        if ("bebida".equalsIgnoreCase(categoria)) {
            double graduacionAlcoholica = rs.getDouble("graduacion_alcoholica");
            double tamaño = rs.getDouble("tamanio");
            return new Bebida.Builder()
                    .id(id)
                    .nombre(nombre)
                    .descripcion(descripcion)
                    .precio(precio)
                    .categoria(categoria)
                    .graduacionAlcoholica(graduacionAlcoholica)
                    .tamaño(tamaño)
                    .build();
        } else if ("plato".equalsIgnoreCase(categoria)) {
            double calorias = rs.getDouble("calorias");
            boolean aptoCeliaco = rs.getBoolean("apto_celiaco");
            boolean aptoVegano = rs.getBoolean("apto_vegano");
            double peso = rs.getDouble("peso");
            return new Plato.Builder()
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
        } else {
            throw new DAOException("Tipo de ItemMenu desconocido: " + categoria);
        }
    }

    private List<ItemMenu> ejecutarConsulta(String sql, Object... parametros) throws DAOException {
        try {

            List<ItemMenu> items = new ArrayList<>();
            search(sql, parametros);

            while (resultado.next()) {
                ItemMenu item = mapearItemMenu(resultado);
                items.add(item);
            }

            closeSearch();
            return items;

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public List<ItemMenu> buscarPorIdPedido(int id) throws DAOException {
        String sql = "SELECT * FROM item_menu I LEFT JOIN items_pedido IP ON I.id_item_menu=IP.id_item_menu"
                + "LEFT JOIN pedido P ON IP.id_pedido= P.id_pedido WHERE P.id_pedido= ?";

        return ejecutarConsulta(sql, id);
    }

    @Override
    public ItemMenu buscarPorNombre(String nombre) throws DAOException {
        String sql = "SELECT * FROM items_menu WHERE LOWER(nombre) = LOWER(?)";
        return ejecutarConsulta(sql, nombre).getFirst();
    }

    @Override
    public List<ItemMenu> buscarDescripcion(String descripcion) throws DAOException {
        String sql = "SELECT * FROM items_menu WHERE LOWER(descripcion) LIKE LOWER(?)";
        return ejecutarConsulta(sql, "%" + descripcion + "%");
    }

    @Override
    public List<ItemMenu> buscarPrecioEntre(int precioMin, int precioMax) throws DAOException {
        String sql = "SELECT * FROM items_menu WHERE precio BETWEEN ? AND ?";
        return ejecutarConsulta(sql, precioMin, precioMax);
    }

    @Override
    public List<ItemMenu> buscarPrecio(int precio) throws DAOException {
        String sql = "SELECT * FROM items_menu WHERE precio = ?";
        return ejecutarConsulta(sql, precio);
    }

    @Override
    public List<ItemMenu> buscarCategoria(String categoria) throws DAOException {
        String sql = "SELECT * FROM items_menu WHERE LOWER(categoria) = LOWER(?)";
        return ejecutarConsulta(sql, categoria);
    }

    @Override
    public List<ItemMenu> buscarBebidas() throws DAOException {
        String sql = "SELECT * FROM items_menu I LEFT JOIN bebida B ON I.id_item_menu=B.id_item_menu WHERE categoria LIKE 'Bebida'";
        return ejecutarConsulta(sql);
    }

    @Override
    public List<ItemMenu> buscarPlatos() throws DAOException {
        String sql = "SELECT * FROM items_menu I LEFT JOIN plato P ON I.id_item_menu=P.id_item_menu WHERE categoria LIKE 'Plato'";
        return ejecutarConsulta(sql);
    }

    @Override
    public List<ItemMenu> buscarComidaPeso(double peso) throws DAOException {
        String sql = "SELECT * FROM items_menu I LEFT JOIN plato P ON I.id_item_menu=P.id_item_menu WHERE categoria LIKE 'Plato' AND P.peso >= ?";
        return ejecutarConsulta(sql, peso);
    }

    @Override
    public List<ItemMenu> buscarCeliacos() throws DAOException {
        String sql = "SELECT * FROM items_menu I LEFT JOIN plato P ON I.id_item_menu=P.id_item_menu WHERE  categoria LIKE 'Plato' AND P.apto_celiaco = TRUE";
        return ejecutarConsulta(sql);
    }

    @Override
    public List<ItemMenu> buscarNoCeliacos() throws DAOException {
        String sql = "SELECT * FROM items_menu I LEFT JOIN plato P ON I.id_item_menu=P.id_item_menu WHERE categoria LIKE 'Plato' AND P.apto_celiaco = FALSE";
        return ejecutarConsulta(sql);
    }

    @Override
    public List<ItemMenu> buscarVeganos() throws DAOException {
        String sql = "SELECT * FROM items_menu I LEFT JOIN plato P ON I.id_item_menu=P.id_item_menu WHERE P.apto_vegano = TRUE";
        return ejecutarConsulta(sql);
    }

    @Override
    public List<ItemMenu> buscarNoVeganos() throws DAOException {
        String sql = "SELECT * FROM items_menu I LEFT JOIN plato P ON I.id_item_menu=P.id_item_menu WHERE P.apto_vegano = FALSE";
        return ejecutarConsulta(sql);
    }

    @Override
    public List<ItemMenu> buscarComidaCalorias(int calorias) throws DAOException {
        String sql = "SELECT * FROM items_menu I LEFT JOIN plato P ON I.id_item_menu=P.id_item_menu WHERE categoria LIKE 'Plato' AND P.calorias <= ?";
        return ejecutarConsulta(sql, calorias);

    }

    @Override
    public List<ItemMenu> buscarBebidaTamaño(double tamaño) throws DAOException {
        String sql = "SELECT * FROM items_menu I LEFT JOIN bebida B ON I.id_item_menu=B.id_item_menu WHERE categoria LIKE 'Bebida' AND B.tamanio >= ?";
        return ejecutarConsulta(sql, tamaño);
    }

    @Override
    public List<ItemMenu> buscarBebidaGraduacion(double graduacion) throws DAOException {
        String sql = "SELECT * FROM items_menu I LEFT JOIN bebida B ON I.id_item_menu=B.id_item_menu WHERE categoria LIKE 'Bebida' AND B.graduacion_alcoholica >= ?";
        return ejecutarConsulta(sql, graduacion);
    }
}
