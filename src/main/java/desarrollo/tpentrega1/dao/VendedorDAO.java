
package desarrollo.tpentrega1.dao;
import desarrollo.tpentrega1.entidades.Vendedor;

public interface VendedorDAO {
    
public void listarVendedor(Vendedor vendedor);
public void crearVendedor(Vendedor vendedor);
public void actualizarVendedor(Vendedor vendedor);
public void eliminarVendedor(int id);
public Vendedor buscarVendedor(int id);
}
