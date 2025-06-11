package com.vpc.modules.patrocinador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatrocinadorService {

    @Autowired
    private PatrocinadorRepository patrocinadorRepository;

    // Obtener todos los patrocinadores
    public List<PatrocinadorEntity> getAllPatrocinadores() {
        return patrocinadorRepository.findAll();
    }

    // Obtener un patrocinador por ID
    public Optional<PatrocinadorEntity> getPatrocinadorById(Long id) {
        return patrocinadorRepository.findById(id);
    }

    // Guardar o actualizar un patrocinador
    public PatrocinadorEntity savePatrocinador(PatrocinadorEntity patrocinador) {
        return patrocinadorRepository.save(patrocinador);
    }

    // Eliminar un patrocinador
    public void deletePatrocinador(Long id) {
        patrocinadorRepository.deleteById(id);
    }
}