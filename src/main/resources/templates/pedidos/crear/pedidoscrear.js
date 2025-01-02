import { getClientes, getVendedores, createPedido, createDetalles, updatePedido, getItemMenu} from "../../utils.js";

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
    savePedido();
    if (vendedores.length != 0)
        window.location.href = "setItems.html";
});
btnVolver.addEventListener("click", () => {
    resetItems();
    window.location.href = "../pedidos.html";
});

btnCrear.addEventListener("click", async () => {

    pedido.total = await calculateTotal();
    if (pedido.total == 0) {
        alert("Debe seleccionar por lo menos un item");
        return;
    }

    

    const tmp = {
        estado: pedido.estado,
        id_cliente: pedido.id_cliente,
        id_vendedor: pedido.id_vendedor,
        id_pago: null,
        total: pedido.total
    };

    const id_pedido = await createPedido(tmp);
    if (id_pedido == null) {
        alert("No se pudo crear el pedido");
        return;
    }
    tmp.id_pedido = id_pedido;

    // asociar items
    const detalles = [];
    for (const value of itemsAdded) {
        detalles.push({
            id_pedido: id_pedido,
            id_item_menu: value.id_item_menu,
            cantidad: value.cantidad
        });
    }

    const pago = {
        monto: pedido.total,
        fecha: new Date(),
        forma_pago: pedido.formapago,
        cvu: pedido.cvu,
        cuit: pedido.cuit,
        alias: pedido.alias
    }

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



function updateDivPago(value) {
    const clearInputPago = () => {
        while (divPago.firstChild) {
            divPago.removeChild(divPago.firstChild);
        }
    }
    const createInputPago = (text, value) => {
        const divC = document.createElement('div');
        const labelC = document.createElement('label');
        const inputC = document.createElement('input');
        inputC.value = value;
    
        labelC.textContent = text;
        inputC.type = "text";
        inputC.classList.add("defsize");
        divC.classList.add("addpan");
        divC.appendChild(labelC);
        divC.appendChild(inputC);
        return { div: divC, input: inputC };
    }

    if (value == "mercadopago") {
        pedido.formapago = value;
        clearInputPago();
        const alias = pedido.alias == null ? "" : pedido.alias;
        const container = createInputPago("Alias", alias);
        divPago.appendChild(container.div);
        container.input.addEventListener("change", () => pedido.alias = container.input.value);

    }
    else if (value == "transferencia") {
        pedido.formapago = value;
        clearInputPago();
        const cvu = pedido.cvu == null ? "" : pedido.cvu;
        const cuit = pedido.cuit == null ? "" : pedido.cuit;
        const container1 = createInputPago("CVU", cvu);
        const container2 = createInputPago("CUIT", cuit);
        divPago.appendChild(container1.div);
        divPago.appendChild(container2.div);
        container1.input.addEventListener("change", () => pedido.cvu = container1.input.value);
        container2.input.addEventListener("change", () => pedido.cuit = container2.input.value);
    }
}



// select-cliente / select-vendedor
selectFormaPago.addEventListener("change", () => updateDivPago(selectFormaPago.value));
selectVendedor.addEventListener("change", () => {
    resetItems()
    pedido.id_vendedor = selectVendedor.value;
});
selectCliente.addEventListener("change", () => pedido.id_cliente = selectCliente.value);

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

async function calculateTotal() {
    let total = 0;

    for (const value of itemsAdded) {
        const item = await getItemMenu(value.id_item_menu);
        total += item.precio * value.cantidad;
    }

    inputTotal.value = total;
    return total;
}

let pedido;
let itemsAdded;

function saveItems() {
    sessionStorage.setItem("vendedor", JSON.stringify(selectVendedor.value));
    sessionStorage.setItem("itemsSeleccionados", JSON.stringify(itemsAdded));
}
function loadItems() {
    itemsAdded = JSON.parse(sessionStorage.getItem("itemsSeleccionados"));
}
function resetItems() {
    itemsAdded = [];
    saveItems();
}
function savePedido() {
    sessionStorage.setItem("pedido", JSON.stringify(pedido));
}
function loadPedido() {
    pedido = JSON.parse(sessionStorage.getItem("pedido"));
    console.log(pedido);
}
function resetPedido() {
    pedido = {
        estado: null,
        id_cliente: null,
        id_vendedor: null,
        id_pago: null,
        total: 0,
        formapago: null,
        alias: null,
        cvu: null,
        cuit: null
    }
    sessionStorage.setItem("pedido", JSON.stringify(pedido));
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
        resetItems();
    }

    if (sessionStorage.getItem("pedido")) {
        loadPedido();
        selectFormaPago.value = pedido.formapago;
        selectVendedor.value = pedido.id_vendedor;
        selectCliente.value = pedido.id_cliente;
        selectEstado.value = pedido.estado;
        selectFormaPago.value = pedido.formapago;
    }
    else {
        resetPedido();
        pedido.formapago = selectFormaPago.value;
    }
    updateDivPago(selectFormaPago.value);


    calculateTotal();

})();
