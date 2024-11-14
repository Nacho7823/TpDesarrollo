
package desarrollo.tpentrega1.entidades;

import desarrollo.tpentrega1.interfaces.FormaDePago;

public class Transferencia implements FormaDePago{
    private String cuit;
    private String cvu;

    public Transferencia(String cuit, String cvu) {
        this.cuit = cuit;
        this.cvu = cvu;
    }
    
    public Transferencia(){}
    
    public String getCuit() {
        return cuit;
    }
    public String getCvu() {
        return cvu;
    }
    
    @Override
    public double aplicarRecargo(double total) {
      return total * 0.02;  
    }
    
}
