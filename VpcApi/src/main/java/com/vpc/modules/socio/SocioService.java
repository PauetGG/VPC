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
}
