package com.dacproject.dacproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dacproject.dacproject.entities.AvaliacaoDaEmpresa;

@Repository
public interface AvaliacaoDaEmpresaRepository extends JpaRepository<AvaliacaoDaEmpresa, Long> {

}
