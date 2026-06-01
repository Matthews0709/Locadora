package com.edu.locadora.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.edu.locadora.Model.Carro;

@Repository
public interface CarroRepository extends JpaRepository<Carro,String> {
    @Query(value = "CALL listar_carros_disponiveis()", nativeQuery = true)
    List<Object[]> listarCarrosDisponiveis();
}
