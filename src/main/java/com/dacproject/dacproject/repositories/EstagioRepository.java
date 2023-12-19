package com.dacproject.dacproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dacproject.dacproject.entities.Estagio;

@Repository
public interface EstagioRepository extends JpaRepository<Estagio, Long> {

}
