/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.Controllers;

import com.desarrollo.tpSpring.DAOs.ClienteRepository;
import static com.desarrollo.tpSpring.Utils.FileUtils.cargarArchivo;
import com.desarrollo.tpSpring.entities.Cliente;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author imsac
 */
@RestController
@RequestMapping("/cliente")
public class ClienteController {
    @Autowired
    private ClienteRepository clienteRepository;
    
    private String cliente_html;
    private String cliente_css;
    private String cliente_js;
    private String cliente_crear_html;
    private String cliente_crear_css;
    private String cliente_crear_js;
    
    public ClienteController() {
        try {
            cliente_html = cargarArchivo("templates/cliente/cliente.html");
            cliente_css = cargarArchivo("templates/cliente/cliente.css");
            cliente_js = cargarArchivo("templates/cliente/cliente.js");
            cliente_crear_html = cargarArchivo("templates/cliente/crear/clientecrear.html");
            cliente_crear_css = cargarArchivo("templates/cliente/crear/clientecrear.css");
            cliente_crear_js = cargarArchivo("templates/cliente/crear/clientecrear.js");
            
        } catch(IOException e){
            throw new RuntimeException("no se pudo cargar la pagina del cliente");
        }
    }

    @GetMapping
    public Iterable<Cliente> obtenerProductos() {
        return clienteRepository.findAll();
//    public Iterable<cliente> obtenerProductos() {
//        return productoService.obtenerProductos();
    }
    
    @GetMapping("/cliente.html")
    public ResponseEntity<String> clienteHtml() {
        return new ResponseEntity<>(cliente_html, HttpStatus.OK);
    }

    @GetMapping("/cliente.css")
    public ResponseEntity<String> clienteCss() {
        return new ResponseEntity<>(cliente_css, HttpStatus.OK);
    }

    @GetMapping("/cliente.js")
    public ResponseEntity<String> clienteJs() {
        return new ResponseEntity<>(cliente_js, HttpStatus.OK);
    }
    
    @GetMapping("/crear/clientecrear.html")
    public ResponseEntity<String> clienteCrearHtml() {
        return new ResponseEntity<>(cliente_crear_html, HttpStatus.OK);
    }

    @GetMapping("/crear/cliente.css")
    public ResponseEntity<String> clienteCrearCss() {
        return new ResponseEntity<>(cliente_crear_css, HttpStatus.OK);
    }

    @GetMapping("/crear/cliente.js")
    public ResponseEntity<String> clienteCrearJs() {
        return new ResponseEntity<>(cliente_crear_js, HttpStatus.OK);
    }
    
    @GetMapping("/clientees")
    public ResponseEntity<Iterable<Cliente>> clientes() {
        Iterable<Cliente> clientes = clienteRepository.findAll();
        return ResponseEntity.ok(clientes);
    }
}
