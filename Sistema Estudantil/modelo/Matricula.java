package modelo;

import java.time.LocalDate;
import modelo.Estudante;
import modelo.Curso;

// Subclasse de Estudante. Aplica o conceito de Herança ('extends')
public class Matricula extends Estudante {
    // Atributos privados específicos da matrícula
    private Curso curso;
    private LocalDate dataMatricula;

    // Construtor Completo: repassa os dados do estudante para a superclasse (Estudante -> Pessoa)
    public Matricula(String matricula, String nomeCompleto, LocalDate dataNascimento, Curso curso, LocalDate dataMatricula) {
        // O 'super' envia os dados para o construtor da classe Estudante
        super(matricula, nomeCompleto, dataNascimento);
        this.curso = curso;
        this.dataMatricula = (dataMatricula != null) ? dataMatricula : LocalDate.now();
    }

    // Getters e Setters específicos
    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }

    public LocalDate getDataMatricula() {
        return dataMatricula;
    }

    public void setDataMatricula(LocalDate dataMatricula) {
        this.dataMatricula = dataMatricula;
    }
}
