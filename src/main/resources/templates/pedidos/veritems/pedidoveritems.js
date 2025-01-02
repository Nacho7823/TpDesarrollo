import { getItemsOfPedido } from "../../utils.js";

const btnVolver = document.getElementById("btn-volver");
btnVolver.addEventListener("click", () => window.location.href = "../pedidos.html");

async function addRow(itemregister) {
    const item = itemregister.item;
    const cantidad = itemregister.cantidad;
    const row = document.createElement('tr');

    const createCell = (text) => {
        const cell = document.createElement('th');
        cell.textContent = text;
        return cell;
    }

    row.appendChild(createCell(item.id_item_menu))
    row.appendChild(createCell(item.nombre))
    row.appendChild(createCell(item.descripcion))
    row.appendChild(createCell(item.precio))
    row.appendChild(createCell(item.categoria))
    row.appendChild(createCell(item.peso))
    row.appendChild(createCell(item.apto_vegano))
    row.appendChild(createCell(item.apto_celiaco))
    row.appendChild(createCell(item.calorias))
    row.appendChild(createCell(item.graduacion_alcoholica))
    row.appendChild(createCell(item.tamanio))
    row.appendChild(createCell(cantidad))

    const tbod = document.getElementById("tablebody");
    tbod.appendChild(row)
}

(async function main() {
    const id_pedido = sessionStorage.getItem("pedido");

    const items = await getItemsOfPedido(id_pedido);

    for (const item of items) {
        await addRow(item);
    }

})();