package com.edu.locadora.Service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.edu.locadora.Model.Carro;
import com.edu.locadora.Repository.CarroRepository;

@Service
public class CarroService {
    
    @Autowired
    CarroRepository carroRepository;

    public void salvar(Carro carro){
        carroRepository.save(carro);
    }

    public List<Carro> listarTodos(){
        return carroRepository.findAll();
    }

    public void excluir(String placa){
        carroRepository.deleteById(placa);
    }

     public Carro buscarPorPlaca(String placa){
        return carroRepository.findById(placa).orElse(null);
    }

    //Checa disponibilidade
    public boolean carroDisponivel(Carro carro) {

        boolean emAluguel = carro.getAlugueis()
                .stream()
                .anyMatch(a -> a.getDevolucao() == null);

        boolean emReparo = carro.getReparos()
                .stream()
                .anyMatch(r -> true);

        return !emAluguel && !emReparo;
    }

    //Atualiza a disponibilidade
    public void atualizarDisponibilidade(Carro carro){
        carro.setDisponibilidade(carroDisponivel(carro));
    }

    public List<Carro> listarCarrosDisponiveisUDF(){

        List<Object[]> dados = carroRepository.listarCarrosDisponiveis();

        List<Carro> carros = new ArrayList<>();

        for (Object[] obj : dados) {

            Carro c = new Carro();

            c.setPlaca((String) obj[0]);
            c.setMarca((String) obj[1]);
            c.setModelo((String) obj[2]);
            c.setCor((String) obj[3]);
            c.setAno((Integer) obj[4]);
            c.setTpCombustivel((String) obj[5]);

            carros.add(c);
        }

        return carros;
    }
    

}
