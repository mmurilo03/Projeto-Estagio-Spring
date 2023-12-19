package com.dacproject.dacproject.dtos;

import com.dacproject.dacproject.entities.AvaliacaoDaEmpresa;

public class AvaliacaoDaEmpresaAtributosDTO extends AvaliacaoDaEmpresaDTO {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String rendimentoDeTrabalho;
  private String conhecimentos;
  private String cumprimentoDasTarefas;
  private String aprendizagem;
  private String desempenho;

  public AvaliacaoDaEmpresaAtributosDTO() {
  }

  public AvaliacaoDaEmpresaAtributosDTO(Long id, String rendimentoDeTrabalho, String conhecimentos,
      String cumprimentoDasTarefas, String aprendizagem, String desempenho) {
    this.id = id;
    this.rendimentoDeTrabalho = rendimentoDeTrabalho;
    this.conhecimentos = conhecimentos;
    this.cumprimentoDasTarefas = cumprimentoDasTarefas;
    this.aprendizagem = aprendizagem;
    this.desempenho = desempenho;
  }

  public AvaliacaoDaEmpresaAtributosDTO(AvaliacaoDaEmpresa entity) {
    this.id = entity == null ? null : entity.getId();
    this.rendimentoDeTrabalho = entity == null ? null : entity.getRendimentoDeTrabalho();
    this.conhecimentos = entity == null ? null : entity.getConhecimentos();
    this.cumprimentoDasTarefas = entity == null ? null : entity.getCumprimentoDasTarefas();
    this.aprendizagem = entity == null ? null : entity.getAprendizagem();
    this.desempenho = entity == null ? null : entity.getDesempenho();
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getRendimentoDeTrabalho() {
    return rendimentoDeTrabalho;
  }

  public void setRendimentoDeTrabalho(String rendimentoDeTrabalho) {
    this.rendimentoDeTrabalho = rendimentoDeTrabalho;
  }

  public String getConhecimentos() {
    return conhecimentos;
  }

  public void setConhecimentos(String conhecimentos) {
    this.conhecimentos = conhecimentos;
  }

  public String getCumprimentoDasTarefas() {
    return cumprimentoDasTarefas;
  }

  public void setCumprimentoDasTarefas(String cumprimentoDasTarefas) {
    this.cumprimentoDasTarefas = cumprimentoDasTarefas;
  }

  public String getAprendizagem() {
    return aprendizagem;
  }

  public void setAprendizagem(String aprendizagem) {
    this.aprendizagem = aprendizagem;
  }

  public String getDesempenho() {
    return desempenho;
  }

  public void setDesempenho(String desempenho) {
    this.desempenho = desempenho;
  }

}