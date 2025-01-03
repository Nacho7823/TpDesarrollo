package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.dao.sql.VendedorDAOSql;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class VendedorController {

    private VendedorDAOSql vendedorDAO= VendedorDAOSql.getInstance();
    
    public VendedorDAOSql getVendedorDAO() {
        return vendedorDAO;
    }


    public VendedorController() {

    }
    
    public Vendedor crearNuevoVendedor(String id, String nombre, String direccion, Coordenada coordenada) {
        Vendedor nuevoVendedor = new Vendedor(id, nombre, direccion, coordenada);
        try {
            vendedorDAO.crearVendedor(nuevoVendedor);
        } catch (DAOException ex) {
            Logger.getLogger(VendedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevoVendedor;
    }
    
    public Vendedor crearNuevoVendedor(String nombre, String direccion, Coordenada coordenada) {
        Vendedor nuevoVendedor = new Vendedor(nombre, direccion, coordenada);
        try {
            vendedorDAO.crearVendedor(nuevoVendedor);
        } catch (DAOException ex) {
            Logger.getLogger(VendedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nuevoVendedor;
    }
    
// Modificar un vendedor existente (asumiendo que se identifica por nombre, dirección, coordenada)
    public void modificarVendedor(String id, String nombre, String direccion, Coordenada coordenada) {
        Vendedor vendedorExistente;
        try {
            vendedorExistente = vendedorDAO.buscarVendedor(id);
            if (vendedorExistente != null) {
                vendedorExistente.setNombre(nombre);
                vendedorExistente.setDireccion(direccion);
                vendedorExistente.setCoordenada(coordenada);
                vendedorDAO.actualizarVendedor(vendedorExistente);
                System.out.println("Vendedor modificado: " + nombre);
            } else {
                System.out.println("Vendedor no encontrado para modificar.");
            }
        } catch (DAOException ex) {
            Logger.getLogger(VendedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void modificarVendedor(Vendedor vendedor) {
        try {
            vendedorDAO.actualizarVendedor(vendedor);
        } catch (DAOException ex) {
            Logger.getLogger(VendedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Eliminar un vendedor por ID
    public void eliminarVendedor(Vendedor vendedor) {
        try {
            vendedorDAO.eliminarVendedor(vendedor);
        } catch (DAOException ex) {
            Logger.getLogger(VendedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Buscar un vendedor por ID
    public Vendedor buscarVendedor(String id) {
        try {
        Vendedor vendedor = vendedorDAO.buscarVendedor(id);
        if (vendedor != null) {
            System.out.println("Vendedor encontrado: " + vendedor.getNombre());
            return vendedor;
        } else {
            System.out.println("Vendedor no encontrado con ID " + id);
            return null;
        }
        } catch(Exception e){
            System.out.println("" + e.getMessage());
        }
        return null;
    }
    
    public Vendedor buscarVendedorPorNombre(String nombre) {
        try {
        Vendedor vendedor = vendedorDAO.buscarVendedorPorNombre(nombre);
        if (vendedor != null) {
            System.out.println("Vendedor encontrado: " + vendedor.getNombre());
            return vendedor;
        } else {
            System.out.println("Vendedor no encontrado con nombre " + nombre);
            return null;
        }
        } catch(Exception e){
            System.out.println("" + e.getMessage());
        }
        return null;
    }

    public List<Vendedor> obtenerListaVendedores() {
        try {
            return vendedorDAO.obtenerVendedores();
        } catch (DAOException ex) {
            Logger.getLogger(VendedorController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

    
}
