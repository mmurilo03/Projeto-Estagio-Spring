package com.dacproject.dacproject.dtos;

import com.dacproject.dacproject.entities.AvaliacaoDoProfessor;

public class AvaliacaoDoProfessorAtributosDTO extends AvaliacaoDoProfessorDTO {
  private static final long serialVersionUID = 1L;

  private Long id;
  private String assiduidade;
  private String disciplina;
  private String sociabilidade;
  private String responsabilidade;
  private String iniciativa;

  public AvaliacaoDoProfessorAtributosDTO() {
  }

  public AvaliacaoDoProfessorAtributosDTO(Long id, String assiduidade, String disciplina,
      String sociabilidade, String responsabilidade, String iniciativa) {
    this.id = id;
    this.assiduidade = assiduidade;
    this.disciplina = disciplina;
    this.sociabilidade = sociabilidade;
    this.responsabilidade = responsabilidade;
    this.iniciativa = iniciativa;
  }

  public AvaliacaoDoProfessorAtributosDTO(AvaliacaoDoProfessor entity) {
    this.id = entity == null ? null : entity.getId();
    this.assiduidade = entity == null ? null : entity.getAssiduidade();
    this.disciplina = entity == null ? null : entity.getDisciplina();
    this.sociabilidade = entity == null ? null : entity.getSociabilidade();
    this.responsabilidade = entity == null ? null : entity.getResponsabilidade();
    this.iniciativa = entity == null ? null : entity.getIniciativa();
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

}