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
}
