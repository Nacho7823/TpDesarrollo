/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1.entidades;


/**
 *
 * @author florh
 */
public class Vendedor {
    private String id;
    private String nombre;
    private String direccion;
    private Coordenada coordenada;

    public Vendedor() {
    }

    public Vendedor(String id, String nombre, String direccion, Coordenada coordenada) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.coordenada = coordenada;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }
 
    public double distancia(Cliente cliente) {
        Coordenada coord1 = this.coordenada;
        Coordenada coord2 = cliente.getCoordenada();

        final int RADIO_TIERRA = 6371; 

        double lat1 = Math.toRadians(coord1.getLat());
        double lng1 = Math.toRadians(coord1.getLng());
        double lat2 = Math.toRadians(coord2.getLat());
        double lng2 = Math.toRadians(coord2.getLng());

        double dLat = lat2 - lat1;
        double dLng = lng2 - lng1;

        double a = Math.sin(dLat / 2) * Math.sin(dLat / 2)
                + Math.cos(lat1) * Math.cos(lat2)
                * Math.sin(dLng / 2) * Math.sin(dLng / 2);

        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

       
        return (RADIO_TIERRA * c);
    }
}
