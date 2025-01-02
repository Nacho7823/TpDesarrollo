
// f = {
//     id_vendedor: 1,
//     nombre: "vendedor 1",
//     direccion: "direccion 1",
//     longitud: "longitud 1",
//     latitud: "latitud 1"
// };

import { deleteVendedor, getVendedores} from "../utils.js";

const btnCliente = document.getElementById("btn-clienteui")
const btnItemMenu = document.getElementById("btn-itemmenuui")
const btnPedidos = document.getElementById("btn-pedidosui")
btnCliente.addEventListener("click", () => window.location.href = "../cliente/cliente.html");
btnItemMenu.addEventListener("click", () => window.location.href = "../itemmenu/itemmenu.html");
btnPedidos.addEventListener("click", () => window.location.href = "../pedidos/pedidos.html");

// -------------

const btnRefrescar = document.getElementById("btn-refresh");
const btnCrear = document.getElementById("btn-crear");
const btnBuscar = document.getElementById("btn-buscar");
const inputBuscarId = document.getElementById("input-buscar-id");
const inputBuscarNombre = document.getElementById("input-buscar-nombre");

inputBuscarId.type = "number";

let vendedores = [];

btnRefrescar.addEventListener("click", () => location.reload());
btnCrear.addEventListener("click", () => window.location.href = "crear/vendedorcrear.html");
btnBuscar.addEventListener("click", () => {
    const id = inputBuscarId.value;
    const nombre = inputBuscarNombre.value;

    const filter = [];
    for (const vendedor of vendedores) {
        if (id == "" && nombre == "") {
            filter.push(vendedor);
        }
        else if (id == "") {
            if (vendedor.nombre == nombre) {
                filter.push(vendedor);
            }
        }
        else if (nombre == "") {
            if (vendedor.id_vendedor == id) {
                filter.push(vendedor);
            }
        }
        else if (vendedor.id_vendedor == id && vendedor.nombre == nombre) {
            filter.push(vendedor);
        }
    }

    clearTable();
    for (const v of filter) {
        addRow(v);
    }

});


function addRow(vendedor) {
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


    row.appendChild(createCell(vendedor.id_vendedor));
    row.appendChild(createCell(vendedor.nombre));
    row.appendChild(createCell(vendedor.direccion));
    row.appendChild(createCell(vendedor.longitud));
    row.appendChild(createCell(vendedor.latitud));
    row.appendChild(createBtn("editar", () => modificarVendedor(vendedor.id_vendedor)));
    row.appendChild(createBtn("eliminar", () => eliminarVendedor(vendedor.id_vendedor)));

    const tbod = document.getElementById("tablebody");
    tbod.appendChild(row)
}

function clearTable() {
    const tbod = document.getElementById("tablebody");
    while (tbod.firstChild) {
        tbod.removeChild(tbod.firstChild);
    }
}



function modificarVendedor(id) {
    const v = vendedores.find(vendedor => vendedor.id_vendedor == id);
    console.log(v);
    sessionStorage.setItem("vendedor", JSON.stringify(v));
    window.location.href = "modificar/vendedormodificar.html";
}

async function eliminarVendedor(id) {
    if (! await deleteVendedor(id)) {
        alert("no se pudo eliminar el vendedor");
        return;
    }
    location.reload();
}


(async function main() {
    vendedores = await getVendedores();
    for (const vendedor of vendedores) {
        addRow(vendedor);
    }
})();