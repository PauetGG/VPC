package com.vpc.modules.equipo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EquipoService {

    @Autowired
    private EquipoRepository equipoRepository;

    public List<EquipoEntity> getAllEquipos() {
        return equipoRepository.findAll();
    }

    public Optional<EquipoEntity> getEquipoById(Long id) {
        return equipoRepository.findById(id);
    }

    public EquipoEntity saveEquipo(EquipoEntity equipo) {
        return equipoRepository.save(equipo);
    }

    public void deleteEquipo(Long id) {
        equipoRepository.deleteById(id);
    }
    public List<EquipoEntity> searchEquipos(String query) {
        return equipoRepository.findByNombreContainingIgnoreCase(query);
    }

    public List<EquipoEntity> getEquiposConDescripcion() {
        return equipoRepository.findByDescripcionIsNotNullAndDescripcionNotOrderByNombreAsc("");
    }

    public EquipoEntity toggleDescripcion(Long id, String nuevaDescripcion) {
        Optional<EquipoEntity> optionalEquipo = equipoRepository.findById(id);
        if (optionalEquipo.isPresent()) {
            EquipoEntity equipo = optionalEquipo.get();
            equipo.setDescripcion(nuevaDescripcion);
            return equipoRepository.save(equipo);
        } else {
            throw new RuntimeException("Equipo no encontrado con ID: " + id);
        }
    }
}
