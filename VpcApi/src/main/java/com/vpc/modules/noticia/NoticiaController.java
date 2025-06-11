package com.vpc.modules.noticia;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/noticias")
public class NoticiaController {

    @Autowired
    private NoticiaService noticiaService;

    // Obtener todas las noticias
    @GetMapping
    public List<NoticiaEntity> getAllNoticias() {
        return noticiaService.getAllNoticias();
    }

    // Obtener una noticia por ID
    @GetMapping("/{id}")
    public Optional<NoticiaEntity> getNoticiaById(@PathVariable Long id) {
        return noticiaService.getNoticiaById(id);
    }

    // Crear o actualizar una noticia
    @PostMapping
    public NoticiaEntity createNoticia(@RequestBody NoticiaEntity noticia) {
        return noticiaService.saveNoticia(noticia);
    }

    // Eliminar una noticia
    @DeleteMapping("/{id}")
    public void deleteNoticia(@PathVariable Long id) {
        noticiaService.deleteNoticia(id);
    }
}