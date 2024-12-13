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

//@RestController
@SpringBootApplication
public class TpSpringApplication {


    public static void main(String[] args) {
        // mvn spring-boot:run
        // mvnw.cmd spring-boot:run
        // mvnw.cmd compile
        
        SpringApplication.run(TpSpringApplication.class, args);


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
    

//    @GetMapping("/{d}")
//    public static ResponseEntity<String> all(@PathVariable String d) throws IOException {
//        return new ResponseEntity<>("ok:" + d, HttpStatus.OK);
//    }

}
