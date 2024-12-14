import { createBebida, updateItemMenu } from "../../utils.js";

const btnVolver = document.getElementById("btn-volver");
const btnCrear = document.getElementById("btn-crear");

const inputId = document.getElementById("input-id");
const inputNombre = document.getElementById("input-nombre");
const inputDescripcion = document.getElementById("input-descripcion");
const inputPrecio = document.getElementById("input-precio");
const inputGraduacionAlcoholica = document.getElementById("input-graduacion-alcoholica");
const inputTamanio = document.getElementById("input-tamanio");

btnVolver.addEventListener("click", () => window.location.href = "../itemmenu.html");

btnCrear.addEventListener("click", async () => {
    const tmp = {
        id_item_menu: itemMenu.id_item_menu,
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


    if(!await updateItemMenu(tmp)){
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


const its = sessionStorage.getItem("itemMenu");
const itemMenu = JSON.parse(its);

inputId.value = itemMenu.id_item_menu;
inputNombre.value = itemMenu.nombre;
inputDescripcion.value = itemMenu.descripcion;
inputPrecio.value = itemMenu.precio;
inputGraduacionAlcoholica.value = itemMenu.graduacion_alcoholica;
inputTamanio.value = itemMenu.tamanio;

