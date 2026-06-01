package com.edu.locadora.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.locadora.Model.Carro;
import com.edu.locadora.Model.Reparo;
import com.edu.locadora.Repository.ReparoRepository;

@Service
public class ReparoService 
{
    @Autowired
    ReparoRepository reparoRepository;

    @Autowired
    CarroService carroService;

    public void salvar(Reparo reparo){
        reparoRepository.save(reparo);
    }

    public List<Reparo> listarTodos(){
        return reparoRepository.findAll();
    }

    public void excluir(Long id){
        reparoRepository.deleteById(id);
    }

     public Reparo buscarPorIdReparo(Long id){
        return reparoRepository.findById(id).orElse(null);
    }

    // Iniciar reparo
    public Reparo iniciarReparo(Carro carro, Reparo reparo){

         if (!carro.getDisponibilidade()) {
            throw new RuntimeException("Carro não disponível para reparo");
        }

        carro.setDisponibilidade(false);
        carroService.salvar(carro);

        reparo.setCarro(carro);
        reparo.setEntrada(LocalDate.now());
        
        return reparoRepository.save(reparo);
    }

    //Finalizar reparo
    public Reparo finalizarReparo(Carro carro, Long id){
         Reparo reparo = reparoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Reparo não encontrado"));

        carro.setDisponibilidade(true);
        carroService.salvar(carro);

         reparo.setSaida(LocalDate.now());

        return reparoRepository.save(reparo);
    }
}
