package com.desarrollo.tpSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TpSpringApplication {

    /*
        PARA CORRER DESDE CMD
        mvnw.cmd clean compile spring-boot:run
    */
    
    
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
