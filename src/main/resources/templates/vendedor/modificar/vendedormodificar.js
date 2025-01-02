import { updateVendedor } from "../../utils.js";

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

btnModificar.addEventListener("click", async ()=> {
    const tmp = {
        id_vendedor: vendedor.id_vendedor,
        nombre: inputNombre.value,
        direccion: inputDireccion.value,
        longitud: Number(inputLongitud.value),
        latitud: Number(inputLatitud.value),
    }

    console.log(tmp);

    if (!verify(tmp)) {
        return;
    }


    if (!await updateVendedor(tmp)) {
        alert("no se pudo modificar el vendedor");
        return;
    }

    window.location.href = "../vendedor.html";

});


const vend = sessionStorage.getItem("vendedor");
console.log(vend);
const vendedor = JSON.parse(vend);

inputId.value = vendedor.id_vendedor;
inputNombre.value = vendedor.nombre;
inputDireccion.value = vendedor.direccion;
inputLongitud.value = vendedor.longitud;
inputLatitud.value = vendedor.latitud;


function verify({ id_vendedor, nombre, direccion, longitud, latitud }) {

    if (id_vendedor == null || id_vendedor == "") {
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

