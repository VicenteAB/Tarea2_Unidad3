package com.example.desafio1A.controlador;

import com.example.desafio1A.Entidades.Automovil;
import com.example.desafio1A.Servicios.AutomovilServicio;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

}
