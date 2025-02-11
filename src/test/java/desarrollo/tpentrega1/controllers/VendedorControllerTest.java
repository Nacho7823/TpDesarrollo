package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.dao.VendedorDAO;
import desarrollo.tpentrega1.dao.sql.VendedorDAOSql;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class VendedorControllerTest {
    @Mock
    VendedorDAOSql vendedorDAO = VendedorDAOSql.getInstance();
    @InjectMocks
    VendedorController vendedorController = new VendedorController();
        
    public VendedorControllerTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
        for(Vendedor v: vendedorController.obtenerListaVendedores()){
            vendedorController.eliminarVendedor(v);
        }
    }

    @Test
    public void testGetVendedorDAO() {
        VendedorDAOSql expResult = vendedorDAO;
        VendedorDAO result = vendedorController.getVendedorDAO();
        assertEquals(expResult.getClass(), result.getClass());
    }

    @Test
    public void testCrearNuevoVendedor() throws DAOException {
        int id = 1;
        String nombre = "";
        String direccion = "";
        Coordenada coordenada = null;
        Vendedor expResult = new Vendedor(id, nombre, direccion, coordenada);
        Vendedor result = vendedorController.crearNuevoVendedor(id, nombre, direccion, coordenada);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getNombre(), result.getNombre());
        assertEquals(expResult.getCoordenada(), result.getCoordenada());
        assertEquals(expResult.getDireccion(), result.getDireccion());
        Mockito.verify(vendedorDAO).crearVendedor(result);
    }

    @Test
    public void testModificarVendedor_4args() throws DAOException {
        int id = 1;
        String nombre = "";
        String direccion = "";
        Coordenada coordenada = null;
        Vendedor vendedor = new Vendedor(id, nombre, direccion, coordenada);
        vendedorController.modificarVendedor(id, nombre, direccion, coordenada);
        Mockito.verify(vendedorDAO).buscarVendedor(id);

    }

    @Test
    public void testModificarVendedor_Vendedor() throws DAOException {
        Vendedor vendedor = null;
        vendedorController.modificarVendedor(vendedor);
        Mockito.verify(vendedorDAO).actualizarVendedor(vendedor);
    }

    @Test
    public void testEliminarVendedor() throws DAOException {
        Vendedor vendedor = null;
        vendedorController.eliminarVendedor(vendedor);
        Mockito.verify(vendedorDAO).eliminarVendedor(vendedor.getId());
    }

    @Test
    public void testBuscarVendedor() throws DAOException {
        int id = 1;
        Vendedor expResult = null;
        Vendedor result = vendedorController.buscarVendedor(id);
        assertEquals(expResult, result);
        Mockito.verify(vendedorDAO).buscarVendedor(id);
    }

    @Test
    public void testObtenerListaVendedores() throws DAOException {
        List<Vendedor> expResult = new ArrayList();
        List<Vendedor> result = vendedorController.obtenerListaVendedores();
        assertEquals(expResult, result);
        Mockito.verify(vendedorDAO).obtenerVendedores();
    }
    
}
