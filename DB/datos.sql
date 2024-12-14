INSERT INTO coordenada (id_coordenada, longitud, latitud) VALUES 
    (1, 0.4, 0.1),
    (2, 0.42, 0.13),
    (3, 0.35, 0.71),
    (4, 0.23, 0.12),
    (5, 0.74, 0.73),
    (6, 0.21, 0.52);

INSERT INTO cliente (nombre, cuit, email, direccion, id_coordenada) VALUES
    ('Luis Perez', '12345678901', 'p@gmail.com', 'Dorrego 123', 1),
    ( 'Pedro Gimenez', '34567415632', 'pgimenez@gmail.com', 'francia 2352', 2),
    ( 'Juan Martinez', '42195312394', 'jm@hotmail.com', 'rivadavia 5923', 4),
    ('Joaquin dallafontana','23124519','joadf@gmail.com','rivadavia 2314', 2),
    ('Gino Pighin','20459671232','gp@hotmail.com','25 de mayo 1231', 4),
    ('Juan Pérez','20123456789','juan@example.com','Calle Falsa 123', 2),
    ('María Gómez','27876543210','maria@example.com','Avenida Siempre Viva 742', 6),
    ('Lila mussin','15463598372','lmusin@hotmail.com','bv galvez 1412', 5),
    ('Alma gimenez','20459763252','almagim@gmai.com','corrientes 1242', 2);



INSERT INTO vendedor (nombre, direccion, id_coordenada) VALUES 
    ( 'Lila loli', 'bv galvez 3124', 5),
    ( 'Joaquin Libreria', 'rivadavia 2415', 2),
    ( 'Alma more', 'corriente 5123', 1),
    ('Luca Patto','urquiza 2341', 6),
    ('Franco Ferretera','J paso 4233', 4),
    ('Supermercado ABC','Av. Corrientes 1500', 2),
    ('Verdulería El Tomate','Calle Libertad 2300', 1),
    ('El loco pizza','bv galvez 3214', 2);
    
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
