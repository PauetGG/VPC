package com.vpc.modules.equipo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipoRepository extends JpaRepository<EquipoEntity, Long> {
	List<EquipoEntity> findByNombreContainingIgnoreCase(String nombre);

    List<EquipoEntity> findByDescripcionIsNotNullAndDescripcionNotOrderByNombreAsc(String emptyString);                    
}
