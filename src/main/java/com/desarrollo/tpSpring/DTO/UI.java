/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.DTO;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;

/**
 *
 * @author imsac
 */
public class UI {

    public class ClienteUI {

        public int id_cliente;

        public String nombre;

        public String cuit;

        public String email;

        public String direccion;

        public double longitud;

        public double latitud;

        public ClienteUI(int id_cliente, String nombre, String cuit, String email, String direccion, double longitud,
                double latitud) {
            this.id_cliente = id_cliente;
            this.nombre = nombre;
            this.cuit = cuit;
            this.email = email;
            this.direccion = direccion;
            this.longitud = longitud;
            this.latitud = latitud;
        }
    }

    public class VendedorUI {

        public int id_vendedor;

        public String nombre;

        public String direccion;

        public double longitud;

        public double latitud;

        public VendedorUI(int id_vendedor, String nombre, String direccion, double longitud, double latitud) {
            this.id_vendedor = id_vendedor;
            this.nombre = nombre;
            this.direccion = direccion;
            this.longitud = longitud;
            this.latitud = latitud;
        }
    }

    public class ItemMenuUI {

        public int id_item_menu;

        public String nombre;

        public String descripcion;

        public double precio;

        public String categoria;

        public double peso;

        public boolean apto_vegano;

        public boolean apto_celiaco;

        public double calorias;

        public double graduacion_alcoholica;

        public String tamanio;

        public ItemMenuUI(int id_item_menu, String nombre, String descripcion,
                double precio, String categoria, double peso,
                boolean apto_vegano, boolean apto_celiaco,
                double calorias, double graduacion_alcoholica, String tamanio) {
            this.id_item_menu = id_item_menu;
            this.nombre = nombre;
            this.descripcion = descripcion;
            this.precio = precio;
            this.categoria = categoria;
            this.peso = peso;
            this.apto_vegano = apto_vegano;
            this.apto_celiaco = apto_celiaco;
            this.calorias = calorias;
            this.graduacion_alcoholica = graduacion_alcoholica;
            this.tamanio = tamanio;
        }
    }

    

}
