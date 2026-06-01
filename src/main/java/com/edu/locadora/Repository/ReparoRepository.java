package com.edu.locadora.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.locadora.Model.Reparo;

@Repository
public interface ReparoRepository extends JpaRepository<Reparo, Long> {
    
}
