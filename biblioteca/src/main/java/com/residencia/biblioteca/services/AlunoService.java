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
		return alunoRepo.findById(id).get();
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
	public void deletarAluno(Aluno aluno) {
		alunoRepo.delete(aluno);
	}
}
