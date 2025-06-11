package com.vpc.modules.producto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/productos")
public class ProductoController {

    @Autowired
    private ProductoService productoService;

    // Obtener todos los productos
    @GetMapping
    public List<ProductoEntity> getAllProductos() {
        return productoService.getAllProductos();
    }

    // Obtener un producto por ID
    @GetMapping("/{id}")
    public Optional<ProductoEntity> getProductoById(@PathVariable Long id) {
        return productoService.getProductoById(id);
    }

    // Crear o actualizar un producto
    @PostMapping
    public ProductoEntity createProducto(@RequestBody ProductoEntity producto) {
        return productoService.saveProducto(producto);
    }

    // Eliminar un producto
    @DeleteMapping("/{id}")
    public void deleteProducto(@PathVariable Long id) {
        productoService.deleteProducto(id);
    }
 // Obtener productos visibles
    @GetMapping("/visibles")
    public List<ProductoEntity> getProductosVisibles() {
        return productoService.getProductosVisibles();
    }

    // Obtener productos ocultos
    @GetMapping("/ocultos")
    public List<ProductoEntity> getProductosOcultos() {
        return productoService.getProductosOcultos();
    }

    // Filtrar productos por categoría
    @GetMapping("/categoria/{categoria}")
    public List<ProductoEntity> getProductosByCategoria(@PathVariable String categoria) {
        return productoService.getProductosByCategoria(categoria);
    }

    // Buscar productos por nombre
    @GetMapping("/search")
    public List<ProductoEntity> searchProductosByNombre(@RequestParam("nombre") String nombre) {
        return productoService.searchProductosByNombre(nombre);
    }

    // Obtener productos ordenados
    @GetMapping("/ordenados")
    public List<ProductoEntity> getProductosOrdenados() {
        return productoService.getProductosOrdenados();
    }

    // Filtrar productos por rango de precio
    @GetMapping("/precio")
    public List<ProductoEntity> getProductosByPrecioBetween(@RequestParam("min") BigDecimal min,
                                                            @RequestParam("max") BigDecimal max) {
        return productoService.getProductosByPrecioBetween(min, max);
    }
}
