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
}
