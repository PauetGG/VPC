package com.vpc.modules.noticia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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
}
