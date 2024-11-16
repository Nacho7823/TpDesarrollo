INSERT INTO cliente (id_cliente, nombre, cuit, email, direccion, longitud, latitud) VALUES
    ('Luis Perez', '12345678901', 'p@gmail.com', 'Dorrego 123', 0.4, 0.1),
    ( 'Pedro Gimenez', '34567415632', 'pgimenez@gmail.com', 'francia 2352', 0.42, 0.13),
    ( 'Juan Martinez', '42195312394', 'jm@hotmail.com', 'rivadavia 5923', 0.45, 0.21),
    ('Joaquin dallafontana','23124519','joadf@gmail.com','rivadavia 2314',42.124,13.123),
    ('Gino Pighin','20459671232','gp@hotmail.com','25 de mayo 1231',51.213,12.321),
    ('Juan Pérez','20123456789','juan@example.com','Calle Falsa 123',-58.381592,-34.603722),
    ('María Gómez','27876543210','maria@example.com','Avenida Siempre Viva 742',-58.392592,-34.609722),
    ('Lila mussin','15463598372','lmusin@hotmail.com','bv galvez 1412',31.123,-13.421),
    ('Alma gimenez','20459763252','almagim@gmai.com','corrientes 1242',10.4211,21.123);



INSERT INTO vendedor (id_vendedor, nombre, direccion, longitud, latitud) VALUES 
    ( 'Lila loli', 'bv galvez 3124', 0.234, 0.634),
    ( 'Joaquin Libreria', 'rivadavia 2415', 0.652, 0.543),
    ( 'Alma more', 'corriente 5123', 0.523, 0.721),
    ('Luca Patto','urquiza 2341',53.123,12.4121),
    ('Franco Ferretera','J paso 4233',1.4512,2.12),
    ('Supermercado ABC','Av. Corrientes 1500',-58.383222,-34.603532),
    ('Verdulería El Tomate','Calle Libertad 2300',-58.384752,-34.606732),
    ('El loco pizza','bv galvez 3214',6.131,12.3421);
    
    INSERT INTO item_menu (nombre, descripcion, precio, categoria) VALUES
    ('Heineken','Cerveza',2300,'Bebida'),
    ('Guaymallen','Alfajor',700,'Plato'),
    ('CocaCola','Gaseosa',2100,'Bebida'),
    ('Hamburguesa Simple','Sin nada',12000,'Plato'),
    ('Te de tilo','yuyos para dormir',50,'Bebida'),
    ('Pan con queso','pan y queso',500,'Plato'),
    ('Tarta de choclo','la mejor tarta',123,'Plato'),
    ('empanada carne','empanada de carne',12312,'Plato'),
    ('Pizza simple','masa y queso',412,'Plato'),
    ('pizza mejor','mejor que cualquiera',921,'Plato'),
    ('Pritty','mas fresca que cualquiera',4331,'Bebida'),
    ('Agua mineral','mas fresca que Coca Cola',2311,'Bebida');

INSERT INTO `plato` VALUES 
(2,100,1,1,100),
(4,0,0,1,0),
(6,0,0,1,0),
(7,0,0,1,0),
(8,0,0,1,0),
(9,312,1,1,34.1),
(10,2312,1,1,46.2);

INSERT INTO `bebida` VALUES
 (1,0.5,700),
 (3,0,700),
 (5,0,0),
 (11,0,1200),
 (12,0,1200);
 
 INSERT INTO vende (id_item_menu, id_vendedor) VALUES
    (1, 1), -- Heineken vendida por Joaquin Libreria
    (1, 5), -- Heineken también vendida por Supermercado ABC
    (2, 3), -- Guaymallen vendido por Alma more
    (2, 6), -- Guaymallen también vendido por Verdulería El Tomate
    (3, 1), -- CocaCola vendida por Joaquin Libreria
    (3, 5), -- CocaCola también vendida por Supermercado ABC
    (4, 7), -- Hamburguesa Simple vendida por El loco pizza
    (5, 3), -- Té de tilo vendido por Alma more
    (6, 6), -- Pan con queso vendido por Verdulería El Tomate
    (7, 6), -- Tarta de choclo vendida por Verdulería El Tomate
    (8, 7), -- Empanada de carne vendida por El loco pizza
    (9, 7), -- Pizza simple vendida por El loco pizza
    (10, 7), -- Pizza mejor vendida por El loco pizza
    (11, 1), -- Pritty vendida por Joaquin Libreria
    (11, 5), -- Pritty también vendida por Supermercado ABC
    (12, 5), -- Agua mineral vendida por Supermercado ABC
    (12, 6); -- Agua mineral también vendida por Verdulería El Tomate
