package desarrollo.tpentrega1.Memory;

import desarrollo.tpentrega1.dao.ClienteDAO;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ClienteMemory implements ClienteDAO {

    private static List<Cliente> clientes = new ArrayList<>();

    public static List<Cliente> getClientes() {
        return clientes;
    }

//    @Override
//    public void listarCliente() {
//        for (Cliente c : clientes) {
//            System.out.println("ID: " + c.getId() + ", Nombre: " + c.getNombre() + 
//                               ", CUIT: " + c.getCuit() + ", Email: " + c.getEmail() + 
//                               ", Dirección: " + c.getDireccion());
//        }
//    }
    @Override
    public void crearCliente(Cliente cliente) {
        clientes.add(cliente);
        System.out.println("Cliente creado: " + cliente.getNombre());
    }

    @Override
    public void actualizarCliente(Cliente cliente) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId() == cliente.getId()) {
                clientes.set(i, cliente);
                return;
            }
        }
        System.out.println("Cliente no encontrado para actualizar.");
    }

    @Override
    public void eliminarCliente(int id) {
        boolean existe = clientes.stream().anyMatch(c -> c.getId() == (id));
        if (existe) {
            clientes.removeIf(c -> c.getId() == (id));
            System.out.println("Cliente eliminado con ID: " + id);
        }
    }

    @Override
    public Cliente buscarCliente(int id) {
        for (Cliente cliente : clientes) {
            if (cliente.getId() == (id)) {
                return cliente;
            }
        }

        return null;
    }

    @Override
    public Cliente buscarClientePorNombre(String nombre) {
        return clientes.stream().filter(c -> c.getNombre().equals(nombre)).findFirst().orElse(null);
    }

    @Override
    public List<Cliente> obtenerClientes() throws DAOException {
        return clientes;
    }

    

}
