package com.residencia.biblioteca.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.residencia.biblioteca.entities.Editora;
import com.residencia.biblioteca.repositories.EditoraRepository;

@Service
public class EditoraService {
	
	@Autowired
	EditoraRepository editoraRepo;
	
	//recuperar todas as editoras
	public List<Editora> listarEditoras(){
		return editoraRepo.findAll();
	}
	
	//recuperar uma editora pela sua chave primária
	public Editora buscarEditoraPorId(Integer id){
		return editoraRepo.findById(id).orElse(null);
	}
	
	//salvar uma nova editora
	public Editora salvarEditora(Editora editora) {
		return editoraRepo.save(editora);
	}
	
	//atualizar uma determinada editora
	public Editora atualizarEditora(Editora editora) {
		return editoraRepo.save(editora);
	}
	
	//deletar uma determinada editora
	public Boolean deletarEditora(Editora editora) {
		if(editora == null)
			return false;
		
		Editora editoraExistente = buscarEditoraPorId(editora.getCodigoEditora());
		
		if(editoraExistente == null)
			return false;
		
		editoraRepo.delete(editora);
		
		Editora editoraContinuaExistindo =
				buscarEditoraPorId(editora.getCodigoEditora());
		
		if(editoraContinuaExistindo != null)
			return false;
		
		return true;
	}
}