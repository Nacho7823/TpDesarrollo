/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package desarrollo.tpentrega1.entidades;

/**
 *
 * @author Flor Hiembuchner
 */
public class Transferencia implements FormaDePago{
    private String cuit;
    private String cvu;

    public Transferencia(String cuit, String cvu) {
        this.cuit = cuit;
        this.cvu = cvu;
    }
    @Override
    public double aplicarRecargo(double total) {
      return total * 0.02;  
    }
    
}
