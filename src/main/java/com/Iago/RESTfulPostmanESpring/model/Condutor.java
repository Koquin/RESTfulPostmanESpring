package com.Iago.RESTfulPostmanESpring.model;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Condutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private boolean habilitado;
    private LocalDate dtNasc;
    private String telefone;
    private String endereco;

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDtNasc() {
        return dtNasc;
    }

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

    public String getEndereco() {
        return endereco;
    }
}
