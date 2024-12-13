package com.desarrollo.tpSpring.Controllers;

import com.desarrollo.tpSpring.DAOs.PedidoRepository;
import static com.desarrollo.tpSpring.Utils.FileUtils.cargarArchivo;
import com.desarrollo.tpSpring.entities.Pedido;
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
@RequestMapping("/pedidos")
public class PedidosController {
    @Autowired
    private PedidoRepository pedidoService;
    
    private String pedidos_html;
    private String pedidos_css;
    private String pedidos_js;
    private String pedidos_crear_html;
    private String pedidos_crear_css;
    private String pedidos_crear_js;
    private String pedidos_modificar_html;
    private String pedidos_modificar_css;
    private String pedidos_modificar_js;

    public PedidosController() {
        try {
            pedidos_html = cargarArchivo("templates/pedidos/pedidos.html");
            pedidos_css = cargarArchivo("templates/pedidos/pedidos.css");
            pedidos_js = cargarArchivo("templates/pedidos/pedidos.js");
            pedidos_crear_html = cargarArchivo("templates/pedidos/crear/pedidoscrear.html");
            pedidos_crear_css = cargarArchivo("templates/pedidos/crear/pedidoscrear.css");
            pedidos_crear_js = cargarArchivo("templates/pedidos/crear/pedidoscrear.js");
            pedidos_modificar_html = cargarArchivo("templates/pedidos/crear/pcmoditems.html");
            pedidos_modificar_css = cargarArchivo("templates/pedidos/crear/pcmoditems.css");
            pedidos_modificar_js = cargarArchivo("templates/pedidos/crear/pcmoditems.js");
            System.out.println("paginas pedidos cargadas correctamente");
        } catch (IOException e) {
            throw new RuntimeException("no se pudo cargar la pagina del pedido");
        }
    }

    // pasar UI
    @GetMapping("/pedidos.html")
    public ResponseEntity<String> pedidosHtml() {
        return new ResponseEntity<>(pedidos_html, HttpStatus.OK);
    }

    @GetMapping("/pedidos.css")
    public ResponseEntity<String> pedidosCss() {
        return new ResponseEntity<>(pedidos_css, HttpStatus.OK);
    }

    @GetMapping("/pedidos.js")
    public ResponseEntity<String> pedidosJs() {
        return new ResponseEntity<>(pedidos_js, HttpStatus.OK);
    }

    @GetMapping("/crear/pedidoscrear.html")
    public ResponseEntity<String> pedidosCrearHtml() {
        return new ResponseEntity<>(pedidos_crear_html, HttpStatus.OK);
    }

    @GetMapping("/crear/pedidoscrear.css")
    public ResponseEntity<String> pedidosCrearCss() {
        return new ResponseEntity<>(pedidos_crear_css, HttpStatus.OK);
    }

    @GetMapping("/crear/pedidoscrear.js")
    public ResponseEntity<String> pedidosCrearJs() {
        return new ResponseEntity<>(pedidos_crear_js, HttpStatus.OK);
    }
    
    @GetMapping("/crear/pcmoditems.html")
    public ResponseEntity<String> pedidosModificarHtml() {
        return new ResponseEntity<>(pedidos_modificar_html, HttpStatus.OK);
    }
    
    @GetMapping("/crear/pcmoditems.css")
    public ResponseEntity<String> pedidosModificarCss() {
        return new ResponseEntity<>(pedidos_modificar_css, HttpStatus.OK);
    }
    
    @GetMapping("/crear/pcmoditems.js")
    public ResponseEntity<String> pedidoModificarJs() {
        return new ResponseEntity<>(pedidos_modificar_js, HttpStatus.OK);
    }

    // funciones
    @GetMapping("/pedidos")
    public ResponseEntity<Iterable<Pedido>> pedidos() {
        Iterable<Pedido> pedidos = pedidoService.findAll();
        return ResponseEntity.ok(pedidos);
    }

    @DeleteMapping("/pedidos")
    public ResponseEntity<String> eliminarPedido(@RequestBody Pedido pedido) {
        pedidoService.delete(pedido);
        return ResponseEntity.ok("Pedido " + pedido.getId_pedido() + " eliminado exitosamente");
    }
    
    @PostMapping("/pedidos")
    public ResponseEntity<String> crearPedido(@RequestBody Pedido pedido) {
        pedidoService.save(pedido);
        return ResponseEntity.ok("Pedido " + pedido.getId_pedido() + " creado exitosamente");
    }
    
    @PutMapping("/pedidos")
    public ResponseEntity<String> modificarPedido(@RequestBody Pedido pedido) {
        pedidoService.save(pedido);
        return ResponseEntity.ok("Pedido " + pedido + " modificado exitosamente");
    }
}
