
package com.desarrollo.tpSpring.entities;

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
@Entity(name= "mercado_pago")
@PrimaryKeyJoinColumn(name = "id_pago")
public class MercadoPago extends Pago{
    
    @Column
    private String alias;

    public MercadoPago(String alias, double calcularTotal) {
        this.alias=alias;
        super.setMonto(calcularTotal);
    }
    
    @Override
    public double aplicarRecargo(double total) {
        return total * 0.04;
    }
}
