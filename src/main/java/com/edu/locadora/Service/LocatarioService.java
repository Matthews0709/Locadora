package com.edu.locadora.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.locadora.Model.Locatario;
import com.edu.locadora.Repository.LocatarioRepository;

@Service
public class LocatarioService 
{
    @Autowired
    LocatarioRepository locatarioRepository;

    public void salvar(Locatario locatario){
        locatarioRepository.save(locatario);
    }

    public List<Locatario> listarTodos(){
        return locatarioRepository.findAll();
    }

    public void excluir(String cpf){
        locatarioRepository.deleteById(cpf);
    }

     public Locatario buscarPorCPF(String cpf){
        return locatarioRepository.findById(cpf).orElse(null);
    }    
}
