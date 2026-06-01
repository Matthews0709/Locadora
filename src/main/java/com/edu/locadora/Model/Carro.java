package com.edu.locadora.Model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;


@Entity
public class Carro 
{
    @OneToMany(mappedBy = "carro")
    private List<Aluguel> alugueis;

    @OneToMany(mappedBy = "carro")
    private List<Reparo> reparos;

    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;


    @Id
    private String placa;
    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    private String tpCombustivel;
    private double qtCombustivel;
    private int quilometragem;
    private String cambio;
    private boolean disponibilidade;

    public Carro(){
    }

    public Carro(String placa, String marca, String modelo, String cor, int ano, String tpCombustivel,
       double qtCombustivel,int quilometragem, String cambio, boolean disponibilidade)
    {
        this.placa = placa;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.tpCombustivel = tpCombustivel;
        this.qtCombustivel = qtCombustivel;
        this.quilometragem = quilometragem;
        this.cambio = cambio;
        this.disponibilidade = disponibilidade;
    }

    public String getPlaca(){
        return placa;
    }

    public void setPlaca(String placa){
        this.placa = placa;
    }

    public String getMarca(){
        return marca;
    }

    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getModelo(){
        return modelo;
    }

    public void setModelo(String modelo){
        this.modelo = modelo;
    }
    public String getCor() 
    {
        return cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }   
    public int getAno(){
        return ano;
    }

    public void setAno(int ano){
        this.ano = ano;
    }

    public String getTpCombustivel() 
    {
        return tpCombustivel;
    }

    public void setTpCombustivel(String tpCombustivel){
        this.tpCombustivel = tpCombustivel;
    }

    public double getQtCombustivel() 
    {
        return qtCombustivel;
    }

    public void setQtCombustivel(double qtCombustivel){
        this.qtCombustivel = qtCombustivel;
    }

    public int getQuilometragem(){
        return quilometragem;
    }

    public void setQuilometragem(int quilometragem){
        this.quilometragem = quilometragem;
    }

    public String getCambio() 
    {
        return cambio;
    }

    public void setCambio(String cambio){
        this.cambio = cambio;
    }

    public boolean getDisponibilidade(){
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade){
        this.disponibilidade = disponibilidade;
    }

    public List<Aluguel> getAlugueis(){
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis){
        this.alugueis = alugueis;
    }

    public List<Reparo> getReparos(){
        return reparos;
    }

    public void setReparos(List<Reparo> reparos){
        this.reparos = reparos;
    }

    public Categoria getCategoria(){
        return categoria;
    }

    public void setCategoria(Categoria categoria){
        this.categoria = categoria;
    }
}
