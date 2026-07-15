package modelo;

import java.time.LocalDate;

//Subclasse de Pessoa. Aplica o conceito de Herança ('extends').
public class Estudante extends Pessoa {
    
    // Construtor: repassar os dados para o construtor da classe(Pessoa)
    public Estudante(String matricula, String nomeCompleto, LocalDate dataNascimento) {
        super(matricula, nomeCompleto, dataNascimento);
    }

    // Sobrescrita de método (@Override):
    @Override
    public void exibirDados() {
        System.out.println("Estudante: " + getNomeCompleto() + " | Matrícula: " + getMatricula());
    }
}