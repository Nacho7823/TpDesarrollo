
// f = {
//     id_vendedor: 1,
//     nombre: "vendedor 1",
//     direccion: "direccion 1",
//     longitud: "longitud 1",
//     latitud: "latitud 1"
// };

const btnCliente = document.getElementById("btn-clienteui")
const btnItemMenu = document.getElementById("btn-itemmenuui")
const btnPedidos = document.getElementById("btn-pedidosui")
btnCliente.addEventListener("click", () => window.location.href = "../cliente/cliente.html");
btnItemMenu.addEventListener("click", () => window.location.href = "../itemmenu/itemmenu.html");
btnPedidos.addEventListener("click", () => window.location.href = "../pedidos/pedidos.html");

// -------------

const btnCrear = document.getElementById("btn-crear");
const btnBuscar = document.getElementById("btn-buscar");
const inputBuscarId = document.getElementById("input-buscar-id");
const inputBuscarNombre = document.getElementById("input-buscar-nombre");

inputBuscarId.type = "number";

const vendedores = [];

btnCrear.addEventListener("click", () => window.location.href = "crear/vendedorcrear.html");
btnBuscar.addEventListener("click", () => {
    id = inputBuscarId.value;
    nombre = inputBuscarNombre.value;

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

async function load() {
    const response = await fetch(window.location.origin + "/vendedor/vendedores");
    if (!response.ok) {
        alert("no se pudieron obtener los vendedores");
        return;
    }
    const vendedoreslist = await response.json();
    for (const v of vendedoreslist) {
        vendedores.push(v);        
    }

    vendedores.forEach(vendedor => {
        addRow(vendedor);
    });
};

load();

function addRow(vendedor) {
    const row = document.createElement('tr');

    createCell = (text) => {
        const cell = document.createElement('th');
        cell.textContent = text;
        return cell;
    }
    createBtn = (text, action) => {
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
    localStorage.setItem("vendedor", JSON.stringify(v));
    window.location.href = "modificar/vendedormodificar.html";
}

function eliminarVendedor(id) {
    fetch(window.location.origin + "/vendedor/vendedor", {
        method: "DELETE",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id_vendedor: id
        })
    }).then(response => {
        if (!response.ok) {
            alert("no se pudo eliminar el vendedor: " + id);
            return;
        }
        window.location.reload();
        window.location.href = "../vendedor/vendedor.html";
    }).catch(e => {
        alert(e);
    });
}