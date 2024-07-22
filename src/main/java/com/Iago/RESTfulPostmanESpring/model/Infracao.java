package com.Iago.RESTfulPostmanESpring.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
public class Infracao {

    public Infracao(Long id, Condutor condutor, Veiculo veiculo, String tipoInfracao, String local) {
        this.id = id;
        this.condutor = condutor;
        this.veiculo = veiculo;
        this.tipoInfracao = tipoInfracao;
        this.local = local;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "Condutor", referencedColumnName = "id")
    private Condutor condutor;

    @OneToOne
    @JoinColumn(name = "Veiculo", referencedColumnName = "id")
    private Veiculo veiculo;

    private String tipoInfracao;
    private String local;

    public Long id(){
        return this.id;
    }

    public Condutor getCondutor() {
        return condutor;
    }

    public Veiculo getVeiculo() {
        return veiculo;
    }

    public String getTipoInfracao() {
        return tipoInfracao;
    }

    public String getLocal() {
        return local;
    }
}
