package com.vpc.modules.clubinfo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
}