
package desarrollo.tpentrega1.Memory;

import desarrollo.tpentrega1.dao.VendedorDAO;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;

public class VendedorMemory implements VendedorDAO{

    private static List<Vendedor> vendedores = new ArrayList<>();

    public static List<Vendedor> getVendedores() {
        return vendedores;
    }
    
//    @Override
//    public void listarVendedor() {
//        for (Vendedor v : vendedores) {
//            System.out.println("ID: " + v.getId() + ", Nombre: " + v.getNombre() +
//                               ", Dirección: " + v.getDireccion() +
//                               ", Coordenada: " + v.getCoordenada());
//        }
//    }

    @Override
    public void crearVendedor(Vendedor vendedor) {
        vendedores.add(vendedor);
        System.out.println("Vendedor creado: " + vendedor.getNombre());
    }

    @Override
    public void actualizarVendedor(Vendedor vendedor) {
        for (int i = 0; i < vendedores.size(); i++) {
            if (vendedores.get(i).getId() == (vendedor.getId())) {
                vendedores.set(i, vendedor);
                System.out.println("Vendedor actualizado: " + vendedor.getNombre());
                return;
            }
    }
    }

@Override
public void eliminarVendedor(int id) {
    boolean existe = vendedores.stream().anyMatch(v -> v.getId() == id);
    
    if (existe) {
        vendedores.removeIf(v -> v.getId() == (id));
        System.out.println("Vendedor eliminado con ID: " + id);
    }
}

    @Override
    public Vendedor buscarVendedor(int id) {
        for (Vendedor vendedor : vendedores) {
            if (vendedor.getId() == (id)) {
                return vendedor;
               
            }
        }
        
        return null;
       
    }

    @Override
    public List<Vendedor> obtenerVendedores() throws DAOException {
        return vendedores;
    }

    @Override
    public List<ItemMenu> getItemsMenusOfVendedor(Vendedor vendedor) throws DAOException {
        for (Vendedor v : vendedores) {
            if (v.getId() == vendedor.getId()) {
                return vendedor.getItemsMenu();
               
            }
        }
        
        return null;
    }
    
}
