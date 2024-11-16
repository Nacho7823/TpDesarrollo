package desarrollo.tpentrega1.controllers;

import desarrollo.tpentrega1.dao.sql.ItemMenuDAOSql;
import desarrollo.tpentrega1.dao.sql.VendedorDAOSql;
import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Plato;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;
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
public class ItemsMenuControllerTest {
    @Mock
    ItemMenuDAOSql itemMenuDAOSql = new ItemMenuDAOSql();
    @Mock
    VendedorDAOSql vendedorDAOSql = new VendedorDAOSql();
    VendedorController vendedorController = new VendedorController(vendedorDAOSql);
    @InjectMocks
    ItemsMenuController itemMenuController = new ItemsMenuController(itemMenuDAOSql, vendedorController);
    
    
    public ItemsMenuControllerTest() {
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
        for(Vendedor v : vendedorController.obtenerListaVendedores()){
            for(ItemMenu item : itemMenuController.obtenerItemsMenuDeVendedor(v.getId())){
                itemMenuController.eliminarItemsMenu(item);
                v.getItemsMenu().remove(item);
                v.setItemMenu(v.getItemsMenu());
            }
        }
    }

    @Test
    public void testObtenerItemsMenuDeVendedor() throws DAOException {
        String id = "";
        List<ItemMenu> expResult = null;
        List<ItemMenu> result = itemMenuController.obtenerItemsMenuDeVendedor(id);
        assertEquals(expResult, result);
        Mockito.verify(itemMenuDAOSql).obtenerItemsMenuDeVendedor(id);
    }

    @Test
    public void testCrearNuevoItem() throws DAOException {
        String nombre = "";
        String descripcion = "";
        double precio = 0.0;
        String categoria = "";
        double calorias = 0.0;
        boolean aptoCeliaco = false;
        boolean aptoVegano = false;
        double peso = 0.0;
        Plato expResult = new Plato.Builder()
                .nombre(nombre)
                .descripcion(descripcion)
                .peso(peso)
                .precio(precio)
                .calorias(calorias)
                .categoria(categoria)
                .aptoCeliaco(aptoCeliaco)
                .aptoVegano(aptoVegano)
                .build();
        Plato result = itemMenuController.crearNuevoItem(nombre, descripcion, precio, categoria, calorias, aptoCeliaco, aptoVegano, peso);
        assertEquals(expResult, result);
        Mockito.verify(itemMenuDAOSql).crearItemMenu(expResult);
    }

    @Test
    public void testCrearNuevaBebida() throws DAOException {
        String id = "";
        String nombre = "";
        String descripcion = "";
        double precio = 0.0;
        String categoria = "";
        Vendedor vendedor = null;
        double tamaño = 0.0;
        double graduacionAlcoholica = 0.0;
        Bebida expResult = new Bebida.Builder()
                .id(id)
                .nombre(nombre)
                .descripcion(descripcion)
                .precio(precio)
                .categoria(categoria)
                .tamaño(tamaño)
                .graduacionAlcoholica(graduacionAlcoholica)
                .build()
                ;
        Bebida result = itemMenuController.crearNuevaBebida(id, nombre, descripcion, precio, categoria, vendedor, tamaño, graduacionAlcoholica);
        assertEquals(expResult, result);
        Mockito.verify(itemMenuDAOSql).crearItemMenu(expResult);
        Mockito.verify(vendedorController).modificarVendedor(vendedor);
    }

    @Test
    public void testModificarItemsMenu() throws DAOException {
        String id = "";
        String nombre = "";
        String descripcion = "";
        double precio = 0.0;
        String categoria = "";
        itemMenuController.modificarItemsMenu(id, nombre, descripcion, precio, categoria);
        Mockito.verify(itemMenuDAOSql).buscarItemMenu(id);
        Mockito.verify(itemMenuDAOSql).actualizarItemMenu(itemMenuController.buscarItemsMenu(id));
    }

    @Test
    public void testModificarPlato() throws DAOException {
        Plato plato = null;
        itemMenuController.modificarPlato(plato);
        Mockito.verify(itemMenuDAOSql).actualizarItemMenu(plato);
    }

    @Test
    public void testModificarBebida() throws DAOException {
        Bebida bebida = null;
        itemMenuController.modificarBebida(bebida);
        Mockito.verify(itemMenuDAOSql).actualizarItemMenu(bebida);
    }

    @Test
    public void testEliminarItemsMenu() throws DAOException {
        ItemMenu id = null;
        itemMenuController.eliminarItemsMenu(id);
        Mockito.verify(itemMenuDAOSql).eliminarItemMenu("");
    }

    @Test
    public void testBuscarItemsMenu() throws DAOException {
        String id = "";
        ItemMenu expResult = null;
        ItemMenu result = itemMenuController.buscarItemsMenu(id);
        assertEquals(expResult, result);
        Mockito.verify(itemMenuDAOSql).buscarItemMenu("");
    }
    
}
