package com.Iago.RESTfulPostmanESpring.controller;

import com.Iago.RESTfulPostmanESpring.exception.DataNotFoundException;
import com.Iago.RESTfulPostmanESpring.model.Infracao;
import com.Iago.RESTfulPostmanESpring.service.CondutorService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;
import com.Iago.RESTfulPostmanESpring.service.InfracaoService;
import java.util.*;
import com.Iago.RESTfulPostmanESpring.model.*;

@RestController
@RequestMapping("/infracoes")
public class InfracaoController {

    @Autowired
    private InfracaoService infracaoService;

    @Autowired
    private CondutorService condutorService;

    @GetMapping
    public ResponseEntity<List<Infracao>> getAllInfracoes(){
        List<Infracao> infracoes = infracaoService.getAllInfracoes();
        return new ResponseEntity<>(infracoes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Infracao> getInfracaoById(@PathVariable Long id){
        try {
            Infracao infracao = infracaoService.getInfracaoById(id);
            return new ResponseEntity<>(infracao, HttpStatus.OK);
        } catch (DataNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<Infracao> createInfracao(@RequestBody Infracao infracao){
        Infracao newInfracao = infracaoService.saveInfracao(infracao);
        return new ResponseEntity<>(newInfracao, HttpStatus.CREATED);
    }

    @PutMapping("{id}")
    public ResponseEntity<Infracao> editInfracao(@RequestBody Infracao infracao, @PathVariable Long id){
        Infracao newInfracao = infracaoService.getInfracaoById(id);

        try {
            newInfracao.setCondutor(infracao.getCondutor());
            newInfracao.setLocal(infracao.getLocal());
            newInfracao.setEnquadramento(infracao.getEnquadramento());
            newInfracao.setVeiculo(infracao.getVeiculo());
        } catch (DataNotFoundException e){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        infracaoService.saveInfracao(newInfracao);
        return new ResponseEntity<>(newInfracao, HttpStatus.ACCEPTED);
    }

    @GetMapping("/placaVeiculo")
    public ResponseEntity<Condutor> informacoesHabilitado (@RequestParam String placa){
        Condutor condutorHabilitado = condutorService.getCondutorByPlacaVeiculo(placa);
        if (condutorHabilitado != null){
            return new ResponseEntity<>(condutorHabilitado, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }


}
