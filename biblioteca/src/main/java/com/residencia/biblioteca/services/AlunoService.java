package com.residencia.biblioteca.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.residencia.biblioteca.dto.AlunoResumidoDTO;
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
	
	//recuperar todos os alunos RESUMIDOS
	public List<AlunoResumidoDTO> listarAlunosResumidos() {
		
	    List<Aluno> alunos = alunoRepo.findAll();
	    List<AlunoResumidoDTO> alunosDTO = new ArrayList<>();

	    for (Aluno aluno : alunos) {
	        AlunoResumidoDTO alunoResDTO = new AlunoResumidoDTO();
	        alunoResDTO.setNumeroMatriculaAluno(aluno.getNumeroMatriculaAluno());
	        alunoResDTO.setNome(aluno.getNome());
	        alunoResDTO.setCpf(aluno.getCpf());
	        alunosDTO.add(alunoResDTO);
	    }

	    return alunosDTO;
	}
	
	//recuperar um aluno pela sua chave primária
	public Aluno buscarAlunoPorId(Integer id){
		return alunoRepo.findById(id).orElse(null);
	}
	
	//recuperar um aluno RESUMIDO pela sua chave primária
	public AlunoResumidoDTO getAlunoResumidoPorId(Integer id){
		
		Aluno aluno =  alunoRepo.findById(id).orElse(null);
		
		if(aluno != null) {
		AlunoResumidoDTO alunoResDTO = new AlunoResumidoDTO(
				 aluno.getNumeroMatriculaAluno(),
				 aluno.getNome(),
				 aluno.getCpf()
				 );
		return alunoResDTO;
		}	
		return null;
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
