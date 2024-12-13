// {
//     "id_cliente": 1,
//     "nombre": "cliente 1",
//     "cuit": "cuit 1",
//     "email": "email 1",
//     "direccion": "direccion 1",
//     "longitud": "longitud 1",
//     "latitud": "latitud 1"
// }


const btnVendedor = document.getElementById("btn-vendedorui")
const btnItemMenu = document.getElementById("btn-itemmenuui")
const btnPedidos = document.getElementById("btn-pedidosui")

btnVendedor.addEventListener("click", () => window.location.href = "../vendedor/vendedor.html");
btnItemMenu.addEventListener("click", () => window.location.href = "../itemmenu/itemmenu.html");
btnPedidos.addEventListener("click", () => window.location.href = "../pedidos/pedidos.html");


const btnCrear = document.getElementById("btn-crear");
const btnBuscar = document.getElementById("btn-buscar");
const inputBuscarId = document.getElementById("input-buscar-id");
const inputBuscarNombre = document.getElementById("input-buscar-nombre");

inputBuscarId.type = "number";

const clientes = [];

btnCrear.addEventListener("click", () => window.location.href = "crear/clientecrear.html");
btnBuscar.addEventListener("click", () => {
    id = inputBuscarId.value;
    nombre = inputBuscarNombre.value;

    const filter = [];
    for (const cliente of clientes) {
        if (id == "" && nombre == "") {
            filter.push(cliente);
        }
        else if (id == "") {
            if (cliente.nombre == nombre) {
                filter.push(cliente);
            }
        }
        else if (nombre == "") {
            if (cliente.id_vendedor == id) {
                filter.push(cliente);
            }
        }
        else if (cliente.id_vendedor == id && cliente.nombre == nombre) {
            filter.push(cliente);
        }
    }

    clearTable();
    for (const v of filter) {
        addRow(v);
    }

});

async function load() {
    const response = await fetch(window.location.origin + "/clientes");
    if (!response.ok) {
        alert("no se pudieron obtener los clientes");
        return;
    }
    const clienteslist = await response.json();
    for (const v of clienteslist) {
        clientes.push(v);
    }
    clientes.forEach(cliente => {
        addRow(cliente);
    });
};

load();


function addRow(cliente) {
    const row = document.createElement('tr');

    createCell = (text) => {
        const cell = document.createElement('th');
        cell.textContent = text;
        return cell;
    }
    createBtn = (text, action) => {
        const btn = document.createElement('button');
        btn.textContent = text;
        btn.classList.add("btntable");
        btn.addEventListener("click", action);

        const cell = document.createElement('th');
        cell.appendChild(btn);
        return cell;
    }

    row.appendChild(createCell(cliente.id_cliente))
    row.appendChild(createCell(cliente.nombre));
    row.appendChild(createCell(cliente.cuit));
    row.appendChild(createCell(cliente.email));
    row.appendChild(createCell(cliente.direccion));
    row.appendChild(createCell(cliente.longitud));
    row.appendChild(createCell(cliente.latitud));
    row.appendChild(createBtn("editar", () => modificarcliente(cliente.id_cliente)));
    row.appendChild(createBtn("eliminar", () => eliminarCliente(cliente.id_cliente)));

    const tbod = document.getElementById("tablebody");
    tbod.appendChild(row)
}



function clearTable() {
    const tbod = document.getElementById("tablebody");
    while (tbod.firstChild) {
        tbod.removeChild(tbod.firstChild);
    }
}


function modificarCliente(id) {
    const v = clientes.find(cliente => cliente.id_cliente == id);
    console.log(v);
    localStorage.setItem("cliente", JSON.stringify(v));
    window.location.href = "modificar/clientemodificar.html";
}

function eliminarCliente(id) {
    fetch(window.location.origin + "/cliente/cliente", {
        method: "DELETE",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id_cliente: id
        })
    }).then(response => {
        if (!response.ok) {
            alert("no se pudo eliminar el cliente: " + id);
            return;
        }
        window.location.reload();
        window.location.href = "../cliente/cliente.html";
    }).catch(e => {
        alert(e);
    });
}

