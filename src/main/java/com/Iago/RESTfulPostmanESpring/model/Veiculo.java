package com.Iago.RESTfulPostmanESpring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String modelo;

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }
}
