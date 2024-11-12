
package desarrollo.tpentrega1.dao;
import desarrollo.tpentrega1.entidades.Vendedor;

public interface VendedorDAO {
    
public void listarVendedor();
public void crearVendedor(Vendedor vendedor);
public void actualizarVendedor(Vendedor vendedor);
public void eliminarVendedor(String id);
public Vendedor buscarVendedor(String id);
}
