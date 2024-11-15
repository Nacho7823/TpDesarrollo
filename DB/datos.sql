INSERT INTO `bebida` VALUES (1,0.5,700),(3,0,700),(5,0,0);

INSERT INTO `cliente` VALUES (0,'Joaquin dallafontana','23124519','joadf@gmail.com','rivadavia 2314',42.124,213.123),(1,'Gino Pighin','20459671232','gp@hotmail.com','25 de mayo 1231',541.213,12.321),(2,'Juan Pérez','20123456789','juan@example.com','Calle Falsa 123',-58.381592,-34.603722),(3,'María Gómez','27876543210','maria@example.com','Avenida Siempre Viva 742',-58.392592,-34.609722),(4,'Lila mussin','15463598372','lmusin@hotmail.com','bv galvez 1412',341.123,-123.421),(5,'Alma gimenez','20459763252','almagim@gmai.com','corrientes 1242',10.4211,21.123);

INSERT INTO `item_menu` VALUES (1,'Heineken','Cerveza',2300,'Bebida',2),(2,'Guaymallen','Alfajor',700,'Plato',3),(3,'CocaCola','Gaseosa',2100,'Bebida',2),(4,'Hamburguesa Simple','Sin nada',120000,'',2),(5,'Te de tilo','yuyos para dormir',50,'',2),(6,'Pan con queso','pan y queso',500,'',2),(7,'Tarta de choclo','la mejor tarta',123,'',0),(8,'empanada carne','empanada de carne',12312,'',0),(9,'Pizza simple','masa y queso',412,'',3),(10,'pizza mejor','mejor que cualquiera',921,'',3);

INSERT INTO `plato` VALUES (2,100,1,1,100),(4,0,0,1,0),(5,0,0,1,0),(6,0,0,1,0),(7,0,0,1,0),(8,0,0,1,0),(9,312,1,1,34.1),(10,2312,1,1,46.2);


INSERT INTO `vendedor` VALUES (0,'Luca Roa','urquiza 2341',53.123,12.4121),(1,'Franco Ferreira','J paso 4233',1.4512,2.12),(2,'Supermercado ABC','Av. Corrientes 1500',-58.383222,-34.603532),(3,'Verdulería El Tomate','Calle Libertad 2300',-58.384752,-34.606732),(4,'El loco pizza','bv galvez 3214',6.131,12.3421);
INSERT INTO cliente (id_cliente, nombre, cuit, email, direccion, longitud, latitud) VALUES
    (0, 'Luis Perez', '12345678901', 'p@gmail.com', 'Dorrego 123', 0.4, 0.1),
    (2, 'Pedro Gimenez', '34567415632', 'pgimenez@gmail.com', 'francia 2352', 0.42, 0.13),
    (1, 'Juan Martinez', '42195312394', 'jm@hotmail.com', 'rivadavia 5923', 0.45, 0.21);


INSERT INTO vendedor (id_vendedor, nombre, direccion, longitud, latitud) VALUES 
    (0, 'Lila Mussin', 'bv galvez 3124', 0.234, 0.634),
    (1, 'Joaquin Dallafontana', 'rivadavia 2415', 0.652, 0.543),
    (2, 'Alma Gimenez', 'corriente 5123', 0.523, 0.721);