package desarrollo.tpentrega1.entidades;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ItemsPedidoMemory implements ItemsPedidoDao {
    private List<ItemMenu> items;


    @Override
    public void buscarPorNombre(String nombre) {
        try {
            
            List<ItemMenu> resultados = items.stream().filter(item -> item.getNombre().equals(nombre))
                                              .collect(Collectors.toList());
            if (resultados.isEmpty()) {
                throw new ItemNoEncontradoException("No se encontró ningún item con el nombre: " + nombre);
            }
            // resultados.forEach(item -> System.out.println(item));
            items = resultados;
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void buscarDescripcion(String descripcion) {
        try {
            List<ItemMenu> resultados = items.stream().filter(item -> item.getDescripcion().equals(descripcion))
                                              .collect(Collectors.toList());
            if (resultados.isEmpty()) {
                throw new ItemNoEncontradoException("No se encontró ningún item con la descripción: " + descripcion);
            }
            // resultados.forEach(item -> System.out.println(item));
            items = resultados;
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void buscarPrecioEntre(int precioMin, int precioMax) {
        try {
            List<ItemMenu> resultados = items.stream().filter(item -> item.getPrecio() >= precioMin && item.getPrecio() <= precioMax)
                                              .collect(Collectors.toList());
            if (resultados.isEmpty()) {
                throw new ItemNoEncontradoException("No se encontraron items en el rango de precio: " + precioMin + " a " + precioMax);
            }
            // resultados.forEach(item -> System.out.println(item));
            items = resultados;
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void buscarPrecio(int precio) {
        try {
            List<ItemMenu> resultados = items.stream().filter(item -> item.getPrecio() == precio)
                                              .collect(Collectors.toList());
            if (resultados.isEmpty()) {
                throw new ItemNoEncontradoException("No se encontró ningún item con el precio: " + precio);
            }
            // resultados.forEach(item -> System.out.println(item));
            items = resultados;
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void buscarCategoria(String categoria) {
        try {
            List<ItemMenu> resultados = items.stream().filter(item -> item.getCategoria().equals(categoria))
                                              .collect(Collectors.toList());
            if (resultados.isEmpty()) {
                throw new ItemNoEncontradoException("No se encontró ningún item en la categoría: " + categoria);
            }
            // resultados.forEach(item -> System.out.println(item));
            items = resultados;
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void buscarBebidas() {
        try {
            List<ItemMenu> resultados = items.stream().filter(item -> item instanceof Bebida)
                                              .collect(Collectors.toList());
            if (resultados.isEmpty()) {
                throw new ItemNoEncontradoException("No se encontraron bebidas.");
            }
            // resultados.forEach(item -> System.out.println(item));
            items = resultados;
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void buscarPlatos() {
        try {
            List<ItemMenu> resultados = items.stream().filter(item -> item instanceof Plato)
                                              .collect(Collectors.toList());
            if (resultados.isEmpty()) {
                throw new ItemNoEncontradoException("No se encontraron platos.");
            }
            // resultados.forEach(item -> System.out.println(item));
            items = resultados;
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void buscarComidaPeso(double peso) {
        try {
            List<ItemMenu> resultados = items.stream().filter(item -> item instanceof Plato && ((Plato) item).peso() == peso)
                                              .collect(Collectors.toList());
            if (resultados.isEmpty()) {
                throw new ItemNoEncontradoException("No se encontraron comidas con el peso: " + peso);
            }
            // resultados.forEach(item -> System.out.println(item));
            items = resultados;
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void buscarCeliacos() {
        try {
            List<ItemMenu> resultados = items.stream().filter(item -> item instanceof Plato && ((Plato) item).aptoCeliaco())
                                              .collect(Collectors.toList());
            if (resultados.isEmpty()) {
                throw new ItemNoEncontradoException("No se encontraron comidas aptas para celíacos.");
            }
            // resultados.forEach(item -> System.out.println(item));
            items = resultados;
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void buscarNoCeliacos() {
        try {
            List<ItemMenu> resultados = items.stream().filter(item -> item instanceof Plato && !((Plato) item).aptoCeliaco())
                                              .collect(Collectors.toList());
            if (resultados.isEmpty()) {
                throw new ItemNoEncontradoException("No se encontraron comidas no aptas para celíacos.");
            }
            // resultados.forEach(item -> System.out.println(item));
            items = resultados;
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void buscarVeganos() {
        try {
            List<ItemMenu> resultados = items.stream().filter(item -> item instanceof Plato && ((Plato) item).aptoVegano())
                                              .collect(Collectors.toList());
            if (resultados.isEmpty()) {
                throw new ItemNoEncontradoException("No se encontraron comidas veganas.");
            }
            // resultados.forEach(item -> System.out.println(item));
            items = resultados;
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void buscarNoVeganos() {
        try {
            List<ItemMenu> resultados = items.stream().filter(item -> item instanceof Plato && !((Plato) item).aptoVegano())
                                              .collect(Collectors.toList());
            if (resultados.isEmpty()) {
                throw new ItemNoEncontradoException("No se encontraron comidas no veganas.");
            }
            // resultados.forEach(item -> System.out.println(item));
            items = resultados;
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void buscarComidaCalorias(int calorias) {
        try {
            List<ItemMenu> resultados = items.stream().filter(item -> item instanceof Plato && ((Plato) item).getCalorias() <= calorias)
                                              .collect(Collectors.toList());
            if (resultados.isEmpty()) {
                throw new ItemNoEncontradoException("No se encontraron comidas con menos de " + calorias + " calorías.");
            }
            // resultados.forEach(item -> System.out.println(item));
            items = resultados;
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void buscarBebidaTamaño(double tamaño) {
        try {
            List<ItemMenu> resultados = items.stream().filter(item -> item instanceof Bebida && ((Bebida) item).getTamaño() == tamaño)
                                              .collect(Collectors.toList());
            if (resultados.isEmpty()) {
                throw new ItemNoEncontradoException("No se encontraron bebidas con tamaño: " + tamaño);
            }
            // resultados.forEach(item -> System.out.println(item));
            items = resultados;
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    @Override
    public void buscarBebidaGraduacion(double graduacion) {
        try {
            List<ItemMenu> resultados = items.stream().filter(item -> item instanceof Bebida && ((Bebida) item).getGraduacionAlcoholica() == graduacion)
                                              .collect(Collectors.toList());
            if (resultados.isEmpty()) {
                throw new ItemNoEncontradoException("No se encontraron bebidas con graduación: " + graduacion);
            }
            // resultados.forEach(item -> System.out.println(item));
            items = resultados;
        } catch (ItemNoEncontradoException e) {
            System.err.println(e.getMessage());
        }
    }

    public void setItems(List<ItemMenu> items1) {
        this.items=items1;
    }
    public List<ItemMenu> getItems() {
        return items;
    }
}
