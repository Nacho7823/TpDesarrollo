import { createCliente } from "../../utils.js";

const btnVolver = document.getElementById("btn-volver");
const btnCrear = document.getElementById("btn-crear");

const inputNombre = document.getElementById("input-nombre");
const inputCuit = document.getElementById("input-cuit");
const inputEmail = document.getElementById("input-email");
const inputDireccion = document.getElementById("input-direccion");
const inputLongitud = document.getElementById("input-longitud");
const inputLatitud = document.getElementById("input-latitud");

inputNombre.maxLength = 50;
inputLongitud.type = "number";  
inputLongitud.step = "0.001";


btnVolver.addEventListener("click", ()=> window.location.href = "../cliente.html");


btnCrear.addEventListener("click", async ()=> {
    const tmp = {
        nombre: inputNombre.value,
        cuit: inputCuit.value,
        email: inputEmail.value,
        direccion: inputDireccion.value,
        longitud: Number(inputLongitud.value),
        latitud: Number(inputLatitud.value),
    };

    if (!verify(tmp)) {
        return;
    }
    
    console.log(tmp);

    if (! await createCliente(tmp)){
        alert("no se pudo crear el cliente");
        return;
    }

    window.location.href = "../cliente.html";
});


function verify({nombre, cuit, email, direccion, longitud, latitud}) {


    if (nombre == null || nombre == "") {
        alert("debe ingresar un nombre");
        return false;    
    }

    if (cuit == null || cuit == "") {
        alert("debe ingresar un cuit");
        return false;    
    }

    if (email == null || email == "") {
        alert("debe ingresar un email");
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

    if (cuit.length > 20) {
        alert("el cuit debe tener menos de 20 caracteres");
        return false;
    }

    if (email.length > 50) {
        alert("el email debe tener menos de 50 caracteres");
        return false;    
    }

    if (direccion.length > 50) {
        alert("la direccion debe tener menos de 50 caracteres");
        return false;    
    }

    return true;
}