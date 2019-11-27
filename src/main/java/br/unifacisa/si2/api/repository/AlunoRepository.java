package br.unifacisa.si2.api.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.unifacisa.si2.api.entity.Aluno;

public interface AlunoRepository extends JpaRepository<Aluno, String> {

	Aluno remove(Aluno aluno);

	Aluno findByCpf(long cpf);

	Aluno findByNome(String nome);

	List<Aluno> findAllByCurso(String curso);

	List<Aluno> findAllByFaculdade(String faculdade);

	
}
