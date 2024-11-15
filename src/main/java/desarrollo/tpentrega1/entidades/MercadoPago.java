
package desarrollo.tpentrega1.entidades;

public class MercadoPago extends Pago{
    private String alias;

    public MercadoPago(String alias,double monto) {
        super(monto);
        this.alias = alias;
    }

    public String getAlias() {
        return alias;
    }

    @Override
    public double aplicarRecargo(double total) {
        return total * 0.04; // Recargo del 4%
    }
    
    

}
