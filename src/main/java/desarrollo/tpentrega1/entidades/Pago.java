
package desarrollo.tpentrega1.entidades;
import desarrollo.tpentrega1.interfaces.FormaDePago;
import java.time.LocalDate;

public abstract class Pago implements FormaDePago{
    private double monto;
    private LocalDate fecha;

    public Pago(double monto) {
        this.monto = monto;
        this.fecha = LocalDate.now();
    } 

    public double getMonto() {
        return monto;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    
    
}

