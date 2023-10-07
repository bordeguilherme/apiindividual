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
		
	}
	
	//salvar um novo aluno
	
	
	//atualizar um determinado aluno
	
	
	//deletar um determinado aluno
}
