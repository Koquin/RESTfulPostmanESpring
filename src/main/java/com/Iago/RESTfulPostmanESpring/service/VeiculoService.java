package com.Iago.RESTfulPostmanESpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.Iago.RESTfulPostmanESpring.repository.*;
import com.Iago.RESTfulPostmanESpring.model.*;
import java.util.*;
import com.Iago.RESTfulPostmanESpring.exception.*;

public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Veiculo> getAllVeiculos (){
        return veiculoRepository.findAll();
    }

    public Veiculo getVeiculoById(Long id){
        return veiculoRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("Veículo não achado")
        );
    }

    public Veiculo saveVeiculo(Veiculo veiculo){
        return veiculoRepository.save(veiculo);
    }

    public void deleteVeiculoById(Long id){
        if (!veiculoRepository.existsById(id)){
            throw new DataNotFoundException("Veículo não encontrado");
        }
        veiculoRepository.deleteById(id);
    }
}
