package com.Iago.RESTfulPostmanESpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.Iago.RESTfulPostmanESpring.model.Infracao;

@Repository
public interface InfracaoRepository extends JpaRepository<Infracao, Long> {
}
