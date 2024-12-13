const btnCliente = document.getElementById("btn-clienteui")
const btnItemMenu = document.getElementById("btn-itemmenuui")
const btnPedidos = document.getElementById("btn-pedidosui")

btnCliente.addEventListener("click", () => window.location.href = "../cliente/cliente.html");
btnItemMenu.addEventListener("click", () => window.location.href = "../itemmenu/itemmenu.html");
btnPedidos.addEventListener("click", () => window.location.href = "../pedidos/pedidos.html");

const btnCrear = document.getElementById("btn-crear");
btnCrear.addEventListener("click", () => window.location.href = "crear/vendedorcrear.html");

async function load() {
    const response = await fetch(window.location.origin + "/vendedor/vendedores");
    if (!response.ok) {

        alert("no se pudieron obtener los vendedores");
        return;
    }
    const clientes = await response.json();
    clientes.forEach(cliente => {
        addRow(cliente);
    });
};

load();


const defData = [
    {
        id_vendedor: 1,
        nombre: "vendedor 1",
        direccion: "direccion 1",
        longitud: "longitud 1",
        latitud: "latitud 1"
    },
    {
        id_vendedor: 2,
        nombre: "vendedor 2",
        direccion: "direccion 2",
        longitud: "longitud 2",
        latitud: "latitud 2"
    }
];

// defData.forEach(e => {
//     addRow(e)
// })

function addRow(vendedor) {
    const row = document.createElement('tr');

    const btnModificar = document.createElement('button');
    const btnEliminar = document.createElement('button');
    btnModificar.classList.add("btntable");
    btnEliminar.classList.add("btntable");
    btnModificar.addEventListener("click", () => modificarVendedor(vendedor.id_vendedor));
    btnEliminar.addEventListener("click", () => eliminarVendedor(vendedor.id_vendedor));

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


function modificarVendedor(id) {
    localStorage.setItem("id_vendedor", id);
    window.location.href = "modificar/vendedormodificar.html";
}

function eliminarVendedor(id) {
    fetch(window.location.origin + "/vendedor/vendedor/" + id, {
        method: "DELETE"
    }).then(response => {
        if (!response.ok) {
            alert("no se pudo eliminar el vendedor: " + id);
            return;
        }
        window.location.reload();
        window.location.href = "../vendedor/vendedor.html";
        alert("delete: " + id);
    }).catch(e => {
        alert(e);
    });
}