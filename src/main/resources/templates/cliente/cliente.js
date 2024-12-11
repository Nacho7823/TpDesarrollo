btnVolver = document.getElementById("btn-volver")

btnVolver.addEventListener("click", () => {
    window.location.href = "../index.html"
})

server = window.location.origin;

btnBuscar = document.getElementById("btn-buscar")
btnEditar = document.getElementById("btn-editar")
btnEliminar = document.getElementById("btn-eliminar")
btnCrear = document.getElementById("btn-crear")


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


def = [{ "id_cliente": 1, "nombre": "Luis Perez", "cuit": "12345678901", "email": "p@gmail.com", "direccion": "Dorrego 123", "longitud": 0.4, "latitud": 0.1 }, { "id_cliente": 2, "nombre": "Pedro Gimenez", "cuit": "34567415632", "email": "pgimenez@gmail.com", "direccion": "francia 2352", "longitud": 0.42, "latitud": 0.13 }, { "id_cliente": 3, "nombre": "Juan Martinez", "cuit": "42195312394", "email": "jm@hotmail.com", "direccion": "rivadavia 5923", "longitud": 0.45, "latitud": 0.21 }, { "id_cliente": 4, "nombre": "Joaquin dallafontana", "cuit": "23124519", "email": "joadf@gmail.com", "direccion": "rivadavia 2314", "longitud": 42.124, "latitud": 13.123 }, { "id_cliente": 5, "nombre": "Gino Pighin", "cuit": "20459671232", "email": "gp@hotmail.com", "direccion": "25 de mayo 1231", "longitud": 51.213, "latitud": 12.321 }, { "id_cliente": 6, "nombre": "Juan Pérez", "cuit": "20123456789", "email": "juan@example.com", "direccion": "Calle Falsa 123", "longitud": -58.381592, "latitud": -34.603722 }, { "id_cliente": 7, "nombre": "María Gómez", "cuit": "27876543210", "email": "maria@example.com", "direccion": "Avenida Siempre Viva 742", "longitud": -58.392592, "latitud": -34.609722 }, { "id_cliente": 8, "nombre": "Lila mussin", "cuit": "15463598372", "email": "lmusin@hotmail.com", "direccion": "bv galvez 1412", "longitud": 31.123, "latitud": -13.421 }, { "id_cliente": 9, "nombre": "Alma gimenez", "cuit": "20459763252", "email": "almagim@gmai.com", "direccion": "corrientes 1242", "longitud": 10.4211, "latitud": 21.123 }];


    def.forEach(e => {
        addRow(e)
    })

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
            `;

    const tbod = document.getElementById("tablebody");
    tbod.appendChild(row)
}