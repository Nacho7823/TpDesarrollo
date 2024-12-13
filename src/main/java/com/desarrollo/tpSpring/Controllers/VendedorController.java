
package com.desarrollo.tpSpring.Controllers;

import com.desarrollo.tpSpring.entities.Vendedor;
import com.desarrollo.tpSpring.DAOs.VendedorRepository;
import static com.desarrollo.tpSpring.Utils.FileUtils.cargarArchivo;
import java.io.IOException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {
    
    @Autowired
    private VendedorRepository vendedorRepository;
    
    private String vendedor_html;
    private String vendedor_css;
    private String vendedor_js;
    private String vendedor_crear_html;
    private String vendedor_crear_css;
    private String vendedor_crear_js;
    
    public VendedorController() {
        try {
            vendedor_html = cargarArchivo("templates/vendedor/vendedor.html");
            vendedor_css = cargarArchivo("templates/vendedor/vendedor.css");
            vendedor_js = cargarArchivo("templates/vendedor/vendedor.js");
            vendedor_crear_html = cargarArchivo("templates/vendedor/crear/vendedorcrear.html");
            vendedor_crear_css = cargarArchivo("templates/vendedor/crear/vendedorcrear.css");
            vendedor_crear_js = cargarArchivo("templates/vendedor/crear/vendedorcrear.js");
            
        } catch(IOException e){
            throw new RuntimeException("no se pudo cargar la pagina del vendedor");
        }
    }

    @GetMapping("/vendedor.html")
    public ResponseEntity<String> vendedorHtml() {
        return new ResponseEntity<>(vendedor_html, HttpStatus.OK);
    }

    @GetMapping("/vendedor.css")
    public ResponseEntity<String> vendedorCss() {
        return new ResponseEntity<>(vendedor_css, HttpStatus.OK);
    }

    @GetMapping("/vendedor.js")
    public ResponseEntity<String> vendedorJs() {
        return new ResponseEntity<>(vendedor_js, HttpStatus.OK);
    }
    
    @GetMapping("/crear/vendedorcrear.html")
    public ResponseEntity<String> vendedorCrearHtml() {
        return new ResponseEntity<>(vendedor_crear_html, HttpStatus.OK);
    }

    @GetMapping("/crear/vendedor.css")
    public ResponseEntity<String> vendedorCrearCss() {
        return new ResponseEntity<>(vendedor_crear_css, HttpStatus.OK);
    }

    @GetMapping("/crear/vendedor.js")
    public ResponseEntity<String> vendedorCrearJs() {
        return new ResponseEntity<>(vendedor_crear_js, HttpStatus.OK);
    }
    
    @GetMapping("/vendedores")
    public ResponseEntity<Iterable<Vendedor>> vendedores() {
        Iterable<Vendedor> vend = vendedorRepository.findAll();
        return ResponseEntity.ok(vend);
    }
    
}
