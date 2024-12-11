package com.desarrollo.tpSpring;

import com.desarrollo.tpSpring.entities.Cliente;
import com.desarrollo.tpSpring.DAOs.ClienteRepository;
import com.desarrollo.tpSpring.entities.Vendedor;
import com.desarrollo.tpSpring.DAOs.VendedorRepository;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

import org.hibernate.*;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@SpringBootApplication
@RestController
public class TpSpringApplication {

    private static String index_html;
    private static String index_css;
    private static String index_js;

    private static String vendedor_html;
    private static String vendedor_css;
    private static String vendedor_js;
    
    private static String cliente_html;
    private static String cliente_css;
    private static String cliente_js;
    
    @Autowired
    private VendedorRepository vendedorRepository;
    @Autowired
    private ClienteRepository clienteRepository;

    public static void main(String[] args) {
        // mvn spring-boot:run
        // mvnw.cmd spring-boot:run
        // mvnw.cmd compile
        
        SpringApplication.run(TpSpringApplication.class, args);

        try {
            index_html = cargarArchivo("templates/index.html");
            index_css = cargarArchivo("templates/index.css");
            index_js = cargarArchivo("templates/index.js");

            vendedor_html = cargarArchivo("templates/vendedor/vendedor.html");
            vendedor_css = cargarArchivo("templates/vendedor/vendedor.css");
            vendedor_js = cargarArchivo("templates/vendedor/vendedor.js");
            
            cliente_html = cargarArchivo("templates/cliente/cliente.html");
            cliente_css = cargarArchivo("templates/cliente/cliente.css");
            cliente_js = cargarArchivo("templates/cliente/cliente.js");

        } catch (IOException e) {
            System.out.println("error html");
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }

//        Configuration configuration = new Configuration();
        // Configurar las propiedades de Hibernate
//        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
//        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/tienda");
//        configuration.setProperty("hibernate.connection.username", "root");
//        configuration.setProperty("hibernate.connection.password", "root");
//        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
//        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
//        configuration.setProperty("hibernate.show_sql", "true");
        // Registrar las clases mapeadas
//        configuration.addAnnotatedClass(Cliente.class);
        // 2. Crear el ServiceRegistry y el SessionFactory
//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties())
//                .build();
//        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        // SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
//        Session session = sessionFactory.openSession();
//        Transaction transaction = session.beginTransaction();
//        Cliente persona = new Cliente();
//        persona.setId_cliente(0);
//        persona.setNombre("Juan");
//        persona.setCuit("2045215979");
//        persona.setDireccion("dawda");
//        persona.setLatitud(0);
//        persona.setLongitud(0);
//        persona.setEmail(" dawdawd");
//        
//        session.save(persona);
//
//        transaction.commit();
//        session.close();
//        sessionFactory.close();
    }

//    @GetMapping("/helloa")
//    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
//        return String.format("Hello %s!", name);
//    }
    public static String cargarArchivo(String nombreArchivo) throws IOException {
        Path path = (Path) Paths.get(new ClassPathResource(nombreArchivo).getURI());
        return new String(Files.readAllBytes((java.nio.file.Path) path));
    }

//    @GetMapping("/{d}")
//    public static ResponseEntity<String> all(@PathVariable String d) throws IOException {
//        return new ResponseEntity<>("ok:" + d, HttpStatus.OK);
//    }
    @GetMapping("/index.html")
    public ResponseEntity<String> indexHtml() {
        return new ResponseEntity<>(index_html, HttpStatus.OK);
    }

    @GetMapping("/index.css")
    public ResponseEntity<String> indexCss() {
        return new ResponseEntity<>(index_css, HttpStatus.OK);
    }

    @GetMapping("/index.js")
    public ResponseEntity<String> indexJs() {
        return new ResponseEntity<>(index_js, HttpStatus.OK);
    }

    @GetMapping("/vendedor/vendedor.html")
    public ResponseEntity<String> vendedorHtml() {
        return new ResponseEntity<>(vendedor_html, HttpStatus.OK);
    }

    @GetMapping("/vendedor/vendedor.css")
    public ResponseEntity<String> vendedorCss() {
        return new ResponseEntity<>(vendedor_css, HttpStatus.OK);
    }

    @GetMapping("/vendedor/vendedor.js")
    public ResponseEntity<String> vendedorJs() {
        return new ResponseEntity<>(vendedor_js, HttpStatus.OK);
    }
    
    @GetMapping("/cliente/cliente.html")
    public ResponseEntity<String> clienteHtml() {
        return new ResponseEntity<>(cliente_html, HttpStatus.OK);
    }

    @GetMapping("/cliente/cliente.css")
    public ResponseEntity<String> clienteCss() {
        return new ResponseEntity<>(cliente_css, HttpStatus.OK);
    }

    @GetMapping("/cliente/cliente.js")
    public ResponseEntity<String> clienteJs() {
        return new ResponseEntity<>(cliente_js, HttpStatus.OK);
    }

    @GetMapping("/vendedores")
    public ResponseEntity<Iterable<Vendedor>> vendedores() {
        Iterable<Vendedor> vend = vendedorRepository.findAll();
        return ResponseEntity.ok(vend);
    }
    
    @GetMapping("/clientes")
    public ResponseEntity<Iterable<Cliente>> clientes() {
        Iterable<Cliente> vend = clienteRepository.findAll();
        return ResponseEntity.ok(vend);
    }

//    @GetMapping("/style.css")
//    public static ResponseEntity<String> cssIndex(){
//            String contenido = css_index;
//            System.out.println(contenido);
//            return new ResponseEntity<>(contenido, HttpStatus.OK);
//    }
//    
//    @GetMapping("/cliente")
//    public String cliente() {
//        return "";
//    }
//    
//    @GetMapping("/vendedores")
//    public String vendedores() {
//        return "";
//    }
}
