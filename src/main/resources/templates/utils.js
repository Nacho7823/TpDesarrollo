async function GET(url) {
    const response = await fetch(url);
    if (!response.ok)
        throw new Error("Error GET: " + response.status);
    return await response.json();
}
async function GET_ID(URL, id) {
    const response = await fetch(URL + "/" + id);
    if (!response.ok)
        throw new Error("Error GET: " + response.status);
    return await response.json();
}

async function POST(url, body) {
    const response = await fetch(window.location.origin + url, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    });
    if (!response.ok)
        throw new Error("Error POST: " + response.status);
    return await response.json();
}
async function PUT(url, body) {
    const response = await fetch(window.location.origin + url, {
        method: "PUT",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    });
    if (!response.ok)
        throw new Error("Error PUT: " + response.status);
    return await response.json();
}
async function DELETE(url, body) {
    const response = await fetch(window.location.origin + url, {
        method: "DELETE",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    });
    if (!response.ok)
        throw new Error("Error DELETE: " + response.status);
    return await response.json();
}

// ------------------------------------------------------------------------

function DTO2Cliente(dto) {
    return {
        id_cliente: dto.id_cliente,
        nombre: dto.nombre,
        cuit: dto.cuit,
        email: dto.email,
        direccion: dto.direccion,
        id_coordenada: dto.coordenada.id_coordenada,
        latitud: dto.coordenada.latitud,
        longitud: dto.coordenada.longitud
    }
}
function Cliente2DTO(cliente) {
    return {
        id_cliente: cliente.id_cliente,
        nombre: cliente.nombre,
        cuit: cliente.cuit,
        email: cliente.email,
        direccion: cliente.direccion,
        coordenada: {
            id_coordenada: cliente.id_coordenada,
            latitud: cliente.latitud,
            longitud: cliente.longitud
        }
    }
}

function DTO2Vendedor(dto) {
    return {
        id_vendedor: dto.id_vendedor,
        nombre: dto.nombre,
        direccion: dto.direccion,
        id_coordenada: dto.coordenada.id_coordenada,
        latitud: dto.coordenada.latitud,
        longitud: dto.coordenada.longitud
    }
}

function Vendedor2DTO(vendedor) {
    return {
        id_vendedor: vendedor.id_vendedor,
        nombre: vendedor.nombre,
        direccion: vendedor.direccion,
        items: [],
        coordenada: {
            id_coordenada: vendedor.id_coordenada,
            latitud: vendedor.latitud,
            longitud: vendedor.longitud
        }
    }
}

function DTO2ItemMenu(dto) {
    return {
        id_item_menu: dto.id_item_menu,
        nombre: dto.nombre,
        descripcion: dto.descripcion,
        precio: dto.precio,
        categoria: dto.categoria,
        peso: dto.peso,
        apto_vegano: dto.aptoVegano,
        apto_celiaco: dto.aptoCeliaco,
        calorias: dto.calorias,
        graduacion_alcoholica: dto.graduacion_alcoholica,
        tamanio: dto.tamanio
    };
}
function ItemMenu2DTO(itemMenu) {
    return {
        id_item_menu: itemMenu.id_item_menu,
        nombre: itemMenu.nombre,
        descripcion: itemMenu.descripcion,
        precio: itemMenu.precio == null ? null : itemMenu.precio.toFixed(2),
        categoria: itemMenu.categoria,
        peso: itemMenu.peso == null ? null : itemMenu.peso.toFixed(2),
        aptoVegano: itemMenu.apto_vegano,
        aptoCeliaco: itemMenu.apto_celiaco,
        calorias: itemMenu.calorias == null ? null : itemMenu.calorias.toFixed(2),
        graduacion_alcoholica: itemMenu.graduacion_alcoholica == null ? null : itemMenu.graduacion_alcoholica.toFixed(2),
        tamanio: itemMenu.tamanio == null ? null : itemMenu.tamanio.toFixed(2)
    };
}

// ------------------------------------------------------------------------

async function getClientes() {
    const clientesDTOs = await GET("/cliente/clientes");
    const clientes = clientesDTOs.map(DTO2Cliente);
    return clientes;
}
async function getCliente(id) {
    return DTO2Cliente(await GET_ID("/cliente/cliente", id));
}
async function createCliente(cliente) {
    return DTO2Cliente(await POST("/cliente/cliente", Cliente2DTO(cliente)));
}
async function updateCliente(cliente) {
    return await PUT("/cliente/cliente", Cliente2DTO(cliente));
}
async function deleteCliente(cliente) {
    return await DELETE("/cliente/cliente", Cliente2DTO(cliente));
}

// vendedor

async function getVendedores() {
    const vendedoresDTOs = await GET("/vendedor/vendedores");
    console.log("vendedoresDTOs", vendedoresDTOs);
    const vendedores = vendedoresDTOs.map(DTO2Vendedor);
    return vendedores;
}
async function getVendedor(id) {
    return DTO2Vendedor(await GET_ID("/vendedor/vendedor", id));
}
async function createVendedor(vendedor) {
    return await POST("/vendedor/vendedor", Vendedor2DTO(vendedor));
}
async function updateVendedor(vendedor) {
    return await PUT("/vendedor/vendedor", Vendedor2DTO(vendedor));
}
async function deleteVendedor(vendedor) {
    return await DELETE("/vendedor/vendedor", Vendedor2DTO(vendedor));
}

// itemmenu

async function getItemMenus() {
    const itemMenusDTOs = await GET("/itemmenu/itemmenus");
    const itemMenus = itemMenusDTOs.map(DTO2ItemMenu);
    return itemMenus;
}
async function getItemMenu(id) {
    return DTO2ItemMenu(await GET_ID("/itemmenu/itemmenu", id));
}
async function createItemMenu(itemmenu) {
    return await POST("/itemmenu/itemmenu", ItemMenu2DTO(itemmenu));
}
async function updateItemMenu(it) {
    return await PUT("/itemmenu/itemmenu", ItemMenu2DTO(it));
}
async function deleteItemMenu(it) {
    return await DELETE("/itemmenu/itemmenu", ItemMenu2DTO(it));
}

// pedidos

async function getPedidos() {
    const pedidosDTOs = await GET("/pedidos/pedidos");
    console.log("pedidosDTOs", pedidosDTOs);
    return await GET("/pedidos/pedidos");
}
async function getPedido(id) {
    return await GET_ID("/pedidos/pedido", id);
}
async function createPedido(pedido) {
    console.log(pedido);
    return await POST("/pedidos/pedido", pedido);
}
async function updatePedido(pedido) {
    return await PUT("/pedidos/pedido", pedido);
}
async function deletePedido(pedido) {
    console.log(pedido);
    return await DELETE("/pedidos/pedido", pedido);
}

// detalle_pedido
async function getDetallePedido(id) {
    return await GET_ID("/detalle_pedido/detalle_pedido", id);
}

async function createDetalles(detalle_pedido) {
    return await POST("/detalle_pedido/detalle_pedido", detalle_pedido);
}

// others

async function getItemsOfPedido(id) {
    return await GET_ID("/itemmenu/itemmenusOfPedido", id);
}

async function getItemsOfVendedor(id) {
    return await GET_ID("/itemmenu/itemmenusOfVendedor", id);
}


export {
    getClientes,
    getCliente,
    createCliente,
    updateCliente,
    deleteCliente,

    getVendedores,
    getVendedor,
    createVendedor,
    updateVendedor,
    deleteVendedor,

    getItemMenus,
    getItemMenu,
    createItemMenu,
    updateItemMenu,
    deleteItemMenu,

    getPedidos,
    getPedido,
    createPedido,
    updatePedido,
    deletePedido,

    getDetallePedido,
    createDetalles,

    getItemsOfPedido,
    getItemsOfVendedor,

};