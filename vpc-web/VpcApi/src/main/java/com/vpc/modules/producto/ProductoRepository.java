package com.vpc.modules.producto;


import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{
	// Filtrar por visibilidad
    List<ProductoEntity> findByVisibleTrue();
    List<ProductoEntity> findByVisibleFalse();

    // Filtrar por categoría
    List<ProductoEntity> findByCategoria(String categoria);

    // Buscar por nombre
    List<ProductoEntity> findByNombreContainingIgnoreCase(String nombre);

    // Obtener productos ordenados
    List<ProductoEntity> findAllByOrderByOrdenAsc();

    // Filtrar por rango de precio
    List<ProductoEntity> findByPrecioBetween(BigDecimal min, BigDecimal max);
	
	
}
