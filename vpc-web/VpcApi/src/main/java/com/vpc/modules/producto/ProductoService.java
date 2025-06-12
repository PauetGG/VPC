package com.vpc.modules.producto;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Obtener todos los productos
    public List<ProductoEntity> getAllProductos() {
        return productoRepository.findAll();
    }

    // Obtener un producto por ID
    public Optional<ProductoEntity> getProductoById(Long id) {
        return productoRepository.findById(id);
    }

    // Guardar o actualizar un producto
    public ProductoEntity saveProducto(ProductoEntity producto) {
        return productoRepository.save(producto);
    }

    // Eliminar un producto
    public void deleteProducto(Long id) {
        productoRepository.deleteById(id);
    }
 // Filtrar productos visibles
    public List<ProductoEntity> getProductosVisibles() {
        return productoRepository.findByVisibleTrue();
    }

    // Filtrar productos ocultos
    public List<ProductoEntity> getProductosOcultos() {
        return productoRepository.findByVisibleFalse();
    }

    // Filtrar productos por categoría
    public List<ProductoEntity> getProductosByCategoria(String categoria) {
        return productoRepository.findByCategoria(categoria);
    }

    // Buscar productos por nombre
    public List<ProductoEntity> searchProductosByNombre(String nombre) {
        return productoRepository.findByNombreContainingIgnoreCase(nombre);
    }

    // Obtener productos ordenados
    public List<ProductoEntity> getProductosOrdenados() {
        return productoRepository.findAllByOrderByOrdenAsc();
    }

    // Filtrar por rango de precio
    public List<ProductoEntity> getProductosByPrecioBetween(BigDecimal min, BigDecimal max) {
        return productoRepository.findByPrecioBetween(min, max);
    }
}
