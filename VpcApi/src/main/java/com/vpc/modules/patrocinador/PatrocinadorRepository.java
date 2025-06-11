package com.vpc.modules.patrocinador;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PatrocinadorRepository extends JpaRepository<PatrocinadorEntity, Long> {
	// Filtrar patrocinadores visibles
    List<PatrocinadorEntity> findByVisibleTrue();

    // Filtrar patrocinadores ocultos
    List<PatrocinadorEntity> findByVisibleFalse();

    // Obtener patrocinadores ordenados
    List<PatrocinadorEntity> findAllByOrderByOrdenAsc();

    // Buscar por nombre
    List<PatrocinadorEntity> findByNombreContainingIgnoreCase(String nombre);
}
