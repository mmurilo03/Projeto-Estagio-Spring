package com.dacproject.dacproject.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.dacproject.dacproject.entities.Empresa;

@Repository
public interface EmpresaRepository extends JpaRepository<Empresa, Long> {

    @Query("SELECT DISTINCT emp FROM Empresa emp "
        + "LEFT JOIN emp.alunos alu "
        + "LEFT JOIN emp.estagios est "
        + "LEFT JOIN emp.avaliacoesDasEmpresas ave WHERE "
        + "(LOWER(emp.nome) LIKE LOWER(CONCAT('%',:nome,'%'))) AND "
        + "(LOWER(emp.cnpj) LIKE LOWER(CONCAT('%',:cnpj,'%'))) ")
	Page<Empresa> find(String nome, String cnpj, Pageable pageable);
	
	@Query("SELECT emp FROM Empresa emp JOIN FETCH emp.alunos WHERE emp IN :empresas")
	List<Empresa> findEmpresaWithAlunos(List<Empresa> empresas);

	 
	@Query("SELECT emp FROM Empresa emp JOIN FETCH emp.estagios WHERE emp IN :empresas")
	List<Empresa> findEmpresaWithEstagios(List<Empresa> empresas);

	 
	@Query("SELECT emp FROM Empresa emp JOIN FETCH emp.avaliacoesDasEmpresas WHERE emp IN :empresas")
	List<Empresa> findEmpresaWithAvaliacaoDaEmpresa(List<Empresa> empresas);

}
