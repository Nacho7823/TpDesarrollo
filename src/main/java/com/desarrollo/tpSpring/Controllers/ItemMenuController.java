package com.desarrollo.tpSpring.Controllers;

import com.desarrollo.tpSpring.DAOs.ItemMenuRepository;
import static com.desarrollo.tpSpring.Utils.FileUtils.cargarArchivo;
import com.desarrollo.tpSpring.entities.ItemMenu;
import com.desarrollo.tpSpring.services.ItemMenuService;
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
@RequestMapping("/itemmenu")
public class ItemMenuController {
    @Autowired
    private ItemMenuService itemMenuService;
//    
    private String itemmenu_html;
    private String itemmenu_css;
    private String itemmenu_js;
    private String bebida_crear_html;
    private String bebida_crear_css;
    private String bebida_crear_js;
    private String plato_crear_html;
    private String plato_crear_css;
    private String plato_crear_js;
    private String bebida_modificar_html;
    private String bebida_modificar_css;
    private String bebida_modificar_js;
    private String plato_modificar_html;
    private String plato_modificar_css;
    private String plato_modificar_js;
    
    public ItemMenuController() {
        try {
            itemmenu_html = cargarArchivo("templates/itemmenu/itemmenu.html");
            itemmenu_css = cargarArchivo("templates/itemmenu/itemmenu.css");
            itemmenu_js = cargarArchivo("templates/itemmenu/itemmenu.js");
            bebida_crear_html = cargarArchivo("templates/itemmenu/crear/bebidacrear.html");
            bebida_crear_css = cargarArchivo("templates/itemmenu/crear/bebidacrear.css");
            bebida_crear_js = cargarArchivo("templates/itemmenu/crear/bebidacrear.js");
            plato_crear_html = cargarArchivo("templates/itemmenu/crear/platocrear.html");
            plato_crear_css = cargarArchivo("templates/itemmenu/crear/platocrear.css");
            plato_crear_js = cargarArchivo("templates/itemmenu/crear/platocrear.js");
            bebida_modificar_html = cargarArchivo("templates/itemmenu/modificar/bebidamodificar.html");
            bebida_modificar_css = cargarArchivo("templates/itemmenu/modificar/bebidamodificar.css");
            bebida_modificar_js = cargarArchivo("templates/itemmenu/modificar/bebidamodificar.js");
            plato_modificar_html = cargarArchivo("templates/itemmenu/modificar/platomodificar.html");
            plato_modificar_css = cargarArchivo("templates/itemmenu/modificar/platomodificar.css");
            plato_modificar_js = cargarArchivo("templates/itemmenu/modificar/platomodificar.js");
            System.out.println("paginas itemMenu cargadas correctamente");
            plato_crear_html = cargarArchivo("templates/itemmenu/crear/platocrear.html");
        } catch (IOException e) {
            throw new RuntimeException("no se pudo cargar la pagina del itemMenu");
        }
    }
//    
//    //pasar UI
    @GetMapping("/itemmenu.html")
    public ResponseEntity<String> itemmenuHtml() {
        return new ResponseEntity<>(itemmenu_html, HttpStatus.OK);
    }

    @GetMapping("/itemmenu.css")
    public ResponseEntity<String> itemmenuCss() {
        return new ResponseEntity<>(itemmenu_css, HttpStatus.OK);
    }

    @GetMapping("/itemmenu.js")
    public ResponseEntity<String> itemmenuJs() {
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/javascript")
                .body(itemmenu_js);
    }

    @GetMapping("/crear/bebidacrear.html")
    public ResponseEntity<String> bebidaCrearHtml() {
        return new ResponseEntity<>(bebida_crear_html, HttpStatus.OK);
    }

    @GetMapping("/crear/bebidacrear.css")
    public ResponseEntity<String> bebidaCrearCss() {
        return new ResponseEntity<>(bebida_crear_css, HttpStatus.OK);
    }

    @GetMapping("/crear/bebidacrear.js")
    public ResponseEntity<String> bebidaCrearJs() {
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/javascript")
                .body(bebida_crear_js);
    }
    
    @GetMapping("/crear/platocrear.html")
    public ResponseEntity<String> platoCrearHtml() {
        return new ResponseEntity<>(plato_crear_html, HttpStatus.OK);
    }

    @GetMapping("/crear/platocrear.css")
    public ResponseEntity<String> platoCrearCss() {
        return new ResponseEntity<>(plato_crear_css, HttpStatus.OK);
    }

    @GetMapping("/crear/platocrear.js")
    public ResponseEntity<String> platoCrearJs() {
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/javascript")
                .body(plato_crear_js);
    }
    
    @GetMapping("/modificar/bebidamodificar.html")
    public ResponseEntity<String> bebidaModificarHtml() {
        return new ResponseEntity<>(bebida_modificar_html, HttpStatus.OK);
    }
    
    @GetMapping("/modificar/bebidamodificar.css")
    public ResponseEntity<String> bebidaModificarCss() {
        return new ResponseEntity<>(bebida_modificar_css, HttpStatus.OK);
    }
    
    @GetMapping("/modificar/bebidamodificar.js")
    public ResponseEntity<String> bebidaModificarJs() {
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/javascript")
                .body(bebida_modificar_js);
    }
    
    @GetMapping("/modificar/platomodificar.html")
    public ResponseEntity<String> platoModificarHtml() {
        return new ResponseEntity<>(plato_modificar_html, HttpStatus.OK);
    }
    
    @GetMapping("/modificar/platomodificar.css")
    public ResponseEntity<String> platoModificarCss() {
        return new ResponseEntity<>(plato_modificar_css, HttpStatus.OK);
    }
    
    @GetMapping("/modificar/platomodificar.js")
    public ResponseEntity<String> platoModificarJs() {
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/javascript")
                .body(plato_modificar_js);
    }
    
    //funciones
    @GetMapping("/itemmenus")
    public ResponseEntity<Iterable<ItemMenu>> items(){
        Iterable<ItemMenu> items = itemMenuService.obtenerItemsMenu();
        return ResponseEntity.ok(items);
    }
    
    @PostMapping("/itemmenu")
    public ResponseEntity<String> addItem(@RequestBody ItemMenu item){
        
        itemMenuService.crearItemsMenu(item);
        return ResponseEntity.ok("Item " +  item.getNombre() + " creado exitosamente");
    }
    
    @PutMapping("/itemmenu")
    public ResponseEntity<ItemMenu> updateItem(@RequestBody ItemMenu item){
        itemMenuService.actualizarItemMenu(item);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
    
    @DeleteMapping("/itemmenu")
    public ResponseEntity<String> deleteItem(@RequestBody ItemMenu item){
        itemMenuService.eliminarItemMenu(item.getId_item_menu());
        return ResponseEntity.ok("Item " +  item.getNombre() + " creado exitosamente");
    }
}
