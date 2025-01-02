import { getItemsOfVendedor, getItemMenu} from "../../utils.js";

const btnVolver = document.getElementById("btn-volver");


btnVolver.addEventListener("click", () => {
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


    sessionStorage.setItem("itemsSeleccionados", JSON.stringify(itemsAdded));
    window.location.href = "pedidoscrear.html";
});



// item-menu
async function updateItemsOfVendedor(id) {
    const items = await getItemsOfVendedor(id);
    console.log(items)
    clearTable();
    for (const item of items) {
        let cant = 0;
        for (const i of itemsAdded) {
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
            const v = ev.target.value;
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
    
}

function calculateTotal() {
    const detalles = [];
    itemsAdded.forEach((value, key) => {
        if (value <= 0) {
            return;
        }
        detalles.push({
            id_item_menu: key,
            cantidad: value
        });
    });

    let total = 0;
    detalles.forEach((detalle) => {
        const item = getItemMenu(detalle.id_item_menu);
        total += item.precio * detalle.cantidad;
    });

    inputTotal.value = total;
}


const id_vendedor = JSON.parse(sessionStorage.getItem("vendedor"));
let itemsAdded = JSON.parse(sessionStorage.getItem("itemsSeleccionados"))

if (Object.keys(itemsAdded).length == 0) 
    itemsAdded = [];


(async function main() {
    console.log(id_vendedor)
    updateItemsOfVendedor(id_vendedor);

})();
