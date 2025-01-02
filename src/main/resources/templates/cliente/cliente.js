// {
//     "id_cliente": 1,
//     "nombre": "cliente 1",
//     "cuit": "cuit 1",
//     "email": "email 1",
//     "direccion": "direccion 1",
//     "longitud": "longitud 1",
//     "latitud": "latitud 1"
// }

import { getClientes, deleteCliente } from "../utils.js";


const btnVendedor = document.getElementById("btn-vendedorui")
const btnItemMenu = document.getElementById("btn-itemmenuui")
const btnPedidos = document.getElementById("btn-pedidosui")

btnVendedor.addEventListener("click", () => window.location.href = "../vendedor/vendedor.html");
btnItemMenu.addEventListener("click", () => window.location.href = "../itemmenu/itemmenu.html");
btnPedidos.addEventListener("click", () => window.location.href = "../pedidos/pedidos.html");


const btnRefrescar = document.getElementById("btn-refresh");
const btnCrear = document.getElementById("btn-crear");
const btnBuscar = document.getElementById("btn-buscar");1
const inputBuscarId = document.getElementById("input-buscar-id");
const inputBuscarNombre = document.getElementById("input-buscar-nombre");

inputBuscarId.type = "number";

let clientes = [];

btnRefrescar.addEventListener("click", () => location.reload());
btnCrear.addEventListener("click", () => window.location.href = "crear/clientecrear.html");
btnBuscar.addEventListener("click", () => {
    const id = inputBuscarId.value;
    const nombre = inputBuscarNombre.value;

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
            if (cliente.id_cliente == id) {
                filter.push(cliente);
            }
        }
        else if (cliente.id_cliente == id && cliente.nombre == nombre) {
            filter.push(cliente);
        }
    }

    clearTable();
    for (const v of filter) {
        addRow(v);
    }

});


function addRow(cliente) {
    const row = document.createElement('tr');

    const createCell = (text) => {
        const cell = document.createElement('th');
        cell.textContent = text;
        return cell;
    }
    const createBtn = (text, action) => {
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
    row.appendChild(createBtn("editar", () => modificarCliente(cliente.id_cliente)));
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
    sessionStorage.setItem("cliente", JSON.stringify(v));
    window.location.href = "modificar/clientemodificar.html";
}

async function eliminarCliente(id) {
    if(! await deleteCliente(id)){
        alert("No se pudo eliminar el cliente");
    };
    location.reload();
}


(async function main() {
    clientes = await getClientes();
    for (const v of clientes) {
        addRow(v);
    }
})();

