package com.Iago.RESTfulPostmanESpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Iago.RESTfulPostmanESpring.model.Enquadramento;
import org.springframework.stereotype.Repository;

@Repository
public interface EnquadramentoRepository extends JpaRepository<Enquadramento, Long> {
}
