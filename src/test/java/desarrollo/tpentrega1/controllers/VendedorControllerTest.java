package desarrollo.tpentrega1.controllers;

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
    VendedorDAOSql vendedorDAOSql = new VendedorDAOSql();
    @InjectMocks
    VendedorController vendedorController = new VendedorController(vendedorDAOSql);
        
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
        VendedorDAOSql expResult = new VendedorDAOSql();
        VendedorDAOSql result = vendedorController.getVendedorDAO();
        assertEquals(expResult.getClass(), result.getClass());
    }

    @Test
    public void testCrearNuevoVendedor() throws DAOException {
        String id = "1";
        String nombre = "";
        String direccion = "";
        Coordenada coordenada = null;
        Vendedor expResult = new Vendedor(id, nombre, direccion, coordenada);
        Vendedor result = vendedorController.crearNuevoVendedor(id, nombre, direccion, coordenada);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getNombre(), result.getNombre());
        assertEquals(expResult.getCoordenada(), result.getCoordenada());
        assertEquals(expResult.getDireccion(), result.getDireccion());
        Mockito.verify(vendedorDAOSql).crearVendedor(result);
    }

    @Test
    public void testModificarVendedor_4args() throws DAOException {
        String id = "";
        String nombre = "";
        String direccion = "";
        Coordenada coordenada = null;
        Vendedor vendedor = new Vendedor(id, nombre, direccion, coordenada);
        vendedorController.modificarVendedor(id, nombre, direccion, coordenada);
        Mockito.verify(vendedorDAOSql).buscarVendedor(id);
    }

    @Test
    public void testModificarVendedor_Vendedor() throws DAOException {
        Vendedor vendedor = null;
        vendedorController.modificarVendedor(vendedor);
        Mockito.verify(vendedorDAOSql).actualizarVendedor(vendedor);
    }

    @Test
    public void testEliminarVendedor() throws DAOException {
        Vendedor vendedor = null;
        vendedorController.eliminarVendedor(vendedor);
        Mockito.verify(vendedorDAOSql).eliminarVendedor(vendedor);
    }

    @Test
    public void testBuscarVendedor() throws DAOException {
        String id = "";
        Vendedor expResult = null;
        Vendedor result = vendedorController.buscarVendedor(id);
        assertEquals(expResult, result);
        Mockito.verify(vendedorDAOSql).buscarVendedor(id);
    }

    @Test
    public void testObtenerListaVendedores() throws DAOException {
        List<Vendedor> expResult = new ArrayList();
        List<Vendedor> result = vendedorController.obtenerListaVendedores();
        assertEquals(expResult, result);
        Mockito.verify(vendedorDAOSql).obtenerVendedores();
    }
    
}
