/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package desarrollo.tpentrega1;


import java.util.ArrayList;

import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.Vendedor;
import desarrollo.tpentrega1.entidades.Cliente;


public class TPEntrega1 {

    public static Vendedor buscarVendedorId(String id, ArrayList<Vendedor> vendedores) {
        int i=0;
        boolean bandera = true;
        Vendedor v = new Vendedor();
        while (i < vendedores.size() && bandera){
        if(vendedores.get(i).getId().equals(id)) {
            bandera = false;
            v = vendedores.get(i);
        } else i++;
    }
        if(!bandera)return v;
            else{ System.out.println("No se ha encontrado vendedor con ese id: "+id); return null;}
    }

    public static Vendedor buscarVendedorNombre(String nombre, ArrayList<Vendedor> vendedores) {
        int i=0;
        boolean bandera = true;
        Vendedor v = new Vendedor();
        while (i < vendedores.size() && bandera){
        if(vendedores.get(i).getNombre().equals(nombre)) {
            bandera = false;
            v = vendedores.get(i);
        } else i++;
    }
        if(!bandera)return v;
            else{ System.out.println("No se ha encontrado vendedor con ese nombre: "+nombre); return null;}
    }

    public static Cliente buscarClienteId(String id, ArrayList<Cliente> clientes) {
        int i=0;
        boolean bandera = true;
        Cliente c = new Cliente();
        while (i < clientes.size() && bandera){
        if(clientes.get(i).getId().equals(id)) {
            bandera = false;
            c = clientes.get(i);
        } else i++;
    }
       if(!bandera) return c;
        else{ System.out.println("No se ha encontrado cliente con el id: "+id); return null;}
    }

    public static Cliente buscarClienteNombre(String nombre, ArrayList<Cliente> clientes) {
         int i=0;
        boolean bandera = true;
        Cliente c = new Cliente();
        while (i < clientes.size() && bandera){
        if(clientes.get(i).getNombre().equals(nombre)) {
            bandera = false;
            c = clientes.get(i);
        } else i++;
    }
        if(!bandera) return c;
        else{ System.out.println("No se ha encontrado cliente con ese nombre: "+nombre); return null;}
    }


    public static ArrayList<Vendedor> crearArregloVendedores() {
        ArrayList<Vendedor> vendedores = new ArrayList<>();
       

        
        vendedores.add(new Vendedor("0",  "Matias Carranza",  "San Martin 1263", new Coordenada(3.45,2.65)));

        
        vendedores.add(new Vendedor("1", "Exequiel sandria", "corrientes 1234",new Coordenada(13.5,54.1)));
        
      
        vendedores.add(new Vendedor("2", "Flor Hiembuchner", "san martin 5412",new Coordenada(34.6,6.12) ));
        
        return vendedores;
    }

    public static ArrayList<Cliente> crearArregloClientes() {
        ArrayList<Cliente> clientes = new ArrayList<>();
       

        //agregar las coordenadas
        clientes.add(new Cliente("0", "juan verde", "20345678912", "juanVerde12@hotmail.com", "corrientes 4124", new Coordenada(3.5, 5.2)));
        
        clientes.add(new Cliente("1", "carlos fernandez", "20364764562", "carlosFernandez12@hotmail.com", "juan de garay 5123", new Coordenada(12.5, 65.2)));
       
        clientes.add(new Cliente("2", "rafael hernandez", "20346572182", "rafaeljosehernandez@gmail.com", "junin 2421", new Coordenada(6.75, 25.12)));

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
        double distancia1 = vendedor1.distancia(cliente1);
        double distancia2 = vendedor2.distancia(cliente2);

        // mostrar distancia
        System.out.println("distancia de cliente1 a vendedor1: " + String.format("%.2f", distancia1) + " km");
        System.out.println("distancia de cliente1 a vendedor2: " + String.format("%.2f",distancia2) + " km");

    }
}
