package com.vpc.modules.jugador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/jugadores")
public class JugadorController {

    @Autowired
    private JugadorService jugadorService;

    // Obtener todos los jugadores
    @GetMapping
    public List<JugadorEntity> getAllJugadores() {
        return jugadorService.getAllJugadores();
    }

    // Obtener un jugador por ID
    @GetMapping("/{id}")
    public Optional<JugadorEntity> getJugadorById(@PathVariable Long id) {
        return jugadorService.getJugadorById(id);
    }

    // Crear un nuevo jugador
    @PostMapping
    public JugadorEntity createJugador(@RequestBody JugadorEntity jugador) {
        return jugadorService.saveJugador(jugador);
    }

    // Eliminar un jugador
    @DeleteMapping("/{id}")
    public void deleteJugador(@PathVariable Long id) {
        jugadorService.deleteJugador(id);
    }
    @GetMapping("/equipo/{equipoId}")
    public List<JugadorEntity> getJugadoresPorEquipo(@PathVariable Long equipoId) {
        return jugadorService.getJugadoresPorEquipo(equipoId);
    }

    @GetMapping("/search")
    public List<JugadorEntity> searchJugadores(@RequestParam String q) {
        return jugadorService.searchJugadores(q);
    }

    @GetMapping("/posicion/{posicion}")
    public List<JugadorEntity> getJugadoresPorPosicion(@PathVariable String posicion) {
        return jugadorService.getJugadoresPorPosicion(posicion);
    }

    @GetMapping("/nacionalidad/{nacionalidad}")
    public List<JugadorEntity> getJugadoresPorNacionalidad(@PathVariable String nacionalidad) {
        return jugadorService.getJugadoresPorNacionalidad(nacionalidad);
    }

    @GetMapping("/rango-edad")
    public List<JugadorEntity> getJugadoresPorRangoEdad(@RequestParam int min, @RequestParam int max) {
        return jugadorService.getJugadoresPorRangoEdad(min, max);
    }

    @PostMapping("/{id}/cambiar-foto")
    public JugadorEntity toggleFoto(@PathVariable Long id, @RequestParam String nuevaFoto) {
        return jugadorService.toggleFoto(id, nuevaFoto);
    }
}
