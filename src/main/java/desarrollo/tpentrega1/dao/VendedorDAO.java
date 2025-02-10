package desarrollo.tpentrega1.dao;

import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.List;

public interface VendedorDAO {

    public void crearVendedor(Vendedor vendedor) throws DAOException;

    public void actualizarVendedor(Vendedor vendedor) throws DAOException;

    public void eliminarVendedor(Vendedor vendedor) throws DAOException;

    public Vendedor buscarVendedor(String id) throws DAOException;
    
    public List<Vendedor> obtenerVendedores() throws DAOException;
    
    public List<ItemMenu> obtenerItemsDeVendedor(Vendedor vendedor) throws DAOException;
    
    public Vendedor buscarVendedorPorNombre(String nombre) throws DAOException;
    
}
