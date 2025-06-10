package com.vpc.modules.jugador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    public List<JugadorEntity> getAllJugadores() {
        return jugadorRepository.findAll();
    }

    public Optional<JugadorEntity> getJugadorById(Long id) {
        return jugadorRepository.findById(id);
    }

    public JugadorEntity saveJugador(JugadorEntity jugador) {
        return jugadorRepository.save(jugador);
    }

    public void deleteJugador(Long id) {
        jugadorRepository.deleteById(id);
    }
}
