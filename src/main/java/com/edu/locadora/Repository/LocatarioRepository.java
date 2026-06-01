package com.edu.locadora.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edu.locadora.Model.Locatario;

@Repository
public interface LocatarioRepository extends JpaRepository<Locatario, String>{
    
}
