/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1.servicios;

import desarrollo.tpentrega1.entidades.Cliente;
import desarrollo.tpentrega1.entidades.Coordenada;
import java.util.ArrayList;



/**
 *
 * @author florh
 */
public class ClienteServicio {
    public Cliente crearCliente(String id, String cuit,String direccion,String email, ArrayList<Coordenada> coordenadas){
        Cliente c=new Cliente();
        c.setId(id);
        c.setCuit(cuit);
        c.setDireccion(direccion);
        c.setEmail(email);
        c.setCoordenadas(coordenadas);
        
        return c;
    }

    
}
