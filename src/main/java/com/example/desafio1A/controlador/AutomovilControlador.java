package com.example.desafio1A.controlador;

import com.example.desafio1A.Entidades.Automovil;
import com.example.desafio1A.Servicios.AutomovilServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/automoviles")
public class AutomovilControlador {

    private final AutomovilServicio automovilServicio;

    public AutomovilControlador(AutomovilServicio automovilServicio) {

        this.automovilServicio = automovilServicio;
    }

    @GetMapping("/generar/{cantidad}")
    public ResponseEntity<List<Automovil>> generarAutomoviles(@PathVariable("cantidad") int cantidad) {
        List<Automovil> automoviles = automovilServicio.generarAutomoviles(cantidad);
        return ResponseEntity.ok(automoviles);
    }

    @GetMapping("/filtrar")
    public ResponseEntity<List<Automovil>> filtrarAutomoviles(
            @RequestParam(required = false) Integer precio,
            @RequestParam(required = false) String tipo,
<<<<<<< HEAD
            @RequestParam(required = false) String color
    ) {
        List<Automovil> automoviles = automovilServicio.obtenerAutomovilesGenerados();

        automoviles = automovilServicio.aplicarFiltros(automoviles, precio, color, tipo);
        return ResponseEntity.ok(automoviles);
    }

=======
            @RequestParam(required = false) String color) {

        List<Automovil> automovilesFiltrados = automovilServicio.filtrarAutomoviles(precio, tipo, color);

        if (automovilesFiltrados.isEmpty()) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.ok(automovilesFiltrados);
        }
    }
>>>>>>> b02ced9ca7c6ac58a26a02f1664c4af094659b68
}
