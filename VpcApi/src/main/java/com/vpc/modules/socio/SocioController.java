package com.vpc.modules.socio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/socios")
public class SocioController {

    @Autowired
    private SocioService socioService;

    // Obtener todos los socios
    @GetMapping
    public List<SocioEntity> getAllSocios() {
        return socioService.getAllSocios();
    }

    // Obtener un socio por ID
    @GetMapping("/{id}")
    public Optional<SocioEntity> getSocioById(@PathVariable Long id) {
        return socioService.getSocioById(id);
    }

    // Crear o actualizar un socio
    @PostMapping
    public SocioEntity createSocio(@RequestBody SocioEntity socio) {
        return socioService.saveSocio(socio);
    }

    // Eliminar un socio
    @DeleteMapping("/{id}")
    public void deleteSocio(@PathVariable Long id) {
        socioService.deleteSocio(id);
    }
}
