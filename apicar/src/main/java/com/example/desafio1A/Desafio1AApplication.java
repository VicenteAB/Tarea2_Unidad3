package com.example.desafio1A;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class Desafio1AApplication {

	public static void main(String[] args) {

		SpringApplication.run(Desafio1AApplication.class, args);
	}
}