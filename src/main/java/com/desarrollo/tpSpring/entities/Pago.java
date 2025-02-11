
package com.desarrollo.tpSpring.entities;

import com.desarrollo.tpSpring.interfaces.FormaDePago;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity(name="pago")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Pago implements FormaDePago{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_pago")
    private int id_pago;
    
    @Column
    private double monto;
    
    
    @Column
    @Temporal(TemporalType.DATE)
    private LocalDate fecha;

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
}
