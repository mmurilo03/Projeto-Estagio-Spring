package com.dacproject.dacproject.dtos;

import com.dacproject.dacproject.entities.Estagio;

public class EstagioAtributosDTO extends EstagioDTO {

  private static final long serialVersionUID = 1L;

  private Long id;

  private String dataInicio;
  private String dataFim;
  private String cargaHoraria;
  private String status;

  public EstagioAtributosDTO() {
  }

  public EstagioAtributosDTO(Long id, String dataInicio, String dataFim,
      String cargaHoraria, String status) {
    this.id = id;
    this.dataInicio = dataInicio;
    this.dataFim = dataFim;
    this.cargaHoraria = cargaHoraria;
    this.status = status;
  }

  public EstagioAtributosDTO(Estagio entity) {
    this.id = entity == null ? null : entity.getId();
    this.dataInicio = entity == null ? null : entity.getDataInicio();
    this.dataFim = entity == null ? null : entity.getDataFim();
    this.cargaHoraria = entity == null ? null : entity.getCargaHoraria();
    this.status = entity == null ? null : entity.getStatus();
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
  
}