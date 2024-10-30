
package desarrollo.tpentrega1.Memory;
import desarrollo.tpentrega1.dao.ClienteDAO;

import desarrollo.tpentrega1.dao.ClienteDAO;
import desarrollo.tpentrega1.entidades.Cliente;
import java.util.ArrayList;
import java.util.List;

public class ClienteMemory implements ClienteDAO{
    
private static List<Cliente> clientes = new ArrayList<>();

    public static List<Cliente> getClientes() {
        return clientes;
    }

    @Override
    public void listarCliente(Cliente cliente) {
        for (Cliente c : clientes) {
            System.out.println("ID: " + c.getId() + ", Nombre: " + c.getNombre() + 
                               ", CUIT: " + c.getCuit() + ", Email: " + c.getEmail() + 
                               ", Dirección: " + c.getDireccion());
        }
    }

    @Override
    public void crearCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente creado: " + cliente.getNombre());
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(cliente.getId())) {
                clientes.set(i, cliente);
               
                return;
            }
        }
        System.out.println("Cliente no encontrado para actualizar.");
    }

    @Override
    public void eliminarCliente(int id) {
        clientes.removeIf(c -> c.getId().equals(String.valueOf(id)));
        System.out.println("Cliente eliminado con ID: " + id);
    }

    @Override
    public Cliente buscarCliente(int id) {
         for (Cliente cliente : clientes) {
            if (cliente.getId().equals(String.valueOf(id))) {
                
                return cliente;
            }
        }
        
        return null;
    }
    
    
}
