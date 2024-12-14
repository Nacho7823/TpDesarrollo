import { getClientes, getVendedores, getItemsOfVendedor, createPedido, createDetalles, updatePedido, getItemMenu} from "../../utils.js";

const btnVolver = document.getElementById("btn-volver");
const btnCrear = document.getElementById("btn-crear");

const selectCliente = document.getElementById("select-cliente");
const selectVendedor = document.getElementById("select-vendedor");
const selectFormaPago = document.getElementById("select-formapago");
const selectEstado = document.getElementById("select-estado");
const inputLongitud = document.getElementById("input-longitud");
const inputLatitud = document.getElementById("input-latitud");
const divPago = document.getElementById("pagopan");

btnVolver.addEventListener("click", () => window.location.href = "../pedidos.html");

btnCrear.addEventListener("click", async () => {
    const tmp = {
        estado: selectEstado.value,
        id_cliente: parseInt(selectCliente.value),
        id_vendedor: parseInt(selectVendedor.value),
        id_pago: null,
        total: 0
    };

    const id_pedido = await createPedido(tmp);
    if (id_pedido == null) {
        alert("No se pudo crear el pedido");
        return;
    }
    tmp.id_pedido = id_pedido;

    // asociar items
    const detalles = [];
    itemsAdded.forEach((value, key) => {
        console.log(key, value);
        if (value <= 0) {
            return;
        }
        detalles.push({
            id_pedido: id_pedido,
            id_item_menu: key,
            cantidad: value
        });
    })

    for (const detalle_pedido of detalles) {
        console.log(detalle_pedido);
        if (!await createDetalles(detalle_pedido)) {
            alert("No se pudo crear el pedido");
            return;
        }
    }

    // calcular precio total
    let total = 0;
    for (const detalle_pedido of detalles) {
        const item = await getItemMenu(detalle_pedido.id_item_menu);
        total += item.precio * detalle_pedido.cantidad;
    }

    tmp.total = total;

    // actualizar pedido
    if (!await updatePedido(tmp)) {
        alert("No se pudo actualizar el pedido");
        return;
    }

    window.location.href = "../pedidos.html";
});

selectFormaPago.addEventListener("change", () => updateDivPago(selectFormaPago.value));
selectVendedor.addEventListener("change", () => updateItemsOfVendedor(selectVendedor.value));

function updateDivPago(value) {
    if (value == "mercadopago") {
        formapago = value;
        clearInputPago();
        const container = createInputPago("Alias");
        divPago.appendChild(container.div);
        container.input.addEventListener("change", () => alias = container.input.value);

    }
    else if (value == "transferencia") {
        formapago = value;
        clearInputPago();
        const container1 = createInputPago("CVU");
        const container2 = createInputPago("CUIT");
        divPago.appendChild(container1.div);
        divPago.appendChild(container2.div);
        container1.input.addEventListener("change", () => cvu = container1.input.value);
        container2.input.addEventListener("change", () => cuit = container2.input.value);
    }
}

function clearInputPago() {
    while (divPago.firstChild) {
        divPago.removeChild(divPago.firstChild);
    }
}

const createInputPago = (text) => {
    const divC = document.createElement('div');
    const labelC = document.createElement('label');
    const inputC = document.createElement('input');

    labelC.textContent = text;
    inputC.type = "text";
    inputC.classList.add("defsize");
    divC.classList.add("addpan");
    divC.appendChild(labelC);
    divC.appendChild(inputC);
    return { div: divC, input: inputC };
}


// select-cliente / select-vendedor
function addOptionsCliente(clientes) {
    const selectElement = document.getElementById("select-cliente");
    for (const cliente of clientes) {
        const option = document.createElement('option');
        option.value = cliente.id_cliente;
        option.textContent = cliente.nombre;
        selectElement.appendChild(option);
    }
}

function addOptionsVendedor(vendedores) {
    const selectElement = document.getElementById("select-vendedor");
    for (const vendedor of vendedores) {
        const option = document.createElement('option');
        option.value = vendedor.id_vendedor;
        option.textContent = vendedor.nombre;
        selectElement.appendChild(option);
    }
}

// item-menu

async function updateItemsOfVendedor(id) {
    const items = await getItemsOfVendedor(id);
    clearTable();
    for (const item of items) {
        addRow(item);
    }
}

function addRow(item) {
    const row = document.createElement('tr');

    const createCell = (text) => {
        const cell = document.createElement('th');
        cell.textContent = text;
        return cell;
    }
    const createInput = (action) => {
        const inp = document.createElement('input');
        inp.addEventListener("change", (ev) => {
            let v = ev.target.value;
            if (v == '') {
                inp.value = 0;
                v = 0;
                action(v)
            }
            else {
                v = parseInt(v);
                action(v)
            }
        });
        inp.type = "number";
        inp.min = 0;
        inp.step = 1;
        inp.value = 0;
        const cell = document.createElement('th');
        cell.appendChild(inp);
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
    row.appendChild(createInput((cant) => setItemCantity(item.id_item_menu, cant)));

    const tbod = document.getElementById("tablebody");
    tbod.appendChild(row)
}

function clearTable() {
    const tbod = document.getElementById("tablebody");
    while (tbod.firstChild) {
        tbod.removeChild(tbod.firstChild);
    }
}


function setItemCantity(id_item_menu, cantity) {
    if (cantity == '') {
        itemsAdded.set(id_item_menu, 0);

    }
    else {
        itemsAdded.set(id_item_menu, cantity);
    }
}

let formapago = "";
let alias = "";
let cvu = "";
let cuit = "";
let itemsAdded = new Map();

(async function main() {
    const clientes = await getClientes();
    const vendedores = await getVendedores();
    addOptionsCliente(clientes);
    addOptionsVendedor(vendedores);

    updateItemsOfVendedor(selectVendedor.value);

    updateDivPago(selectFormaPago.value);
    formapago = selectFormaPago.value;

})();
