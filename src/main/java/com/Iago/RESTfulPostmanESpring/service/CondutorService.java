package com.Iago.RESTfulPostmanESpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.Iago.RESTfulPostmanESpring.repository.*;
import com.Iago.RESTfulPostmanESpring.model.*;
import java.util.*;
import com.Iago.RESTfulPostmanESpring.exception.*;
import org.springframework.stereotype.Service;

@Service
public class CondutorService {

    @Autowired
    private CondutorRepository condutorRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Condutor> getAllCondutores(){
        return condutorRepository.findAll();
    }

    public Condutor getCondutorById (Long id){
        return condutorRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("Condutor não encontrado")
        );
    }

    public Condutor saveCondutor (Condutor condutor){
        return condutorRepository.save(condutor);
    }

    public void deleteCondutorById(Long id){
        if (!condutorRepository.existsById(id)) {
            throw new DataNotFoundException("Condutor não encontrado");
        }
        condutorRepository.deleteById(id);
    }

    public Condutor getCondutorByPlacaVeiculo(String placa){
        Condutor condutor = veiculoRepository.findByPlaca(placa).getCondutor();
        if (condutor == null){
            throw new DataNotFoundException("Condutor não encontrado");
        }
        return condutor;
    }




}
