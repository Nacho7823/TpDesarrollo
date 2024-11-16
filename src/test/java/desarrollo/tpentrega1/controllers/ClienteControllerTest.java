package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.dao.sql.ClienteDAOSql;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.List;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {
    @Mock
    ClienteDAOSql clienteDAO = new ClienteDAOSql();
    @InjectMocks
    ClienteController clienteController = new ClienteController(clienteDAO);
    
    
    public ClienteControllerTest() {
    }

    @org.junit.jupiter.api.BeforeAll
    public static void setUpClass() throws Exception {
    }

    @org.junit.jupiter.api.AfterAll
    public static void tearDownClass() throws Exception {
    }

    @org.junit.jupiter.api.BeforeEach
    public void setUp() throws Exception {
        
    }

    @org.junit.jupiter.api.AfterEach
    public void tearDown() throws Exception {
        if(!(clienteController.obtenerListaClientes()==null)){
            for(Cliente c : clienteController.obtenerListaClientes()){
                clienteController.eliminarCliente(c);
            }
        }
    }
    
    @org.junit.jupiter.api.Test
    public void testCrearNuevoCliente() throws DAOException {
        String id = "";
        String nombre = "";
        String cuit = "";
        String email = "";
        String direccion = "";
        Coordenada coordenada = null;
        Cliente c = new Cliente(id, nombre, cuit, email, direccion, coordenada);
        clienteController.crearNuevoCliente(id, nombre, cuit, email, direccion, coordenada);
        Mockito.verify(clienteDAO).crearCliente(c);
    }

    
    @org.junit.jupiter.api.Test
    public void testModificarCliente() throws DAOException {
        String id = "";
        String nombre = "";
        String cuit = "";
        String email = "";
        String direccion = "";
        Coordenada coordenada = null;
        Cliente c = new Cliente(id, nombre, cuit, email, direccion, coordenada);
        clienteController.modificarCliente(id, nombre, cuit, email, direccion, coordenada);
        Mockito.verify(clienteDAO).actualizarCliente(c);
    }

    @org.junit.jupiter.api.Test
    public void testEliminarCliente() throws DAOException {
        Cliente id = null;
        clienteController.eliminarCliente(id);
        Mockito.verify(clienteDAO).eliminarCliente(id.getId());
    }

    @org.junit.jupiter.api.Test
    public void testBuscarCliente() throws DAOException {
        String id = "";
        Cliente c1 = new Cliente("1", "nombre", "", "", "", null);
        Cliente expResult = null;
        Cliente result1 = clienteController.buscarCliente("1");
        Cliente result = clienteController.buscarCliente(id);
        assertEquals(expResult, result);
        assertEquals(c1, result1);
        Mockito.verify(clienteDAO).buscarCliente(id);
        Mockito.verify(clienteDAO).buscarCliente("1");
    }

    @org.junit.jupiter.api.Test
    public void testObtenerListaClientes() throws DAOException {
        List<Cliente> expResult = null;
        List<Cliente> result = clienteController.obtenerListaClientes();
        assertEquals(expResult, result);
        Mockito.verify(clienteDAO).obtenerClientes();
    }

}
