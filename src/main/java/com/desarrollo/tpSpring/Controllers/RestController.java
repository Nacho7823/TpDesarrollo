
package com.desarrollo.tpSpring.Controllers;

import com.desarrollo.tpSpring.entities.Vendedor;
import com.desarrollo.tpSpring.DAOs.VendedorRepository;
import org.springframework.web.bind.annotation.*;

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
