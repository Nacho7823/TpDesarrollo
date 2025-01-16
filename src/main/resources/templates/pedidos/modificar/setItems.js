import { getItemsOfVendedor } from "../../utils.js";

const btnVolver = document.getElementById("btn-volver");


btnVolver.addEventListener("click", () => {
    const itemsAdded = getItemsAdded();
    for (let i = 0; i < itemsAdded.length; i++) {
        if (itemsAdded[i].cantidad < 0) {
            alert("la cantidad no puede ser negativa");
            return;
        }

        if (itemsAdded[i].cantidad == 0) {
            itemsAdded.splice(i, 1);
            i--;
        }
    }


    setItemsAdded(itemsAdded);
    window.location.href = "pedidosmodificar.html";
});



// item-menu
async function updateItemsOfVendedor(id) {
    const items = await getItemsOfVendedor(id);
    console.log(items)
    clearTable();
    for (const item of items) {
        let cant = 0;
        for (const i of getItemsAdded()) {
            if (i.id_item_menu == item.id_item_menu) {
                cant = i.cantidad;
                break;
            }
        }
        
        addRow(item, cant);
    }
}


function addRow(item, valueCant) {
    const row = document.createElement('tr');

    const createCell = (text) => {
        const cell = document.createElement('th');
        cell.textContent = text;
        return cell;
    }
    const createInput = (action) => {
        const inp = document.createElement('input');
        inp.addEventListener("change", (ev) => {
            const v = Number(ev.target.value);
            action(v)
        });
        inp.type = "number";
        inp.min = 0;
        inp.step = 1;
        inp.value = valueCant;
        const cell = document.createElement('th');
        cell.appendChild(inp);
        return cell;
    }
    console.log(valueCant);

    row.appendChild(createCell(item.id_item_menu));
    row.appendChild(createCell(item.nombre));
    row.appendChild(createCell(item.descripcion));
    row.appendChild(createCell(item.precio));
    row.appendChild(createCell(item.categoria));
    row.appendChild(createCell(item.peso));
    row.appendChild(createCell(item.apto_vegano));
    row.appendChild(createCell(item.apto_celiaco));
    row.appendChild(createCell(item.calorias));
    row.appendChild(createCell(item.graduacion_alcoholica));
    row.appendChild(createCell(item.tamanio));
    row.appendChild(createInput((cant) => setItemCantity(item.id_item_menu, cant)));

    const tbod = document.getElementById("tablebody");
    tbod.appendChild(row)
}

function clearTable() {
    const tbod = document.getElementById("tablebody");
    while (tbod.firstChild) {
        tbod.removeChild(tbod.firstChild);
    }
}


function setItemCantity(id_item_menu, cantity) {
    const itemsAdded = getItemsAdded();
    let index = -1;
    for (let i = 0; i < itemsAdded.length; i++) {
        if (itemsAdded[i].id_item_menu == id_item_menu) {
            index = i;
            break;
        }
    }
    if (index == -1)
        itemsAdded.push({ id_item_menu: id_item_menu, cantidad: cantity });
    
    else 
        itemsAdded[index].cantidad = cantity;

    setItemsAdded(itemsAdded);
    
}


// if (Object.keys(itemsAdded).length == 0) 
    // itemsAdded = [];

function getPedido() {
    return JSON.parse(sessionStorage.getItem("pedido"));
}
function getItemsAdded() {
    return JSON.parse(sessionStorage.getItem("itemsSeleccionados"));
}
function setItemsAdded(items) {
    sessionStorage.setItem("itemsSeleccionados", JSON.stringify(items));
}

(async function main() {
    const pedido = getPedido();
    updateItemsOfVendedor(pedido.id_vendedor);

})();
