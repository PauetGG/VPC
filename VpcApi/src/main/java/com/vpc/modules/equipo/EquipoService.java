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
}
