
package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.Memory.VendedorMemory;
import desarrollo.tpentrega1.entidades.Coordenada;
import java.util.List;
import java.util.UUID;

public class VendedorController {
    private VendedorMemory vendedorDAO = new VendedorMemory();

    public VendedorController(VendedorMemory vendedorMemory) {
       this.vendedorDAO=vendedorMemory;
    }

    // Mostrar la lista de todos los vendedores
    public void mostrarListaVendedor() {
        System.out.println("Lista de Vendedores:");
        vendedorDAO.listarVendedor(null); // null porque el método listarVendedor no necesita un parámetro
    }

    // Crear un nuevo vendedor con generación automática de ID
    public void crearNuevoVendedor(String id,String nombre, String direccion, Coordenada coordenada) {
        //String id = UUID.randomUUID().toString(); // Generación automática de ID
        Vendedor nuevoVendedor = new Vendedor(id, nombre, direccion, coordenada);
        vendedorDAO.crearVendedor(nuevoVendedor);
    }

    // Modificar un vendedor existente (asumiendo que se identifica por nombre, dirección, coordenada)
    public void modificarVendedor(String id, String nombre, String direccion, Coordenada coordenada) {
        Vendedor vendedorExistente = vendedorDAO.buscarVendedor(id);
        if (vendedorExistente != null) {
            vendedorExistente.setNombre(nombre);
            vendedorExistente.setDireccion(direccion);
            vendedorExistente.setCoordenada(coordenada);
            vendedorDAO.actualizarVendedor(vendedorExistente);
            System.out.println("Vendedor modificado: " + nombre);
        } else {
            System.out.println("Vendedor no encontrado para modificar.");
        }
    }
    
    public void modificarVendedor(Vendedor vendedor) {
        vendedorDAO.actualizarVendedor(vendedor);
    }

    // Eliminar un vendedor por ID
    public void eliminarVendedor(String id) {
        vendedorDAO.eliminarVendedor(id);
    }

    // Buscar un vendedor por ID
    public Vendedor buscarVendedor(String id) {
        Vendedor vendedor = vendedorDAO.buscarVendedor(id);
        if (vendedor != null) {
            System.out.println("Vendedor encontrado: " + vendedor.getNombre());
            return vendedor;
        } else {
            System.out.println("Vendedor no encontrado con ID " + id);
            return null;
        }
    }

    public List<Vendedor> obtenerListaVendedores() {
        return vendedorDAO.getVendedores();
    }
}
