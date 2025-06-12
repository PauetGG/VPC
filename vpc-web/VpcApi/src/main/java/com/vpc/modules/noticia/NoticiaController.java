package com.vpc.modules.noticia;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
    @GetMapping("/visibles")
    public List<NoticiaEntity> getNoticiasVisibles() {
        return noticiaService.getNoticiasVisibles();
    }

    @GetMapping("/ultimas")
    public List<NoticiaEntity> getUltimasNoticias(@RequestParam int count) {
        return noticiaService.getUltimasNoticias(count);
    }

    @GetMapping("/fuente/{fuente}")
    public List<NoticiaEntity> getNoticiasPorFuente(@PathVariable String fuente) {
        return noticiaService.getNoticiasPorFuente(fuente);
    }

    @GetMapping("/search")
    public List<NoticiaEntity> searchNoticias(@RequestParam String q) {
        return noticiaService.searchNoticias(q);
    }

    @GetMapping("/rango-fecha")
    public List<NoticiaEntity> getNoticiasPorRangoFecha(@RequestParam("desde") String desdeStr,
                                                        @RequestParam("hasta") String hastaStr) {
        LocalDateTime desde = LocalDateTime.parse(desdeStr);
        LocalDateTime hasta = LocalDateTime.parse(hastaStr);
        return noticiaService.getNoticiasPorRangoFecha(desde, hasta);
    }

    @PostMapping("/{id}/toggle-visibilidad")
    public NoticiaEntity toggleVisibilidad(@PathVariable Long id) {
        return noticiaService.toggleVisibilidad(id);
    }
}