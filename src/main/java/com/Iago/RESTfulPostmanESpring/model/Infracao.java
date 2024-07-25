package com.Iago.RESTfulPostmanESpring.model;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

@Entity
public class Infracao {

    public Infracao(Long id, Condutor condutor, Veiculo veiculo, Enquadramento enquadramento, String local) {
        this.id = id;
        this.condutor = condutor;
        this.veiculo = veiculo;
        this.enquadramento = enquadramento;
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

    @OneToOne
    @JoinColumn(name = "Enquadramento", referencedColumnName = "id")
    private Enquadramento enquadramento;

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

    public String getLocal() {
        return local;
    }

    public Enquadramento getEnquadramento() {
        return enquadramento;
    }

    public Long getId() {
        return id;
    }

    public void setCondutor(Condutor condutor) {
        this.condutor = condutor;
    }

    public void setVeiculo(Veiculo veiculo) {
        this.veiculo = veiculo;
    }

    public void setEnquadramento(Enquadramento enquadramento) {
        this.enquadramento = enquadramento;
    }

    public void setLocal(String local) {
        this.local = local;
    }
}
