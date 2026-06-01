package com.edu.locadora.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Reparo 
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "placa_carro")
    private Carro carro;

    private LocalDate entrada;
    private int diasReparo;
    private String defeito;
    private double valorReparo;
    private LocalDate saida;

    public Reparo(){
    }

    public Reparo(Long id,Carro carro, LocalDate entrada, int diasReparo, String defeito, double valorReparo, LocalDate saida)
    {
        this.id = id;
        this.carro = carro;
        this.diasReparo = diasReparo;
        this.defeito = defeito;
        this.valorReparo = valorReparo;
        this.entrada = entrada;
        this.saida = saida;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public Carro getCarro(){
        return carro;
    }

    public void setCarro(Carro carro){
        this.carro = carro;
    }
    
        public LocalDate getEntrada(){
      return entrada;
    }

    public void setEntrada(LocalDate entrada){
        this.entrada = entrada;
    }

    public int getDiasReparo(){
        return diasReparo;
    }

    public void setDiasReparo(int diasReparo){
        this.diasReparo = diasReparo;
    }

    public String getDefeito(){
        return defeito;
    }

    public void setDefeito(String defeito){
        this.defeito = defeito;
    }

    public double getValorReparo(){
        return valorReparo;
    }

    public void setValorReparo(double valorReparo){
        this.valorReparo = valorReparo;
    }

    public LocalDate getSaida(){
        return saida;
    }

    public void setSaida(LocalDate saida){
        this.saida = saida;
    }
}
