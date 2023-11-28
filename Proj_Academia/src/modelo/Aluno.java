/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author pablo
 */
public class Aluno {
    private String cpf;
    private String nome;
    private String DatNasc;
    private float peso;
    private float altura;
    
    private int idAluno;

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getDatNasc() {
        return DatNasc;
    }

    public float getPeso() {
        return peso;
    }

    public float getAltura() {
        return altura;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDatNasc(String DatNasc) {
        this.DatNasc = DatNasc;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

    public void setAltura(float altura) {
        this.altura = altura;
    }
    
    
    
    
}
