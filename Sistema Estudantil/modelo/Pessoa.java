package modelo;

import java.time.LocalDate;

//Classe abstrata que serve como base (Superclasse) 
public abstract class Pessoa {
    // Atributos privados:
    private String matricula;
    private String nomeCompleto;
    private LocalDate dataNascimento;

    // Construtor: 
    public Pessoa(String matricula, String nomeCompleto, LocalDate dataNascimento) {
        this.matricula = matricula;
        this.nomeCompleto = nomeCompleto;
        this.dataNascimento = dataNascimento;
    }

    // Métodos Getters e Setters: Permitem o acesso e modificação segura dos atributos privados
    public String getMatricula() {
         return matricula; }
    public void setMatricula(String matricula) { 
        this.matricula = matricula; }
    
    public String getNomeCompleto() { 
        return nomeCompleto; }
    public void setNomeCompleto(String nomeCompleto) {
         this.nomeCompleto = nomeCompleto; }
    
    public LocalDate getDataNascimento() { 
        
        return dataNascimento; }
    public void setDataNascimento(LocalDate dataNascimento) {
         this.dataNascimento = dataNascimento; }

    // Método abstrato:
    public abstract void exibirDados();
}