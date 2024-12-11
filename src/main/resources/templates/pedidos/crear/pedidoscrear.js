const btnModificarItems = document.getElementById("btn-modificar-items");
const btnVolver = document.getElementById("btn-volver");
const btnCrear = document.getElementById("btn-crear");

const inputId = document.getElementById("input-id");
const inputNombre = document.getElementById("input-nombre");
const inputDireccion = document.getElementById("input-direccion");
const inputLongitud = document.getElementById("input-longitud");
const inputLatitud = document.getElementById("input-latitud");

btnModificarItems.addEventListener("click", ()=> {
    window.location.href = "./pcmoditems.html";
});

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


