const btnVolver = document.getElementById("btn-volver");
const btnCrear = document.getElementById("btn-crear");

const inputId = document.getElementById("input-id");
const inputNombre = document.getElementById("input-nombre");
const inputCuit = document.getElementById("input-cuit");
const inputEmail = document.getElementById("input-email");
const inputDireccion = document.getElementById("input-direccion");
const inputLongitud = document.getElementById("input-longitud");
const inputLatitud = document.getElementById("input-latitud");

btnVolver.addEventListener("click", ()=> {
    window.location.href = "../cliente.html";
});



btnCrear.addEventListener("click", ()=> {
    id = inputId.value;
    nombre = inputNombre.value;
    cuit = inputCuit.value;
    email = inputEmail.value;
    direccion = inputDireccion.value;
    longitud = inputLongitud.value;
    latitud = inputLatitud.value;
    
    s = "";
    s += "id: " + id + "\n";
    s += "nombre: " + nombre + "\n";
    s += "cuit: " + cuit + "\n";
    s += "email: " + email + "\n";
    s += "direccion: " + direccion + "\n";
    s += "longitud: " + longitud + "\n";
    s += "latitud: " + latitud + "\n";
    
    alert(s);

    console.log(s);
});


