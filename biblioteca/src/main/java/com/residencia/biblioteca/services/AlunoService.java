package com.residencia.biblioteca.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.residencia.biblioteca.entities.Aluno;
import com.residencia.biblioteca.repositories.AlunoRepository;

@Service
public class AlunoService {

	@Autowired
	AlunoRepository alunoRepo;
	
	//recuperar todos os alunos
	public List<Aluno> listarAlunos(){
		return alunoRepo.findAll();
	}
	
	//recuperar um aluno pela sua chave primária
	public Aluno buscarAlunoPorId(Integer id){
		return alunoRepo.findById(id).orElse(null);
	}
	
	//salvar um novo aluno
	public Aluno salvarAluno(Aluno aluno) {
		return alunoRepo.save(aluno);
	}
	
	//atualizar um determinado aluno
	public Aluno atualizarAluno(Aluno aluno) {
		return alunoRepo.save(aluno);
	}
	
	//deletar um determinado aluno
	public Boolean deletarAluno(Aluno aluno) {
		if(aluno == null)
			return false;
		
		Aluno alunoExistente = buscarAlunoPorId(aluno.getNumeroMatriculaAluno());
		
		if(alunoExistente == null)
			return false;
		
		alunoRepo.delete(aluno);
		
		Aluno alunoContinuaExistindo =
				buscarAlunoPorId(aluno.getNumeroMatriculaAluno());
		
		if(alunoContinuaExistindo != null)
			return false;
		
		return true;
	}
}
