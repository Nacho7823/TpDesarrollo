CREATE TABLE coordenada (
    id_coordenada BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    longitud DECIMAL(9, 6) NOT NULL,
    latitud DECIMAL(9, 6) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE vendedor (
    id_vendedor BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    id_coordenada BIGINT UNSIGNED,
    FOREIGN KEY (id_coordenada) REFERENCES coordenada(id_coordenada) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE cliente (
    id_cliente BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    cuit VARCHAR(20) NOT NULL,
    email VARCHAR(50) NOT NULL,
    direccion VARCHAR(50) NOT NULL,
    id_coordenada BIGINT UNSIGNED,
    FOREIGN KEY (id_coordenada) REFERENCES coordenada(id_coordenada) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE item_menu (
    id_item_menu VARCHAR(30) PRIMARY KEY,
    nombre VARCHAR(30) NOT NULL,
    descripcion VARCHAR(50) NOT NULL,
    precio DECIMAL(10, 2) NOT NULL,
    categoria VARCHAR(20) NOT NULL
) ENGINE=InnoDB;

CREATE TABLE vende (
    id_item_menu VARCHAR(30),
    id_vendedor BIGINT UNSIGNED,
    PRIMARY KEY(id_item_menu, id_vendedor),
    FOREIGN KEY (id_item_menu) REFERENCES item_menu(id_item_menu) ON DELETE CASCADE,
    FOREIGN KEY (id_vendedor) REFERENCES vendedor(id_vendedor) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE plato (
    id_item_menu VARCHAR(30) PRIMARY KEY,
    calorias DECIMAL(8, 2) NOT NULL,
    apto_celiaco BOOLEAN,
    apto_vegano BOOLEAN,
    peso DECIMAL(5, 2) NOT NULL,
    FOREIGN KEY (id_item_menu) REFERENCES item_menu(id_item_menu) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE bebida (
    id_item_menu VARCHAR(30) PRIMARY KEY,
    graduacion_alcoholica DECIMAL(5, 2) NOT NULL,
    tamanio DECIMAL(8, 2) NOT NULL,
    FOREIGN KEY (id_item_menu) REFERENCES item_menu(id_item_menu) ON DELETE CASCADE
) ENGINE=InnoDB;

CREATE TABLE pago (
    id_pago BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    monto DECIMAL(10, 2) NOT NULL,
    fecha DATE NOT NULL
) ENGINE=InnoDB;

CREATE TABLE mercado_pago (
    id_pago BIGINT UNSIGNED PRIMARY KEY,
    alias VARCHAR(20) NOT NULL,
    FOREIGN KEY (id_pago) REFERENCES pago(id_pago)
) ENGINE=InnoDB;

CREATE TABLE transferencia (
    id_pago BIGINT UNSIGNED PRIMARY KEY,
    cvu VARCHAR(20) NOT NULL,
    cuit VARCHAR(20) NOT NULL,
    FOREIGN KEY (id_pago) REFERENCES pago(id_pago)
) ENGINE=InnoDB;

CREATE TABLE pedido (
    id_pedido BIGINT UNSIGNED AUTO_INCREMENT PRIMARY KEY,
    estado INT NOT NULL,
    id_cliente BIGINT UNSIGNED,
    id_vendedor BIGINT UNSIGNED,
    id_pago BIGINT UNSIGNED,
    total DECIMAL(10, 2) NOT NULL,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_vendedor) REFERENCES vendedor(id_vendedor),
    FOREIGN KEY (id_pago) REFERENCES pago(id_pago)
) ENGINE=InnoDB;

CREATE TABLE detalle_pedido (
    id_pedido BIGINT UNSIGNED,
    id_item_menu VARCHAR(30),
    cantidad INT NOT NULL,
    PRIMARY KEY (id_pedido, id_item_menu),
    FOREIGN KEY (id_pedido) REFERENCES pedido(id_pedido),
    FOREIGN KEY (id_item_menu) REFERENCES item_menu(id_item_menu)
) ENGINE=InnoDB;
