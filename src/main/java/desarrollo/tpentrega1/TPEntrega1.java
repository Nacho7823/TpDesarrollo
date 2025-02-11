//package desarrollo.tpentrega1;
//
//import desarrollo.tpentrega1.interfaces.FormaDePago;
//import desarrollo.tpentrega1.enums.EstadoPedido;
//import desarrollo.tpentrega1.exceptions.InvalidOrderException;
//import desarrollo.tpentrega1.Memory.ItemsPedidoMemory;
//import java.util.ArrayList;
//
//import desarrollo.tpentrega1.entidades.*;
//
//
//import java.util.List;
//
//public class TPEntrega1 {
//
//    public static Vendedor buscarVendedorId(String id, ArrayList<Vendedor> vendedores) {
//        for (int i = 0; i < vendedores.size(); i++) {
//            if (vendedores.get(i).getId().equals(id)) {
//                return vendedores.get(i);
//            }
//        }
//        return null;
//    }
//
//    public static Vendedor buscarVendedorNombre(String nombre, ArrayList<Vendedor> vendedores) {
//        for (int i = 0; i < vendedores.size(); i++) {
//            if (vendedores.get(i).getNombre().equals(nombre)) {
//                return vendedores.get(i);
//            }
//        }
//        return null;
//    }
//
//    public static Cliente buscarClienteId(String id, ArrayList<Cliente> clientes) {
//        for (int i = 0; i < clientes.size(); i++) {
//            if (clientes.get(i).getId().equals(id)) {
//                return clientes.get(i);
//            }
//        }
//        return null;
//    }
//
//    public static Cliente buscarClienteNombre(String nombre, ArrayList<Cliente> cliente) {
//        for (int i = 0; i < cliente.size(); i++) {
//            if (cliente.get(i).getNombre().equals(nombre)) {
//                return cliente.get(i);
//            }
//        }
//        return null;
//    }
//
//    static ArrayList<Vendedor> crearArregloVendedores() {
//        ArrayList<Vendedor> vendedores = new ArrayList<>();
//        Coordenada coords;
//        ArrayList<ItemMenu> items = new ArrayList<>();
//
//        coords = new Coordenada(1.23, 2.34);
//        items.addAll(List.of(
//                new Bebida(200, 1),
//                new Bebida(200, 10),
//                new Bebida(200, 0),
//                new Bebida(200, 0),
//                new Bebida(200, 0),
//                new Plato(20, true, true, 200),
//                new Plato(20, false, true, 200),
//                new Plato(20, true, true, 200),
//                new Plato(20000, true, false, 2)));
//
//        vendedores.add(new Vendedor("0", "Matias Carranza", "San Martin 1263", coords, items));
//
//        coords = new Coordenada(3.45, 4.56);
//        items = new ArrayList<>();
//        items.addAll(List.of(
//                new Bebida(200, 1),
//                new Bebida(200, 10),
//                new Bebida(200, 2),
//                new Bebida(200, 3),
//                new Bebida(200, 1.11),
//                new Plato(500, true, false, 200),
//                new Plato(1200, false, false, 500),
//                new Plato(190.93, true, false, 600),
//                new Plato(20000, true, false, 333)));
//        vendedores.add(new Vendedor("1", "Exequiel sandria", "corrientes 1234", coords, items));
//
//        coords = new Coordenada(4.12, 3.41);
//        items = new ArrayList<>();
//        items.addAll(List.of(
//                new Plato("0", "Pizza", "Deliciosa", 500, "Comida", 300, true, true, 300),
//
//                new Plato("1", "Hamburguesa", "carne", 1200, "Comida", 400, false, true, 150),
//
//                new Plato("2", "Hamburguesa", "vegana", 190.93, "Comida", 400, true, true, 150),
//
//                new Plato("3", "Milanesas", "napolitana", 130, "Comida", 600, true, false, 333),
//
//                new Bebida("4", "Cerveza", "Artesanal", 200, "Bebida", 0.5, 5.0),
//                new Bebida("5", "Cerveza", "Rubia", 250, "Bebida", 0.5, 5.0),
//                new Bebida("6", "Gin", "frutos rojos", 230, "Bebida", 0.5, 3.0),
//                new Bebida("7", "Gin", "heredero", 230, "Bebida", 0.5, 7.0),
//
//                new Bebida("8", "Gaseosa", "Cocacola 200", 100, "Bebida", 0.2, 0.0),
//                new Bebida("9", "Gaseosa", "Cocacola 500", 140, "Bebida", 0.5, 0.0),
//                new Bebida("10", "Gaseosa", "Cocacola 1500", 230, "Bebida", 1.5, 0.0),
//                new Bebida("11", "Gaseosa", "Cocacola 200", 100, "Bebida", 0.5, 0.0)));
//        vendedores.add(new Vendedor("2", "Flor Hiembuchner", "san martin 5412", coords, items));
//
//        return vendedores;
//    }
//
//    static ArrayList<Cliente> crearArregloClientes() {
//        ArrayList<Cliente> clientes = new ArrayList<>();
//        Coordenada coords;
//
//        coords = new Coordenada(1.32, 4.21);
//        clientes.add(
//                new Cliente("0", "juan verde", "20345678912", "juanVerde12@hotmail.com", "corrientes 4124", coords));
//
//        coords = new Coordenada(2.54, 3.53);
//        clientes.add(new Cliente("1", "carlos fernandez", "20364764562", "carlosFernandez12@hotmail.com",
//                "juan de garay 5123", coords));
//
//        coords = new Coordenada(2.12, 1.51);
//        clientes.add(new Cliente("2", "rafael hernandez", "20346572182", "rafaeljosehernandez@gmail.com", "junin 2421",
//                coords));
//
//        return clientes;
//    }
//
//    public static void main(String[] args) {
//
//        /*
//         * //ETAPA 1
//         * // vendedores
//         * ArrayList<Vendedor> vendedores = crearArregloVendedores();
//         * 
//         * // buscar vendedor en arreglo
//         * Vendedor vendedor2 = buscarVendedorId("2", vendedores);
//         * Vendedor vendedor1 = buscarVendedorNombre("Exequiel sandria", vendedores);
//         * Vendedor vendedor0 = buscarVendedorId("0", vendedores);
//         * 
//         * // eliminar vendedor
//         * vendedores.remove(0); // borramos el vendedor con indice 0
//         * 
//         * // clientes
//         * ArrayList<Cliente> clientes = crearArregloClientes();
//         * // buscar cliente en matriz
//         * 
//         * Cliente cliente1 = buscarClienteId("1", clientes);
//         * Cliente cliente2 = buscarClienteNombre("rafael hernandez", clientes);
//         * 
//         * // eliminar cliente
//         * clientes.remove(0); // borramos el cliente con indice 0
//         * 
//         * // distancia
//         * int distancia1 = (int) vendedor1.distancia(cliente1);
//         * int distancia2 = (int) vendedor2.distancia(cliente2);
//         * 
//         * mostrar distancia
//         * System.out.println("distancia de cliente1 a vendedor1: " + distancia1);
//         * System.out.println("distancia de cliente1 a vendedor2: " + distancia2);
//         */
//
//        /*
//         * ETAPA 3
//         * 
//         * // Crear algunos objetos de prueba
//         * 
//         * ItemMenu[] itemsArray = {
//         * new Plato("0", "Pizza", "Deliciosa", 500, "Comida", 300, true, true, 300),
//         * 
//         * new Plato("1", "Hamburguesa", "carne", 1200, "Comida", 400, false, true,
//         * 150),
//         * 
//         * new Plato("2", "Hamburguesa", "vegana", 190.93, "Comida", 400, true, true,
//         * 150),
//         * 
//         * new Plato("3", "Milanesas", "napolitana", 130, "Comida", 600, true, false,
//         * 333),
//         * 
//         * new Bebida("4", "Cerveza", "Artesanal", 200, "Bebida", 0.5, 5.0),
//         * new Bebida("5", "Cerveza", "Rubia", 250, "Bebida", 0.5, 5.0),
//         * new Bebida("6", "Gin", "frutos rojos", 230, "Bebida", 0.5, 3.0),
//         * new Bebida("7", "Gin", "heredero", 230, "Bebida", 0.5, 7.0),
//         * 
//         * new Bebida("8", "Gaseosa", "Cocacola 200", 100, "Bebida", 0.2, 0.0),
//         * new Bebida("9", "Gaseosa", "Cocacola 500", 140, "Bebida", 0.5, 0.0),
//         * new Bebida("10", "Gaseosa", "Cocacola 1500", 230, "Bebida", 1.5, 0.0),
//         * new Bebida("11", "Gaseosa", "Cocacola 200", 100, "Bebida", 0.5, 0.0)
//         * };
//         * 
//         * 
//         * // Crear un Stream con los items
//         * List<ItemMenu> items = List.of(itemsArray);
//         * 
//         * 
//         * // Crear una instancia de ItemsPedidoMemory y asignar el Stream
//         * ItemsPedidoMemory itemsPedidoMemory = new ItemsPedidoMemory();
//         * itemsPedidoMemory.setItems(items);
//         * 
//         * // Probar los métodos
//         * 
//         * System.out.println("\nBuscar bebida por graduación:");
//         * itemsPedidoMemory.buscarBebidaGraduacion(5.0);
//         * 
//         * List<ItemMenu> itemsFiltrados = itemsPedidoMemory.getItems();
//         * for (ItemMenu item : itemsFiltrados) {
//         * System.out.println(item);
//         * }
//         * 
//         * System.out.println("\nBuscar bebida por graduación y precio:");
//         * itemsPedidoMemory.buscarPrecioEntre(500, 1200);
//         * 
//         * itemsFiltrados = itemsPedidoMemory.getItems();
//         * for (ItemMenu item : itemsFiltrados) {
//         * System.out.println(item);
//         * }
//         */
//
//        // ETAPA 4
//
//        ArrayList<Vendedor> vendedores = crearArregloVendedores();
//        Vendedor vendedor = buscarVendedorNombre("Flor Hiembuchner", vendedores);
//
//        ArrayList<Cliente> clientes = crearArregloClientes();
//        Cliente cliente = buscarClienteId("1", clientes);
//        
//        ItemsPedidoMemory itemsPedidoMemory = new ItemsPedidoMemory();
//        itemsPedidoMemory.setItems(vendedor.getItemsMenu());
//
//        itemsPedidoMemory.buscarBebidas();
//        itemsPedidoMemory.buscarPrecio(250);
//        // itemsPedidoMemory.buscar
//
//        List<ItemMenu> items = itemsPedidoMemory.getItems();
//
//        // items.stream().filter(item -> {
//        // return item.getNombre().equals("Cerveza") ||
//        // item.getNombre().equals("Gaseosa");
//        // });
//
//        FormaDePago formaDePago = new Transferencia("20346572182", "0000003100092901454053");
//        PedidoDetalle pedidoDetalle = new PedidoDetalle(items);
//
//        Pedido pedido;
//        try {
//            pedido = new Pedido(cliente,pedidoDetalle, formaDePago, vendedor);
//            System.out.println("Pedido creado a nombre de: "+pedido.getCliente().getNombre()+", total: $" + pedido.getTotal());
//            System.out.println("Items:" + pedido.getPedidoDetalle().getItems().toString());
//            System.out.println();
//
//        } catch (InvalidOrderException e) {
//            System.out.println(e.getMessage());
//        }
//
//        itemsPedidoMemory.setItems(vendedor.getItemsMenu());
//        itemsPedidoMemory.buscarBebidaGraduacion(7);
//        items=itemsPedidoMemory.getItems();
//        pedidoDetalle.setItems(items);
//        
//        try {
//            pedido = new Pedido(cliente,pedidoDetalle, formaDePago, vendedor);
//            System.out.println("Pedido creado a nombre de: "+pedido.getCliente().getNombre()+", total: $" + pedido.getTotal());
//            System.out.println("Items:" + pedido.getPedidoDetalle().getItems().toString());
//            System.out.println();
//
//        } catch (InvalidOrderException e) {
//            System.out.println(e.getMessage());
//        }
//        
//        // etapa 5
//        ArrayList<Pedido> pedidos= new ArrayList<>();
//        vendedor.buscarPedidoPorEstado(pedidos, EstadoPedido.RECIBIDO);
//        
//        vendedor.cambiarEstadoPedido(pedidos.get(0), EstadoPedido.PROCESADO);
//        vendedor.cambiarEstadoPedido(pedidos.get(1), EstadoPedido.ENVIADO);
//        
//        
//}
//
//}
package desarrollo.tpentrega1;

import desarrollo.tpentrega1.controllers.ClienteController;
import desarrollo.tpentrega1.controllers.PedidoController;
import desarrollo.tpentrega1.controllers.VendedorController;
import desarrollo.tpentrega1.UI.MenuGeneral;
import desarrollo.tpentrega1.controllers.ItemsMenuController;
import desarrollo.tpentrega1.dao.ClienteDAO;
import desarrollo.tpentrega1.dao.ItemsPedidoDAO;
import desarrollo.tpentrega1.dao.PedidoDAO;
import desarrollo.tpentrega1.dao.VendedorDAO;
import desarrollo.tpentrega1.dao.sql.ClienteDAOSql;
import desarrollo.tpentrega1.dao.sql.ItemMenuDAOSql;
import desarrollo.tpentrega1.dao.sql.ItemsPedidoDAOSql;
import desarrollo.tpentrega1.dao.sql.PedidoDAOSql;
import desarrollo.tpentrega1.dao.sql.VendedorDAOSql;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.exceptions.DAOException;

import javax.swing.*;
import desarrollo.tpentrega1.dao.ItemMenuDAO;

public class TPEntrega1 {

    public static void main(String[] args) throws DAOException {

        // Crear instancias de memoria (simulando bases de datos en memoria)
        ClienteDAO clienteDAO = ClienteDAOSql.getInstance();
        VendedorDAO vendedorDAO = VendedorDAOSql.getInstance();
        PedidoDAO pedidoDAO =PedidoDAOSql.getInstance();
        ItemMenuDAO itemMenuDAO =ItemMenuDAOSql.getInstance();
        ItemsPedidoDAO itemsPedidoDAO =ItemsPedidoDAOSql.getInstance();

        // Crear instancias de controladores
        ClienteController clienteController = new ClienteController();
        VendedorController vendedorController = new VendedorController();
        PedidoController pedidoController = new PedidoController();
        ItemsMenuController itemsMenuController = new ItemsMenuController(vendedorController);

        // Cargar datos de prueba para clientes

//       Cliente c2= clienteController.buscarCliente("2");
            
        

        // Cargar datos de prueba para vendedores
//        Vendedor v2 = vendedorController.buscarVendedor("2");
//        Vendedor v3 = vendedorController.buscarVendedor("3");


//        vendedorController.buscarVendedor("2").addItemMenu(itemsMenuController.buscarItemsMenu("1"));
//        vendedorController.buscarVendedor("2").addItemMenu(itemsMenuController.buscarItemsMenu("3"));
//        vendedorController.buscarVendedor("3").addItemMenu(itemsMenuController.buscarItemsMenu("2"));


        
        // Configurar UI de Cliente y Vendedor
        SwingUtilities.invokeLater(() -> {
            MenuGeneral menu = new MenuGeneral(clienteController, vendedorController, itemsMenuController, pedidoController);
            menu.setVisible(true);
            menu.setLocationRelativeTo(null);
        });
    }
}
