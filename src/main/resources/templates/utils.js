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
    if (!response.ok) {
        alert("Error DELETE: " + response.status);
        throw new Error("Error DELETE: " + response.status);
    }
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

function Pedido2DTO(pedido) {
    console.log("pedido", pedido);
    const f = pedido.fecha;
    // `${year}-${month}-${day}`;
    const fecha = f.getFullYear() + "-" + (f.getMonth() + 1) + "-" + f.getDate();
    return {
        estado: pedido.estado,
        id_cliente: pedido.id_cliente,
        id_vendedor: pedido.id_vendedor,
        detalle_pedido: pedido.detalle_pedido,

        formapago: pedido.formapago,
        monto: pedido.monto,
        fecha: fecha,
        cvu: pedido.cvu,
        cuit: pedido.cuit,
        alias: pedido.alias
    }
}

function DTO2Pedido(dto) {

    console.log(dto);
    /*
    const detalle_pedido = [];
    for (const value of itemsAdded) {
        detalle_pedido.push({
            id_item_menu: value.id_item_menu,
            cantidad: value.cantidad
        });
    }

    const tmp = {
        estado: pedido.estado,
        id_cliente: pedido.id_cliente,
        id_vendedor: pedido.id_vendedor,
        detalle_pedido: detalle_pedido,

        formapago: pedido.formapago,
        monto: pedido.total,
        fecha: new Date(),
        cvu: pedido.cvu,
        cuit: pedido.cuit,
        alias: pedido.alias
    };
    */
    
    console.log("pago", dto.pago);
    console.log("fecha", dto.pago);
    const f = dto.pago.fecha;
    console.log(f);
    const [anio, mes, dia] = f.split("-").map(Number);
    const fecha = new Date(anio, mes - 1, dia); // Meses en JS son 0-indexados

    const detalle_pedido = [];
    for (const value of dto.items) {
        detalle_pedido.push({
            id_item_menu: value.id_item_menu.id_item_menu,  //TODO: fix
            cantidad: value.cantidad
        })
    }

    return {
        id_pedido: dto.id_pedido,
        estado: dto.estado,
        id_cliente: dto.id_cliente.id_cliente,         // FIXME
        id_vendedor: dto.id_vendedor.id_vendedor,       // FIXME

        detalle_pedido: detalle_pedido,

        formapago: dto.pago.alias == null ? "transferencia" : "mercadopago",
        monto: dto.pago.monto,
        fecha: fecha,
        cvu: dto.pago.cvu,
        cuit: dto.pago.cuit,
        alias: dto.pago.alias
    }
}

// ------------------------------------------------------------------------
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
    return await POST("/cliente/cliente", Cliente2DTO(cliente));
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

// vende
async function getVende(id_item_menu, id_vendedor) {
    const id = id_item_menu + "-" + id_vendedor;
    return await GET_ID("/vende/vende", id);
}
async function createVende(id_item_menu, id_vendedor) {
    return await POST("/vende/vende", { id_item_menu: id_item_menu, id_vendedor: id_vendedor });
}
async function deleteVende(id_item_menu, id_vendedor) {
    return await DELETE("/vende/vende", { id_item_menu: id_item_menu, id_vendedor: id_vendedor });
}


// pedidos

async function getPedidos() {
    const dtos = await GET("/pedidos/pedidos");
    const pedidos = dtos.map(DTO2Pedido);
    return pedidos;
}
async function getPedido(id) {
    return DTO2Pedido(await GET_ID("/pedidos/pedido", id));
}
async function createPedido(pedido) {
    const p = Pedido2DTO(pedido);
    console.log("dto", p);
    return await POST("/pedidos/pedido", Pedido2DTO(pedido));
}
async function updatePedido(pedido) {
    return await PUT("/pedidos/pedido", Pedido2DTO(pedido));
}
async function deletePedido(pedido) {
    console.log(pedido);
    return await DELETE("/pedidos/pedido", Pedido2DTO(pedido));
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
    const dtos = await GET_ID("/itemmenu/itemmenusOfPedido", id);
    console.log(dtos);

    const items = dtos.map((item) => {
        return {
            cantidad: item.cantidad,
            item_menu: DTO2ItemMenu(item.id_item_menu)
        }
    });
    return items
}

async function getItemsOfVendedor(id) {
    const dtos = await GET_ID("/itemmenu/itemmenusOfVendedor", id);
    const items = dtos.map(DTO2ItemMenu);
    return items;
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

    getVende,
    createVende,
    deleteVende,

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