CREATE TABLE vendedor (
    id_vendedor int PRIMARY KEY,
    nombre varchar(20),
    direccion varchar(50),
    longitud DOUBLE PRECISION,
    latitud DOUBLE PRECISION
);

CREATE TABLE cliente (
    id_cliente int PRIMARY KEY,
    nombre varchar(20),
    cuit varchar(11),
    email varchar(80),
    direccion varchar(50),
    longitud DOUBLE PRECISION,
    latitud DOUBLE PRECISION
);

CREATE TABLE item_menu (
    id_item_menu int PRIMARY KEY,
    nombre varchar(20),
    descripcion varchar(100),
    precio DOUBLE PRECISION,
    categoria varchar(100),
    id_vendedor int REFERENCES vendedor(id_vendedor)
);

CREATE TABLE plato (
    id_item_menu int PRIMARY KEY REFERENCES item_menu(id_item_menu),
    calorias DOUBLE PRECISION,
    apto_celiaco BOOLEAN,
    apto_vegano BOOLEAN,
    peso DOUBLE PRECISION
);

CREATE TABLE bebida (
    id_item_menu int PRIMARY KEY REFERENCES item_menu(id_item_menu),
    graduacion_alcoholica DOUBLE PRECISION,
    tamanio DOUBLE PRECISION
);

CREATE TABLE pago (
    id_pago int PRIMARY KEY,
    monto DOUBLE PRECISION,
    fecha DATE
);

CREATE TABLE mercado_pago (
    id_pago int PRIMARY KEY REFERENCES pago(id_pago),
    alias varchar(20)
);

CREATE TABLE transferencia (
    id_pago int PRIMARY KEY REFERENCES pago(id_pago),
    cvu varchar(22),
    cuit varchar(11)
);

CREATE TABLE pedido (
    id_pedido int PRIMARY KEY,
    estado int,
    id_cliente int REFERENCES cliente(id_cliente),
    id_pago int REFERENCES pago(id_pago)
);

CREATE TABLE pedido_detalle (
    id_pedido int REFERENCES pedido(id_pedido),
    id_item_menu int REFERENCES item_menu(id_item_menu),
    PRIMARY KEY (id_pedido, id_item_menu)
);
