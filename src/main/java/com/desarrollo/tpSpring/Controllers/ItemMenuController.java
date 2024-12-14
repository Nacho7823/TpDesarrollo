package com.desarrollo.tpSpring.Controllers;

import com.desarrollo.tpSpring.DAOs.ItemMenuRepository;
import static com.desarrollo.tpSpring.Utils.FileUtils.cargarArchivo;

import com.desarrollo.tpSpring.entities.Bebida;
import com.desarrollo.tpSpring.entities.ItemMenu;
import com.desarrollo.tpSpring.entities.Plato;
import com.desarrollo.tpSpring.services.ItemMenuService;
import java.io.IOException;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
    // //pasar UI
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

    // funciones
    @GetMapping("/itemmenus")
    public ResponseEntity<Iterable<ItemMenu>> items() {
        Iterable<ItemMenu> items = itemMenuService.obtenerItemsMenu();
        return ResponseEntity.ok(items);
    }

    @PostMapping("/itemmenu")
    public ResponseEntity<Boolean> addItem(@RequestBody Map<String, Object> data) {
        if (data.get("categoria").equals("Plato")) {
            Plato.Builder builder = new Plato.Builder();
            builder.nombre((String) data.get("nombre"));
            builder.descripcion((String) data.get("descripcion"));
            builder.precio(Double.parseDouble((String) data.get("precio")));
            builder.categoria((String) data.get("categoria"));
            builder.aptoCeliaco(Boolean.getBoolean((String)data.get("apto_celiaco")));
            builder.aptoVegano(Boolean.getBoolean((String)data.get("apto_vegano")));
            builder.peso(Double.parseDouble((String) data.get("peso")));
            builder.calorias(Double.parseDouble((String) data.get("calorias")));
            Plato item = builder.build();

            System.out.println("create item" + item.toString());
            itemMenuService.crearItemsMenu(item);
            return ResponseEntity.ok(true);
        } else {
            Bebida.Builder builder = new Bebida.Builder();
            builder.nombre((String) data.get("nombre"));
            builder.descripcion((String) data.get("descripcion"));
            builder.precio(Double.parseDouble((String) data.get("precio")));
            builder.categoria((String) data.get("categoria"));
            builder.graduacionAlcoholica(Double.parseDouble((String) data.get("graduacion_alcoholica")));
            builder.tamaño(Double.parseDouble((String) data.get("tamanio")));
            Bebida item = builder.build();
            
            System.out.println("create item" + item.toString());
            itemMenuService.crearItemsMenu(item);
            return ResponseEntity.ok(true);
        }

    }

    @PutMapping("/itemmenu")
    public ResponseEntity<Boolean> updateItem(@RequestBody Map<String, Object> data) {
        if (data.get("categoria").equals("Plato")) {
            Plato.Builder builder = new Plato.Builder();
            builder.id((Integer) data.get("id_item_menu"));
            builder.nombre((String) data.get("nombre"));
            builder.descripcion((String) data.get("descripcion"));
            builder.precio(Double.parseDouble((String) data.get("precio")));
            builder.categoria((String) data.get("categoria"));
            builder.aptoCeliaco(Boolean.getBoolean((String)data.get("apto_celiaco")));
            builder.aptoVegano(Boolean.getBoolean((String)data.get("apto_vegano")));
            builder.peso(Double.parseDouble((String) data.get("peso")));
            builder.calorias(Double.parseDouble((String) data.get("calorias")));
            Plato item = builder.build();

            System.out.println("update item" + item.toString());
            itemMenuService.actualizarItemMenu(item);
            return ResponseEntity.ok(true);
        } else {
            Bebida.Builder builder = new Bebida.Builder();
            builder.id((Integer) data.get("id_item_menu"));
            builder.nombre((String) data.get("nombre"));
            builder.descripcion((String) data.get("descripcion"));
            builder.precio(Double.parseDouble((String) data.get("precio")));
            builder.categoria((String) data.get("categoria"));
            builder.graduacionAlcoholica(Double.parseDouble((String) data.get("graduacion_alcoholica")));
            builder.tamaño(Double.parseDouble((String) data.get("tamanio")));
            Bebida item = builder.build();
            
            System.out.println("update item" + item.toString());
            itemMenuService.actualizarItemMenu(item);
            return ResponseEntity.ok(true);
        }
    }

    @DeleteMapping("/itemmenu")
    public ResponseEntity<Boolean> deleteItem(@RequestBody Map<String, Object> data) {
        itemMenuService.eliminarItemMenu((Integer) data.get("id_item_menu"));
        return ResponseEntity.ok(true);
    }
    
    @GetMapping("/itemmenusOfVendedor/{id}")
    public ResponseEntity<Iterable<ItemMenu>> itemsOfVendedor(@PathVariable int id) {
        Iterable<ItemMenu> items = itemMenuService.obtenerItemsMenuDeVendedor(id);
        return ResponseEntity.ok(items);
    }
}
