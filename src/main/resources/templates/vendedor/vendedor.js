const btnCliente = document.getElementById("btn-clienteui")
const btnItemMenu = document.getElementById("btn-itemmenuui")
const btnPedidos = document.getElementById("btn-pedidosui")

btnCliente.addEventListener("click", ()=>{
    window.location.href = "../cliente/cliente.html";
});
btnItemMenu.addEventListener("click", ()=>{
    window.location.href = "../itemmenu/itemmenu.html";
});
btnPedidos.addEventListener("click", () => {
    window.location.href = "../pedidos/pedidos.html";
});

const btnCrear = document.getElementById("btn-crear")
btnCrear.addEventListener("click", ()=>{
    window.location.href = "crear/vendedorcrear.html";
})

// server = window.location.origin;

// btnBuscar = document.getElementById("btn-buscar")

async function load() {
    const response = await fetch(window.location.origin + "/vendedores");
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
    row.innerHTML = `
                <th>${vendedor.id_vendedor}</th>
                <th>${vendedor.nombre}</th>
                <th>${vendedor.direccion}</th>
                <th>${vendedor.longitud}</th>
                <th>${vendedor.latitud}</th>
                <th>editar</th>
                <th>eliminar</th>
            `;

    const tbod = document.getElementById("tablebody");
    tbod.appendChild(row)
}