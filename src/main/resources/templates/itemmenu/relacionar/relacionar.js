
import { getVendedores, getItemMenus, getVende, createVende, deleteVende } from "../../utils.js";

const btnCliente = document.getElementById("btn-clienteui")
const btnVendedor = document.getElementById("btn-vendedorui")
const btnPedidos = document.getElementById("btn-pedidosui")
btnCliente.addEventListener("click", () => window.location.href = "../../cliente/cliente.html");
btnVendedor.addEventListener("click", () => window.location.href = "../../vendedor/vendedor.html");
btnPedidos.addEventListener("click", () => window.location.href = "../../pedidos/pedidos.html");

const btnVolver = document.getElementById("btn-volver");

btnVolver.addEventListener("click", () => window.location.href = "../itemmenu.html");


function addRow(item) {
    const row = document.createElement('tr');

    const createCell = (text) => {
        const cell = document.createElement('th');
        cell.textContent = text;
        return cell;
    }
    const createInput = (status, action) => {
        const input = document.createElement('input');
        input.type = "checkbox";
        input.checked = status;
        input.addEventListener("change", (e) => action(e.target.checked));

        const cell = document.createElement('th');
        cell.appendChild(input);
        return cell;
    }

    row.appendChild(createCell(item.id_item_menu));
    row.appendChild(createCell(item.nombre_item_menu));
    row.appendChild(createCell(item.id_vendedor));
    row.appendChild(createCell(item.nombre_vendedor));
    row.appendChild(createInput(item.value, (r) => relacionar(item.id_item_menu, item.id_vendedor, r)));

    const tbod = document.getElementById("tablebody");
    tbod.appendChild(row)
}


function clearTable() {
    const tbod = document.getElementById("tablebody");
    while (tbod.firstChild) {
        tbod.removeChild(tbod.firstChild);
    }
}


function relacionar(id_item_menu, id_vendedor, value) {
    if (value) 
        createVende(id_item_menu, id_vendedor);
    else
        deleteVende(id_item_menu, id_vendedor);

}



let itemMenus;
let vendedores;

(async function main() {
    itemMenus = await getItemMenus();
    vendedores = await getVendedores();

    for (const item of itemMenus) {
        for (const vendedor of vendedores) {
            addRow({
                id_item_menu: item.id_item_menu,
                nombre_item_menu: item.nombre,
                id_vendedor: vendedor.id_vendedor,
                nombre_vendedor: vendedor.nombre,
                value: await getVende(item.id_item_menu, vendedor.id_vendedor)
            });
            console.log(await getVende(item.id_item_menu, vendedor.id_vendedor));
        }
    }
})();

