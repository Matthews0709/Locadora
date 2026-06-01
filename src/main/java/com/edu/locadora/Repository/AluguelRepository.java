package com.edu.locadora.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.locadora.Model.Aluguel;

@Repository
public interface AluguelRepository extends JpaRepository<Aluguel, Long>{
    
}
