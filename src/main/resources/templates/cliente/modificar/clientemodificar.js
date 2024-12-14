import { updateCliente } from "../../utils.js";

const btnVolver = document.getElementById("btn-volver");
const btnModificar = document.getElementById("btn-modificar");

const inputId = document.getElementById("input-id");
const inputNombre = document.getElementById("input-nombre");
const inputCuit = document.getElementById("input-cuit");
const inputEmail = document.getElementById("input-email");
const inputDireccion = document.getElementById("input-direccion");
const inputLongitud = document.getElementById("input-longitud");
const inputLatitud = document.getElementById("input-latitud");

inputNombre.maxLength = 30;
inputCuit.maxLength = 20;
inputEmail.maxLength = 50;
inputDireccion.maxLength = 50;
inputLongitud.type = "number";
inputLongitud.step = "0.001";

btnVolver.addEventListener("click", () => window.location.href = "../cliente.html");

btnModificar.addEventListener("click", async () => {
    const tmp = {
        id: cliente.id_cliente,
        nombre: inputNombre.value,
        cuit: inputCuit.value,
        email: inputEmail.value,
        direccion: inputDireccion.value,
        id_coordenada: cliente.id_coordenada,
        longitud: Number(inputLongitud.value),
        latitud: Number(inputLatitud.value),
    };

    console.log(tmp);

    if (!verify(tmp)) {
        return;
    }


    if (! await updateCliente(tmp)) {
        alert("no se pudo modificar el cliente");
    }
    window.location.href = "../cliente.html";

});


const clie = sessionStorage.getItem("cliente");
const cliente = JSON.parse(clie);

inputId.value = cliente.id_cliente;
inputNombre.value = cliente.nombre;
inputCuit.value = cliente.cuit;
inputEmail.value = cliente.email;
inputDireccion.value = cliente.direccion;
inputLongitud.value = cliente.longitud;
inputLatitud.value = cliente.latitud;


function verify( {id, nombre, cuit, email, direccion, longitud, latitud}) {

    if (id == null || id == "") {
        alert("debe ingresar un id");
        return false;
    }

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

