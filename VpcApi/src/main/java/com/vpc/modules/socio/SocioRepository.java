package com.vpc.modules.socio;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SocioRepository extends JpaRepository<SocioEntity, Long>{
	// Buscar por nombre o apellidos
    List<SocioEntity> findByNombreContainingIgnoreCaseOrApellidosContainingIgnoreCase(String nombre, String apellidos);

    // Buscar por email
    Optional<SocioEntity> findByEmail(String email);

    // Filtrar por estado
    List<SocioEntity> findByEstado(String estado);

    // Filtrar por tipo de socio
    List<SocioEntity> findByTipoSocio(String tipoSocio);

    // Filtrar socios que han aceptado el RGPD
    List<SocioEntity> findByAceptacionRgpdIsNotNull();
}
