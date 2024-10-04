/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1.entidades;

/**
 *
 * @author Flor Hiembuchner
 */
public class MercadoPago implements FormaDePago{
    private String alias;

    public MercadoPago(String alias) {
        this.alias = alias;
    }

    @Override
    public double aplicarRecargo(double total) {
        return total * 0.04; // Recargo del 4%
    }

    public String getAlias() {
        return alias;
    }

}
