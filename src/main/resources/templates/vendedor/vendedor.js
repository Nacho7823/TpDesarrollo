const btnCliente = document.getElementById("btn-clienteui")
const btnItemMenu = document.getElementById("btn-itemmenuui")
const btnPedidos = document.getElementById("btn-pedidosui")

btnCliente.addEventListener("click", ()=>{
    window.location.href = "../cliente/cliente.html";
});
btnItemMenu.addEventListener("click", ()=>{
    window.location.href = "../itemmenu/itemmenu.html";
});

const btnCrear = document.getElementById("btn-crear")
btnCrear.addEventListener("click", ()=>{
    window.location.href = "crear/vendedorcrear.html";
})

// server = window.location.origin;

// btnBuscar = document.getElementById("btn-buscar")

btnBuscar.addEventListener("click", async () => {

    try {
        const response = await fetch(server + "/vendedores");
        if (!response.ok) {
            alert("no se pudo obtener los vendedores: response not ok");
            throw new Error("error al obtener los vendedores " + response.status);
        }
        const data = await response.json();
        alert(data);

    } catch (error) {
        alert(error);
    }
});


def = [{
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    }, 
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    },
    {
        "id_cliente": 1,
        "nombre": "Luis Perez",
        "direccion": "Dorrego 123",
        "longitud": 0.4,
        "latitud": 0.1
    }
];

def.forEach(e => {
    addRow(e)
})

function addRow(vendedor) {
    const row = document.createElement('tr');
    row.innerHTML = `
                <th>${vendedor.id_cliente}</th>
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