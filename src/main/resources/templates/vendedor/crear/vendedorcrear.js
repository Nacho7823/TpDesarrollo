import { createVendedor } from "../../utils.js";

const btnVolver = document.getElementById("btn-volver");
const btnCrear = document.getElementById("btn-crear");

const inputNombre = document.getElementById("input-nombre");
const inputDireccion = document.getElementById("input-direccion");
const inputLongitud = document.getElementById("input-longitud");
const inputLatitud = document.getElementById("input-latitud");

inputNombre.maxLength = 50;
inputLongitud.type = "number";  
inputLongitud.step = "0.001";


btnVolver.addEventListener("click", ()=> window.location.href = "../vendedor.html");


btnCrear.addEventListener("click", async ()=> {
    const tmp = {
        nombre: inputNombre.value,
        direccion: inputDireccion.value,
        longitud: Number(inputLongitud.value),
        latitud: Number(inputLatitud.value),
    }

    console.log(tmp);
    if (!verify(tmp)) {
        return;
    }
    
    if (! await createVendedor(tmp)) {
        alert("no se pudo crear el vendedor");
        return;
    }

    window.location.href = "../vendedor.html";

});


function verify({ nombre, direccion, longitud, latitud }) {

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