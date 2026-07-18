package modelo;

import java.time.LocalDate;

public class Professor extends Pessoa {
	
	private String especialidade;
	
	    //parecido com o da subclasse estudante, mas adicionando o atributo especialidade
	    public Professor(String matricula, String nomeCompleto, LocalDate dataNascimento, String especialidade) {
	        super(matricula, nomeCompleto, dataNascimento);
	        this.especialidade = especialidade;    }
	    
	    //crie o get e setter de especialidade aqui, devido a ser um atributo exclusivo desta classe
	    public String getEspecialidade() { return especialidade; }
	    public void   setEspecialidade(String especialidade) { this.especialidade = especialidade; }

	    @Override
	    public void exibirDados() {
	        System.out.println("Professor: " + getNomeCompleto()
	        + " | Matrícula: " + getMatricula()
	        + " | Data de Nascimento: " + getDataNascimento() 
	        + " | Especialidade: " + getEspecialidade());
	    }
	}
