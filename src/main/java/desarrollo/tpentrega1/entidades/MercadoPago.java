
package desarrollo.tpentrega1.entidades;

import desarrollo.tpentrega1.interfaces.FormaDePago;

public class MercadoPago implements FormaDePago{
    private String alias;

    public MercadoPago(String alias) {
        this.alias = alias;
    }
    
    public MercadoPago(){}

    public String getAlias() {
        return alias;
    }

    @Override
    public double aplicarRecargo(double total) {
        return total * 0.04; // Recargo del 4%
    }
    
    

}
