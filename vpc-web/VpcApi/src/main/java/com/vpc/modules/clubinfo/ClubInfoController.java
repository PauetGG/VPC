package com.vpc.modules.clubinfo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/club-info")
public class ClubInfoController {

    @Autowired
    private ClubInfoService clubInfoService;

    // Obtener todos los registros
    @GetMapping
    public List<ClubInfoEntity> getAllClubInfo() {
        return clubInfoService.getAllClubInfo();
    }

    // Obtener un registro por ID
    @GetMapping("/{id}")
    public Optional<ClubInfoEntity> getClubInfoById(@PathVariable Long id) {
        return clubInfoService.getClubInfoById(id);
    }

    // Obtener registros por sección
    @GetMapping("/seccion/{seccion}")
    public List<ClubInfoEntity> getClubInfoBySeccion(@PathVariable String seccion) {
        return clubInfoService.getClubInfoBySeccion(seccion);
    }

    // Crear o actualizar un registro
    @PostMapping
    public ClubInfoEntity saveClubInfo(@RequestBody ClubInfoEntity clubInfo) {
        return clubInfoService.saveClubInfo(clubInfo);
    }

    // Eliminar un registro
    @DeleteMapping("/{id}")
    public void deleteClubInfo(@PathVariable Long id) {
        clubInfoService.deleteClubInfo(id);
    }
 // Obtener registros de una sección ordenados
    @GetMapping("/seccion/{seccion}/ordenado")
    public List<ClubInfoEntity> getClubInfoBySeccionYOrden(@PathVariable String seccion) {
        return clubInfoService.getClubInfoBySeccionYOrden(seccion);
    }

    // Buscar registros
    @GetMapping("/search")
    public List<ClubInfoEntity> searchClubInfo(@RequestParam String q) {
        return clubInfoService.searchClubInfo(q);
    }

    // Cambiar imagen principal
    @PostMapping("/{id}/cambiar-imagen")
    public ClubInfoEntity toggleImagenPrincipal(@PathVariable Long id, @RequestParam String nuevaImagen) {
        return clubInfoService.toggleImagenPrincipal(id, nuevaImagen);
    }

    // Cambiar orden
    @PostMapping("/{id}/cambiar-orden")
    public ClubInfoEntity toggleOrden(@PathVariable Long id, @RequestParam Integer nuevoOrden) {
        return clubInfoService.toggleOrden(id, nuevoOrden);
    }
}