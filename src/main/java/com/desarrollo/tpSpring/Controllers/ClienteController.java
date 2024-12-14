/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.desarrollo.tpSpring.Controllers;

import com.desarrollo.tpSpring.DAOs.ClienteRepository;
import static com.desarrollo.tpSpring.Utils.FileUtils.cargarArchivo;
import com.desarrollo.tpSpring.entities.Cliente;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
    private String cliente_modificar_html;
    private String cliente_modificar_css;
    private String cliente_modificar_js;

    public ClienteController() {
        try {
            cliente_html = cargarArchivo("templates/cliente/cliente.html");
            cliente_css = cargarArchivo("templates/cliente/cliente.css");
            cliente_js = cargarArchivo("templates/cliente/cliente.js");
            cliente_crear_html = cargarArchivo("templates/cliente/crear/clientecrear.html");
            cliente_crear_css = cargarArchivo("templates/cliente/crear/clientecrear.css");
            cliente_crear_js = cargarArchivo("templates/cliente/crear/clientecrear.js");
            cliente_modificar_html = cargarArchivo("templates/cliente/modificar/clientemodificar.html");
            cliente_modificar_css = cargarArchivo("templates/cliente/modificar/clientemodificar.css");
            cliente_modificar_js = cargarArchivo("templates/cliente/modificar/clientemodificar.js");
            System.out.println("paginas cliente cargadas correctamente");
        } catch (IOException e) {
            throw new RuntimeException("no se pudo cargar la pagina del cliente");
        }
    }

    // pasar UI
    @GetMapping("/cliente.html")
    public ResponseEntity<String> ClienteHtml() {
        return new ResponseEntity<>(cliente_html, HttpStatus.OK);
    }

    @GetMapping("/cliente.css")
    public ResponseEntity<String> ClienteCss() {
        return new ResponseEntity<>(cliente_css, HttpStatus.OK);
    }

    @GetMapping("/cliente.js")
    public ResponseEntity<String> ClienteJs() {
        return new ResponseEntity<>(cliente_js, HttpStatus.OK);
    }

    @GetMapping("/crear/clientecrear.html")
    public ResponseEntity<String> ClienteCrearHtml() {
        return new ResponseEntity<>(cliente_crear_html, HttpStatus.OK);
    }

    @GetMapping("/crear/clientecrear.css")
    public ResponseEntity<String> clienteCrearCss() {
        return new ResponseEntity<>(cliente_crear_css, HttpStatus.OK);
    }

    @GetMapping("/crear/clientecrear.js")
    public ResponseEntity<String> clienteCrearJs() {
        return new ResponseEntity<>(cliente_crear_js, HttpStatus.OK);
    }
    
    @GetMapping("/modificar/clientemodificar.html")
    public ResponseEntity<String> clienteModificarHtml() {
        return new ResponseEntity<>(cliente_modificar_html, HttpStatus.OK);
    }
    
    @GetMapping("/modificar/clientemodificar.css")
    public ResponseEntity<String> clienteModificarCss() {
        return new ResponseEntity<>(cliente_modificar_css, HttpStatus.OK);
    }
    
    @GetMapping("/modificar/clientemodificar.js")
    public ResponseEntity<String> clienteModificarJs() {
        return new ResponseEntity<>(cliente_modificar_js, HttpStatus.OK);
    }

    // datos
    @GetMapping("/clientes")
    public ResponseEntity<Iterable<Cliente>> clientes() {
        Iterable<Cliente> clien = clienteRepository.findAll();
        return ResponseEntity.ok(clien);
    }
    
    @GetMapping("/cliente")
    public ResponseEntity<Cliente> getCliente(@RequestBody String id_cliente) {
        Optional<Cliente> opt = clienteRepository.findById(Long.valueOf(id_cliente));
        if(opt.isEmpty())
            return ResponseEntity.notFound().build();
        
        return ResponseEntity.ok(opt.get());
    }

    @DeleteMapping("/cliente")
    public ResponseEntity<String> eliminarCliente(@RequestBody Cliente cliente) {
        long id = cliente.getId_cliente();
        Optional<Cliente> opt = clienteRepository.findById(id);
        if(opt.isEmpty()){
            System.out.println("no se pudo eliminar el cliente: " + id);
            return ResponseEntity.badRequest().body("no se pudo eliminar");
        }
        
        clienteRepository.delete(opt.get());
        System.out.println("delete cliente: " + id);
        return ResponseEntity.ok("cliente " + id + " eliminado exitosamente");
    }
    
    @PostMapping("/cliente")
    public ResponseEntity<String> crearCliente(@RequestBody Cliente cliente) {
        clienteRepository.save(cliente);
        return ResponseEntity.ok("cliente " + cliente + " creado exitosamente");
    }
    
    
    @PutMapping("/cliente")
    public ResponseEntity<String> modificarCliente(@RequestBody Cliente cliente) {
        System.out.println("id: " + cliente.getId_cliente());
        clienteRepository.save(cliente);
        return ResponseEntity.ok("cliente " + cliente + " modificado exitosamente");
    }
    
}