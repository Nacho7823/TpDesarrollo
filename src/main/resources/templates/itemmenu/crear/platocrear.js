import { createItemMenu } from "../../utils.js";

const btnVolver = document.getElementById("btn-volver");
const btnCrear = document.getElementById("btn-crear");

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


    if(!await createItemMenu(tmp)){
        alert("no se pudo crear la bebida");
        return;
    }

    window.location.href = "../itemmenu.html";

});

// TODO
function validar({nombre, descripcion, precio, peso}) {
    if(!nombre.trim() || !descripcion.trim() || peso <= 0 || precio <= 0) {
        alert("No se permiten campos vacios ni valores invalidos");
        return false;
    }
    return true;
}
