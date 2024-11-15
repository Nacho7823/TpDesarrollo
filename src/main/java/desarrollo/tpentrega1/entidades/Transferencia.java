
package desarrollo.tpentrega1.entidades;

public class Transferencia extends Pago{
    private String cuit;
    private String cvu;

    public Transferencia(String cuit, String cvu,double monto) {
        super(monto);
        this.cuit = cuit;
        this.cvu = cvu;
    }
    
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
