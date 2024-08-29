/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package desarrollo.tpentrega1;

import java.util.ArrayList;
import java.util.Random;

import desarrollo.tpentrega1.entidades.Coordenada;
import desarrollo.tpentrega1.entidades.Vendedor;

/**
 *
 * @author florh
 */
public class TPEntrega1 {

    public static Vendedor buscarId(String id, ArrayList<Vendedor> vendedores) {
        for (int i = 0; i < vendedores.size(); i++) {
            if (vendedores.get(i).getId().equals(id)) {
                return vendedores.get(i);
            }
        }
        return null;
    }

    public static Vendedor buscarNombre(String nombre, ArrayList<Vendedor> vendedores) {
        for (int i = 0; i < vendedores.size(); i++) {
            if (vendedores.get(i).getNombre().equals(nombre)) {
                return vendedores.get(i);
            }
        }
        return null;
    }

    void etapa1() {
        ArrayList<Vendedor> vendedores = new ArrayList<>();
        ArrayList<Coordenada> coords;

        coords = new ArrayList<Coordenada>();
        coords.add(new Coordenada(1.23, 2.34));
        vendedores.add(new Vendedor("0",  "Matias Sandria",  "San Martin 1263", coords));


        coords = new ArrayList<Coordenada>();
        coords.add(new Coordenada(3.45, 4.56));
        vendedores.add(new Vendedor("1", "Exequiel sandria", "corrientes 1234", coords));

        coords = new ArrayList<Coordenada>();
        coords.add(new Coordenada(4.12, 3.41));
        vendedores.add(new Vendedor("2", "Flor Hiembuchner", "san martin 5412", coords));
        
        // buscar vendedor en arreglo

        Vendedor vendedor1 = buscarId("1", vendedores);
        Vendedor vendedor2 = buscarNombre("Exequiel sandria", vendedores);

        // eliminar vendedor

        vendedores.remove(0);   //borramos el vendedor con indice 0
    }


    public static void main(String[] args) {
        
    }
}
