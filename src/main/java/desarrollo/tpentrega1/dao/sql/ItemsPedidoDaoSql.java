package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.ItemsPedidoDao;
import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Plato; 
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ItemsPedidoDAOSql extends DAO<ItemMenu> implements ItemsPedidoDao {

  
    private ItemMenu mapearItemMenu(ResultSet rs) throws DAOException {
        try {
            String tipo = rs.getString("tipo");
            String id = rs.getString("id");
            String nombre = rs.getString("nombre");
            String descripcion = rs.getString("descripcion");
            double precio = rs.getDouble("precio");
            String categoria = rs.getString("categoria");
            
            if ("bebida".equalsIgnoreCase(tipo)) {
                double graduacionAlcoholica = rs.getDouble("graduacion_alcoholica");
                double tamaño = rs.getDouble("tamaño");
                return new Bebida.Builder()
                        .id(id)
                        .nombre(nombre)
                        .descripcion(descripcion)
                        .precio(precio)
                        .categoria(categoria)
                        .graduacionAlcoholica(graduacionAlcoholica)
                        .tamaño(tamaño)
                        .build();
            } else if ("plato".equalsIgnoreCase(tipo)) {
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
                throw new DAOException("Tipo de ItemMenu desconocido: " + tipo);
                
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemsPedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

   
    private List<ItemMenu> ejecutarConsulta(String sql, Object... parametros) throws DAOException {
        List<ItemMenu> items = new ArrayList<>();
        PreparedStatement pstmt = null;
        ResultSet rs = null;

        try {
            ConectarBase();
            pstmt = conexion.prepareStatement(sql);

            // Asignar parámetros
            for (int i = 0; i < parametros.length; i++) {
                pstmt.setObject(i + 1, parametros[i]);
            }

            rs = pstmt.executeQuery();

            while (rs.next()) {
                ItemMenu item = mapearItemMenu(rs);
                items.add(item);
            }

        } catch (ClassNotFoundException | SQLException ex) {
            throw new DAOException("Error al ejecutar la consulta: " + ex.getMessage());
        } finally {
            try {
                if (rs != null) rs.close();
                if (pstmt != null) pstmt.close();
                desconectarBase();
            } catch (Exception ex) {
                throw new DAOException("Error al cerrar recursos: " + ex.getMessage());
            }
        }

        return items;
    }

    @Override
    public ItemMenu buscarPorNombre(String nombre) {
        String sql = "SELECT * FROM items_menu WHERE LOWER(nombre) = LOWER(?)";
        try {
            return ejecutarConsulta(sql, nombre).getFirst();
        } catch (DAOException ex) {
            Logger.getLogger(ItemsPedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }

    @Override
    public List<ItemMenu> buscarDescripcion(String descripcion) {
        String sql = "SELECT * FROM items_menu WHERE LOWER(descripcion) LIKE LOWER(?)";
        try {
            return ejecutarConsulta(sql, "%" + descripcion + "%");
        } catch (DAOException ex) {
            Logger.getLogger(ItemsPedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ItemMenu> buscarPrecioEntre(int precioMin, int precioMax) {
        try {
            String sql = "SELECT * FROM items_menu WHERE precio BETWEEN ? AND ?";
            return ejecutarConsulta(sql, precioMin, precioMax);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsPedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ItemMenu> buscarPrecio(int precio) {
        String sql = "SELECT * FROM items_menu WHERE precio = ?";
        try {
            return ejecutarConsulta(sql, precio);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsPedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ItemMenu> buscarCategoria(String categoria) {
        String sql = "SELECT * FROM items_menu WHERE LOWER(categoria) = LOWER(?)";
        try {
            return ejecutarConsulta(sql, categoria);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsPedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ItemMenu> buscarBebidas() {
        String sql = "SELECT * FROM items_menu WHERE tipo = 'bebida'";
        try {
            return ejecutarConsulta(sql);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsPedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ItemMenu> buscarPlatos() {
        try {
            String sql = "SELECT * FROM items_menu WHERE tipo = 'plato'";
            return ejecutarConsulta(sql);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsPedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ItemMenu> buscarComidaPeso(double peso) {
        try {
            String sql = "SELECT * FROM items_menu WHERE tipo = 'plato' AND peso >= ?";
            return ejecutarConsulta(sql, peso);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsPedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ItemMenu> buscarCeliacos() {
        String sql = "SELECT * FROM items_menu WHERE  tipo = 'plato' AND apto_celiaco = TRUE";
        try {
            return ejecutarConsulta(sql);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsPedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ItemMenu> buscarNoCeliacos() {
        String sql = "SELECT * FROM items_menu WHERE tipo = 'plato' AND apto_celiaco = FALSE";
        try {
            return ejecutarConsulta(sql);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsPedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ItemMenu> buscarVeganos() {
        try {
            String sql = "SELECT * FROM items_menu WHERE apto_vegano = TRUE";
            return ejecutarConsulta(sql);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsPedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ItemMenu> buscarNoVeganos() {
        try {
            String sql = "SELECT * FROM items_menu WHERE apto_vegano = FALSE";
            return ejecutarConsulta(sql);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsPedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ItemMenu> buscarComidaCalorias(int calorias) {
        String sql = "SELECT * FROM items_menu WHERE tipo = 'plato' AND calorias <= ?";
        try {
            return ejecutarConsulta(sql, calorias);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsPedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
       
    }

    @Override
    public List<ItemMenu> buscarBebidaTamaño(double tamaño) {
        try {
            String sql = "SELECT * FROM items_menu WHERE tipo = 'bebida' AND tamaño >= ?";
            return ejecutarConsulta(sql, tamaño);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsPedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }

    @Override
    public List<ItemMenu> buscarBebidaGraduacion(double graduacion) {
        try {
            String sql = "SELECT * FROM items_menu WHERE tipo = 'bebida' AND graduacion_alcoholica >= ?";
            return ejecutarConsulta(sql, graduacion);
        } catch (DAOException ex) {
            Logger.getLogger(ItemsPedidoDAOSql.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
}
