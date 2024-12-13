package com.desarrollo.tpSpring.Controllers;

import com.desarrollo.tpSpring.DAOs.ItemMenuRepository;
import static com.desarrollo.tpSpring.Utils.FileUtils.cargarArchivo;
import com.desarrollo.tpSpring.entities.ItemMenu;
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
    private ItemMenuRepository itemMenuDAO;
//    
//    private String itemmenu_html;
//    private String itemmenu_css;
//    private String itemmenu_js;
//    private String bebida_crear_html;
//    private String bebida_crear_css;
//    private String bebida_crear_js;
//    private String plato_crear_html;
//    private String plato_crear_css;
//    private String plato_crear_js;
//    
//    public ItemMenuController() {
//        try {
//            itemmenu_html = cargarArchivo("templates/itemmenu/itemmenu.html");
//            itemmenu_css = cargarArchivo("templates/itemmenu/itemmenu.css");
//            itemmenu_js = cargarArchivo("templates/itemmenu/itemmenu.js");
//            bebida_crear_html = cargarArchivo("templates/itemmenu/crear/bebidacrear.html");
//            bebida_crear_css = cargarArchivo("templates/itemmenu/crear/bebidacrear.css");
//            bebida_crear_js = cargarArchivo("templates/itemmenu/crear/bebidacrear.js");
//            plato_crear_html = cargarArchivo("templates/itemmenu/crear/platocrear.html");
//            plato_crear_css = cargarArchivo("templates/itemmenu/crear/platocrear.css");
//            plato_crear_js = cargarArchivo("templates/itemmenu/crear/platocrear.js");
//            System.out.println("paginas itemMenu cargadas correctamente");
//        } catch (IOException e) {
//            throw new RuntimeException("no se pudo cargar la pagina del itemMenu");
//        }
//    }
//    
//    //pasar UI
//    @GetMapping("/itemmenu.html")
//    public ResponseEntity<String> itemmenuHtml() {
//        return new ResponseEntity<>(itemmenu_html, HttpStatus.OK);
//    }
//
//    @GetMapping("/itemmenu.css")
//    public ResponseEntity<String> itemmenuCss() {
//        return new ResponseEntity<>(itemmenu_css, HttpStatus.OK);
//    }
//
//    @GetMapping("/itemmenu.js")
//    public ResponseEntity<String> itemmenuJs() {
//        return new ResponseEntity<>(itemmenu_js, HttpStatus.OK);
//    }
//
//    @GetMapping("/crear/bebidacrear.html")
//    public ResponseEntity<String> bebidaCrearHtml() {
//        return new ResponseEntity<>(bebida_crear_html, HttpStatus.OK);
//    }
//
//    @GetMapping("/crear/bebidacrear.css")
//    public ResponseEntity<String> bebidaCrearCss() {
//        return new ResponseEntity<>(bebida_crear_css, HttpStatus.OK);
//    }
//
//    @GetMapping("/crear/bebidacrear.js")
//    public ResponseEntity<String> bebidaCrearJs() {
//        return new ResponseEntity<>(bebida_crear_js, HttpStatus.OK);
//    }
//    
//    @GetMapping("/crear/platocrear.html")
//    public ResponseEntity<String> platoCrearHtml() {
//        return new ResponseEntity<>(plato_crear_html, HttpStatus.OK);
//    }
//
//    @GetMapping("/crear/platocrear.css")
//    public ResponseEntity<String> platoCrearCss() {
//        return new ResponseEntity<>(plato_crear_css, HttpStatus.OK);
//    }
//
//    @GetMapping("/crear/bebidacrear.js")
//    public ResponseEntity<String> platoCrearJs() {
//        return new ResponseEntity<>(plato_crear_js, HttpStatus.OK);
//    }
    
    //funciones
    @GetMapping("/items")
    public ResponseEntity<Iterable<ItemMenu>> items(){
        Iterable<ItemMenu> items = itemMenuDAO.findAll();
        return ResponseEntity.ok(items);
    }
    
    @PostMapping("/items")
    public ResponseEntity<String> addItem(@RequestBody ItemMenu item){
        ItemMenu i;
        i = itemMenuDAO.save(item);
        return ResponseEntity.ok("Item " +  i.getNombre() + " creado exitosamente");
    }
    
    @PutMapping("/items")
    public ResponseEntity<ItemMenu> updateItem(@RequestBody ItemMenu item){
        itemMenuDAO.save(item);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
    
    @DeleteMapping("/items")
    public ResponseEntity<String> deleteItem(@RequestBody ItemMenu item){
        itemMenuDAO.delete(item);
        return ResponseEntity.ok("Item " +  item.getNombre() + " creado exitosamente");
    }
}
