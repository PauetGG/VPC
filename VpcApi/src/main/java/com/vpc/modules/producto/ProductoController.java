package com.vpc.modules.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
}
