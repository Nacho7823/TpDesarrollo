package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.ItemsMenuDAO;
import desarrollo.tpentrega1.dao.VendedorDAO;
import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendedorDAOSql extends DAO implements VendedorDAO {

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

            String sql = "INSERT INTO vendedor (nombre, direccion, id_coordenada) VALUES (?, ?, ?)";

            int id = create(sql,
                    vendedor.getNombre(),
                    vendedor.getDireccion(),
                    vendedor.getCoordenada().getId_coordenada());

            vendedor.setId(id);

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

    @Override
    public void actualizarVendedor(Vendedor vendedor) throws DAOException {
        try {

            String sql = "UPDATE vendedor SET nombre = ?, direccion = ?, id_coordenada = ? WHERE id_vendedor = ?";

            update(sql,
                    vendedor.getNombre(),
                    vendedor.getDireccion(),
                    vendedor.getCoordenada().getId_coordenada(),
                    vendedor.getId()
            );

        } catch (SQLException e) {
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

            String sql = "SELECT nombre, direccion, id_coordenada FROM vendedor WHERE id_vendedor = ?";

            search(sql, id);

            if (!resultado.next()) {
                throw new DAOException("vendedor not found");
            }
            return new Vendedor(
                    id,
                    resultado.getString("nombre"),
                    resultado.getString("direccion"),
                    new Coordenada(resultado.getInt("id_coordenada"), 0, 0));

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
                int idCoordenada = resultado.getInt("id_coordenada");

                Coordenada coord = new Coordenada(idCoordenada, 0, 0);
                Vendedor vendedor = new Vendedor(id, nombre, direccion, coord);

                listaVendedores.add(vendedor);
            }
        } catch (SQLException e) {
            throw new DAOException("No se pudo obtener los vendedores: \n" + e.getMessage());
        }

        return listaVendedores;
    }

    public List<ItemMenu> getItemsMenusOfVendedor(Vendedor vendedor) throws DAOException {
        try {

            String sql = "SELECT id_item_menu WHERE id_vendedor = ?";

            search(sql, vendedor.getId());

            List<ItemMenu> items = new ArrayList<>();
            while (resultado.next()) {

                Bebida.Builder bebida = new Bebida.Builder();   // podria ser plato tambien
                bebida.id(resultado.getInt("id_item_menu"));
                ItemMenu item = bebida.build();
                items.add(item);

            }

            return items;

        } catch (SQLException e) {
            throw new DAOException("No se pudo buscar el vendedor: \n" + e.getMessage());
        }
    }

    public void setItemMenuOfVendedor(Vendedor vendedor, ItemMenu items) throws DAOException {
        try {

            String sql = "INSERT INTO vende (id_item_menu, id_vendedor) VALUES (?, ?)";

            createNoKey(sql,
                    vendedor.getId(),
                    items.getId()
            );

        } catch (SQLException e) {
            throw new DAOException(e.getMessage());
        }
    }

}
