
package com.desarrollo.tpSpring.DAOs;

import com.desarrollo.tpSpring.entities.Cliente;
import com.desarrollo.tpSpring.entities.Vendedor;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class DataBase {
    public static void getDataBase() {
        Configuration configuration = new Configuration();
        
        // propiedades Hibernate
        configuration.setProperty("hibernate.connection.driver_class", "com.mysql.cj.jdbc.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:mysql://localhost:3306/tienda");
        configuration.setProperty("hibernate.connection.username", "root");
        configuration.setProperty("hibernate.connection.password", "root");
        configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
        configuration.setProperty("hibernate.hbm2ddl.auto", "update");
        configuration.setProperty("hibernate.show_sql", "true");
        
        configuration.addAnnotatedClass(Cliente.class);
        configuration.addAnnotatedClass(Vendedor.class);

        
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(configuration.getProperties())
                .build();
        
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        // SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
    }
    
    private DataBase() {
        
    }
}
