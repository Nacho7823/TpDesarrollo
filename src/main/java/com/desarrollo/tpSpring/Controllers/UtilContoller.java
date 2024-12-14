package com.desarrollo.tpSpring.Controllers;

import com.desarrollo.tpSpring.DAOs.ClienteRepository;
import static com.desarrollo.tpSpring.Utils.FileUtils.cargarArchivo;
import com.desarrollo.tpSpring.entities.Cliente;
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
@RequestMapping("/utils.js")
public class UtilContoller {
    
    // solo aca
    private String utils_js;

    public UtilContoller() {
        try {
            utils_js = cargarArchivo("templates/utils.js");
            System.out.println("utils.js cargado correctamente");
        } catch (IOException e) {
            throw new RuntimeException("no se pudo cargar las utilidades");
        }
    }
    // pasar UI
    // solo aca (es para todos los controllers
    @GetMapping
    public ResponseEntity<String> utilsjs() {
        return ResponseEntity
                .ok()
                .header("Content-Type", "application/javascript")
                .body(utils_js);
    }
    
}