package com.example.desafio1A.Entidades;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAño() {
        return año;
    }

    public void setAño(Integer año) {
        this.año = año;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Boolean getTurbo() {
        return turbo;
    }

    public void setTurbo(Boolean turbo) {
        this.turbo = turbo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Integer getCabinas() {
        return cabinas;
    }

    public void setCabinas(Integer cabinas) {
        this.cabinas = cabinas;
    }

    public Boolean getSunroof() {
        return sunroof;
    }

    public void setSunroof(Boolean sunroof) {
        this.sunroof = sunroof;
    }

    public Integer getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(Integer popularidad) {
        this.popularidad = popularidad;
    }
}
