package com.desarrollo.tpSpring.Controllers;

import com.desarrollo.tpSpring.entities.Vendedor;
import com.desarrollo.tpSpring.DAOs.VendedorRepository;
import static com.desarrollo.tpSpring.Utils.FileUtils.cargarArchivo;
import com.desarrollo.tpSpring.entities.Cliente;
import com.desarrollo.tpSpring.services.VendedorService;
import java.io.IOException;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vendedor")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;

    private String vendedor_html;
    private String vendedor_css;
    private String vendedor_js;
    private String vendedor_crear_html;
    private String vendedor_crear_css;
    private String vendedor_crear_js;
    private String vendedor_modificar_html;
    private String vendedor_modificar_css;
    private String vendedor_modificar_js;
    
    private String relacionar_html;
    private String relacionar_css;
    private String relacionar_js;
    

    public VendedorController() {
        try {
            vendedor_html = cargarArchivo("templates/vendedor/vendedor.html");
            vendedor_css = cargarArchivo("templates/vendedor/vendedor.css");
            vendedor_js = cargarArchivo("templates/vendedor/vendedor.js");
            vendedor_crear_html = cargarArchivo("templates/vendedor/crear/vendedorcrear.html");
            vendedor_crear_css = cargarArchivo("templates/vendedor/crear/vendedorcrear.css");
            vendedor_crear_js = cargarArchivo("templates/vendedor/crear/vendedorcrear.js");
            vendedor_modificar_html = cargarArchivo("templates/vendedor/modificar/vendedormodificar.html");
            vendedor_modificar_css = cargarArchivo("templates/vendedor/modificar/vendedormodificar.css");
            vendedor_modificar_js = cargarArchivo("templates/vendedor/modificar/vendedormodificar.js");
            
            relacionar_html = cargarArchivo("templates/vendedor/relacionar/relacionar.html");
            relacionar_css = cargarArchivo("templates/vendedor/relacionar/relacionar.css");
            relacionar_js = cargarArchivo("templates/vendedor/relacionar/relacionar.js");
            
            System.out.println("paginas vendedor cargadas correctamente");
        } catch (IOException e) {
            throw new RuntimeException("no se pudo cargar la pagina del vendedor");
        }
    }
    

    // pasar UI
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
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/javascript")
                .body(vendedor_js);
    }

    @GetMapping("/crear/vendedorcrear.html")
    public ResponseEntity<String> vendedorCrearHtml() {
        return new ResponseEntity<>(vendedor_crear_html, HttpStatus.OK);
    }

    @GetMapping("/crear/vendedorcrear.css")
    public ResponseEntity<String> vendedorCrearCss() {
        return new ResponseEntity<>(vendedor_crear_css, HttpStatus.OK);
    }

    @GetMapping("/crear/vendedorcrear.js")
    public ResponseEntity<String> vendedorCrearJs() {
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/javascript")
                .body(vendedor_crear_js);
    }
    
    @GetMapping("/modificar/vendedormodificar.html")
    public ResponseEntity<String> vendedorModificarHtml() {
        return new ResponseEntity<>(vendedor_modificar_html, HttpStatus.OK);
    }
    
    @GetMapping("/modificar/vendedormodificar.css")
    public ResponseEntity<String> vendedorModificarCss() {
        return new ResponseEntity<>(vendedor_modificar_css, HttpStatus.OK);
    }
    
    @GetMapping("/modificar/vendedormodificar.js")
    public ResponseEntity<String> vendedorModificarJs() {
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/javascript")
                .body(vendedor_modificar_js);
    }
    
    @GetMapping("/relacionar/relacionar.html")
    public ResponseEntity<String> relacionarHtml() {
        return new ResponseEntity<>(relacionar_html, HttpStatus.OK);
    }
    
    @GetMapping("/relacionar/relacionar.css")
    public ResponseEntity<String> relacionarCss() {
        return new ResponseEntity<>(relacionar_css, HttpStatus.OK);
    }
    
    @GetMapping("/relacionar/relacionar.js")
    public ResponseEntity<String> relacionarJs() {
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/javascript")
                .body(relacionar_js);
    }

    // datos
    @GetMapping("/vendedores")
    public ResponseEntity<Iterable<Vendedor>> vendedores() {
        Iterable<Vendedor> vend = vendedorService.obtenerVendedores();
        return ResponseEntity.ok(vend);
    }
    
    @GetMapping("/vendedor/{id}")
    public ResponseEntity<Vendedor> getVendedor(@PathVariable int id) {
        Vendedor vendedor = vendedorService.buscarVendedor(id);
        return ResponseEntity.ok(vendedor);
    }

    @DeleteMapping("/vendedor")
    public ResponseEntity<Boolean> eliminarVendedor(@RequestBody Vendedor vendedor) {
        long id = vendedor.getId_vendedor();
        Vendedor opt = vendedorService.buscarVendedor(id);
        if(opt==null){
            System.out.println("no se pudo eliminar el vendedor: " + id);
            return ResponseEntity.badRequest().body(false);
        }
        
        vendedorService.eliminarVendedor(id);
        System.out.println("delete vendedor: " + id);
        return ResponseEntity.ok(true);
    }
    
    @PostMapping("/vendedor")
    public ResponseEntity<Boolean> crearVendedor(@RequestBody Vendedor vendedor) {
        System.out.println("  ");
        System.out.println("  ");
        System.out.println("vendedor: " + vendedor.toString());
        System.out.println("  ");
        System.out.println("  ");
        vendedorService.crearVendedor(vendedor);
        return ResponseEntity.ok(true);
    }
    
    @PutMapping("/vendedor")
    public ResponseEntity<Boolean> modificarVendedor(@RequestBody Vendedor vendedor) {
        System.out.println("  ");
        System.out.println("  ");
        System.out.println("vendedor: " + vendedor.toString());
        System.out.println("  ");
        System.out.println("  ");
        vendedorService.actualizarVendedor(vendedor);
        return ResponseEntity.ok(true);
    }
}
