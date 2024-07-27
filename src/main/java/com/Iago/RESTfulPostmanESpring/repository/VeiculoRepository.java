package com.Iago.RESTfulPostmanESpring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.Iago.RESTfulPostmanESpring.model.Veiculo;
import org.springframework.stereotype.Repository;

@Repository
public interface VeiculoRepository extends JpaRepository<Veiculo, Long> {
    Veiculo findByPlaca(String placa);
}
