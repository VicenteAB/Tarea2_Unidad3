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

            @RequestParam(required = false) String color) {


        List<Automovil> automoviles = automovilServicio.obtenerAutomovilesGenerados();

        automoviles = automovilServicio.aplicarFiltros(automoviles, precio, color, tipo);
        return ResponseEntity.ok(automoviles);
    }


}
