btnVendedor = document.getElementById("btn-vendedor");
btnCliente = document.getElementById("btn-cliente");
btnPedidos = document.getElementById("btn-pedidos");
btnItems = document.getElementById("btn-items");

btnVendedor.addEventListener("click", () => {
    window.location.href = "./vendedor/vendedor.html"
    // window.location.href = "https://localhost/vendedor"
})

btnCliente.addEventListener("click", () => {
    window.location.href = "./cliente/cliente.html"
    // window.location.href = "https://localhost/vendedor"
})

