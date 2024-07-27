package com.Iago.RESTfulPostmanESpring.service;


import org.springframework.beans.factory.annotation.Autowired;
import com.Iago.RESTfulPostmanESpring.repository.*;
import com.Iago.RESTfulPostmanESpring.model.*;
import java.util.*;
import com.Iago.RESTfulPostmanESpring.exception.*;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

@Service
public class InfracaoService {

    @Autowired
    private InfracaoRepository infracaoRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    public List<Infracao> getAllInfracoes() {
        return infracaoRepository.findAll();
    }

    public Infracao getInfracaoById(Long id) {
        return infracaoRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("Infração não encontrada")
        );
    }

    public Infracao saveInfracao(Infracao infracao) {
        return infracaoRepository.save(infracao);
    }

    public void deleteInfracaoById(Long id) {
        if (!infracaoRepository.existsById(id)) {
            throw new DataNotFoundException(("Infração não encontrada"));
        }
        infracaoRepository.deleteById(id);
    }


}


