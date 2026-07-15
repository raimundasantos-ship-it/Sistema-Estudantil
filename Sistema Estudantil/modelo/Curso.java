package modelo;

/* 
Importar o item professor responsavel para dentro do curso; 
terminar de construir o curso;
*/

import java.util.UUID;
public class Curso {

    private UUID idCurso;
    private String nomeCurso;
    private String cargaHoraria;

    public Curso(){}

    public Curso(String nomeCurso, String cargaHoraria) {
        this.idCurso = UUID.randomUUID();
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
    }

    public Curso(UUID idCurso, String nomeCurso, String cargaHoraria) {
        this.idCurso = (idCurso != null) ? idCurso : UUID.randomUUID();
        this.nomeCurso = nomeCurso;
        this.cargaHoraria = cargaHoraria;
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

}