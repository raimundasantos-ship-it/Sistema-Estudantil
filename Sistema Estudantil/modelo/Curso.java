package modelo;

import java.util.UUID;

public class Curso {

    private UUID idCurso;
    private String nomeCurso;
    private String cargaHoraria;
    private Professor professor;

    public Curso() {}

    public Curso(String nomeCurso, String cargaHoraria) {
        this.idCurso = UUID.randomUUID();
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
    }

    public Curso(String nomeCurso, String cargaHoraria, Professor professor) {
        this.idCurso = UUID.randomUUID();
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    public Curso(UUID idCurso, String nomeCurso, String cargaHoraria) {
        this.idCurso = (idCurso != null) ? idCurso : UUID.randomUUID();
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
    }

    public Curso(UUID idCurso, String nomeCurso, String cargaHoraria, Professor professor) {
        this.idCurso = (idCurso != null) ? idCurso : UUID.randomUUID();
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
        this.professor = professor;
    }

    public UUID getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(UUID idCurso) {
        this.idCurso = idCurso;
    }

    public String getNomeCurso() {
        return nomeCurso;
    }

    public void setNomeCurso(String nomeCurso) {
        this.nomeCurso = nomeCurso;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public String getNomeProfessor() {
        return (professor != null) ? professor.getNomeCompleto() : null;
    }
}