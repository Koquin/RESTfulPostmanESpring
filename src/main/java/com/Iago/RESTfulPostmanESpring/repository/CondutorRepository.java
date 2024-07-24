package com.Iago.RESTfulPostmanESpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Iago.RESTfulPostmanESpring.model.Condutor;
import org.springframework.stereotype.Repository;

@Repository
public interface CondutorRepository extends JpaRepository<Condutor, Long> {
}
