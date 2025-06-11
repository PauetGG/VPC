package com.vpc.modules.noticia;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoticiaRepository extends JpaRepository<NoticiaEntity, Long>{
	List<NoticiaEntity> findByVisibleTrueOrderByFechaPublicacionDesc();

    List<NoticiaEntity> findByFuenteIgnoreCaseOrderByFechaPublicacionDesc(String fuente);

    List<NoticiaEntity> findByTituloContainingIgnoreCaseOrContenidoContainingIgnoreCase(String titulo, String contenido);

    List<NoticiaEntity> findByFechaPublicacionBetweenOrderByFechaPublicacionDesc(LocalDateTime desde, LocalDateTime hasta);
}
