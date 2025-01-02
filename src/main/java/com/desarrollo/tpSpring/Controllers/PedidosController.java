package com.desarrollo.tpSpring.Controllers;

import static com.desarrollo.tpSpring.Utils.FileUtils.cargarArchivo;
import com.desarrollo.tpSpring.entities.Cliente;
import com.desarrollo.tpSpring.entities.ItemMenu;
import com.desarrollo.tpSpring.entities.ItemsPedido;
import com.desarrollo.tpSpring.entities.MercadoPago;
import com.desarrollo.tpSpring.entities.Pago;
import com.desarrollo.tpSpring.entities.Pedido;
import com.desarrollo.tpSpring.entities.Transferencia;
import com.desarrollo.tpSpring.entities.Vendedor;
import com.desarrollo.tpSpring.enums.EstadoPedido;
import com.desarrollo.tpSpring.services.ClienteService;
import com.desarrollo.tpSpring.services.ItemMenuService;
import com.desarrollo.tpSpring.services.PedidoService;
import com.desarrollo.tpSpring.services.VendedorService;
import java.io.IOException;
import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
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
    private PedidoService pedidoService;
    @Autowired
    private VendedorService vendedorService;
    @Autowired
    private ClienteService clienteService;
    @Autowired
    private ItemMenuService itemMenuService;

    private String pedidos_html;
    private String pedidos_css;
    private String pedidos_js;
    private String pedidos_crear_html;
    private String pedidos_crear_css;
    private String pedidos_crear_js;
    private String pedidos_crear_setItems_html;
    private String pedidos_crear_setItems_css;
    private String pedidos_crear_setItems_js;
    
    
    private String pedidos_modificar_html;
    private String pedidos_modificar_css;
    private String pedidos_modificar_js;
    private String pedidoveritems_html;
    private String pedidoveritems_css;
    private String pedidoveritems_js;

    public PedidosController() {
        try {
            pedidos_html = cargarArchivo("templates/pedidos/pedidos.html");
            pedidos_css = cargarArchivo("templates/pedidos/pedidos.css");
            pedidos_js = cargarArchivo("templates/pedidos/pedidos.js");
            pedidos_crear_html = cargarArchivo("templates/pedidos/crear/pedidoscrear.html");
            pedidos_crear_css = cargarArchivo("templates/pedidos/crear/pedidoscrear.css");
            pedidos_crear_js = cargarArchivo("templates/pedidos/crear/pedidoscrear.js");
            pedidos_crear_setItems_html = cargarArchivo("templates/pedidos/crear/setItems.html");
            pedidos_crear_setItems_css = cargarArchivo("templates/pedidos/crear/setItems.css");
            pedidos_crear_setItems_js = cargarArchivo("templates/pedidos/crear/setItems.js");
            pedidos_modificar_html = cargarArchivo("templates/pedidos/modificar/pedidosmodificar.html");
            pedidos_modificar_css = cargarArchivo("templates/pedidos/modificar/pedidosmodificar.css");
            pedidos_modificar_js = cargarArchivo("templates/pedidos/modificar/pedidosmodificar.js");
            pedidoveritems_html = cargarArchivo("templates/pedidos/veritems/pedidoveritems.html");
            pedidoveritems_css = cargarArchivo("templates/pedidos/veritems/pedidoveritems.css");
            pedidoveritems_js = cargarArchivo("templates/pedidos/veritems/pedidoveritems.js");
            System.out.println("paginas pedidos cargadas correctamente");
        } catch (IOException e) {
            throw new RuntimeException("no se pudo cargar la pagina del pedido");
        }
    }

    //`${year}-${month}-${day}`;
    private LocalDate parseDate(String date) {
        String[] splits = date.split("-");
        LocalDate localDate = LocalDate.of(Integer.parseInt(splits[0]), Integer.parseInt(splits[1]), Integer.parseInt(splits[2]));
        return localDate;
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
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/javascript")
                .body(pedidos_js);
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
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/javascript")
                .body(pedidos_crear_js);
    }
    
    @GetMapping("/crear/setItems.html")
    public ResponseEntity<String> pedidosCrearSetItemsHtml() {
        return new ResponseEntity<>(pedidos_crear_setItems_html, HttpStatus.OK);
    }

    @GetMapping("/crear/setItems.css")
    public ResponseEntity<String> pedidosCrearSetItemsCss() {
        return new ResponseEntity<>(pedidos_crear_setItems_css, HttpStatus.OK);
    }

    @GetMapping("/crear/setItems.js")
    public ResponseEntity<String> pedidosCrearSetItemsJs() {
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/javascript")
                .body(pedidos_crear_setItems_js);
    }

    @GetMapping("/modificar/pedidosmodificar.html")
    public ResponseEntity<String> pedidosModificarHtml() {
        return new ResponseEntity<>(pedidos_modificar_html, HttpStatus.OK);
    }

    @GetMapping("/modificar/pedidosmodificar.css")
    public ResponseEntity<String> pedidosModificarCss() {
        return new ResponseEntity<>(pedidos_modificar_css, HttpStatus.OK);
    }

    @GetMapping("/modificar/pedidosmodificar.js")
    public ResponseEntity<String> pedidoModificarJs() {
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/javascript")
                .body(pedidos_modificar_js);
    }

    @GetMapping("/veritems/pedidoveritems.html")
    public ResponseEntity<String> pedidosVerItemsHtml() {
        return new ResponseEntity<>(pedidoveritems_html, HttpStatus.OK);
    }

    @GetMapping("/veritems/pedidoveritems.css")
    public ResponseEntity<String> pedidosVerItemsCss() {
        return new ResponseEntity<>(pedidoveritems_css, HttpStatus.OK);
    }

    @GetMapping("/veritems/pedidoveritems.js")
    public ResponseEntity<String> pedidosVerItemsJs() {
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/javascript")
                .body(pedidoveritems_js);
    }

    // funciones
    @GetMapping("/pedidos")
    public ResponseEntity<Iterable<Pedido>> pedidos() {
        Iterable<Pedido> pedidos = pedidoService.obtenerPedidos();
        return ResponseEntity.ok(pedidos);
    }

    @DeleteMapping("/pedido")
    public ResponseEntity<Boolean> eliminarPedido(@RequestBody Pedido pedido) {
        pedidoService.eliminarPedido(pedido);
        return ResponseEntity.ok(true);
    }

    @PostMapping("/pedido")
    public ResponseEntity<Boolean> crearPedido(@RequestBody Map<String, Object> data) {
        System.out.println("pedido: " + data.toString());
        EstadoPedido estado = EstadoPedido.valueOf((String) data.get("estado"));
        int id_cliente = (int) data.get("id_cliente");
        int id_vendedor = (int) data.get("id_vendedor");

        Cliente cliente = clienteService.buscarCliente(id_cliente);
        Vendedor vendedor = vendedorService.buscarVendedor(id_vendedor);
            
        List<Map<String, Object>> itemsDetalles = (List<Map<String, Object>>) data.get("detalle_pedido");
        
        Pedido pedido = new Pedido();
        Set<ItemsPedido> items = new HashSet();
        for (int i = 0; i < itemsDetalles.size(); i++) {
            int id_item_menu = (int) itemsDetalles.get(i).get("id_item_menu");
            int cantidad = (int) itemsDetalles.get(i).get("cantidad");

            ItemMenu itemMenu = itemMenuService.buscarItemMenu(id_item_menu);
            ItemsPedido item = new ItemsPedido(pedido, itemMenu, cantidad);
            items.add(item);
        }

        Pago pago;
        if (data.get("formapago").equals("mercadopago")) {
            String alias = (String) data.get("alias");
            int monto = (Integer) data.get("monto");
            String fecha = (String) data.get("fecha");
            pago = new MercadoPago(alias);
            pago.setMonto(monto);
            pago.setFecha(parseDate(fecha));
        } else {              //transferencia
            String cvu = (String) data.get("cvu");
            String cuit = (String) data.get("cuit");
            int monto = (int) data.get("monto");
            String fecha = (String) data.get("fecha");
            pago = new Transferencia(cuit, cvu);
            pago.setMonto(monto);
            pago.setFecha(parseDate(fecha));
        }
        
        pedido.setCliente(cliente);
        pedido.setVendedor(vendedor);
        pedido.setItems(items);
        pedido.setEstado(estado);
        pedido.setPago(pago);
        pedido.calcularTotal();
        pedidoService.crearPedido(pedido);
        System.out.println("pedido creado");
        return ResponseEntity.ok(true);
    }

    @PutMapping("/pedido")
    public ResponseEntity<String> modificarPedido(@RequestBody Pedido pedido) {
        pedidoService.actualizarPedido(pedido);
        return ResponseEntity.ok("Pedido " + pedido + " modificado exitosamente");
    }

}
