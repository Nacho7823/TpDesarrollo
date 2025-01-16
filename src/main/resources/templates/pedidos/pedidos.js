import { getPedidos, getVendedor, getCliente, deletePedido, getPedido, getItemsOfPedido} from "../utils.js";

const btnVendedor = document.getElementById("btn-vendedorui")
const btnCliente = document.getElementById("btn-clienteui")
const btnItemMenu = document.getElementById("btn-itemmenuui")
btnCliente.addEventListener("click", () => window.location.href = "../cliente/cliente.html");
btnVendedor.addEventListener("click", () => window.location.href = "../vendedor/vendedor.html");
btnItemMenu.addEventListener("click", () => window.location.href = "../itemmenu/itemmenu.html");

const btnRefrescar = document.getElementById("btn-refresh")
const btnBuscar = document.getElementById("btn-buscar")
const btnCrear = document.getElementById("btn-crear")
const inputBuscarId = document.getElementById("input-buscar-id")

btnRefrescar.addEventListener("click", () => location.reload());
btnCrear.addEventListener("click", () => window.location.href = "crear/pedidoscrear.html");
btnBuscar.addEventListener("click", () => {
    const id = inputBuscarId.value;

    const filter = [];
    for (const pedido of pedidos) {
        if (id == "") {
            filter.push(pedido);
        }
        else if (pedido.id_pedido == id) {
            filter.push(pedido);
        }
    }

    clearTable();
    for (const v of filter) {
        addRow(v);
    }

});


async function addRow(pedido) {
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

    const nombreCliente = (await getCliente(pedido.id_cliente)).nombre;
    const nombreVendedor = (await getVendedor(pedido.id_vendedor)).nombre;

    let formaPago = pedido.formapago + "\n";
    if (pedido.alias != null) 
        formaPago += "alias: '" + pedido.alias + "'";
    
    if (pedido.cuit != null) 
        formaPago += "cuit:'" + pedido.cuit + "' cvu:'" + pedido.cvu + "'";
    


    row.appendChild(createCell(pedido.id_pedido))
    row.appendChild(createCell(nombreCliente));
    row.appendChild(createCell(nombreVendedor));
    row.appendChild(createCell(pedido.estado));
    row.appendChild(createCell(formaPago));
    // row.appendChild(createCell(pedido.formapago));
    row.appendChild(createCell(pedido.monto));
    row.appendChild(createBtn("ver items", () => verItemsPedido(pedido)));
    row.appendChild(createBtn("editar", () => modificarPedido(pedido)));
    row.appendChild(createBtn("eliminar", () => eliminarPedido(pedido)));

    const tbod = document.getElementById("tablebody");
    tbod.appendChild(row)
}


function clearTable() {
    const tbod = document.getElementById("tablebody");
    while (tbod.firstChild) {
        tbod.removeChild(tbod.firstChild);
    }
}


function modificarPedido(v) {
    sessionStorage.setItem("pedido", JSON.stringify(v));
    sessionStorage.setItem("itemsSeleccionados", JSON.stringify(v.detalle_pedido));
    
    window.location.href = "modificar/pedidosmodificar.html";
}

async function eliminarPedido(v) {
    if(!await deletePedido(v)) {
        alert("No se pudo eliminar el pedido");
    }
    window.location.reload();
}

function verItemsPedido(p) {
    sessionStorage.setItem("id_pedido", p.id_pedido);
    window.location.href = "veritems/pedidoveritems.html";

}


let pedidos;

(async function main() {
    pedidos = await getPedidos();
    for (const pedido of pedidos) {
        await addRow(pedido);
    }
})();