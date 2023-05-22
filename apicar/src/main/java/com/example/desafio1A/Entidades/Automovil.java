package com.example.desafio1A.Entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Automovil {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String marca;

    private Integer año;

    private String color;

    private Integer precio;

    private Boolean turbo;

    private String tipo;

    private String motor;

    private Integer cabinas;

    private Boolean sunroof;

    private Integer popularidad;
}
