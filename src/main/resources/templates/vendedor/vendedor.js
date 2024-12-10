btnVolver = document.getElementById("btn-volver")

btnVolver.addEventListener("click", () => {
    window.location.href="../index.html"
})

server = window.location.origin;

btnBuscar = document.getElementById("btn-buscar")
btnEditar = document.getElementById("btn-editar")
btnEliminar = document.getElementById("btn-eliminar")
btnCrear = document.getElementById("btn-crear")


btnBuscar.addEventListener("click", () => {
    
    try {
        const response = await fetch(server + "/vendedores");
        if (!response.ok) {
            alert("no se pudo obtener los vendedores");
            throw new Error("error al obtener los vendedores " + response.status);
        }
        const data = await response.json();
        alert(data);

    } catch(error) {
        alert(error);
    }
});