package com.edu.locadora.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Categoria 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private double valorDiaria;

    @OneToMany(mappedBy = "categoria")
    private List<Carro> carros;

    public Categoria(){
    }

    public Categoria(String nome, double valorDiaria){
        this.nome = nome;
        this.valorDiaria = valorDiaria;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getNome(){
        return nome;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public double getValorDiaria(){
        return valorDiaria;
    }

    public void setValorDiaria(double valorDiaria){
        this.valorDiaria = valorDiaria;
    }

    public List<Carro> getCarros(){
        return carros;
    }

    public void setCarros(List<Carro> carros){
        this.carros = carros;
    }
}
