/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.desarrollo.tpSpring.interfaces;

import com.desarrollo.tpSpring.entities.Pedido;

/**
 *
 * @author florh
 */
public interface Observador {
    void actualizar(Pedido pedido);
}
