/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1.entidades;

public class Bebida extends ItemMenu {
    private double graduacionAlcoholica;
    private double tamaño;

    public Bebida(){}

    public Bebida(double tamaño, double graduacionAlcoholica) {
        this.graduacionAlcoholica = graduacionAlcoholica;
        this.tamaño = tamaño;
    }

    // getters / setters

    public double getGraduacionAlcoholica() {
        return graduacionAlcoholica;
    }

    public void setGraduacionAlcoholica(double graduacionAlcoholica) {
        this.graduacionAlcoholica = graduacionAlcoholica;
    }

    public double getTamaño() {
        return tamaño;
    }

    public void setTamaño(double tamaño) {
        this.tamaño = tamaño;
    }

    // funcs

    public double peso() {
        double p;
        if (graduacionAlcoholica == 0)
            p = (tamaño * 1.04 + ((tamaño * 20) / 100));
        else
            p = (tamaño * 0.99 + ((tamaño * 20) / 100));
        return 0;
    };

    public boolean aptoVegano() {
        return false;
    };

    public boolean esBebida() {
        return true;
    };

    public boolean esComida() {
        return false;
    };
}
