
package com.desarrollo.tpSpring.services;

import com.desarrollo.tpSpring.DAOs.BebidaRepository;
import com.desarrollo.tpSpring.DAOs.ItemMenuRepository;
import com.desarrollo.tpSpring.DAOs.ItemsPedidoRepository;
import com.desarrollo.tpSpring.DAOs.PedidoRepository;
import com.desarrollo.tpSpring.DAOs.PlatoRepository;
import com.desarrollo.tpSpring.DAOs.VendedorRepository;
import com.desarrollo.tpSpring.entities.ItemMenu;
import com.desarrollo.tpSpring.entities.ItemsPedido;
import com.desarrollo.tpSpring.entities.Pedido;
import com.desarrollo.tpSpring.entities.Plato;
import com.desarrollo.tpSpring.entities.Vendedor;
import jakarta.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class ItemMenuService {

    @Autowired
    public ItemMenuRepository itemMenuRepository;
    @Autowired
    public PlatoRepository platoRepository;
    @Autowired
    public BebidaRepository bebidaRepository;
    @Autowired
    public VendedorRepository vendedorRepository;
    @Autowired
    public ItemsPedidoRepository itemsPedidoRepository;
    @Autowired
    public PedidoRepository pedidoRepository;

    public List<ItemMenu> obtenerItemsMenu() {
        return itemMenuRepository.findAll();
    }

    @Transactional
    public void crearItemsMenu(ItemMenu item) {
        try {
            itemMenuRepository.save(item);
            System.out.println("Item creado exitosamente");

        } catch (Exception e) {
            System.err.println("Error inesperado al crear el item: " + e.getMessage());
        }
    }

    @Transactional
    public void actualizarItemMenu(ItemMenu item) {
        try {
            itemMenuRepository.save(item);
            System.out.println("Item actualizado exitosamente");
        } catch (Exception e) {
            System.err.println("Error al acceder a la base de datos: " + e.getMessage());
        }

    }

    @Transactional
    public void eliminarItemMenu(Integer id) {
        try {
            itemMenuRepository.deleteById(id);
            System.out.println("Item eliminado exitosamente: " + id);

        } catch (Exception e) {
            System.err.println("Error al acceder a la base de datos: " + e.getMessage());
        }
    }

    public ItemMenu buscarItemMenu(Integer id) {
        return itemMenuRepository.findById(id).get();
    }

    public ItemMenu buscarItemPorNombre(String nombre) {
        return itemMenuRepository.findByNombre(nombre);
    }

    public List<ItemMenu> buscarPorDescripcionItemMenus(String descripcion) {
        return itemMenuRepository.findByDescripcion(descripcion);
    }

    public List<ItemMenu> buscarPorPrecioEntre(int precioMin, int precioMax) {
        return itemMenuRepository.findByPrecioBetween(precioMin, precioMax);
    }

    public List<ItemMenu> buscarPorPrecio(int precio) {
        return itemMenuRepository.findByPrecio(precio);

    }

    public List<ItemMenu> buscarBebidas() {
        return (List<ItemMenu>) itemMenuRepository.findAllBebida();
    }

    public List<ItemMenu> buscarPlatos() {
        return (List<ItemMenu>) itemMenuRepository.findAllPlato();
    }

    public List<Plato> encontrarPorPeso(double peso) {
        return platoRepository.findByPeso(peso);
    }

    public List<Plato> esAptoCeliaco(boolean apto) {
        return platoRepository.findByAptoCeliaco(apto);
    }

    public List<Plato> esAptoVegano(boolean apto) {
        return platoRepository.findByAptoVegano(apto);
    }

    public List<Plato> encontrarPorCalorias(int calorias) {
        return platoRepository.findByCalorias(calorias);
    }

    public List<ItemMenu> obtenerItemsMenuDeVendedor(int id) {
        Vendedor vendedor = vendedorRepository.findById((long) id).get();
        return itemMenuRepository.findByVendedores(vendedor);
    }

    public List<ItemsPedido> obtenerItemsMenuDePedido(int id) {
        Pedido pedido = pedidoRepository.findById(id).get();
        List<ItemsPedido> itemsPedido = itemsPedidoRepository.findByPedido(pedido);

        return itemsPedido;
    }

//      public List<Bebida> findByGraduacion_alcoholica(double graduacion_alcoholica){
//          return bebidaRepository.findByGraduacion_alcoholica(graduacion_alcoholica);
//      }
}
