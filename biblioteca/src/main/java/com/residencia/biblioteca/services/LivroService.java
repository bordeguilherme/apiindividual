package com.residencia.biblioteca.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.residencia.biblioteca.entities.Livro;
import com.residencia.biblioteca.repositories.LivroRepository;

@Service
public class LivroService {

	@Autowired
	LivroRepository livroRepo;
	
	//recuperar todos os livros
	public List<Livro> listarLivros(){
		return livroRepo.findAll();
	}
	
	//recuperar um livro pela sua chave primária
	public Livro buscarLivroPorId(Integer id){
		return livroRepo.findById(id).orElse(null);
	}
	
	//salvar um novo livro
	public Livro salvarLivro(Livro livro) {
		return livroRepo.save(livro);
	}
	
	//atualizar um determinado livro
	public Livro atualizarLivro(Livro livro) {
		return livroRepo.save(livro);
	}
	
	//deletar um determinado livro
	public Boolean deletarLivro(Livro livro) {
		if(livro == null)
			return false;
		
		Livro livroExistente = buscarLivroPorId(livro.getCodigoLivro());
		
		if(livroExistente == null)
			return false;
		
		livroRepo.delete(livro);
		
		Livro livroContinuaExistindo =
				buscarLivroPorId(livro.getCodigoLivro());
		
		if(livroContinuaExistindo != null)
			return false;
		
		return true;
	}
}