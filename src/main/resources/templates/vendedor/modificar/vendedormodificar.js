const btnVolver = document.getElementById("btn-volver");
const btnModificar = document.getElementById("btn-modificar");

const inputId = document.getElementById("input-id");
const inputNombre = document.getElementById("input-nombre");
const inputDireccion = document.getElementById("input-direccion");
const inputLongitud = document.getElementById("input-longitud");
const inputLatitud = document.getElementById("input-latitud");

inputNombre.maxLength = 30;
inputDireccion.maxLength = 50;
inputLongitud.type = "number";  
inputLongitud.step = "0.001";

btnVolver.addEventListener("click", ()=> window.location.href = "../vendedor.html");

btnModificar.addEventListener("click", ()=> {
    id = vendedor.id_vendedor;
    nombre = inputNombre.value;
    direccion = inputDireccion.value;
    longitud = Number(inputLongitud.value);
    latitud = Number(inputLatitud.value);


    if (!verify(id, nombre, direccion, longitud, latitud)) {
        return;
    }

    
    s = "";
    s += "id: " + id + "\n";
    s += "nombre: " + nombre + "\n";
    s += "direccion: " + direccion + "\n";
    s += "longitud: " + longitud + "\n";
    s += "latitud: " + latitud + "\n";
    
    console.log(s);

    fetch(window.location.origin + "/vendedor/vendedor", {
        method: "PUT",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            id_vendedor: id,
            nombre: nombre,
            direccion: direccion,
            longitud: longitud,
            latitud: latitud
        })
    }).then(response => {
        if (!response.ok) {
            alert("no se pudo modificar el vendedor: " + id);
            return;
        }
        window.location.href = "../vendedor.html";
    }).catch(e => {
        alert(e);
    });

});


const vend = localStorage.getItem("vendedor");
const vendedor = JSON.parse(vend);

inputId.value = vendedor.id_vendedor;
inputNombre.value = vendedor.nombre;
inputDireccion.value = vendedor.direccion;
inputLongitud.value = vendedor.longitud;
inputLatitud.value = vendedor.latitud;


function verify(id, nombre, direccion, longitud, latitud) {

    if (id == null || id == "") {
        alert("debe ingresar un id");
        return false;    
    }

    if (nombre == null || nombre == "") {
        alert("debe ingresar un nombre");
        return false;    
    }

    if (direccion == null || direccion == "") {
        alert("debe ingresar una direccion");
        return false;    
    }

    if (longitud == null || longitud == "") {
        alert("debe ingresar una longitud");
        return false;    
    }

    if (latitud == null || latitud == "") {
        alert("debe ingresar una latitud");
        return false;    
    }

    if (nombre.length > 30) {
        alert("el nombre debe tener menos de 30 caracteres");
        return false;    
    }

    if (direccion.length > 50) {
        alert("la direccion debe tener menos de 50 caracteres");
        return false;    
    }

    return true;
}

