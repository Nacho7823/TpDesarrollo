package com.desarrollo.tpSpring.Controllers;

import com.desarrollo.tpSpring.entities.Vendedor;
import com.desarrollo.tpSpring.DAOs.VendedorRepository;
import static com.desarrollo.tpSpring.Utils.FileUtils.cargarArchivo;
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
    private VendedorRepository vendedorRepository;

    private String vendedor_html;
    private String vendedor_css;
    private String vendedor_js;
    private String vendedor_crear_html;
    private String vendedor_crear_css;
    private String vendedor_crear_js;
    private String vendedor_modificar_html;
    private String vendedor_modificar_css;
    private String vendedor_modificar_js;
    

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

    // datos
    @GetMapping("/vendedores")
    public ResponseEntity<Iterable<Vendedor>> vendedores() {
        Iterable<Vendedor> vend = vendedorRepository.findAll();
        return ResponseEntity.ok(vend);
    }

    @DeleteMapping("/vendedor")
    public ResponseEntity<String> eliminarVendedor(@RequestBody Vendedor vendedor) {
        long id = vendedor.getId_vendedor();
        Optional<Vendedor> opt = vendedorRepository.findById(id);
        if(opt.isEmpty()){
            System.out.println("no se pudo eliminar el vendedor: " + id);
            return ResponseEntity.badRequest().body("no se pudo eliminar");
        }
        
        vendedorRepository.delete(opt.get());
        System.out.println("delete vendedor: " + id);
        return ResponseEntity.ok("Vendedor " + id + " eliminado exitosamente");
    }
    
    @PostMapping("/vendedor")
    public ResponseEntity<String> crearVendedor(@RequestBody Vendedor vendedor) {
        vendedorRepository.save(vendedor);
        return ResponseEntity.ok("Vendedor " + vendedor + " creado exitosamente");
    }
    
    
    @PutMapping("/vendedor")
    public ResponseEntity<String> modificarVendedor(@RequestBody Vendedor vendedor) {
        System.out.println("id: " + vendedor.getId_vendedor());
        vendedorRepository.save(vendedor);
        return ResponseEntity.ok("Vendedor " + vendedor + " modificado exitosamente");
    }
}
