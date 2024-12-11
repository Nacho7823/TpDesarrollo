/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 *
 * @author florh
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class MercadoPago extends Pago{
    @Column
    private String alias;

    MercadoPago(String alias, double calcularTotal) {
        this.alias=alias;
        super.setMonto(calcularTotal);
    }
    
    @Override
    public double aplicarRecargo(double total) {
        return total * 0.04; // Recargo del 4%
    }
}
