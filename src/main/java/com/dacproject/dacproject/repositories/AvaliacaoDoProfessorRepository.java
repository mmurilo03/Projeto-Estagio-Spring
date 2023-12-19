package com.dacproject.dacproject.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dacproject.dacproject.entities.AvaliacaoDoProfessor;

@Repository
public interface AvaliacaoDoProfessorRepository extends JpaRepository<AvaliacaoDoProfessor, Long> {

}
