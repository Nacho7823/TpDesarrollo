CREATE TABLE vendedor (
    id_vendedor INT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    direccion VARCHAR(20) NOT NULL,
    longitud DECIMAL(9, 6) NOT NULL,
    latitud DECIMAL(9, 6) NOT NULL
);

CREATE TABLE cliente (
    id_cliente INT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    cuit VARCHAR(20) NOT NULL,
    email VARCHAR(20) NOT NULL,
    direccion VARCHAR(20) NOT NULL,
    longitud DECIMAL(9, 6) NOT NULL,
    latitud DECIMAL(9, 6) NOT NULL
);

CREATE TABLE item_menu (
    id_item_menu INT PRIMARY KEY,
    nombre VARCHAR(20) NOT NULL,
    descripcion VARCHAR(20) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    categoria VARCHAR(20) NOT NULL
);

CREATE TABLE vende (
    id_item_menu INT REFERENCES item_menu(id_item_menu),
    id_vendedor INT REFERENCES vendedor(id_vendedor),
    PRIMARY KEY(id_item_menu, id_vendedor)
);

CREATE TABLE plato (
    id_item_menu INT PRIMARY KEY REFERENCES item_menu(id_item_menu),
    calorias DECIMAL(5, 2) NOT NULL,
    apto_celiaco BOOLEAN,
    apto_vegano BOOLEAN,
    peso DECIMAL(5, 2) NOT NULL
);

CREATE TABLE bebida (
    id_item_menu INT PRIMARY KEY REFERENCES item_menu(id_item_menu),
    graduacion_alcoholica DECIMAL(5, 2) NOT NULL,
    tamanio DECIMAL(5, 2) NOT NULL
);

CREATE TABLE pago (
    id_pago INT PRIMARY KEY,
    monto DECIMAL(10, 2) NOT NULL,
    fecha DATE NOT NULL
);

CREATE TABLE mercado_pago (
    id_pago INT PRIMARY KEY REFERENCES pago(id_pago),
    alias VARCHAR(20) NOT NULL
);

CREATE TABLE transferencia (
    id_pago INT PRIMARY KEY REFERENCES pago(id_pago),
    cvu VARCHAR(20) NOT NULL,
    cuit VARCHAR(20) NOT NULL
);

CREATE TABLE pedido (
    id_pedido INT PRIMARY KEY,
    estado INT NOT NULL,
    id_cliente INT REFERENCES cliente(id_cliente),
    id_pago INT REFERENCES pago(id_pago),
    total DECIMAL(10, 2) NOT NULL
);

CREATE TABLE detalle_pedido (
    id_pedido INT REFERENCES pedido(id_pedido),
    id_item_menu INT REFERENCES item_menu(id_item_menu),
    cantidad INT NOT NULL,
    PRIMARY KEY (id_pedido, id_item_menu)
);

