package com.vpc.modules.noticia;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class NoticiaService {

    @Autowired
    private NoticiaRepository noticiaRepository;

    // Obtener todas las noticias
    public List<NoticiaEntity> getAllNoticias() {
        return noticiaRepository.findAll();
    }

    // Obtener una noticia por ID
    public Optional<NoticiaEntity> getNoticiaById(Long id) {
        return noticiaRepository.findById(id);
    }

    // Guardar o actualizar una noticia
    public NoticiaEntity saveNoticia(NoticiaEntity noticia) {
        return noticiaRepository.save(noticia);
    }

    // Eliminar una noticia por ID
    public void deleteNoticia(Long id) {
        noticiaRepository.deleteById(id);
    }
    
    public List<NoticiaEntity> getNoticiasVisibles() {
        return noticiaRepository.findByVisibleTrueOrderByFechaPublicacionDesc();
    }

    public List<NoticiaEntity> getUltimasNoticias(int count) {
        Pageable pageable = PageRequest.of(0, count, Sort.by("fechaPublicacion").descending());
        return noticiaRepository.findAll(pageable).getContent();
    }

    public List<NoticiaEntity> getNoticiasPorFuente(String fuente) {
        return noticiaRepository.findByFuenteIgnoreCaseOrderByFechaPublicacionDesc(fuente);
    }

    public List<NoticiaEntity> searchNoticias(String query) {
        return noticiaRepository.findByTituloContainingIgnoreCaseOrContenidoContainingIgnoreCase(query, query);
    }

    public List<NoticiaEntity> getNoticiasPorRangoFecha(LocalDateTime desde, LocalDateTime hasta) {
        return noticiaRepository.findByFechaPublicacionBetweenOrderByFechaPublicacionDesc(desde, hasta);
    }

    public NoticiaEntity toggleVisibilidad(Long id) {
        Optional<NoticiaEntity> optionalNoticia = noticiaRepository.findById(id);
        if (optionalNoticia.isPresent()) {
            NoticiaEntity noticia = optionalNoticia.get();
            noticia.setVisible(!noticia.isVisible());
            noticia.setActualizadoEn(LocalDateTime.now());
            return noticiaRepository.save(noticia);
        } else {
            throw new RuntimeException("Noticia no encontrada con ID: " + id);
        }
    }
}
