/*
async function GET(url) {
    return await fetch(url);
}
async function GET(URL, plainbody) {
    return await fetch(URL, {
        method: "GET",
        headers: {
            'Content-Type': 'text/plain'
        },
        body: plainbody
    });
}

async function POST(URL, body) {
    return await fetch(URL, {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    });
}

async function PUT(URL, body) {
    return await fetch(URL, {
        method: "PUT",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    });
}

async function DELETE(URL, body) {
    return await fetch(URL, {
        method: "DELETE",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify(body)
    });
}



async function getClientes() {
    const response = await GET(window.location.origin + "/cliente/clientes");
    if (!response.ok) {
        console.log("no se pudieron obtener los clientes");
        return null;
    }
    return await response.json();
}
async function getVendedores() {
    const response = await GET(window.location.origin + "/vendedor/vendedores");
    if (!response.ok) {
        console.log("no se pudieron obtener los vendedores");
        return null;
    }
    return await response.json();
}

async function getCliente(id) {
    const response = await GET(window.location.origin + "/cliente/cliente", id);

    if (!response.ok) {
        console.log("no se pudo obtener el cliente: response not ok");
        return null;
    }
    
    return await response.json();
}

async function getVendedor(id) {
    const response = await GET(window.location.origin + "/vendedor/vendedor", id);

    if (!response.ok) {
        console.log("no se pudo obtener el vendedor: response not ok");
        return null;
    }
    
    return await response.json();
}

async function updateCliente(cliente) {
    return await PUT(window.location.origin + "/cliente/cliente", cliente);
}

async function updateVendedor(cliente) {
    return await PUT(window.location.origin + "/cliente/cliente", cliente);
}


async function createCliente(cliente) {
    const response = await fetch(window.location.origin + "/cliente/cliente", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            nombre: nombre,
            cuit: cuit,
            email: email,
            direccion: direccion,
            longitud: longitud,
            latitud: latitud
        })
    });.then(response => {
        if (!response.ok) {
            alert("no se pudo crear el cliente: " + " - " + response.status);
            return;
        }
        window.location.href = "../cliente.html";
    }).catch(e => {
        alert(e);
    });
}


*/


/*

const response = await fetch(window.location.origin + "/pedido/pedido", {
        method: "DELETE",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id_pedido: id
        })
    });
    if (!response.ok) {
        alert("no se pudo eliminar el pedido: " + id);
        return;
    }*/

/*

fetch(window.location.origin + "/vendedor/vendedor", {
    method: "POST",
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
        nombre: nombre,
        direccion: direccion,
        longitud: longitud,
        latitud: latitud
    })
}).then(response => {
    if (!response.ok) {
        alert("no se pudo crear el vendedor: " + " - " + response.status);
        return;
    }
    window.location.href = "../vendedor.html";
}).catch(e => {
    alert(e);
});
 
fetch(window.location.origin + "/vendedor/vendedor", {
    method: "PUT",
    headers: {
        'Content-Type': 'application/json'
    },
    body: JSON.stringify({
        id_vendedor: id,
        nombre: nombre,
        direccion: direccion,
        longitud: longitud,
        latitud: latitud
    })
}).then(response => {
    if (!response.ok) {
        alert("no se pudo modificar el vendedor: " + id);
        return;
    }
    window.location.href = "../vendedor.html";
}).catch(e => {
    alert(e);
});
 
*/



function get(id) {
    const lc = sessionStorage.getItem(id);
    if (lc == "" || lc == null) {
        return [];
    }
    const obj = JSON.parse(lc);
    return obj;
}
function save(id, value) {
    sessionStorage.setItem(id, JSON.stringify(value));
}

async function getClientes() {
    const _cliente = get(clientesID);
    return _cliente;
}
async function getCliente(id) {
    const _cliente = get(clientesID);
    return _cliente.find(cliente => cliente.id_cliente == id);
}
async function createCliente(cliente) {
    const _cliente = get(clientesID);
    cliente.id_cliente = _cliente.length + 5;
    _cliente.push(cliente);
    save(clientesID, _cliente);
    return true;
}
async function updateCliente(cliente) {
    const _cliente = get(clientesID);
    const index = _cliente.findIndex(c => c.id_cliente == cliente.id_cliente);
    _cliente[index] = cliente;
    save(clientesID, _cliente);
    return true;
}
async function deleteCliente(id) {
    let _cliente = get(clientesID);
    _cliente = _cliente.filter(cliente => cliente.id_cliente != id);
    save(clientesID, _cliente);
    return true;
}

// vendedor

async function getVendedores() {
    const _vendedor = get(vendedoresID);
    return _vendedor;
}
async function getVendedor(id) {
    const _vendedor = get(vendedoresID);
    return _vendedor.find(vendedor => vendedor.id_vendedor == id);
}
async function createVendedor(vendedor) {
    const _vendedor = get(vendedoresID);
    vendedor.id_vendedor = _vendedor.length + 5;
    _vendedor.push(vendedor);
    save(vendedoresID, _vendedor);
    return true;
}
async function updateVendedor(vendedor) {
    const _vendedor = get(vendedoresID);
    const index = _vendedor.findIndex(v => v.id_vendedor == vendedor.id_vendedor);
    _vendedor[index] = vendedor;
    save(vendedoresID, _vendedor);
    return true;
}
async function deleteVendedor(id) {
    let _vendedor = get(vendedoresID);
    _vendedor = _vendedor.filter(vendedor => vendedor.id_vendedor != id);
    save(vendedoresID, _vendedor);
    return true;
}


// vende

async function getVende(id_item_menu, id_vendedor) {
    const _vende = get(vendeID);
    const index = _vende.findIndex(v => v.id_item_menu == id_item_menu && v.id_vendedor == id_vendedor);
    if (index == -1) {
        return false;
    }
    return true;
}
async function createVende(id_item_menu, id_vendedor) {
    const _vende = get(vendeID);
    // find if exists
    const index = _vende.findIndex(v => v.id_item_menu == id_item_menu && v.id_vendedor == id_vendedor);
    if (index != -1) {
        // update
        _vende[index].id_item_menu = id_item_menu;
        _vende[index].id_vendedor = id_vendedor;
        save(vendeID, _vende);
        return true;
    }
    const vende = {
        id_vende: _vende.length + 5,
        id_item_menu: id_item_menu,
        id_vendedor: id_vendedor
    };

    _vende.push(vende);
    save(vendeID, _vende);
    return true;
}

async function deleteVende(id_item_menu, id_vendedor) {
    let _vende = get(vendeID);
    _vende = _vende.filter(v => (v.id_item_menu != id_item_menu || v.id_vendedor != id_vendedor));
    save(vendeID, _vende);

    return true;
}

// itemmenu

async function getItemMenus() {
    const _item_menu = get(item_menusID);
    return _item_menu;
}
async function getItemMenu(id) {
    const _item_menu = get(item_menusID);
    return _item_menu.find(item => item.id_item_menu == id);
}
// async function createItemMenu(itemmenu) {
//     const _item_menu = get(item_menusID);
//     itemmenu.id_item_menu = _item_menu.length + 5;
//     _item_menu.push(itemmenu);
//     save(item_menusID, _item_menu);
//     return true;
// }
async function createBebida(bebida) {
    const _item_menu = get(item_menusID);
    bebida.id_item_menu = _item_menu.length + 5;
    _item_menu.push(bebida);
    save(item_menusID, _item_menu);
    return true;
}
async function createPlato(plato) {
    const _item_menu = get(item_menusID);
    plato.id_item_menu = _item_menu.length + 5;
    _item_menu.push(plato);
    save(item_menusID, _item_menu);
    return true;
}
async function updateItemMenu(it) {
    const _item_menu = get(item_menusID);
    const index = _item_menu.findIndex(item => item.id_item_menu == it.id_item_menu);
    _item_menu[index] = it;
    save(item_menusID, _item_menu);
    return true;
}
async function deleteItemMenu(id) {
    let _item_menu = get(item_menusID);
    _item_menu = _item_menu.filter(itemmenu => itemmenu.id_item_menu != id);
    save(item_menusID, _item_menu);
    return true;
}

// pedidos

async function getPedidos() {
    const _pedido = get(pedidosID);
    return _pedido;
}
async function getPedido(id) {
    const _pedido = get(pedidosID);
    return _pedido.find(pedido => pedido.id_pedido == id);
}
async function createPedido(pedido) {
    const _pedido = get(pedidosID);
    pedido.id_pedido = _pedido.length + 5;
    _pedido.push(pedido);
    save(pedidosID, _pedido);
    return pedido.id_pedido;
}
async function updatePedido(pedido) {
    const _pedido = get(pedidosID);
    const index = _pedido.findIndex(p => p.id_pedido == pedido.id_pedido);
    _pedido[index] = pedido;
    save(pedidosID, _pedido);
    return true;
}
async function deletePedido(id) {
    let _pedido = get(pedidosID);
    _pedido = _pedido.filter(pedido => pedido.id_pedido != id);
    save(pedidosID, _pedido);
    return true;
}

// detalle_pedido
async function getDetallePedido(id) {
    const _detalle_pedido = get(detalle_pedidoID);
    return _detalle_pedido.find(detalle_pedido => detalle_pedido.id_pedido == id);
}

async function createDetalles(detalle_pedido) {
    const _detalle_pedido = get(detalle_pedidoID);
    _detalle_pedido.push(detalle_pedido);
    save(detalle_pedidoID, _detalle_pedido);
    return true;
}

// others

async function getItemsOfPedido(id) {
    const _detalle_pedido = get(detalle_pedidoID);
    const _item_menu = get(item_menusID);
    console.log(_detalle_pedido);
    const items = [];
    for (const det of _detalle_pedido) {
        if (det.id_pedido == id) {
            const cantidad = det.cantidad;
            const item = _item_menu.find(item => item.id_item_menu == det.id_item_menu);
            items.push({item, cantidad});
        }
    }

    return items;
}

async function getItemsOfVendedor(id) {
    const _vende = get(vendeID);
    const _item_menu = get(item_menusID);
    const items = []
    for (const vende of _vende) {
        if (vende.id_vendedor == id) {
            items.push(_item_menu.find(item => item.id_item_menu == vende.id_item_menu));
        }
    }

    return items;
}


const clientesID = "clientesID";
const vendedoresID = "vendedoresID";
const item_menusID = "item_menusID";
const pedidosID = "pedidosID";
const detalle_pedidoID = "detalle_pedidoID";
const vendeID = "vendeID";
const pagoID = "pagoID";
const mercadoPagoID = "mercadoPagoID";
const transferenciaID = "transferenciaID";

const __cliente = [
    {
        id_cliente: 1,
        nombre: "Juan Perez",
        cuit: "20334591822",
        email: "jp@gmail.com",
        direccion: "bv galvez 1412",
        longitud: 0.021,
        latitud: 0.32
    },
    {
        id_cliente: 2,
        nombre: "Maria Lopez",
        cuit: "20334591822",
        email: "jp@gmail.com",
        direccion: "bv galvez 1412",
        longitud: 0.021,
        latitud: 0.32
    }
];

const __vendedor = [
    {
        id_vendedor: 1,
        nombre: "Delca",
        direccion: "Av gral paz 123",
        longitud: 0.234,
        latitud: 0.412
    },
    {
        id_vendedor: 2,
        nombre: "Alvear",
        direccion: "junin 3212",
        longitud: 0.345,
        latitud: 0.532
    }
];

const __item_menu = [
    {
        id_item_menu: 1,
        nombre: "cocacola",
        descripcion: "gaeosa",
        precio: 2000,
        categoria: "Bebida",
        peso: null,
        apto_vegano: null,
        apto_celiaco: null,
        calorias: null,
        graduacion_alcoholica: 0.0,
        tamanio: 700
    },
    {
        id_item_menu: 2,
        nombre: "pizza",
        descripcion: "comida italiana",
        precio: 2000,
        categoria: "Plato",
        peso: 700,
        apto_vegano: true,
        apto_celiaco: true,
        calorias: 1500,
        graduacion_alcoholica: null,
        tamanio: null
    }
];

const __vende = [
    {
        id_vende: 0,
        id_item_menu: 1,
        id_vendedor: 1
    },
    {
        id_vende: 1,
        id_item_menu: 2,
        id_vendedor: 1
    }
];

const __detalle_pedido = [
    {
        id_pedido: 1,
        id_item_menu: 1,
        cantidad: 10
    },
    {
        id_pedido: 1,
        id_item_menu: 2,
        cantidad: 5
    }
];

const __pedido = [
    {
        id_pedido: 1,
        id_cliente: 1,
        id_vendedor: 1,
        estado: "ENVIADO",
        id_pago: 1,
        total: 200
    }
];

const __pago = [
    {
        id_pago: 1,
        monto: 200,
        fecha: "2023-02-20"
    }
];

const __mercado_pago = [
    {
        id_pago: 1,
        alias: "mercadopago.mp",
    }
]

const __transferencia = [];

function load() {
    if (get(clientesID).length > 0)
        return;

    save(clientesID, __cliente);
    save(vendedoresID, __vendedor);
    save(item_menusID, __item_menu);
    save(vendeID, __vende);
    save(detalle_pedidoID, __detalle_pedido);
    save(pedidosID, __pedido);
    save(pagoID, __pago);
    save(mercadoPagoID, __mercado_pago);
    save(transferenciaID, __transferencia);
}
load();


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

    getVende,
    createVende,
    deleteVende,

    getItemMenus,
    getItemMenu,
    // createItemMenu,
    createBebida,
    createPlato,
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

    load
};