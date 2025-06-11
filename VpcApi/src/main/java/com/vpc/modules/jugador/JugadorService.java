package com.vpc.modules.jugador;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    public List<JugadorEntity> getJugadoresPorEquipo(Long equipoId) {
        return jugadorRepository.findByEquipo_IdOrderByNombreAsc(equipoId);
    }

    public List<JugadorEntity> searchJugadores(String query) {
        return jugadorRepository.findByNombreContainingIgnoreCase(query);
    }

    public List<JugadorEntity> getJugadoresPorPosicion(String posicion) {
        return jugadorRepository.findByPosicionIgnoreCaseOrderByNombreAsc(posicion);
    }

    public List<JugadorEntity> getJugadoresPorNacionalidad(String nacionalidad) {
        return jugadorRepository.findByNacionalidadIgnoreCaseOrderByNombreAsc(nacionalidad);
    }

    public List<JugadorEntity> getJugadoresPorRangoEdad(int minEdad, int maxEdad) {
        return jugadorRepository.findByEdadBetween(minEdad, maxEdad);
    }

    public JugadorEntity toggleFoto(Long id, String nuevaFoto) {
        Optional<JugadorEntity> optionalJugador = jugadorRepository.findById(id);
        if (optionalJugador.isPresent()) {
            JugadorEntity jugador = optionalJugador.get();
            jugador.setFoto(nuevaFoto);
            jugador.setActualizadoEn(LocalDateTime.now());
            return jugadorRepository.save(jugador);
        } else {
            throw new RuntimeException("Jugador no encontrado con ID: " + id);
        }
    }
}
