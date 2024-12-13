const btnVendedor = document.getElementById("btn-vendedorui")
const btnItemMenu = document.getElementById("btn-itemmenuui")
const btnPedidos = document.getElementById("btn-pedidosui")

btnVendedor.addEventListener("click", () => {
    window.location.href = "../vendedor/vendedor.html";
});
btnItemMenu.addEventListener("click", () => {
    window.location.href = "../itemmenu/itemmenu.html";
});
btnPedidos.addEventListener("click", () => {
    window.location.href = "../pedidos/pedidos.html";
});


// btnBuscar = document.getElementById("btn-buscar")
// btnEditar = document.getElementById("btn-editar")
// btnEliminar = document.getElementById("btn-eliminar")
btnCrear = document.getElementById("btn-crear")

btnCrear.addEventListener("click", () => {
    window.location.href = "crear/clientecrear.html";
})

async function load() {
    const response = await fetch(window.location.origin + "/clientes");
    if (!response.ok) {
        
        alert("no se pudieron obtener los clientes");
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
        "id_cliente": 1,
        "nombre": "cliente 1",
        "cuit": "cuit 1",
        "email": "email 1",
        "direccion": "direccion 1",
        "longitud": "longitud 1",
        "latitud": "latitud 1"
    },
    { 
        "id_cliente": 2,
        "nombre": "cliente 2",
        "cuit": "cuit 2",
        "email": "email 2",
        "direccion": "direccion 2",
        "longitud": "longitud 2",
        "latitud": "latitud 2"
    }
];

// defData.forEach(cliente => {
    // addRow(cliente);
// });

function addRow(cliente) {
    const row = document.createElement('tr');
    row.innerHTML = `
                <th>${cliente.id_cliente}</th>
                <th>${cliente.nombre}</th>
                <th>${cliente.cuit}</th>
                <th>${cliente.email}</th>
                <th>${cliente.direccion}</th>
                <th>${cliente.longitud}</th>
                <th>${cliente.latitud}</th>
                <th>editar</th>
                <th>eliminar</th>
            `;

    const tbod = document.getElementById("tablebody");
    tbod.appendChild(row)
}