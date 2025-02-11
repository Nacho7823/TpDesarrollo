package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.dao.sql.PedidoDAOSql;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Pago;
import desarrollo.tpentrega1.entidades.Pedido;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.enums.EstadoPedido;
import desarrollo.tpentrega1.exceptions.DAOException;
import desarrollo.tpentrega1.exceptions.InvalidOrderException;
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
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class PedidoControllerTest {
    @Mock
    PedidoDAOSql pedidoDAOSql =  new PedidoDAOSql();
    @InjectMocks
    PedidoController pedidoController = new PedidoController();
    
    public PedidoControllerTest() {
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
    public void tearDown() throws DAOException {
        for(Pedido p : pedidoController.obtenerListaPedidos()){
            pedidoController.eliminarPedido(p.getId());
        }
    }
    
    @Test
    public void testNewPedido() throws Exception {
        int id = 1;
        Coordenada co = new Coordenada();
        List<ItemMenu> items = new ArrayList();
        Vendedor vendedor = new Vendedor(1, "a", " ", co, items);
        Cliente cliente = new Cliente(1, "c", "3", "d", "", co);
        Pago pago = null;
        EstadoPedido estado = null;
        Pedido expResult = new Pedido(id, cliente, vendedor, items, pago, estado);
        when(pedidoDAOSql.buscarPedido(id)).thenReturn(expResult);
        pedidoController.newPedido(id, cliente, vendedor, items, pago, estado);
        Pedido result = pedidoController.buscarYDevolverPedido(id);
        assertEquals(expResult.getId(), result.getId());
        assertEquals(expResult.getCliente(), result.getCliente());
        assertEquals(expResult.getEstado(), result.getEstado());
        assertEquals(expResult.getItems(), result.getItems());
    }

    @Test
    public void testModificarPedidoEstado() throws Exception {
        int id = 3;
        Coordenada co = new Coordenada();
        List<ItemMenu> items = new ArrayList();
        Vendedor vendedor = new Vendedor(1, "a", " ", co, items);
        Cliente cliente = new Cliente(1, "c", "3", "d", "", co);
        Pago pago = null;
        EstadoPedido estado = null;
        Pedido pedido = new Pedido(id, cliente, vendedor, items, pago, estado);
        when(pedidoDAOSql.buscarPedido(id)).thenReturn(pedido);
        pedidoController.newPedido(id, cliente, vendedor, items, pago, estado);
        pedidoController.modificarPedidoEstado(id, estado);
        pedido = pedidoController.buscarYDevolverPedido(id);
        Mockito.verify(pedidoDAOSql, times(2)).buscarPedido(id);
        Mockito.verify(pedidoDAOSql).actualizarPedido(pedido);
    }

    @Test
    public void testEliminarPedido() throws Exception {
        int id = 1;
        pedidoController.eliminarPedido(id);
        Mockito.verify(pedidoDAOSql).eliminarPedido(id);
    }

    @Test
    public void testBuscarPedido() throws DAOException {
        int id = 1;
        Pedido expResult = null;
        Pedido result = pedidoController.buscarYDevolverPedido(id);
        assertEquals(expResult, result);
        Mockito.verify(pedidoDAOSql).buscarPedido(id);
    }

    @Test
    public void testBuscarYDevolverPedido() throws DAOException {
        int id = 1;
        Pedido expResult = null;
        Pedido result = pedidoController.buscarYDevolverPedido(id);
        assertEquals(expResult, result);
        Mockito.verify(pedidoDAOSql).buscarPedido(id);
    }

    @Test
    public void testObtenerListaPedidos() throws Exception {
        List<Pedido> expResult = new ArrayList();
        List<Pedido> result = pedidoController.obtenerListaPedidos();
        assertEquals(expResult, result);
        Mockito.verify(pedidoDAOSql).obtenerPedidos();
    }

    @Test
    public void testAddItem() throws Exception {
        ItemMenu item = null;
        Pedido p = null;
        pedidoController.addItem(item, p);
        Mockito.verify(pedidoDAOSql).addItem(item, p);
    }

    @Test
    public void testGetItems() throws InvalidOrderException {
        int id = 3;
        Coordenada co = new Coordenada();
        List<ItemMenu> items = new ArrayList();
        Vendedor vendedor = new Vendedor(1, "a", " ", co, items);
        Cliente cliente = new Cliente(1, "c", "3", "d", "", co);
        Pago pago = null;
        EstadoPedido estado = null;
        Pedido p = new Pedido(id, cliente, vendedor, items, pago, estado);
        List<ItemMenu> expResult = new ArrayList();
        List<ItemMenu> result = pedidoController.getItems(p);
        assertEquals(expResult, result);
    }

    @Test

    public void testRemoveItem() throws Exception {
        ItemMenu item = null;
        Pedido p = null;
        pedidoController.removeItem(item, p);
        Mockito.verify(pedidoDAOSql).removeItem(item, p);
    }
    
}
