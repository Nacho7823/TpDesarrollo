
package desarrollo.tpentrega1.dao;
import desarrollo.tpentrega1.entidades.Cliente;

public interface ClienteDAO {

    public void listarCliente(Cliente cliente);
    public void crearCliente(Cliente cliente);
    public void actualizarCliente(Cliente cliente);
    public void eliminarCliente(int id);
    public Cliente buscarCliente(int id);
}
