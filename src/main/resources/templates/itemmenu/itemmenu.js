
import { deleteItemMenu, getItemMenus } from "../utils.js";

const btnCliente = document.getElementById("btn-clienteui")
const btnVendedor = document.getElementById("btn-vendedorui")
const btnPedidos = document.getElementById("btn-pedidosui")
btnCliente.addEventListener("click", () => window.location.href = "../cliente/cliente.html");
btnVendedor.addEventListener("click", () => window.location.href = "../vendedor/vendedor.html");
btnPedidos.addEventListener("click", () => window.location.href = "../pedidos/pedidos.html");

const btnRefrescar = document.getElementById("btn-refresh");
const btnBuscar = document.getElementById("btn-buscar");
const btnCrearBebida = document.getElementById("btn-crear-bebida")
const btnCrearPlato = document.getElementById("btn-crear-plato")
const inputBuscarId = document.getElementById("input-buscar-id");
const inputBuscarNombre = document.getElementById("input-buscar-nombre");

btnBuscar.addEventListener("click", () => {
    const id = inputBuscarId.value;
    const nombre = inputBuscarNombre.value;

    console.log(id);
    console.log(nombre);

    const filter = [];
    for (const item of itemMenus) {
        if (id == "" && nombre == "") {
            filter.push(item);
        }
        else if (id == "") {
            if (item.nombre == nombre) {
                filter.push(item);
            }
        }
        else if (nombre == "") {
            if (item.id_item_menu == id) {
                filter.push(item);
            }
        }
        else if (item.id_item_menu == id && item.nombre == nombre) {
            filter.push(item);
        }
    }

    clearTable();
    for (const v of filter) {
        addRow(v);
    }

});

btnRefrescar.addEventListener("click", () => location.reload());
btnCrearBebida.addEventListener("click", () => window.location.href = "crear/bebidacrear.html");
btnCrearPlato.addEventListener("click", () => window.location.href = "crear/platocrear.html");


function addRow(item) {
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

    row.appendChild(createCell(item.id_item_menu));
    row.appendChild(createCell(item.nombre));
    row.appendChild(createCell(item.descripcion));
    row.appendChild(createCell(item.precio));
    row.appendChild(createCell(item.categoria));
    row.appendChild(createCell(item.peso));
    row.appendChild(createCell(item.apto_vegano));
    row.appendChild(createCell(item.apto_celiaco));
    row.appendChild(createCell(item.calorias));
    row.appendChild(createCell(item.graduacion_alcoholica));
    row.appendChild(createCell(item.tamanio));
    row.appendChild(createBtn("editar", () => modificarItemMenu(item.id_item_menu)));
    row.appendChild(createBtn("eliminar", () => eliminarItemMenu(item.id_item_menu)));

    const tbod = document.getElementById("tablebody");
    tbod.appendChild(row)
}


function clearTable() {
    const tbod = document.getElementById("tablebody");
    while (tbod.firstChild) {
        tbod.removeChild(tbod.firstChild);
    }
}


function modificarItemMenu(id) {
    const v = itemMenus.find(item => item.id_item_menu == id);
    console.log(v);
    sessionStorage.setItem("itemMenu", JSON.stringify(v));
    if (v.graduacion_alcoholica == null) {
        window.location.href = "modificar/platomodificar.html";
    }
    else {
        window.location.href = "modificar/bebidamodificar.html";
    }
}

async function eliminarItemMenu(id) {
    const item = itemMenus.find(item => item.id_item_menu == id);
    if (! await deleteItemMenu(item)) {
        alert("no se pudo eliminar el itemMenu");
        return;
    }
    location.reload();
}


let itemMenus;

(async function main() {
    itemMenus = await getItemMenus();
    for (const item of itemMenus) {
        addRow(item);
    }
})();

