package desarrollo.tpentrega1.dao;

import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.List;

public interface VendedorDAO {

    public void crearVendedor(Vendedor vendedor) throws DAOException;

    public void actualizarVendedor(Vendedor vendedor) throws DAOException;

    public void eliminarVendedor(int id) throws DAOException;

    public Vendedor buscarVendedor(int id) throws DAOException;
    
    public List<Vendedor> obtenerVendedores() throws DAOException;
    
    public List<ItemMenu> obtenerItemsDeVendedor(Vendedor vendedor) throws DAOException;
    
    public Vendedor buscarVendedorPorNombre(String nombre) throws DAOException;
    
    public void setVende(int v, int i) throws DAOException;
    
    public void eliminarVende(int v) throws DAOException;
    
    public List<ItemMenu> getVendeList(int v) throws DAOException;
    
    public boolean getVende(int v, int i) throws DAOException;
    
}
