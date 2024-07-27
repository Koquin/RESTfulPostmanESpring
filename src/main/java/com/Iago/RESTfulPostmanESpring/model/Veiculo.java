package com.Iago.RESTfulPostmanESpring.model;

import jakarta.persistence.*;

@Entity
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String placa;
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "id_condutor")
    private Condutor condutor;

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public Condutor getCondutor() {
        return condutor;
    }
}
