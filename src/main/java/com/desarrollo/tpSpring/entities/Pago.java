
package com.desarrollo.tpSpring.entities;

import com.desarrollo.tpSpring.interfaces.FormaDePago;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public abstract class Pago implements FormaDePago{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id_pago;
    
    @Basic
    @Column
    private double monto;
    @Temporal(TemporalType.DATE)
    @Column
    private LocalDate fecha;

    
    
}
