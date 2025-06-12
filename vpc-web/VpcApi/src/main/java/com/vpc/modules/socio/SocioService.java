package com.vpc.modules.socio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SocioService {

    @Autowired
    private SocioRepository socioRepository;

    // Obtener todos los socios
    public List<SocioEntity> getAllSocios() {
        return socioRepository.findAll();
    }

    // Obtener un socio por ID
    public Optional<SocioEntity> getSocioById(Long id) {
        return socioRepository.findById(id);
    }

    // Guardar o actualizar un socio
    public SocioEntity saveSocio(SocioEntity socio) {
        return socioRepository.save(socio);
    }

    // Eliminar un socio
    public void deleteSocio(Long id) {
        socioRepository.deleteById(id);
    }
 // Buscar por nombre o apellidos
    public List<SocioEntity> searchByNombreOrApellidos(String searchTerm) {
        return socioRepository.findByNombreContainingIgnoreCaseOrApellidosContainingIgnoreCase(searchTerm, searchTerm);
    }

    // Buscar por email
    public Optional<SocioEntity> getSocioByEmail(String email) {
        return socioRepository.findByEmail(email);
    }

    // Filtrar por estado
    public List<SocioEntity> getSociosByEstado(String estado) {
        return socioRepository.findByEstado(estado);
    }

    // Filtrar por tipo de socio
    public List<SocioEntity> getSociosByTipoSocio(String tipoSocio) {
        return socioRepository.findByTipoSocio(tipoSocio);
    }

    // Filtrar socios que han aceptado el RGPD
    public List<SocioEntity> getSociosQueHanAceptadoRgpd() {
        return socioRepository.findByAceptacionRgpdIsNotNull();
    }
}
