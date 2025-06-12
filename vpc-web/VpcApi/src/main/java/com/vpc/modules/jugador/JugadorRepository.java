package com.vpc.modules.jugador;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface JugadorRepository extends JpaRepository<JugadorEntity, Long>{
	  List<JugadorEntity> findByEquipo_IdOrderByNombreAsc(Long equipoId);

	    List<JugadorEntity> findByNombreContainingIgnoreCase(String nombre);

	    List<JugadorEntity> findByPosicionIgnoreCaseOrderByNombreAsc(String posicion);

	    List<JugadorEntity> findByNacionalidadIgnoreCaseOrderByNombreAsc(String nacionalidad);

	    @Query("SELECT j FROM JugadorEntity j WHERE " +
	           "YEAR(CURRENT_DATE) - YEAR(j.fechaNacimiento) BETWEEN :minEdad AND :maxEdad " +
	           "ORDER BY j.nombre ASC")
	    List<JugadorEntity> findByEdadBetween(int minEdad, int maxEdad);
}
