package desarrollo.tpentrega1.dao.sql;


import desarrollo.tpentrega1.dao.VendedorDAO;
import desarrollo.tpentrega1.entidades.Vendedor;
import java.sql.Connection;



public class VendedorDAOSql extends DAO<Vendedor> implements VendedorDAO {
    
    private Connection connection;
    
    public VendedorDAOSql() {
        connection = ConnectionDB.getConnection();
    }

//    @Override
//    public void listarVendedor() {
        /*try {
            guardar(vendedor);
            System.out.println("El vendedor ha sido creado exitosamente");
        } catch (Exception e) {
            System.out.println(e);
            
        }
    }*/          // que es esto???? porque se crea un vendedor con la funcion listar
//    }
    @Override
    public void crearVendedor(Vendedor vendedor) {
        
    }

    @Override
    public void actualizarVendedor(Vendedor vendedor) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public void eliminarVendedor(String id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    @Override
    public Vendedor buscarVendedor(String id) {
        throw new UnsupportedOperationException("Not supported yet."); 
    }

    
    // por que hay funciones iguales??
    public void eliminarVendedor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public Vendedor buscarVendedor(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
