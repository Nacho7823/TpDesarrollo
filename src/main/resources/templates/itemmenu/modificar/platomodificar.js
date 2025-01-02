import { getVendedores, createPlato, updateItemMenu } from "../../utils.js";

const btnVolver = document.getElementById("btn-volver");
const btnCrear = document.getElementById("btn-crear");

const inputId = document.getElementById("input-id");
const inputNombre = document.getElementById("input-nombre");
const inputDescripcion = document.getElementById("input-descripcion");
const inputPrecio = document.getElementById("input-precio");
const inputPeso = document.getElementById("input-peso");
const inputAptoVegano = document.getElementById("input-apto-vegano");
const inputAptoCeliaco = document.getElementById("input-apto-celiaco");
const inputCalorias = document.getElementById("input-calorias");

btnVolver.addEventListener("click", () => window.location.href = "../itemmenu.html");

btnCrear.addEventListener("click", async () => {
    const tmp = {
        id_item_menu: itemMenu.id_item_menu,
        nombre: inputNombre.value,
        descripcion: inputDescripcion.value,
        precio: Number(inputPrecio.value),
        categoria: "Plato",
        peso: Number(inputPeso.value),
        apto_vegano: Boolean(inputAptoVegano.checked),
        apto_celiaco: Boolean(inputAptoCeliaco.checked),
        calorias: Number(inputCalorias.value),
        graduacion_alcoholica: null,
        tamanio: null,
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

function validar({nombre, descripcion, precio, peso}) {
    if(!nombre.trim() || !descripcion.trim() || peso <= 0 || precio <= 0) {
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
inputPeso.value = itemMenu.peso;
inputAptoVegano.checked = itemMenu.apto_vegano;
inputAptoCeliaco.checked = itemMenu.apto_celiaco;
inputCalorias.value = itemMenu.calorias;
