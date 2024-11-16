package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.ItemsMenuDAO;
import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Plato;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ItemMenuDAOSql extends DAO<ItemMenu> implements ItemsMenuDAO {
     
    private static ItemMenuDAOSql instance = null;
    
    public static ItemMenuDAOSql getInstance(){
        if(instance == null) instance =  new ItemMenuDAOSql();
        return instance;
    }
        
        
    @Override
    public void crearItemMenu(ItemMenu itemMenu) throws DAOException {
        String sql = "INSERT INTO item_menu (nombre, descripcion, precio, categoria) VALUES (?, ?, ?, ?)";
         try (PreparedStatement stmt = conexion.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            ConectarBase();
            stmt.setString(1, itemMenu.getNombre());
            stmt.setString(2, itemMenu.getDescripcion());
            stmt.setDouble(3, itemMenu.getPrecio());
            stmt.setString(4, itemMenu.getCategoria());
        
            stmt.executeUpdate();
            
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    int idItemMenu = generatedKeys.getInt(1);
                    
                   itemMenu.setId(String.valueOf(idItemMenu));
                    
                }
                }
                    
                } catch (Exception ex) {
            throw new DAOException("no se pudo crear el ItemMenu: \n" + ex.getMessage());
        }
                if (itemMenu instanceof Bebida) {
            crearBebida((Bebida) itemMenu);
        } else {
            crearPlato((Plato) itemMenu);
        }
    }

    public void crearBebida(Bebida bebida) throws DAOException {

        String sql = "INSERT INTO bebida (id_item_menu, graduacion_alcoholica, tamanio) VALUES (?, ?, ?)";
        try {

            insertarModificarEliminar(sql,
                    Integer.valueOf(bebida.getId()),
                    bebida.getGraduacionAlcoholica(),
                    bebida.getTamaño());

        } catch (Exception ex) {
            throw new DAOException("no se pudo crear la bebida: \n" + ex.getMessage());
        }
    }

    public void crearPlato(Plato plato) throws DAOException {

        String sql = "INSERT INTO plato (id_item_menu, calorias, apto_celiaco, apto_vegano, peso) VALUES (?, ?, ?, ?, ?)";
        try {

            insertarModificarEliminar(sql,
                    Integer.valueOf(plato.getId()),
                    plato.getCalorias(),
                    plato.aptoCeliaco(),
                    plato.aptoVegano(),
                    plato.peso());

        } catch (Exception ex) {
            throw new DAOException("no se pudo crear el plato: \n" + ex.getMessage());
        }
    }

    
    @Override
    public void actualizarItemMenu(ItemMenu itemMenu) throws DAOException {

        String sql = "UPDATE item_menu SET nombre = ?, descripcion = ?, precio = ?, categoria = ? WHERE id_item_menu = ?";

        try {

            insertarModificarEliminar(sql,
                    itemMenu.getNombre(),
                    itemMenu.getDescripcion(),
                    itemMenu.getPrecio(),
                    itemMenu.getCategoria(),
                    Integer.valueOf(itemMenu.getId()));

        } catch (Exception ex) {
            throw new DAOException("no se pudo actualizar el item_menu: \n" + ex.getMessage());
        }
                if (itemMenu instanceof Bebida) {
            actualizarBebida(((Bebida) itemMenu));
        } else {
            actualizarPlato(((Plato) itemMenu));
        }
    }

    public void actualizarBebida(Bebida bebida) throws DAOException {
        String sql = "UPDATE bebida SET graduacion_alcoholica = ?, tamanio = ? WHERE id_item_menu = ?";

        try {
            insertarModificarEliminar(sql,
                    bebida.getGraduacionAlcoholica(),
                    bebida.getTamaño(),
                    Integer.parseInt(bebida.getId()));

        } catch (Exception ex) {
            throw new DAOException("no se pudo actualizar la bebida: \n" + ex.getMessage());
        }
    }

    public void actualizarPlato(Plato plato) throws DAOException {

        String sql = "UPDATE plato SET calorias = ?, apto_celiaco = ?, apto_vegano = ?, peso = ? WHERE id_item_menu = ?";

        try {
            insertarModificarEliminar(sql,
                    plato.getCalorias(),
                    plato.aptoCeliaco(),
                    plato.aptoVegano(),
                    plato.peso(),
                    Integer.parseInt(plato.getId()));

        } catch (Exception ex) {
            throw new DAOException("no se pudo actualizar el plato: \n" + ex.getMessage());
        }
    }

    @Override
    public void eliminarItemMenu(String id) throws DAOException {

        String sql = "DELETE FROM item_menu WHERE id_item_menu = ?";

        try {
            insertarModificarEliminar(sql, Integer.valueOf(id));
        } catch (Exception ex) {
            throw new DAOException("no se pudo eliminar el itemMenu: \n" + ex.getMessage());
        }
    }

    @Override
    public ItemMenu buscarItemMenu(String id) throws DAOException {
        
        String sql = "SELECT * FROM item_menu I LEFT JOIN bebida B ON I.id_item_menu=B.id_item_menu LEFT JOIN plato P ON"
                + " I.id_item_menu=P.id_item_menu WHERE I.id_item_menu= ?";
        ItemMenu itemMenu = null;

         try {
            ConectarBase();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(id));
            resultado = preparedStatement.executeQuery();

            if(resultado.next()) {
                String nombre = resultado.getString("nombre");
                String descripcion = resultado.getString("descripcion");
                double precio = resultado.getDouble("precio");
                String categoria = resultado.getString("categoria");
                
                
                if(categoria.equalsIgnoreCase("bebida")){
                    double tamaño= resultado.getDouble("tamanio");
                    double graduacionAlcoholica= resultado.getDouble("graduacion_alcoholica");
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
                else if(categoria.equalsIgnoreCase("plato")){
                    double calorias= resultado.getDouble("calorias");
                    boolean aptoCeliaco=resultado.getBoolean("apto_celiaco");
                    boolean aptoVegano=resultado.getBoolean("apto_vegano");
                    double peso= resultado.getDouble("peso");
                    itemMenu= new Plato.Builder()
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
            }
        } catch (Exception ex) {
            throw new DAOException("No se pudo obtener los itemMenu: \n" + ex.getMessage());
        } finally {
            try {

                desconectarBase();
            } catch (Exception e) {
                throw new DAOException("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return itemMenu;

    }
 
    
    @Override
    public List<ItemMenu> obtenerItemsMenuDeVendedor(String id) throws DAOException {

       String sql = "SELECT * FROM item_menu I "
                + "LEFT JOIN bebida B ON I.id_item_menu = B.id_item_menu "
                + "LEFT JOIN plato P ON I.id_item_menu = P.id_item_menu "
                + "WHERE EXISTS (SELECT 1 FROM vende V WHERE V.id_item_menu = I.id_item_menu "
                + "AND V.id_vendedor = ?)";

        List<ItemMenu> listaItemMenus = new ArrayList<>();

        try {
            ConectarBase();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setString(1, id);
            resultado = preparedStatement.executeQuery();

            while (resultado.next()) {
                String id_item_menu = String.valueOf(resultado.getInt("id_item_menu"));
                String nombre = resultado.getString("nombre");
                String descripcion = resultado.getString("descripcion");
                double precio = resultado.getDouble("precio");
                String categoria = resultado.getString("categoria");
                
                ItemMenu itemMenu= null;
                
                if(categoria.equalsIgnoreCase("bebida")){
                    double tamaño= resultado.getDouble("tamanio");
                    double graduacionAlcoholica= resultado.getDouble("graduacion_alcoholica");
                itemMenu = new Bebida.Builder()
                        .id(id_item_menu)
                        .nombre(nombre)
                        .descripcion(descripcion)
                        .precio(precio)
                        .categoria(categoria)
                        .graduacionAlcoholica(graduacionAlcoholica)
                        .tamaño(tamaño)
                        .build(); 
                }
                else if(categoria.equalsIgnoreCase("plato")){
                    double calorias= resultado.getDouble("calorias");
                    boolean aptoCeliaco=resultado.getBoolean("apto_celiaco");
                    boolean aptoVegano=resultado.getBoolean("apto_vegano");
                    double peso= resultado.getDouble("peso");
                    itemMenu= new Plato.Builder()
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
        } catch (Exception ex) {
            throw new DAOException("No se pudo obtener los itemMenu: \n" + ex.getMessage());
        } finally {
            try {

                desconectarBase();
            } catch (Exception e) {
                throw new DAOException("Error al cerrar la conexión: " + e.getMessage());
            }
        }

        return listaItemMenus;
    }
}
