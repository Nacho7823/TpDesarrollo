/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.services;

import com.desarrollo.tpSpring.DAOs.VendeRepository;
import com.desarrollo.tpSpring.entities.ItemMenu;
import com.desarrollo.tpSpring.entities.Vende;
import com.desarrollo.tpSpring.entities.VendeID;
import com.desarrollo.tpSpring.entities.Vendedor;
import jakarta.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

/**
 *
 * @author imsac
 */
@Service
public class VendeService {
    @Autowired
    private VendedorService vendedorService;
    @Autowired
    @Lazy
    private ItemMenuService itemMenuService;
    
    @Autowired
    private VendeRepository vendeRepository;
    
    
    
    @Transactional
    public boolean buscarVende(int id_item_menu, int id_vendedor) {
//        Vendedor v = vendedorService.buscarVendedor(id_vendedor);
//        ItemMenu it = itemMenuService.buscarItemMenu(id_item_menu);
        
        VendeID vid = new VendeID(id_item_menu, id_vendedor);
        Optional<Vende> vend = vendeRepository.findById(vid);
        
        return vend.isPresent();
    }
    
    @Transactional
    public void crearVende(int id_item_menu, int id_vendedor) {
        Vendedor v = vendedorService.buscarVendedor(id_vendedor);
        ItemMenu it = itemMenuService.buscarItemMenu(id_item_menu);
//        v.getItems().add(it);
//        vendedorService.actualizarVendedor(v);
        Vende vende = new Vende(it, v);
        vendeRepository.save(vende);
        
    }
    
    @Transactional
    public void borrarVende(int id_item_menu, int id_vendedor) {
//        Vendedor v = vendedorService.buscarVendedor(id_vendedor);
//        ItemMenu it = itemMenuService.buscarItemMenu(id_item_menu);
//        v.getItems().remove(it);
//        vendedorService.actualizarVendedor(v);

        Optional<Vende> vende = vendeRepository.findById(new VendeID(id_item_menu, id_vendedor));
        
        if (vende.isEmpty())
            return; //TODO add something
        
        vendeRepository.delete(vende.get());
        
        
    }
    
    public List<ItemMenu> getItemMenuOfVendedor(int id_vendedor) {
        Vendedor v = vendedorService.buscarVendedor(id_vendedor);
        
        List<Vende> vendeList = vendeRepository.findAll();
        List<Integer> itemsIDs = new ArrayList<>();
        
        for (Vende vende : vendeList) {
            if (vende.getVendedor().getId_vendedor() == id_vendedor)
                itemsIDs.add(vende.getItemMenu().getId_item_menu());
        }
        
        List<ItemMenu> items = new ArrayList<>();
        
        for (int itemID : itemsIDs) {
            ItemMenu it = itemMenuService.buscarItemMenu(itemID);
            items.add(it);
        }
        
        return items;
    }
    
}
