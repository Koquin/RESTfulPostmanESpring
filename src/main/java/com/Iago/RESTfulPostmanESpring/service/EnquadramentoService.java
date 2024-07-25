package com.Iago.RESTfulPostmanESpring.service;

import org.springframework.beans.factory.annotation.Autowired;
import com.Iago.RESTfulPostmanESpring.repository.*;
import com.Iago.RESTfulPostmanESpring.model.*;
import java.util.*;
import com.Iago.RESTfulPostmanESpring.exception.*;

public class EnquadramentoService {

    @Autowired
    private EnquadramentoRepository enquadramentoRepository;

    public List<Enquadramento> getAllEnquadramentos(){
        return enquadramentoRepository.findAll();
    }

    public Enquadramento getEnquadramentoById(Long id){
        return enquadramentoRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("Enquadramento não encontrado")
        );
    }

    public Enquadramento saveEnquadramento(Enquadramento enquadramento){
        return enquadramentoRepository.save(enquadramento);
    }

    public void deleteEnquadramentoById(Long id){
        if (!enquadramentoRepository.existsById(id)){
            throw new DataNotFoundException("Enquadramento não encontrado");
        }
        enquadramentoRepository.deleteById(id);
    }

}
