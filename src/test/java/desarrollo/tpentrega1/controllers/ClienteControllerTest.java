package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.dao.sql.ClienteDAOSql;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.exceptions.DAOException;
import java.util.ArrayList;
import java.util.List;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;

@ExtendWith(MockitoExtension.class)
public class ClienteControllerTest {
    @Mock
    ClienteDAOSql clienteDAO = new ClienteDAOSql();
    @Captor
    ArgumentCaptor<Cliente> clienteCaptor;
    @InjectMocks
    ClienteController clienteController = new ClienteController();
    
    
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
        Cliente result = clienteController.crearNuevoCliente(id, nombre, cuit, email, direccion, coordenada);
        assertEquals(c.getCoordenada(), result.getCoordenada());
        assertEquals(c.getCuit(), result.getCuit());
        assertEquals(c.getDireccion(), result.getDireccion());
        assertEquals(c.getEmail(), result.getEmail());
        assertEquals(c.getId(), result.getId());
        assertEquals(c.getNombre(), result.getNombre());
        Mockito.verify(clienteDAO).crearCliente(result);
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
        clienteController.crearNuevoCliente(id, nombre, cuit, email, direccion, coordenada);
        clienteController.modificarCliente(id, nombre, cuit, email, direccion, coordenada);
        Mockito.verify(clienteDAO).crearCliente(clienteCaptor.capture());
        Cliente result = clienteCaptor.getValue();
        assertEquals(c.getCoordenada(), result.getCoordenada());
        assertEquals(c.getCuit(), result.getCuit());
        assertEquals(c.getDireccion(), result.getDireccion());
        assertEquals(c.getEmail(), result.getEmail());
        assertEquals(c.getId(), result.getId());
        assertEquals(c.getNombre(), result.getNombre());
    }

    @org.junit.jupiter.api.Test
    public void testEliminarCliente() throws DAOException {
        String id = "";
        String nombre = "";
        String cuit = "";
        String email = "";
        String direccion = "";
        Coordenada coordenada = null;
        Cliente c = new Cliente(id, nombre, cuit, email, direccion, coordenada);
        clienteController.crearNuevoCliente(id, nombre, cuit, email, direccion, coordenada);
        clienteController.eliminarCliente(c);
        Mockito.verify(clienteDAO).eliminarCliente(id);
    }

    @org.junit.jupiter.api.Test
    public void testBuscarCliente() throws DAOException {
        clienteController.crearNuevoCliente("1", "nombre", "", "", "", null);
        clienteController.buscarCliente("1");
        Mockito.verify(clienteDAO).buscarCliente("1");
    }

    @org.junit.jupiter.api.Test
    public void testObtenerListaClientes() throws DAOException {
        List<Cliente> expResult = new ArrayList();
        List<Cliente> result = clienteController.obtenerListaClientes();
        assertEquals(expResult, result);
        Mockito.verify(clienteDAO).obtenerClientes();
    }

}
