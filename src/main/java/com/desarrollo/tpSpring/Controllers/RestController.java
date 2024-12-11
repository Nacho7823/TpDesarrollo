/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.Controllers;

import com.desarrollo.tpSpring.entities.Vendedor;
import com.desarrollo.tpSpring.DAOs.VendedorRepository;
import org.springframework.web.bind.annotation.*;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author imsac
 */


//@RestController
@RequestMapping("/vendedor")
public class RestController {
    
    private VendedorRepository vendedorRepository;

    @GetMapping
    public Iterable<Vendedor> obtenerProductos() {
        return vendedorRepository.findAll();
//    public Iterable<Vendedor> obtenerProductos() {
//        return productoService.obtenerProductos();
    }
    
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
        return String.format("Hello %s!", name);
    }
    
    @GetMapping("/cliente")
    public String cliente() {
        return "";
    }
    
    @GetMapping("/vendedores")
    public String vendedores() {
        return "";
    }
    
}
