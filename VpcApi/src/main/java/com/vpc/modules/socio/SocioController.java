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
    // Buscar socios por nombre o apellidos (query param)
    // Ejemplo: /api/socios/search?query=juan
    @GetMapping("/search")
    public List<SocioEntity> searchSocios(@RequestParam("query") String query) {
        return socioService.searchByNombreOrApellidos(query);
    }

    // Buscar socio por email
    // Ejemplo: /api/socios/email?email=correo@example.com
    @GetMapping("/email")
    public Optional<SocioEntity> getSocioByEmail(@RequestParam("email") String email) {
        return socioService.getSocioByEmail(email);
    }

    // Filtrar socios por estado
    // Ejemplo: /api/socios/estado/Activo
    @GetMapping("/estado/{estado}")
    public List<SocioEntity> getSociosByEstado(@PathVariable String estado) {
        return socioService.getSociosByEstado(estado);
    }

    // Filtrar socios por tipo de socio
    // Ejemplo: /api/socios/tipo/Individual
    @GetMapping("/tipo/{tipoSocio}")
    public List<SocioEntity> getSociosByTipoSocio(@PathVariable String tipoSocio) {
        return socioService.getSociosByTipoSocio(tipoSocio);
    }

    // Filtrar socios que han aceptado el RGPD
    // Ejemplo: /api/socios/aceptado-rgpd
    @GetMapping("/aceptado-rgpd")
    public List<SocioEntity> getSociosQueHanAceptadoRgpd() {
        return socioService.getSociosQueHanAceptadoRgpd();
    }
}
