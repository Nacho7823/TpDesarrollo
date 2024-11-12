package desarrollo.tpentrega1.dao.sql;


import desarrollo.tpentrega1.dao.VendedorDAO;
import desarrollo.tpentrega1.entidades.Vendedor;



public class VendedorDAOSql extends DAO<Vendedor> implements VendedorDAO {

    @Override
    public void listarVendedor(Vendedor vendedor) {
        try {
            guardar(vendedor);
            System.out.println("El vendedor ha sido creado exitosamente");
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }

    @Override
    public void crearVendedor(Vendedor vendedor) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void actualizarVendedor(Vendedor vendedor) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void eliminarVendedor(String id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public Vendedor buscarVendedor(String id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    public void eliminarVendedor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Vendedor buscarVendedor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
