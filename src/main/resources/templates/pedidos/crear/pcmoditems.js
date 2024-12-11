const btnVolver = document.getElementById("btn-volver");
const btnCrear = document.getElementById("btn-crear");

const inputId = document.getElementById("input-id");
const inputNombre = document.getElementById("input-nombre");
const inputDireccion = document.getElementById("input-direccion");
const inputLongitud = document.getElementById("input-longitud");
const inputLatitud = document.getElementById("input-latitud");

btnVolver.addEventListener("click", ()=> {
    window.location.href = "../pedidos.html";
});



btnCrear.addEventListener("click", ()=> {
    id = inputId.value;
    nombre = inputNombre.value;
    direccion = inputDireccion.value;
    longitud = inputLongitud.value;
    latitud = inputLatitud.value;
    
    s = "";
    s += "id: " + id + "\n";
    s += "nombre: " + nombre + "\n";
    s += "direccion: " + direccion + "\n";
    s += "longitud: " + longitud + "\n";
    s += "latitud: " + latitud + "\n";
    
    alert(s);

    console.log(s);
});


const items = [
    {
        id: 1,
        cliente: "juan",
        vendedor: "pedro",
        estado: "pendiente",
        formapago: "mercadopago",
        alias: "pedro.mp",
        total: 100
    }
]

function addToTable(table, item) {
    let row = table.insertRow();
    let cell1 = row.insertCell(0);
    let cell2 = row.insertCell(1);
    let cell3 = row.insertCell(2);
    let cell4 = row.insertCell(3);
    let cell5 = row.insertCell(4);
    cell1.innerHTML = item.id;
    cell2.innerHTML = item.nombre;
    cell3.innerHTML = item.direccion;
    cell4.innerHTML = item.longitud;
    cell5.innerHTML = item.latitud;
}
