package com.vpc.modules.producto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
