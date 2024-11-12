
package desarrollo.tpentrega1.dao;
import desarrollo.tpentrega1.entidades.Cliente;

public interface ClienteDAO {

    public void listarCliente();
    public void crearCliente(Cliente cliente);
    public void actualizarCliente(Cliente cliente);
    public void eliminarCliente(String id);
    public Cliente buscarCliente(String id);
}
