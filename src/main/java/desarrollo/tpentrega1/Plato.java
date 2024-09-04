/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1;

/**
 *
 * @author gui
 */
public class Plato extends ItemMenu {
    private double calorias;
    private boolean aptoCeliaco;
    private boolean aptoVegano;
    //private boolean aptoVegetariano;
    private double peso;
    public double peso(){
    return (peso+((peso*10)/100));
    };
    public boolean aptoVegano(){ //consultar método
    return aptoVegano;
    };
    public boolean esBebida(){
    return false;
    };
    public boolean esComida(){
    return true;
    };
    
    public void setAptoVegano(boolean apto){
        this.aptoVegano=apto;
    }
    public void setCalorias(double calorias){
        this.calorias=calorias;
    }
    


    public String getId() {
        return super.getId();
    }

    public String getCategoria() {
        return super.getCategoria(); 
    }

    public double getCalorias() {
        return calorias;
    }
}
