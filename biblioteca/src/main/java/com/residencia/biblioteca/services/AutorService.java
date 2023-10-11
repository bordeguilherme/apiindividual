package com.residencia.biblioteca.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.residencia.biblioteca.entities.Autor;
import com.residencia.biblioteca.repositories.AutorRepository;

@Service
public class AutorService {

	@Autowired
	AutorRepository autorRepo;
	
	//recuperar todos os autores
	public List<Autor> listarAutores(){
		return autorRepo.findAll();
	}
	
	//recuperar um autor pela sua chave primária
	public Autor buscarAutorPorId(Integer id){
		return autorRepo.findById(id).orElse(null);
	}
	
	//salvar um novo autor
	public Autor salvarAutor(Autor autor) {
		return autorRepo.save(autor);
	}
	
	//atualizar um determinado autor
	public Autor atualizarAutor(Autor autor) {
		return autorRepo.save(autor);
	}
	
	//deletar um determinado autor
	public Boolean deletarAutor(Autor autor) {
		if(autor == null)
			return false;
		
		Autor autorExistente = buscarAutorPorId(autor.getCodigoAutor());
		
		if(autorExistente == null)
			return false;
		
		autorRepo.delete(autor);
		
		Autor autorContinuaExistindo =
				buscarAutorPorId(autor.getCodigoAutor());
		
		if(autorContinuaExistindo != null)
			return false;
		
		return true;
	}
}
