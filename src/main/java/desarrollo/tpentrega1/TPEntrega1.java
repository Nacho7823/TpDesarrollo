/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package desarrollo.tpentrega1;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Random;

import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Bebida;
import desarrollo.tpentrega1.entidades.ItemMenu;
import desarrollo.tpentrega1.entidades.Plato;
import java.util.List;

/**
 *
 * @author florh
 */
public class TPEntrega1 {

    public static Vendedor buscarVendedorId(String id, ArrayList<Vendedor> vendedores) {
        for (int i = 0; i < vendedores.size(); i++) {
            if (vendedores.get(i).getId().equals(id)) {
                return vendedores.get(i);
            }
        }
        return null;
    }

    public static Vendedor buscarVendedorNombre(String nombre, ArrayList<Vendedor> vendedores) {
        for (int i = 0; i < vendedores.size(); i++) {
            if (vendedores.get(i).getNombre().equals(nombre)) {
                return vendedores.get(i);
            }
        }
        return null;
    }

    public static Cliente buscarClienteId(String id, ArrayList<Cliente> clientes) {
        for (int i = 0; i < clientes.size(); i++) {
            if (clientes.get(i).getId().equals(id)) {
                return clientes.get(i);
            }
        }
        return null;
    }

    public static Cliente buscarClienteNombre(String nombre, ArrayList<Cliente> cliente) {
        for (int i = 0; i < cliente.size(); i++) {
            if (cliente.get(i).getNombre().equals(nombre)) {
                return cliente.get(i);
            }
        }
        return null;
    }


    static ArrayList<Vendedor> crearArregloVendedores() {
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        Coordenada coords;
        ArrayList<ItemMenu> items = new ArrayList<>();

        coords = new Coordenada(1.23, 2.34);
        items.addAll(List.of(
            new Bebida(200, 1),
            new Bebida(200, 10),
            new Bebida(200, 0),
            new Bebida(200, 0),
            new Bebida(200, 0),
            new Plato(20, true, true, 200),
            new Plato(20, false, true, 200),
            new Plato(20, true, true, 200),
            new Plato(20000, true, false, 2)
        ));
        
        vendedores.add(new Vendedor("0",  "Matias Carranza",  "San Martin 1263", coords, items));


        coords = new Coordenada(3.45, 4.56);
        items.clear();
        items.addAll(List.of(
            new Bebida(200, 1),
            new Bebida(200, 10),
            new Bebida(200, 2),
            new Bebida(200, 3),
            new Bebida(200, 1.11),
            new Plato(500, true, false, 200),
            new Plato(1200, false, false, 500),
            new Plato(190.93, true, false, 600),
            new Plato(20000, true, false, 333)
        ));
        vendedores.add(new Vendedor("1", "Exequiel sandria", "corrientes 1234", coords, items));

        coords = new Coordenada(4.12, 3.41);
        items.clear();
        items.addAll(List.of(
            new Bebida(200, 1),
            new Bebida(200, 10),
            new Bebida(200, 0),
            new Bebida(200, 3),
            new Bebida(200, 1.11),
            new Plato(500, true, true, 200),
            new Plato(1200, false, false, 500),
            new Plato(190.93, true, false, 600),
            new Plato(20000, true, false, 333)
        ));
        vendedores.add(new Vendedor("2", "Flor Hiembuchner", "san martin 5412", coords, items));
        
        return vendedores;
    }

    static ArrayList<Cliente> crearArregloClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
        Coordenada coords;

        coords = new Coordenada(1.32, 4.21);
        clientes.add(new Cliente("0", "juan verde", "20345678912", "juanVerde12@hotmail.com", "corrientes 4124", coords));

        coords = new Coordenada(2.54, 3.53);
        clientes.add(new Cliente("1", "carlos fernandez", "20364764562", "carlosFernandez12@hotmail.com", "juan de garay 5123", coords));

        coords = new Coordenada(2.12, 1.51);
        clientes.add(new Cliente("2", "rafael hernandez", "20346572182", "rafaeljosehernandez@gmail.com", "junin 2421", coords));

        return clientes;
    }

    public static void main(String[] args) {
        
        // vendedores
        ArrayList<Vendedor> vendedores = crearArregloVendedores();
        
        // buscar vendedor en arreglo
        Vendedor vendedor1 = buscarVendedorId("1", vendedores);
        Vendedor vendedor2 = buscarVendedorNombre("Exequiel sandria", vendedores);

        // eliminar vendedor
        vendedores.remove(0);   //borramos el vendedor con indice 0

        // clientes
        ArrayList<Cliente> clientes = crearArregloClientes();
        // buscar cliente en matriz

        Cliente cliente1 = buscarClienteId("1", clientes);
        Cliente cliente2 = buscarClienteNombre("rafael hernandez", clientes);

        // eliminar cliente
        clientes.remove(0);   //borramos el cliente con indice 0

        // distancia
        int distancia1 = (int)vendedor1.distancia(cliente1);
        int distancia2 = (int)vendedor2.distancia(cliente2);

        // mostrar distancia
        System.out.println("distancia de cliente1 a vendedor1: " + distancia1);
        System.out.println("distancia de cliente1 a vendedor2: " + distancia2);
        
    }
}
