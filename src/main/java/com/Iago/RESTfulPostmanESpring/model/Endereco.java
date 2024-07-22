package com.Iago.RESTfulPostmanESpring.model;

import jakarta.persistence.*;

@Entity
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cidade;
    private String bairro;
    private String rua;
    private String cep;

    String getCidade(){
        return this.cidade;
    }

    String getBairro(){
        return this.bairro;
    }

    String getRua(){
        return this.rua;
    }

    String getCep(){
        return this.cep;
    }

    Long getId(){
        return this.id;
    }
}
