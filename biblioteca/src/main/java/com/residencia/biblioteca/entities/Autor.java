package com.residencia.biblioteca.entities;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

//import com.fasterxml.jackson.annotation.JsonIdentityInfo;
//import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

//@JsonIdentityInfo (
//		generator = ObjectIdGenerators.PropertyGenerator.class,
//		property = "codigoAutor"
//	)
@Entity
@Table(name = "autor")
public class Autor {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "codigoautor")
	private Integer codigoAutor;

	@Column(name = "nomeautor")
	private String nomeAutor;
	
	@JsonManagedReference(value = "autor-livro-ref")
	@OneToMany(mappedBy = "autor")
	private List<Livro> livros;

	public Integer getCodigoAutor() {
		return codigoAutor;
	}

	public void setCodigoAutor(Integer codigoAutor) {
		this.codigoAutor = codigoAutor;
	}

	public String getNomeAutor() {
		return nomeAutor;
	}

	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}

	public List<Livro> getLivros() {
		return livros;
	}

	public void setLivros(List<Livro> livros) {
		this.livros = livros;
	}
}
