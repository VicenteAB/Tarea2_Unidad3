package com.example.desafio1A.Servicios;

import com.example.desafio1A.Entidades.Automovil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class AutomovilServicio {

    private final List<String> marcas = Arrays.asList("Toyota", "Honda", "Ford", "Chevrolet", "Nissan");
    private final List<String> colores = Arrays.asList("Rojo", "Azul", "Negro", "Blanco", "Gris");
    private final List<String> tipos = Arrays.asList("Sedan", "Camioneta", "SUV");
    private final List<String> motoresSedan = Arrays.asList("1.4cc", "1.6cc", "2.0cc");
    private final List<String> motoresCamioneta = Arrays.asList("2.4cc", "3.0cc", "4.0cc");
    private final List<String> motoresSUV = Arrays.asList("1.8cc", "2.2cc", "2.8cc");

    private List<Automovil> automovilesGenerados = new ArrayList<>();

    private final Random random = new Random();

    private List<Automovil> automoviles;

    public AutomovilServicio() {
        automoviles = generarAutomoviles(100);
    }
    public List<Automovil> generarAutomoviles(int cantidad) {
        automovilesGenerados.clear();
        List<Automovil> automoviles = new ArrayList<>();

        for (int i = 0; i < cantidad; i++) {
            Automovil automovil = new Automovil();

            automovil.setId((long) i + 1);
            automovil.setMarca(marcas.get(random.nextInt(marcas.size())));
            automovil.setAño(random.nextInt(9) + 2015);
            automovil.setColor(colores.get(random.nextInt(colores.size())));
            automovil.setPrecio(random.nextInt(22000001) + 8000000);
            automovil.setTurbo(random.nextBoolean());
            automovil.setTipo(tipos.get(random.nextInt(tipos.size())));

            switch (automovil.getTipo()) {
                case "Sedan":
                    automovil.setMotor(motoresSedan.get(random.nextInt(motoresSedan.size())));
                    break;
                case "Camioneta":
                    automovil.setMotor(motoresCamioneta.get(random.nextInt(motoresCamioneta.size())));
                    automovil.setCabinas(random.nextInt(2) + 1);
                    break;
                case "SUV":
                    automovil.setMotor(motoresSUV.get(random.nextInt(motoresSUV.size())));
                    automovil.setSunroof(random.nextBoolean());
                    break;
            }

            automovil.setPopularidad(0);
            automoviles.add(automovil);
        }
        automovilesGenerados.addAll(automoviles);
        return automoviles;
    }

<<<<<<< HEAD
    public List<Automovil> obtenerAutomovilesGenerados() {
        return automovilesGenerados;
    }
    public List<Automovil> aplicarFiltros(List<Automovil> automoviles, Integer precio, String color, String tipo) {
        List<Automovil> resultado = new ArrayList<>(automoviles);

        if (precio != null) {
            resultado = resultado.stream()
                    .filter(auto -> auto.getPrecio() <= precio)
                    .collect(Collectors.toList());
        }

        if (color != null) {
            resultado = resultado.stream()
                    .filter(auto -> auto.getColor().equalsIgnoreCase(color))
                    .collect(Collectors.toList());
        }

        if (tipo != null) {
            resultado = resultado.stream()
                    .filter(auto -> auto.getTipo().equalsIgnoreCase(tipo))
                    .collect(Collectors.toList());
        }

        return resultado;
=======
    public List<Automovil> filtrarAutomoviles(Integer precio, String tipo, String color) {
        List<Automovil> automovilesFiltrados = generarAutomoviles(100); // Generar una nueva lista de automóviles

        return automovilesFiltrados.stream()
                .filter(automovil -> {
                    boolean precioFiltrado = precio == null || automovil.getPrecio() <= precio;
                    boolean tipoFiltrado = tipo == null || automovil.getTipo().equalsIgnoreCase(tipo);
                    boolean colorFiltrado = color == null || automovil.getColor().equalsIgnoreCase(color);

                    return precioFiltrado && tipoFiltrado && colorFiltrado;
                })
                .collect(Collectors.toList());
>>>>>>> b02ced9ca7c6ac58a26a02f1664c4af094659b68
    }
}