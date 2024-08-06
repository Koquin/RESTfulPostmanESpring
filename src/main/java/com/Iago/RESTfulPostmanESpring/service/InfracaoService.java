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
    private CondutorRepository condutorRepository;

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private EnquadramentoRepository enquadramentoRepository;

    public List<Infracao> getAllInfracoes() {
        return infracaoRepository.findAll();
    }

    public Infracao getInfracaoById(Long id) {
        return infracaoRepository.findById(id).orElseThrow(
                () -> new DataNotFoundException("Infração não encontrada")
        );
    }

    public Infracao saveInfracao(Infracao infracao) {
        // Verificar e carregar entidades associadas, se necessário
        if (infracao.getCondutor() != null) {
            Long condutorId = infracao.getCondutor().getId();
            if (condutorId != null) {
                Condutor condutorExistente = condutorRepository.findById(condutorId).orElse(null);
                infracao.setCondutor(condutorExistente);
            }
        }
        if (infracao.getVeiculo() != null) {
            Long veiculoId = infracao.getVeiculo().getId();
            if (veiculoId != null) {
                Veiculo veiculoExistente = veiculoRepository.findById(veiculoId).orElse(null);
                infracao.setVeiculo(veiculoExistente);
            }
        }
        if (infracao.getEnquadramento() != null) {
            Long enquadramentoId = infracao.getEnquadramento().getId();
            if (enquadramentoId != null) {
                Enquadramento enquadramentoExistente = enquadramentoRepository.findById(enquadramentoId).orElse(null);
                infracao.setEnquadramento(enquadramentoExistente);
            }
        }
        return infracaoRepository.save(infracao);
    }

    public void deleteInfracaoById(Long id) {
        if (!infracaoRepository.existsById(id)) {
            throw new DataNotFoundException(("Infração não encontrada"));
        }
        infracaoRepository.deleteById(id);
    }


}


