package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.dao.sql.VendedorDAOSql;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendedorController {

    private VendedorDAOSql vendedorDAO= VendedorDAOSql.getInstance();
    
    public VendedorDAOSql getVendedorDAO() {
        return vendedorDAO;
    }


    private static VendedorController instance;
    
    public static VendedorController getInstance() {
        if (instance == null) {
            instance = new VendedorController();
        }
        return instance;
    }

    private VendedorController() {
     
    }
    
    public void crearNuevoVendedor(Vendedor vendedor) throws Exception {
        vendedorDAO.crearVendedor(vendedor);
    }
    
    public void modificarVendedor(Vendedor vendedor) throws Exception {
        vendedorDAO.actualizarVendedor(vendedor);
    }

    public void eliminarVendedor(int id) throws Exception {
        vendedorDAO.eliminarVendedor(id);
    }

    public Vendedor buscarVendedor(int id) throws Exception {
        return vendedorDAO.buscarVendedor(id);
    }
    
    public Vendedor buscarVendedorPorNombre(String nombre) throws Exception {
        return vendedorDAO.buscarVendedorPorNombre(nombre);
    }

    public List<Vendedor> obtenerListaVendedores() throws Exception {
        return vendedorDAO.obtenerVendedores();
    }
    
    public List<ItemMenu> obtenerItemsDeVendedor(Vendedor vendedor) throws Exception{
        return vendedorDAO.obtenerItemsDeVendedor(vendedor);
    }
    
    public boolean obtenerRelacion(int idVendedor, int idItemMenu) throws Exception {
        return vendedorDAO.getVende(idVendedor, idItemMenu);
    }
    
    public void eliminarRelacionConItems(int idVendedor) throws Exception {
        vendedorDAO.eliminarVende(idVendedor);
    }
    
    public void setRelacionConItems(int idVendedor, List<ItemMenu> items) throws Exception {
        for (ItemMenu item : items) {
            vendedorDAO.setVende(idVendedor, item.getId());
        }
        
    }
    

    
}
