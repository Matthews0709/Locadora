package com.edu.locadora.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edu.locadora.Model.Categoria;
import com.edu.locadora.Repository.CategoriaRepository;

@Service
public class CategoriaService 
{
    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodas() {
        return categoriaRepository.findAll();
    }

    public void salvar(Categoria categoria) {
        categoriaRepository.save(categoria);
    }

    public void excluir(Long id){
        categoriaRepository.deleteById(id);
    }

     public Categoria buscarPoridCategoria(Long id){
        return categoriaRepository.findById(id).orElse(null);
    }
}
