select item_menu.id_item_menu,
		item_menu.nombre,
		item_menu.descripcion ,
		item_menu.precio,
		item_menu.categoria,
		bebida.graduacion_alcoholica,
		bebida.tamanio,
		plato.calorias,
		plato.apto_celiaco,
		plato.apto_vegano,
		plato.peso 
from 
	item_menu left join plato on item_menu.id_item_menu = plato.id_item_menu 
	left join bebida on item_menu.id_item_menu = bebida.id_item_menu where item_menu.id_item_menu = ?;


"select item_menu.id_item_menu,\n" +
"		item_menu.nombre,\n" +
"		item_menu.descripcion ,\n" +
"		item_menu.precio,\n" +
"		item_menu.categoria,\n" +
"		bebida.graduacion_alcoholica,\n" +
"		bebida.tamanio,\n" +
"		plato.calorias,\n" +
"		plato.apto_celiaco,\n" +
"		plato.apto_vegano,\n" +
"		plato.peso \n" +
"from \n" +
"	item_menu left join plato on item_menu.id_item_menu = plato.id_item_menu \n" +
"	left join bebida on item_menu.id_item_menu = bebida.id_item_menu where item_menu.id_item_menu = ?;\n";