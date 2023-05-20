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

    private List<Automovil> automoviles;

    public AutomovilServicio() {
        automoviles = generarAutomoviles(100);
    }
    private final Random random = new Random();

    public List<Automovil> generarAutomoviles(int cantidad) {
        List<Automovil> automoviles = new ArrayList<>();

        for (int i = 0; i < cantidad; i++) {
            Automovil automovil = new Automovil();

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

        return automoviles;
    }

    public List<Automovil> getAutomovilesByTipo(String tipo) {
        return automoviles.stream()
                .filter(automovil -> automovil.getTipo().equalsIgnoreCase(tipo))
                .collect(Collectors.toList());
    }
}