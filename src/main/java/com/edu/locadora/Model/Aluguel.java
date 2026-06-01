package com.edu.locadora.Model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Aluguel 
{
    @ManyToOne
    @JoinColumn(name = "cpf_locatario")
    private Locatario locatario;

    @ManyToOne
    @JoinColumn(name = "placa_carro")
    private Carro carro;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int qtDias;
    private LocalDate devolucao;
    private LocalDate dataRetirada;
    private double valorAluguel;
    private double valorTotal;
    private double valorCombustivel;
    private boolean danos;

    public Aluguel(){
    }

    public Aluguel(Long id, int qtDias, LocalDate devolucao, double valorAluguel, double valorTotal, double valorCombustivel, boolean danos)
    {
        this.id = id;
        this.qtDias = qtDias;
        this.devolucao = devolucao;
        this.valorAluguel = valorAluguel;
        this.valorTotal = valorTotal;
        this.valorCombustivel = valorCombustivel;
        this.danos = danos;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public int getQtDias(){
      return qtDias;
    }

    public void setQtDias(int qtDias){
        this.qtDias = qtDias;
    }

    public LocalDate getDevolucao(){
      return devolucao;
    }

    public void setDevolucao(LocalDate devolucao){
        this.devolucao = devolucao;
    }

    public double getValorAluguel(){
        return valorAluguel;
    }

    public void setValorAluguel(double valorAluguel){
        this.valorAluguel = valorAluguel;
    }

    public double getValorTotal(){
        return valorTotal;
    }

    public void setValorTotal(double valorTotal){
        this.valorTotal = valorTotal;
    }

    public double getValorCombustivel(){
        return valorCombustivel;
    }

    public void setValorCombustivel(double valorCombustivel){
        this.valorCombustivel = valorCombustivel;
    }

    public boolean getDanos(){
        return danos;
    }

    public void setDanos(boolean danos){
        this.danos = danos;
    }

    public Locatario getLocatario(){
        return locatario; 
    }
    public void setLocatario(Locatario locatario){
        this.locatario = locatario; 
    }

    public Carro getCarro(){
        return carro; 
    }
    public void setCarro(Carro carro){
        this.carro = carro; 
    }

    public LocalDate getDataRetirada(){
        return dataRetirada;
    }

    public void setDataRetirada(LocalDate dataRetirada){
        this.dataRetirada = dataRetirada;
    }
}
