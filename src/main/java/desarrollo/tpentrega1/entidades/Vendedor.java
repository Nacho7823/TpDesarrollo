/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1.entidades;


import java.util.ArrayList;


public class Vendedor {
    private String id;
    private String nombre;
    private String direccion;
    private Coordenada coordenada;
    private ArrayList<ItemMenu> itemsMenu;   // lo agregamos al constructor?

    public Vendedor() {
    }

    public Vendedor(String id, String nombre, String direccion, Coordenada coordenada, ArrayList<ItemMenu> itemsMenu) {
        this.id = id;
        this.nombre = nombre;
        this.direccion = direccion;
        this.coordenada = coordenada;
        this.itemsMenu = itemsMenu;
    }

    // getters / setters
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
 
    public ArrayList<ItemMenu> getItemMenu(){
        return this.itemsMenu;
    }

    public void setItemMenu(ArrayList<ItemMenu> itemsMenu){
        this.itemsMenu = itemsMenu;
    }

    // funcs
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

    public ArrayList<Bebida> getItemBebidas(){
        ArrayList<Bebida> bebidas = new ArrayList<>();

        for (ItemMenu item : itemsMenu){
            if (item instanceof Bebida){
                bebidas.add((Bebida)item);
            }
        }
        return bebidas;
    }

    public ArrayList<Plato> getItemComidas(){
        ArrayList<Plato> comidas = new ArrayList<>();

        for (ItemMenu item : itemsMenu){
            if (item instanceof Plato){
                comidas.add((Plato)item);
            }
        }
        return comidas;
    }
    
    public ArrayList<Plato> getItemComidasVeganas() {
        ArrayList<Plato> comidasVeganas = new ArrayList<>();
        
        for (ItemMenu item : itemsMenu) {
            if (item instanceof Plato && ((Plato) item).aptoVegano()) {
                comidasVeganas.add((Plato) item);
            }
        }

        return comidasVeganas;
    }

    public ArrayList<Bebida> getItemBebidasSinAlcohol() {
        ArrayList<Bebida> bebidasSinAlcohol = new ArrayList<>();

        for (ItemMenu item : itemsMenu) {
            if (item instanceof Bebida && ((Bebida) item).getGraduacionAlcoholica() == 0) {
                bebidasSinAlcohol.add((Bebida) item);
            }
        }

        return bebidasSinAlcohol;
    }

}
