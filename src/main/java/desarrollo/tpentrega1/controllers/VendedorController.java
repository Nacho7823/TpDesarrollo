package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.dao.CoordenadaDAO;
import desarrollo.tpentrega1.dao.VendedorDAO;
import desarrollo.tpentrega1.dao.sql.CoordenadaDAOSql;
import desarrollo.tpentrega1.dao.sql.VendedorDAOSql;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendedorController {

    private VendedorDAO vendedorDAO= VendedorDAOSql.getInstance();
    private CoordenadaDAO coordenadaDAO = CoordenadaDAOSql.getInstance();
    
//    private ItemMenuController itemMenuController = ItemMenuController.getInstance();
    

    private static VendedorController instance;
    public static VendedorController getInstance() {
        if (instance == null) 
            instance = new VendedorController();
        
        return instance;
    }
    private VendedorController() {
    }
    
    public void crearNuevoVendedor(Vendedor vendedor) {
        try {
            Coordenada coord = vendedor.getCoordenada();
            coordenadaDAO.crearCoordenada(coord);
            vendedorDAO.crearVendedor(vendedor);
            
        } catch (DAOException e) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e.getMessage());
        }
    }
    
    
    public void modificarVendedor(Vendedor vendedor) {
        try {
            coordenadaDAO.actualizarCoordenada(vendedor.getCoordenada());
            vendedorDAO.actualizarVendedor(vendedor);
            
        } catch (DAOException e) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e.getMessage());
        }
    }

    // Eliminar un vendedor por ID
    public void eliminarVendedor(Vendedor vendedor) {
        try {
            coordenadaDAO.eliminarCoordenada(vendedor.getCoordenada().getId_coordenada());
            vendedorDAO.eliminarVendedor(vendedor.getId());
            
        } catch (DAOException e) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e.getMessage());
        }
    }

    // Buscar un vendedor por ID
    public Vendedor buscarVendedor(int id) {
        try {
            Vendedor vendedor = vendedorDAO.buscarVendedor(id);
            Coordenada coord = coordenadaDAO.buscarCoordenada(vendedor.getCoordenada().getId_coordenada());
            vendedor.setCoordenada(coord);
            
            return vendedor;
            
        } catch (DAOException e) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Vendedor> obtenerListaVendedores() {
        try {
            List<Vendedor> vendedores = vendedorDAO.obtenerVendedores();
            
            for (int i = 0; i < vendedores.size(); i++) {
                Vendedor vend = vendedores.get(i);
                Coordenada coord = coordenadaDAO.buscarCoordenada(vend.getCoordenada().getId_coordenada());
                vend.setCoordenada(coord);
                
                vendedores.set(i, vend);
                
            }
            
            return vendedores;
        } catch (DAOException e) {
            Logger.getLogger(ClienteController.class.getName()).log(Level.SEVERE, null, e);
            throw new RuntimeException(e.getMessage());
        }
    }
    
    
    

    
}
