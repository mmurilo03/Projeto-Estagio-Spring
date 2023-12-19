package com.dacproject.dacproject.dtos;

import java.io.Serializable;

import com.dacproject.dacproject.entities.Aluno;
import com.dacproject.dacproject.entities.AvaliacaoDoProfessor;
import com.dacproject.dacproject.entities.Orientador;

public class AvaliacaoDoProfessorDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String assiduidade;
  private String disciplina;
  private String sociabilidade;
  private String responsabilidade;
  private String iniciativa;

  private AlunoDTO aluno;

  private OrientadorDTO orientador;

  public AvaliacaoDoProfessorDTO() {
  }

  public AvaliacaoDoProfessorDTO(Long id, String assiduidade, String disciplina,
      String sociabilidade, String responsabilidade, String iniciativa,
      Aluno aluno, Orientador orientador) {
    this.id = id;
    this.assiduidade = assiduidade;
    this.disciplina = disciplina;
    this.sociabilidade = sociabilidade;
    this.responsabilidade = responsabilidade;
    this.iniciativa = iniciativa;
    this.aluno = new AlunoAtributosDTO(aluno);
    this.orientador = new OrientadorAtributosDTO(orientador);
  }

  public AvaliacaoDoProfessorDTO(AvaliacaoDoProfessor entity) {
    this.id = entity.getId();
    this.assiduidade = entity.getAssiduidade();
    this.disciplina = entity.getDisciplina();
    this.sociabilidade = entity.getSociabilidade();
    this.responsabilidade = entity.getResponsabilidade();
    this.iniciativa = entity.getIniciativa();
    this.aluno = new AlunoAtributosDTO(entity.getAluno());
    this.orientador = new OrientadorAtributosDTO(entity.getOrientador());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAssiduidade() {
    return assiduidade;
  }

  public void setAssiduidade(String assiduidade) {
    this.assiduidade = assiduidade;
  }

  public String getDisciplina() {
    return disciplina;
  }

  public void setDisciplina(String disciplina) {
    this.disciplina = disciplina;
  }

  public String getSociabilidade() {
    return sociabilidade;
  }

  public void setSociabilidade(String sociabilidade) {
    this.sociabilidade = sociabilidade;
  }

  public String getResponsabilidade() {
    return responsabilidade;
  }

  public void setResponsabilidade(String responsabilidade) {
    this.responsabilidade = responsabilidade;
  }

  public String getIniciativa() {
    return iniciativa;
  }

  public void setIniciativa(String iniciativa) {
    this.iniciativa = iniciativa;
  }

  public AlunoDTO getAluno() {
    return aluno;
  }

  public void setAluno(AlunoDTO aluno) {
    this.aluno = aluno;
  }

  public OrientadorDTO getOrientador() {
    return orientador;
  }

  public void setOrientador(OrientadorDTO orientador) {
    this.orientador = orientador;
  }

  
}