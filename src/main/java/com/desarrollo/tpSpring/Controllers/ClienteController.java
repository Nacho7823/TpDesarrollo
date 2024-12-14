package com.desarrollo.tpSpring.Controllers;

import static com.desarrollo.tpSpring.Utils.FileUtils.cargarArchivo;
import com.desarrollo.tpSpring.entities.Cliente;
import com.desarrollo.tpSpring.services.ClienteService;
import java.io.IOException;
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

@RestController
@RequestMapping("/cliente")
public class ClienteController {
    
    @Autowired
    private ClienteService clienteService;

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
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/javascript")
                .body(cliente_js);
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
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/javascript")
                .body(cliente_crear_js);
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
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/javascript")
                .body(cliente_modificar_js);
    }

    // datos
    @GetMapping("/clientes")
    public ResponseEntity<Iterable<Cliente>> clientes() {
        Iterable<Cliente> vend = clienteService.obtenerClientes();
        return ResponseEntity.ok(vend);
    }

    @DeleteMapping("/cliente")
    public ResponseEntity<Boolean> eliminarcliente(@RequestBody Cliente cliente) {
        System.out.println("  ");
        System.out.println("  ");
        System.out.println("cliente: " + cliente.toString());
        System.out.println("  ");
        System.out.println("  ");
        clienteService.eliminarCliente(cliente.getId_cliente());
        return ResponseEntity.ok(true);
    }
    
    @PostMapping("/cliente")
    public ResponseEntity<Boolean> crearcliente(@RequestBody Cliente cliente) {
        System.out.println("  ");
        System.out.println("  ");
        System.out.println("cliente: " + cliente.toString());
        System.out.println("  ");
        System.out.println("  ");
        clienteService.crearCliente(cliente);
        return ResponseEntity.ok(true);
    }
    
    
    @PutMapping("/cliente")
    public ResponseEntity<Boolean> modificarcliente(@RequestBody Cliente cliente) {
        System.out.println("  ");
        System.out.println("  ");
        System.out.println("cliente: " + cliente.toString());
        System.out.println("  ");
        System.out.println("  ");
        clienteService.actualizarCliente(cliente);
        return ResponseEntity.ok(true);
    }
    
}