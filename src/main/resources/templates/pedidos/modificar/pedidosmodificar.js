import { getClientes, getVendedores, createPedido, getItemMenu, updatePedido } from "../../utils.js";

const btnModificarItems = document.getElementById("btn-modificar-items");
const btnVolver = document.getElementById("btn-volver");
const btnModificar = document.getElementById("btn-modificar");

const inputId = document.getElementById("input-id");
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
});

btnModificar.addEventListener("click", async () => {

    const pedido = getPedido();
    pedido.total = await calculateTotal();
    
    if (pedido.total == 0) {
        alert("Debe seleccionar por lo menos un item");
        return;
    }

    const detalle_pedido = [];
    for (const value of getItemsAdded()) {
        detalle_pedido.push({
            id_item_menu: value.id_item_menu,
            cantidad: value.cantidad
        });
    }

    const tmp = {
        id_pedido: pedido.id_pedido,
        estado: pedido.estado,
        id_cliente: pedido.id_cliente,
        id_vendedor: pedido.id_vendedor,
        detalle_pedido: detalle_pedido,

        formapago: pedido.formapago,
        monto: pedido.total,
        fecha: pedido.fecha,
        cvu: pedido.cvu,
        cuit: pedido.cuit,
        alias: pedido.alias
    };

    if (!await updatePedido(tmp)) {
        alert("No se pudo modificar el pedido");
        return;
    }

    console.log("pedido modificado: ", tmp);
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

    const pedido = getPedido();

    console.log("pedido", pedido);

    if (value == "mercadopago") {
        pedido.formapago = value;
        setPedido(pedido);
        clearInputPago();
        const alias = pedido.alias == null ? "" : pedido.alias;
        const container = createInputPago("Alias", alias);
        divPago.appendChild(container.div);
        container.input.addEventListener("change", () => {
            const p = getPedido();
            p.alias = container.input.value
            setPedido(p);
        });

    }
    else if (value == "transferencia") {
        pedido.formapago = value;
        setPedido(pedido);
        clearInputPago();
        const cvu = pedido.cvu == null ? "" : pedido.cvu;
        const cuit = pedido.cuit == null ? "" : pedido.cuit;
        const container1 = createInputPago("CVU", cvu);
        const container2 = createInputPago("CUIT", cuit);
        divPago.appendChild(container1.div);
        divPago.appendChild(container2.div);
        container1.input.addEventListener("change", () => {
            const p = getPedido();
            p.cvu = container1.input.value
            setPedido(p);
        });
        container2.input.addEventListener("change", () => {
            const p = getPedido();
            p.cuit = container2.input.value
            setPedido(p);
        });
    }
}



// select-cliente / select-vendedor
selectFormaPago.addEventListener("change", () => updateDivPago(selectFormaPago.value));
selectVendedor.addEventListener("change", () => {
    resetItems()
    const v = Number(selectVendedor.value);
    const pedido = getPedido()
    pedido.id_vendedor = v;
    setPedido(pedido);
    calculateTotal();
});
selectCliente.addEventListener("change", () => {
    const pedido = getPedido()
    pedido.id_cliente = Number(selectCliente.value)
    setPedido(pedido);
});
selectEstado.addEventListener("change", () => {
    const pedido = getPedido()
    pedido.estado = selectEstado.value
    setPedido(pedido);
});

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

    for (const value of getItemsAdded()) {
        const item = await getItemMenu(value.id_item_menu);
        total += item.precio * value.cantidad;
    }
    
    inputTotal.value = total;
    return total;
}

function getPedido() {
    // return JSON.parse(sessionStorage.getItem("pedido"));
    const pedido = JSON.parse(sessionStorage.getItem("pedido"));
    pedido.fecha = new Date(pedido.fecha);
    return pedido;
}

function setPedido(pedido) {
    sessionStorage.setItem("pedido", JSON.stringify(pedido));
}

function getItemsAdded() {
    return JSON.parse(sessionStorage.getItem("itemsSeleccionados"));
}

function setItemsAdded(items) {
    sessionStorage.setItem("itemsSeleccionados", JSON.stringify(items));
}

function resetItems() {
    itemsAdded = [];
    setItemsAdded(itemsAdded);
}

const clientes = await getClientes();
const vendedores = await getVendedores();

(async function main() {
    addOptionsCliente(clientes);
    addOptionsVendedor(vendedores);

    const pedido = getPedido();
    
    inputId.value = pedido.id_pedido;
    selectFormaPago.value = pedido.formapago;
    selectVendedor.value = pedido.id_vendedor;
    selectCliente.value = pedido.id_cliente;
    selectEstado.value = pedido.estado;
    selectFormaPago.value = pedido.formapago;
    updateDivPago(selectFormaPago.value);

    calculateTotal();

})();
