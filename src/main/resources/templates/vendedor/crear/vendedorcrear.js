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


btnCrear.addEventListener("click", ()=> {
    nombre = inputNombre.value;
    direccion = inputDireccion.value;
    longitud = Number(inputLongitud.value);
    latitud = Number(inputLatitud.value);
    
    s = "";
    s += "nombre: " + nombre + "\n";
    s += "direccion: " + direccion + "\n";
    s += "longitud: " + longitud + "\n";
    s += "latitud: " + latitud + "\n";
    
    console.log(s);

    fetch(window.location.origin + "/vendedor/vendedor", {
        method: "POST",
        headers: {
            'Content-Type': 'application/json'
        },
        body: JSON.stringify({
            nombre: nombre,
            direccion: direccion,
            longitud: longitud,
            latitud: latitud
        })
    }).then(response => {
        if (!response.ok) {
            alert("no se pudo crear el vendedor: " + " - " + response.status);
            return;
        }
        window.location.href = "../vendedor.html";
    }).catch(e => {
        alert(e);
    });

});


