
package com.desarrollo.tpSpring.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "transferencia")
@PrimaryKeyJoinColumn(name = "id_pago")
public class Transferencia extends Pago{
    
    @Column
    private String cuit;
    @Column
    private String cvu;

    
    public Transferencia(String cuit, String cvu, double calcularTotal) {
        this.cuit=cuit;
        this.cvu=cvu;
        super.setMonto(calcularTotal * 1.02);
    }
    
    @Override
    public double aplicarRecargo(double total) {
      return total * 0.02;  
    }
}
