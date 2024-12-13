
package com.desarrollo.tpSpring.entities;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Transferencia extends Pago{
    @Basic
    @Column
    private String cuit;
    @Column
    private String cvu;

    Transferencia(String cuit, String cvu, double calcularTotal) {
        this.cuit=cuit;
        this.cvu=cvu;
        super.setMonto(calcularTotal);
    }
    
    @Override
    public double aplicarRecargo(double total) {
      return total * 0.02;  
    }
}
