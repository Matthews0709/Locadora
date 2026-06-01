package com.edu.locadora.Service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.locadora.Model.Aluguel;
import com.edu.locadora.Model.Carro;
import com.edu.locadora.Model.Locatario;
import com.edu.locadora.Repository.AluguelRepository;


@Service
public class AluguelService
{    
    @Autowired
    AluguelRepository aluguelRepository;

    @Autowired
    CarroService carroService;

    public void salvar(Aluguel aluguel){
        aluguelRepository.save(aluguel);
    }

    public List<Aluguel> listarTodos(){
        return aluguelRepository.findAll();
    }

    public void excluir(Long id){
        aluguelRepository.deleteById(id);
    }

     public Aluguel buscarPorId(Long id){
        return aluguelRepository.findById(id).orElse(null);
    }

      //Valor base do aluguel
    public double calcularValorAluguel(Carro carro, int dias) {
        return carro.getCategoria().getValorDiaria() * dias;
    }

    // Calcula o combustível
    public double calcularCombustivel(Carro carro, double litrosFaltando) {

           if ("GASOLINA".equalsIgnoreCase(carro.getTpCombustivel())) {
            return litrosFaltando * 7.0;
        }

        if ("ALCOOL".equalsIgnoreCase(carro.getTpCombustivel())) {
            return litrosFaltando * 5.5;
        }

        return 0;
    }

    //Calcula o valor final
    public double calcularValorFinal(Carro carro, int dias,
                                     double litrosFaltando,
                                     boolean danos) {

        double valorBase = calcularValorAluguel(carro, dias);
        double combustivel = calcularCombustivel(carro, litrosFaltando);
        double multa = danos ? 200.0 : 0.0;

        return valorBase + combustivel + multa;
    }

    //Criar aluguel
    public Aluguel criarAluguel(Carro carro, Locatario locatario, int dias) {

        if (!carroService.carroDisponivel(carro)) {
            throw new RuntimeException("Carro não disponível");
        }

        Aluguel aluguel = new Aluguel();
        aluguel.setCarro(carro);
        aluguel.setLocatario(locatario);
        aluguel.setQtDias(dias);
    
        double valorBase = calcularValorAluguel(carro, dias);

        aluguel.setValorTotal(valorBase);
        aluguel.setValorCombustivel(0);
        aluguel.setDataRetirada(LocalDate.now());

        carro.setDisponibilidade(false);
        carroService.salvar(carro);

        return aluguelRepository.save(aluguel);
    }

    // Devolução
    public Aluguel devolverCarro(Long id,
                                 double litrosFaltando,
                                 boolean danos) {
        Aluguel aluguel = aluguelRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Aluguel não encontrado"));

        Carro carro = aluguel.getCarro();

        double valorBase = calcularValorAluguel(carro, aluguel.getQtDias());
        double combustivel = calcularCombustivel(carro, litrosFaltando);
        double multa = danos ? 200.0 : 0.0;

        double valorFinal = valorBase + combustivel + multa;

        aluguel.setValorTotal(valorFinal);
        aluguel.setValorCombustivel(combustivel);
        aluguel.setDevolucao(LocalDate.now());

        carro.setDisponibilidade(true);
        carroService.salvar(carro);

        return aluguelRepository.save(aluguel);
    }

}
