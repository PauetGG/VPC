package com.vpc.modules.equipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/equipos")
public class EquipoController {

    @Autowired
    private EquipoService equipoService;

    // Obtener todos los equipos
    @GetMapping
    public List<EquipoEntity> getAllEquipos() {
        return equipoService.getAllEquipos();
    }

    // Obtener un equipo por ID
    @GetMapping("/{id}")
    public Optional<EquipoEntity> getEquipoById(@PathVariable Long id) {
        return equipoService.getEquipoById(id);
    }

    // Crear un nuevo equipo
    @PostMapping
    public EquipoEntity createEquipo(@RequestBody EquipoEntity equipo) {
        return equipoService.saveEquipo(equipo);
    }

    // Eliminar un equipo
    @DeleteMapping("/{id}")
    public void deleteEquipo(@PathVariable Long id) {
        equipoService.deleteEquipo(id);
    }
    @GetMapping("/search")
    public List<EquipoEntity> searchEquipos(@RequestParam String q) {
        return equipoService.searchEquipos(q);
    }

    @GetMapping("/con-descripcion")
    public List<EquipoEntity> getEquiposConDescripcion() {
        return equipoService.getEquiposConDescripcion();
    }

    @PostMapping("/{id}/cambiar-descripcion")
    public EquipoEntity toggleDescripcion(@PathVariable Long id, @RequestParam String nuevaDescripcion) {
        return equipoService.toggleDescripcion(id, nuevaDescripcion);
    }
}
