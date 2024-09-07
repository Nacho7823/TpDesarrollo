/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1.entidades;


public class Plato extends ItemMenu {
    private double calorias;
    private boolean aptoCeliaco;
    private boolean aptoVegano;
    private double peso;

    public Plato() {
    }

    public Plato(double calorias, boolean aptoCeliaco, boolean aptoVegano, double peso) {
        this.calorias = calorias;
        this.aptoCeliaco = aptoCeliaco;
        this.aptoVegano = aptoVegano;
        this.peso = peso;
    }

    // getters / setters

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public void setAptoCeliaco(boolean apto) {
        this.aptoCeliaco = apto;
    }

    public void setAptoVegano(boolean apto) {
        this.aptoVegano = apto;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    // funcs

    public double peso() {
        return (peso + ((peso * 10) / 100));
    };

    public boolean aptoVegano() { // consultar método
        return aptoVegano;
    };

    public boolean esBebida() {
        return false;
    };

    public boolean esComida() {
        return true;
    };

    // public String getId() {
    // return super.getId();
    // }

    // public String getCategoria() {
    // return super.getCategoria();
    // }

}
