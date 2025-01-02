/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.Controllers;

import com.desarrollo.tpSpring.entities.ItemMenu;
import com.desarrollo.tpSpring.services.ItemMenuService;
import com.desarrollo.tpSpring.services.VendeService;
import com.desarrollo.tpSpring.services.VendedorService;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author imsac
 */
@RestController
@RequestMapping("/vende")
public class VendeController {
    
    @Autowired
    private VendeService vendeService;
    
    @GetMapping("/vende/{a}-{b}")
    public ResponseEntity<Boolean> itemsOfVendedor(@PathVariable int a, @PathVariable int b) {
        Map<String, Object> obj = new HashMap<>();
        
        int id_item_menu = a;
        int id_vendedor = b;
        
        // checkIfExists
        boolean exists = vendeService.buscarVende(id_item_menu, id_vendedor);
        System.out.println("get: (item: " + id_item_menu + ", " + id_vendedor + "):" + exists);
        
        return ResponseEntity.ok(exists);
    }
    
    
    @PostMapping("/vende")
    public ResponseEntity<Boolean> addItem(@RequestBody Map<String, Object> data) {
        int id_item_menu = (Integer) data.get("id_item_menu");
        int id_vendedor = (Integer) data.get("id_vendedor");
        
        //TODO: create
        System.out.println("create: (item: " + id_item_menu + ", " + id_vendedor + ")");
        vendeService.crearVende(id_item_menu, id_vendedor);
        
        return ResponseEntity.ok(true);
    }
    
    @DeleteMapping("/vende")
    public ResponseEntity<Boolean> deleteItem(@RequestBody Map<String, Object> data) {
        int id_item_menu = (Integer) data.get("id_item_menu");
        int id_vendedor = (Integer) data.get("id_vendedor");
        
        //TODO: delete
        System.out.println("delete: (item: " + id_item_menu + ", " + id_vendedor + ")");
        vendeService.borrarVende(id_item_menu, id_vendedor);
        
        return ResponseEntity.ok(true);
    }
}
