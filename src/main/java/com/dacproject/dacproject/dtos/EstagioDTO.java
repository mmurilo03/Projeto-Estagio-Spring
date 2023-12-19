package com.dacproject.dacproject.dtos;

import java.io.Serializable;

import com.dacproject.dacproject.entities.Aluno;
import com.dacproject.dacproject.entities.Empresa;
import com.dacproject.dacproject.entities.Estagio;
import com.dacproject.dacproject.entities.Orientador;

public class EstagioDTO implements Serializable {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String dataInicio;
  private String dataFim;
  private String cargaHoraria;
  private String status;

  private AlunoDTO alunoEstagio;

  private OrientadorDTO orientadorEstagio;

  private EmpresaDTO empresaEstagio;

  public EstagioDTO() {
  }

  public EstagioDTO(Long id, String dataInicio, String dataFim,
      String cargaHoraria, String status, Aluno alunoEstagio, 
      Orientador orientadorEstagio, Empresa empresaEstagio) {
    this.id = id;
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
    this.cargaHoraria = cargaHoraria;
    this.status = status;
    this.alunoEstagio = new AlunoAtributosDTO(alunoEstagio);
    this.orientadorEstagio = new OrientadorDTO(orientadorEstagio);
    this.empresaEstagio = new EmpresaDTO(empresaEstagio);
  }

  public EstagioDTO(Estagio entity) {
    this.id = entity == null ? null : entity.getId();
    this.dataInicio = entity == null ? null : entity.getDataInicio();
    this.dataFim = entity == null ? null : entity.getDataFim();
    this.cargaHoraria = entity == null ? null : entity.getCargaHoraria();
    this.status = entity == null ? null : entity.getStatus();
    this.alunoEstagio = entity == null ? null : new AlunoAtributosDTO(entity.getAlunoEstagio());
    this.orientadorEstagio = entity == null ? null : new OrientadorAtributosDTO(entity.getOrientadorEstagio());
    this.empresaEstagio = entity == null ? null : new EmpresaAtributosDTO(entity.getEmpresaEstagio());
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getDataInicio() {
    return dataInicio;
  }

  public void setDataInicio(String dataInicio) {
    this.dataInicio = dataInicio;
  }

  public String getDataFim() {
    return dataFim;
  }

  public void setDataFim(String dataFim) {
    this.dataFim = dataFim;
  }

  public String getCargaHoraria() {
    return cargaHoraria;
  }

  public void setCargaHoraria(String cargaHoraria) {
    this.cargaHoraria = cargaHoraria;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

public AlunoDTO getAlunoEstagio() {
    return alunoEstagio;
}

public void setAlunoEstagio(AlunoDTO alunoEstagio) {
    this.alunoEstagio = alunoEstagio;
}

public OrientadorDTO getOrientadorEstagio() {
    return orientadorEstagio;
}

public void setOrientadorEstagio(OrientadorDTO orientadorEstagio) {
    this.orientadorEstagio = orientadorEstagio;
}

public EmpresaDTO getEmpresaEstagio() {
    return empresaEstagio;
}

public void setEmpresaEstagio(EmpresaDTO empresaEstagio) {
    this.empresaEstagio = empresaEstagio;
}

  
}