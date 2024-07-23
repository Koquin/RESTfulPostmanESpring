package com.Iago.RESTfulPostmanESpring.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
public class Enquadramento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String tipo;
    private String descricao;

    public String getDescricao() {
        return descricao;
    }

    public Long getId() {
        return id;
    }

    public String getTipo() {
        return tipo;
    }
}
