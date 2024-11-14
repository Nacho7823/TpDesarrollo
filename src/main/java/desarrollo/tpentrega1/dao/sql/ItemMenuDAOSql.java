package desarrollo.tpentrega1.dao.sql;

import desarrollo.tpentrega1.dao.ItemsMenuDAO;
import desarrollo.tpentrega1.dao.VendedorDAO;
import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Plato;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ItemMenuDAOSql extends DAO<ItemMenu> implements ItemsMenuDAO {

    @Override
    public void crearItemMenu(ItemMenu itemMenu) throws DAOException {
        if (itemMenu instanceof Bebida) {
            pcrearBebida(((Bebida) itemMenu));
        } else {
            pcrearPlato(((Plato) itemMenu));
        }
    }

    public void pcrearItemMenu(ItemMenu itemMenu) throws DAOException {
        String sql = "INSERT INTO item_menu (id_item_menu, nombre, descripcion, precio, categoria, id_vendedor) VALUES (?, ?, ?, ?, ?, ?)";
        try {

            insertarModificarEliminar(sql,
                    itemMenu.getId(),
                    itemMenu.getNombre(),
                    itemMenu.getDescripcion(),
                    itemMenu.getPrecio(),
                    itemMenu.getCategoria(),
                    itemMenu.getVendedor().getId());

        } catch (Exception ex) {
            throw new DAOException("no se pudo crear el item_menu: \n" + ex.getMessage());
        }

    }

    public void pcrearBebida(Bebida bebida) throws DAOException {

        String sql = "INSERT INTO bebida (id_item_menu, graduacion_alcoholica, tamanio) VALUES (?, ?, ?)";
        try {

            insertarModificarEliminar(sql,
                    bebida.getId(),
                    bebida.getGraduacionAlcoholica(),
                    bebida.getTamaño());

        } catch (Exception ex) {
            throw new DAOException("no se pudo crear la bebida: \n" + ex.getMessage());
        }
        pcrearItemMenu(bebida);
    }

    public void pcrearPlato(Plato plato) throws DAOException {

        String sql = "INSERT INTO plato (id_item_menu, calorias, apto_celiaco, apto_vegano, peso) VALUES (?, ?, ?, ?, ?)";
        try {

            insertarModificarEliminar(sql,
                    plato.getId(),
                    plato.getCalorias(),
                    plato.aptoCeliaco(),
                    plato.aptoVegano(),
                    plato.peso());

        } catch (Exception ex) {
            throw new DAOException("no se pudo crear la plato: \n" + ex.getMessage());
        }
        pcrearItemMenu(plato);
    }

    @Override
    public void actualizarItemMenu(ItemMenu itemMenu) throws DAOException {
        if (itemMenu instanceof Bebida) {
            pactualizarBebida(((Bebida) itemMenu));
        } else {
            pactualizarPlato(((Plato) itemMenu));
        }
    }

    public void pactualizarItemMenu(ItemMenu itemMenu) throws DAOException {

        String sql = "UPDATE item_menu SET nombre = ?, descripcion = ?, precio = ?, categoria = ?, id_vendedor = ? WHERE id_item_menu = ?";

        try {

            insertarModificarEliminar(sql,
                    itemMenu.getNombre(),
                    itemMenu.getDescripcion(),
                    itemMenu.getPrecio(),
                    itemMenu.getCategoria(),
                    itemMenu.getVendedor().getId());

        } catch (Exception ex) {
            throw new DAOException("no se pudo actualizar el item_menu: \n" + ex.getMessage());
        }
    }

    public void pactualizarBebida(Bebida bebida) throws DAOException {
        String sql = "UPDATE bebida SET graduacion_alcoholica = ?, tamanio = ? WHERE id_item_menu = ?";

        try {
            insertarModificarEliminar(sql,
                    bebida.getGraduacionAlcoholica(),
                    bebida.getTamaño(),
                    bebida.getId());

        } catch (Exception ex) {
            throw new DAOException("no se pudo actualizar la bebida: \n" + ex.getMessage());
        }
        pactualizarItemMenu(bebida);
    }

    public void pactualizarPlato(Plato plato) throws DAOException {

        // id_item_menu, calorias, apto_celiaco, apto_vegano, peso
        String sql = "UPDATE plato SET calorias = ?, apto_celiaco = ?, apto_vegano = ?, peso = ? WHERE id_item_menu = ?";

        try {
            insertarModificarEliminar(sql,
                    plato.getCalorias(),
                    plato.aptoCeliaco(),
                    plato.aptoVegano(),
                    plato.peso(),
                    plato.getId());

        } catch (Exception ex) {
            throw new DAOException("no se pudo actualizar el plato: \n" + ex.getMessage());
        }
        pactualizarItemMenu(plato);
    }

    @Override
    public void eliminarItemMenu(ItemMenu itemMenu) throws DAOException {
        if (itemMenu instanceof Bebida) {
            peliminarBebida(((Bebida) itemMenu));
        } else {
            peliminarPlato(((Plato) itemMenu));
        }
    }

    public void peliminarItemMenu(ItemMenu itemMenu) throws DAOException {

        String sql = "DELETE FROM item_menu WHERE id_item_menu = ?";

        try {

            insertarModificarEliminar(sql, itemMenu.getId());

        } catch (Exception ex) {
            throw new DAOException("no se pudo eliminar el itemMenu: \n" + ex.getMessage());
        }
    }

    public void peliminarBebida(Bebida bebida) throws DAOException {

        String sql = "DELETE FROM bebida WHERE id_item_menu = ?";

        try {
            insertarModificarEliminar(sql, bebida.getId());

        } catch (Exception ex) {
            throw new DAOException("no se pudo eliminar la bebida: \n" + ex.getMessage());
        }
        peliminarItemMenu(bebida);
    }

    public void peliminarPlato(Plato plato) throws DAOException {

        String sql = "DELETE FROM plato WHERE id_item_menu = ?";

        try {
            insertarModificarEliminar(sql, plato.getId());

        } catch (Exception ex) {
            throw new DAOException("no se pudo eliminar el plato: \n" + ex.getMessage());
        }
        peliminarItemMenu(plato);
    }

    @Override
    public ItemMenu buscarItemMenu(String id, VendedorDAO vdao) throws DAOException {
        Bebida bebida = pbuscarBebida(id);
        if (bebida != null) {
            ItemMenu item = pbuscarItemMenu(id, vdao);
            bebida.setNombre(item.getId());
            bebida.setDescripcion(item.getDescripcion());
            bebida.setPrecio(item.getPrecio());
            bebida.setDescripcion(item.getCategoria());
            bebida.setVendedor(item.getVendedor());
            return bebida;
            
        } 
        Plato plato = pbuscarPlato(id);
        if(plato != null) {
            ItemMenu item = pbuscarItemMenu(id, vdao);
            plato.setNombre(item.getId());
            plato.setDescripcion(item.getDescripcion());
            plato.setPrecio(item.getPrecio());
            plato.setDescripcion(item.getCategoria());
            plato.setVendedor(item.getVendedor());
            return plato;
        }
        return pbuscarItemMenu(id, vdao);
    }
    //bebida (id_item_menu, graduacion_alcoholica, tamanio)
    //plato (id_item_menu, calorias, apto_celiaco, apto_vegano, peso)

    public ItemMenu pbuscarItemMenu(String id, VendedorDAO vdao) throws DAOException {
        
        String sql = "SELECT nombre, descripcion, precio, categoria, id_vendedor FROM item_menu WHERE id_item_menu = ?";
        ItemMenu itemMenu = null;

        try {
            ConectarBase();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(id));
            resultado = preparedStatement.executeQuery();

            if (resultado.next()) {

                String nombre = resultado.getString("nombre");
                String descripcion = resultado.getString("descripcion");
                double precio = resultado.getDouble("precio");
                String categoria = resultado.getString("categoria");
                int id_vendedor = resultado.getInt("id_vendedor");

                Vendedor v = vdao.buscarVendedor(String.valueOf(id_vendedor));

                itemMenu = new ItemMenu(
                        id,
                        nombre,
                        descripcion,
                        precio,
                        categoria,
                        v) {
                    @Override
                    public boolean esComida() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public boolean esBebida() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public boolean aptoVegano() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public double peso() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }
                };

                // TODO: add items menu
            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DAOException("No se pudo buscar el itemMenu: \n" + ex.getMessage());
        } finally {
            try {
                desconectarBase();
            } catch (Exception e) {
                throw new DAOException("Error al desconectar la base de datos: " + e.getMessage());
            }
        }

        return itemMenu;

    }

    public Bebida pbuscarBebida(String id) throws DAOException {
        
        String sql = "SELECT graduacion_alcoholica, tamanio FROM bebida WHERE id_item_menu = ?";
        Bebida bebida = null;

        try {
            ConectarBase();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(id));
            resultado = preparedStatement.executeQuery();

            if (resultado.next()) {

                double graduacion_alcoholica = resultado.getDouble("graduacion_alcoholica");
                double tamanio = resultado.getDouble("tamanio");
                
                bebida = new Bebida(graduacion_alcoholica, tamanio);
                bebida.setId(id);
                // TODO: add items menu
            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DAOException("No se pudo buscar la bebida: \n" + ex.getMessage());
        } finally {
            try {
                desconectarBase();
            } catch (Exception e) {
                throw new DAOException("Error al desconectar la base de datos: " + e.getMessage());
            }
        }

        return bebida;

    }

    public Plato pbuscarPlato(String id) throws DAOException {
        
        String sql = "SELECT calorias, apto_celiaco, apto_vegano, peso FROM plato WHERE id_item_menu = ?";
        Plato plato = null;

        try {
            ConectarBase();
            PreparedStatement preparedStatement = conexion.prepareStatement(sql);
            preparedStatement.setInt(1, Integer.parseInt(id));
            resultado = preparedStatement.executeQuery();

            if (resultado.next()) {

                double calorias = resultado.getDouble("calorias");
                boolean apto_celiaco = resultado.getBoolean("apto_celiaco");
                boolean apto_vegano = resultado.getBoolean("apto_vegano");
                double peso = resultado.getDouble("peso");
                
                plato = new Plato(calorias, apto_celiaco, apto_vegano, peso);
                plato.setId(id);
                // TODO: add items menu
            }

            preparedStatement.close();
        } catch (SQLException | ClassNotFoundException ex) {
            throw new DAOException("No se pudo buscar el plato: \n" + ex.getMessage());
        } finally {
            try {
                desconectarBase();
            } catch (Exception e) {
                throw new DAOException("Error al desconectar la base de datos: " + e.getMessage());
            }
        }

        return plato;

    }

    
    @Override
    public List<ItemMenu> obtenerItemMenus(VendedorDAO vdao) throws DAOException {
        List<ItemMenu> list = pobtenerItemMenus(vdao);
        
        for (int i = 0; i < list.size(); i++) {
            ItemMenu currentItem = list.get(i);
            Bebida bebida = pbuscarBebida(currentItem.getId());
            
            if (bebida != null) {
                bebida.setNombre(currentItem.getId());
                bebida.setDescripcion(currentItem.getDescripcion());
                bebida.setPrecio(currentItem.getPrecio());
                bebida.setDescripcion(currentItem.getCategoria());
                bebida.setVendedor(currentItem.getVendedor());
                
                list.set(i, bebida);
                continue;
            }
            
            Plato plato = pbuscarPlato(currentItem.getId());
            
            if (plato != null) {
                plato.setNombre(currentItem.getId());
                plato.setDescripcion(currentItem.getDescripcion());
                plato.setPrecio(currentItem.getPrecio());
                plato.setDescripcion(currentItem.getCategoria());
                plato.setVendedor(currentItem.getVendedor());
                
                list.set(i, plato);
                continue;
            }
        }
        
        return list;
    }
    
    
    public List<ItemMenu> pobtenerItemMenus(VendedorDAO vdao) throws DAOException {

        String sql = "SELECT id_item_menu, nombre, descripcion, precio, categoria, id_vendedor FROM item_menu";
        List<ItemMenu> listaItemMenus = new ArrayList<>();

        try {
            consultarBase(sql);

            while (resultado.next()) {
                String id_item_menu = resultado.getString("id_item_menu");
                String nombre = resultado.getString("nombre");
                String descripcion = resultado.getString("descripcion");
                double precio = resultado.getDouble("precio");
                String categoria = resultado.getString("categoria");
                int id_vendedor = resultado.getInt("id_vendedor");

                Vendedor v = vdao.buscarVendedor(String.valueOf(id_vendedor));

                ItemMenu itemMenu = new ItemMenu(
                        id_item_menu,
                        nombre,
                        descripcion,
                        precio,
                        categoria,
                        v) {
                    @Override
                    public boolean esComida() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public boolean esBebida() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public boolean aptoVegano() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }

                    @Override
                    public double peso() {
                        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
                    }
                };

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
