/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1;

/**
 *
 * @author gui
 */
public class Bebida extends ItemMenu {
    private double graduacionAlcoholica;
    private double tamaño;
    public double peso(){
        double p;
        if(graduacionAlcoholica==0) p=(tamaño*1.04 + ((tamaño*20)/100));
        else p=(tamaño*0.99 + ((tamaño*20)/100));
    return 0;
    };
    public boolean aptoVegano(){ //consultar este método
    return false;
    };
    public boolean esBebida(){
    return true;
    };
    public boolean esComida(){
    return false;
    };
}
