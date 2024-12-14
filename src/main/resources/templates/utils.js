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

async function GET(url) {
    const response = await fetch(url);
    if (!response.ok)
        throw new Error("Error GET: " + response.status);
    return await response.json();
}
async function GET_ID(URL, plainbody) {
    const response = await fetch(URL, {
        method: "GET",
        headers: {
            'Content-Type': 'text/plain'
        },
        body: plainbody
    });
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

async function getClientes() {
    const clietnes = await GET("/cliente/clientes");
    console.log(clietnes);
    return await GET("/cliente/clientes");
}
async function getCliente(id) {
    return await GET_ID("/cliente/cliente", id);
}
async function createCliente(cliente) {
    return await POST("/cliente/cliente", cliente);
}
async function updateCliente(cliente) {
    return await PUT("/cliente/cliente", cliente);
}
async function deleteCliente(id) {
    return await DELETE("/cliente/cliente", id);
}

// vendedor

async function getVendedores() {
    const v = await GET("/vendedor/vendedores");
    console.log(v);
    return await GET("/vendedor/vendedores");
}
async function getVendedor(id) {
    return await GET_ID("/vendedor/vendedor", id);
}
async function createVendedor(vendedor) {
    return await POST("/vendedor/vendedor", vendedor);
}
async function updateVendedor(vendedor) {
    return await PUT("/vendedor/vendedor", vendedor);
}
async function deleteVendedor(id) {
    return await DELETE("/vendedor/vendedor", id);
}

// itemmenu

async function getItemMenus() {
    return await GET("/itemmenu/itemmenus");
}
async function getItemMenu(id) {
    return await GET_ID("/itemmenu/itemmenu", id);
}
// async function createItemMenu(itemmenu) {
//     const _item_menu = get(item_menusID);
//     itemmenu.id_item_menu = _item_menu.length + 5;
//     _item_menu.push(itemmenu);
//     save(item_menusID, _item_menu);
//     return await true;
// }
async function createBebida(bebida) {
    return await POST("/itemmenu/itemmenu", bebida);
}
async function createPlato(plato) {
    return await POST("/itemmenu/itemmenu", plato);
}
async function updateItemMenu(it) {
    return await PUT("/itemmenu/itemmenu", it);
}
async function deleteItemMenu(id) {
    return await DELETE("/itemmenu/itemmenu", id);
}

// pedidos

async function getPedidos() {
    return await GET("/pedido/pedidos");
}
async function getPedido(id) {
    return await GET_ID("/pedido/pedido", id);
}
async function createPedido(pedido) {
    return await POST("/pedido/pedido", pedido);
}
async function updatePedido(pedido) {
    return await PUT("/pedido/pedido", pedido);
}
async function deletePedido(id) {
    return await DELETE("/pedido/pedido", id);
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
    return await GET_ID("/detalle_pedido/detalle_pedido", id);
}

async function getItemsOfVendedor(id) {
    return await GET_ID("/detalle_pedido/detalle_pedido", id);
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

};