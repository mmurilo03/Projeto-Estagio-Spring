package com.dacproject.dacproject.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dacproject.dacproject.entities.Orientador;

@Repository
public interface OrientadorRepository extends JpaRepository<Orientador, Long> {
    
    @Query("SELECT DISTINCT ori FROM Orientador ori "
        + "LEFT JOIN ori.alunos alu "
        + "LEFT JOIN ori.estagios est "
        + "LEFT JOIN ori.avaliacoesDosProfessores ave WHERE "
        + "(LOWER(ori.nome) LIKE LOWER(CONCAT('%',:nome,'%'))) AND "
        + "(LOWER(ori.matricula) LIKE LOWER(CONCAT('%',:matricula,'%'))) ")
	Page<Orientador> find(String nome, String matricula, Pageable pageable);
	
	@Query("SELECT ori FROM Orientador ori JOIN FETCH ori.alunos WHERE ori IN :orientadores")
	List<Orientador> findEmpresaWithAlunos(List<Orientador> orientadores);

	 
	@Query("SELECT ori FROM Orientador ori JOIN FETCH ori.estagios WHERE ori IN :orientadores")
	List<Orientador> findEmpresaWithEstagios(List<Orientador> orientadores);

	 
	@Query("SELECT ori FROM Orientador ori JOIN FETCH ori.avaliacoesDosProfessores WHERE ori IN :orientadores")
	List<Orientador> findEmpresaWithAvaliacaoDaEmpresa(List<Orientador> orientadores);
}
