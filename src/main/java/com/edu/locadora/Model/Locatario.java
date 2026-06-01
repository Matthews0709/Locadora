package com.edu.locadora.Model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Locatario 
{
    @OneToMany(mappedBy = "locatario")
    private List<Aluguel> alugueis;

    @Id
    private String cpf;
    private String nome;
    private String habilitacao;
    private LocalDate nascimento;
    private String logradouro;
    private int numero;
    private String cep;
    private String cidade;

    public Locatario(){
    }

    public Locatario(String cpf, String nome, String habilitacao, LocalDate nascimento,
    String logradouro,int numero,String cep,String cidade)
    {
        this.cpf = cpf;
        this.nome = nome;
        this.habilitacao = habilitacao;
        this.nascimento = nascimento;
        this.logradouro = logradouro;
        this.numero = numero;
        this.cep = cep;
        this.cidade = cidade;
    }

    public String getCpf()
    {
        return cpf;
    }

    public void setCpf(String cpf) 
    {
        this.cpf = cpf;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome = nome;
    }
    
    public String getHabilitacao() 
    {
        return habilitacao;
    }

    public void setHabilitacao(String habilitacao) 
    {
        this.habilitacao = habilitacao;
    }

    public LocalDate getNascimento(){
      return nascimento;
    }

    public void setNascimento(LocalDate nascimento){
        this.nascimento = nascimento;
    }

    public String getLogradouro() 
    {
        return logradouro;
    }

    public void setLogradouro(String logradouro) 
    {
        this.logradouro = logradouro;
    }

    
    public int getNumero() 
    {
        return numero;
    }

    public void setNumero(int numero) 
    {
        this.numero = numero;
    }

    public String getCep() 
    {
        return cep;
    }

    public void setCep(String cep) 
    {
        this.cep = cep;
    }

    public String getCidade() 
    {
        return cidade;
    }

    public void setCidade(String cidade) 
    {
        this.cidade = cidade;
    }

    public List<Aluguel> getAlugueis(){
        return alugueis;
    }

    public void setAlugueis(List<Aluguel> alugueis){
        this.alugueis = alugueis;
    } 
}
