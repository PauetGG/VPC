package com.vpc.modules.patrocinador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/patrocinadores")
public class PatrocinadorController {

    @Autowired
    private PatrocinadorService patrocinadorService;

    // Obtener todos los patrocinadores
    @GetMapping
    public List<PatrocinadorEntity> getAllPatrocinadores() {
        return patrocinadorService.getAllPatrocinadores();
    }

    // Obtener un patrocinador por ID
    @GetMapping("/{id}")
    public Optional<PatrocinadorEntity> getPatrocinadorById(@PathVariable Long id) {
        return patrocinadorService.getPatrocinadorById(id);
    }

    // Crear o actualizar un patrocinador
    @PostMapping
    public PatrocinadorEntity createPatrocinador(@RequestBody PatrocinadorEntity patrocinador) {
        return patrocinadorService.savePatrocinador(patrocinador);
    }

    // Eliminar un patrocinador
    @DeleteMapping("/{id}")
    public void deletePatrocinador(@PathVariable Long id) {
        patrocinadorService.deletePatrocinador(id);
    }
 // Obtener patrocinadores visibles
    @GetMapping("/visibles")
    public List<PatrocinadorEntity> getPatrocinadoresVisibles() {
        return patrocinadorService.getPatrocinadoresVisibles();
    }

    // Obtener patrocinadores ocultos
    @GetMapping("/ocultos")
    public List<PatrocinadorEntity> getPatrocinadoresOcultos() {
        return patrocinadorService.getPatrocinadoresOcultos();
    }

    // Obtener patrocinadores ordenados
    @GetMapping("/ordenados")
    public List<PatrocinadorEntity> getPatrocinadoresOrdenados() {
        return patrocinadorService.getPatrocinadoresOrdenados();
    }

    // Buscar patrocinadores por nombre
    @GetMapping("/search")
    public List<PatrocinadorEntity> searchPatrocinadoresByNombre(@RequestParam("nombre") String nombre) {
        return patrocinadorService.searchPatrocinadoresByNombre(nombre);
    }
}
