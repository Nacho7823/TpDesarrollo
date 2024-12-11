const btnVendedor = document.getElementById("btn-vendedorui")
const btnItemMenu = document.getElementById("btn-itemmenuui")
const btnPedidos = document.getElementById("btn-pedidosui")

btnVendedor.addEventListener("click", () => {
    window.location.href = "../vendedor/vendedor.html";
});

// server = window.location.origin;

// btnBuscar = document.getElementById("btn-buscar")
// btnEditar = document.getElementById("btn-editar")
// btnEliminar = document.getElementById("btn-eliminar")
btnCrear = document.getElementById("btn-crear")

btnCrear.addEventListener("click", () => {
    window.location.href = "crear/clientecrear.html";
})


btnBuscar.addEventListener("click", async () => {

    try {
        const response = await fetch(server + "/clientes");
        if (!response.ok) {
            alert("no se pudo obtener los vendedores: response not ok");
            throw new Error("error al obtener los vendedores " + response.status);
        }

        const data = await response.json();

        alert("type: " + typeof (data) + " " + JSON.stringify(data));

        data.forEach(element => {
            addRow(cliente)
        });




    } catch (error) {
        alert(error);
    }
});


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