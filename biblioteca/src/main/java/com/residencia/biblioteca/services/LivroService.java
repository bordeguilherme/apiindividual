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
		return livroRepo.findById(id).get();
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
	public void deletarLivro(Livro livro) {
		livroRepo.delete(livro);
	}
}