import { createItemMenu } from "../../utils.js";

const btnVolver = document.getElementById("btn-volver");
const btnCrear = document.getElementById("btn-crear");

const inputNombre = document.getElementById("input-nombre");
const inputDescripcion = document.getElementById("input-descripcion");
const inputPrecio = document.getElementById("input-precio");
const inputGraduacionAlcoholica = document.getElementById("input-graduacion-alcoholica");
const inputTamanio = document.getElementById("input-tamanio");

btnVolver.addEventListener("click", () => window.location.href = "../itemmenu.html");

btnCrear.addEventListener("click", async () => {
    const tmp = {
        nombre: inputNombre.value,
        descripcion: inputDescripcion.value,
        precio: Number(inputPrecio.value),
        categoria: "Bebida",
        peso: null,
        apto_vegano: null,
        apto_celiaco: null,
        calorias: null,
        graduacion_alcoholica: Number(inputGraduacionAlcoholica.value),
        tamanio: Number(inputTamanio.value)
    };
    
    console.log(tmp);

    // validar
    if(!validar(tmp)){
        return;
    }


    if(!await createItemMenu(tmp)){
        alert("no se pudo crear la bebida");
        return;
    }

    window.location.href = "../itemmenu.html";

});

function validar({nombre, descripcion, precio, graduacion_alcoholica, tamanio}) {
    if(!nombre.trim() || !descripcion.trim() || precio <= 0 || graduacion_alcoholica < 0 || tamanio <= 0) {
        alert("No se permiten campos vacios ni valores invalidos");
        return false;
    }
    return true;
}


