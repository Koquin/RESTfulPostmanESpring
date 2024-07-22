package com.Iago.RESTfulPostmanESpring.model;

import jakarta.persistence.*;

@Entity
public class Condutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private boolean habilitado;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "endereco", referencedColumnName = "id")
    private Endereco endereco;

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public boolean isHabilitado() {
        return habilitado;
    }

    public Endereco getEndereco() {
        return endereco;
    }
}
