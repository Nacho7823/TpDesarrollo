const btnCliente = document.getElementById("btn-clienteui")
const btnVendedor = document.getElementById("btn-vendedorui")
const btnPedidos = document.getElementById("btn-pedidosui")

btnCliente.addEventListener("click", ()=>{
    window.location.href = "../cliente/cliente.html";
});
btnVendedor.addEventListener("click", ()=>{
    window.location.href = "../vendedor/vendedor.html";
});
btnPedidos.addEventListener("click", () => {
    window.location.href = "../pedidos/pedidos.html";
});

const btnCrearBebida = document.getElementById("btn-crear-bebida")
const btnCrearPlato = document.getElementById("btn-crear-plato")

btnCrearBebida.addEventListener("click", ()=>{
    window.location.href = "crear/bebidacrear.html";
})
btnCrearPlato.addEventListener("click", ()=>{
    window.location.href = "crear/platocrear.html";
})

// server = window.location.origin;

// btnBuscar = document.getElementById("btn-buscar")

async function load() {
    const response = await fetch(window.location.origin + "/itemmenus");
    if (!response.ok) {
        
        alert("no se pudieron obtener los itemmenus");
        return;
    }
    const itemmenus = await response.json();
    for (const item of itemmenus) {
        addRow(item);
    }
}

load();

const defData = [
    {
        id_itemmenu: 1,
        nombre: "itemmenu 1",
        descripcion: "descripcion 1",
        precio: "precio 1",
        categoria: "categoria 1",
        peso: "peso 1",
        aptoVegano: "aptoVegano 1",
        aptoCeliaco: "aptoCeliaco 1",
        calorias: "calorias 1",
        graduacionAlcoholica: "graduacionAlcoholica 1",
        tamano: "tamano 1"
    },
    {
        id_itemmenu: 2,
        nombre: "itemmenu 2",
        descripcion: "descripcion 2",
        precio: "precio 2",
        categoria: "categoria 2",
        peso: "peso 2",
        aptoVegano: "aptoVegano 2",
        aptoCeliaco: "aptoCeliaco 2",
        calorias: "calorias 2",
        graduacionAlcoholica: "graduacionAlcoholica 2",
        tamano: "tamano 2"
    }
]


// defData.forEach(item => addRow(item))

function addRow(item) {
    const row = document.createElement('tr');
    row.innerHTML = `
                <th>${item.id_itemmenu}</th>
                <th>${item.nombre}</th>
                <th>${item.descripcion}</th>
                <th>${item.precio}</th>
                <th>${item.categoria}</th>
                <th>${item.peso}</th>
                <th>${item.aptoVegano}</th>
                <th>${item.aptoCeliaco}</th>
                <th>${item.calorias}</th>
                <th>${item.graduacionAlcoholica}</th>
                <th>${item.tamano}</th>
                <th>editar</th>
                <th>eliminar</th>
            `;

    const tbod = document.getElementById("tablebody");
    tbod.appendChild(row)
}