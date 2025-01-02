import { getClientes, getVendedores, getItemsOfVendedor, createPedido, createDetalles, updatePedido, getItemMenu} from "../../utils.js";

const btnModificarItems = document.getElementById("btn-modificar-items");
const btnVolver = document.getElementById("btn-volver");
const btnCrear = document.getElementById("btn-crear");

const selectCliente = document.getElementById("select-cliente");
const selectVendedor = document.getElementById("select-vendedor");
const selectFormaPago = document.getElementById("select-formapago");
const selectEstado = document.getElementById("select-estado");
const inputTotal = document.getElementById("input-total");
const divPago = document.getElementById("pagopan");

btnModificarItems.addEventListener("click", () => {
    if (vendedores.length != 0)
        window.location.href = "setItems.html";
});
btnVolver.addEventListener("click", () => {
    window.location.href = "../pedidos.html";
    id_vendedor = selectVendedor.value;
    itemsAdded = [];
    saveItems();
});

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
selectVendedor.addEventListener("change", () => {
    id_vendedor = selectVendedor.value;
    itemsAdded = [];
    saveItems();
});

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




function calculateTotal() {
    const detalles = [];
    itemsAdded.forEach((value, key) => {
        if (value <= 0) {
            return;
        }
        detalles.push({
            id_item_menu: key,
            cantidad: value
        });
    });

    let total = 0;
    detalles.forEach((detalle) => {
        const item = getItemMenu(detalle.id_item_menu);
        total += item.precio * detalle.cantidad;
    });

    inputTotal.value = total;
}

let formapago = "";
let alias = "";
let cvu = "";
let cuit = "";


let itemsAdded;
function saveItems() {
    sessionStorage.setItem("vendedor", JSON.stringify(selectVendedor.value));
    sessionStorage.setItem("itemsSeleccionados", JSON.stringify(itemsAdded));
}
function loadItems() {
    id_vendedor = JSON.parse(sessionStorage.getItem("vendedor"));
    itemsAdded = JSON.parse(sessionStorage.getItem("itemsSeleccionados"));
}

const clientes = await getClientes();
const vendedores = await getVendedores();

(async function main() {
    addOptionsCliente(clientes);
    addOptionsVendedor(vendedores);

    if (sessionStorage.getItem("itemsSeleccionados")) 
        loadItems();
    else {
        id_vendedor = selectVendedor.value;
        itemsAdded = []
        saveItems();
    }

    updateDivPago(selectFormaPago.value);
    formapago = selectFormaPago.value;

})();
