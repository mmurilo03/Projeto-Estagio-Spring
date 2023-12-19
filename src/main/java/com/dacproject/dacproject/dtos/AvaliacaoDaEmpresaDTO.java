package com.dacproject.dacproject.dtos;

import java.io.Serializable;

import com.dacproject.dacproject.entities.Aluno;
import com.dacproject.dacproject.entities.AvaliacaoDaEmpresa;
import com.dacproject.dacproject.entities.Empresa;

public class AvaliacaoDaEmpresaDTO implements Serializable {
  private static final long serialVersionUID = 1L;

  private Long id;

  private String rendimentoDeTrabalho;
  private String conhecimentos;
  private String cumprimentoDasTarefas;
  private String aprendizagem;
  private String desempenho;

  private AlunoDTO aluno;

  private EmpresaDTO empresa;

  public AvaliacaoDaEmpresaDTO() {
  }

  public AvaliacaoDaEmpresaDTO(Long id, String rendimentoDeTrabalho, String conhecimentos,
      String cumprimentoDasTarefas, String aprendizagem, String desempenho,
      Aluno aluno, Empresa empresa) {
    this.id = id;
    this.rendimentoDeTrabalho = rendimentoDeTrabalho;
    this.conhecimentos = conhecimentos;
    this.cumprimentoDasTarefas = cumprimentoDasTarefas;
    this.aprendizagem = aprendizagem;
    this.desempenho = desempenho;
    this.aluno = new AlunoAtributosDTO(aluno);
    this.empresa = new EmpresaAtributosDTO(empresa);
  }

  public AvaliacaoDaEmpresaDTO(AvaliacaoDaEmpresa entity) {
    this.id = entity.getId();
    this.rendimentoDeTrabalho = entity.getRendimentoDeTrabalho();
    this.conhecimentos = entity.getConhecimentos();
    this.cumprimentoDasTarefas = entity.getCumprimentoDasTarefas();
    this.aprendizagem = entity.getAprendizagem();
    this.desempenho = entity.getDesempenho();
    this.aluno = new AlunoAtributosDTO(entity.getAluno());
    this.empresa = new EmpresaAtributosDTO(entity.getEmpresa());
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

public AlunoDTO getAluno() {
    return aluno;
}

public void setAluno(AlunoDTO aluno) {
    this.aluno = aluno;
}

public EmpresaDTO getEmpresa() {
    return empresa;
}

public void setEmpresa(EmpresaDTO empresa) {
    this.empresa = empresa;
}

}