package com.gabriel.biblioteca.dto;

import java.util.List;

import com.gabriel.biblioteca.model.Autor;
import com.gabriel.biblioteca.model.Livro;

public class AutorResponse {
	
	private Long id;
	private String nome;
	private String nacionalidade;
	private int anoNascimento;
	private List<String> titulosLivros;
	
	public static AutorResponse fromEntity(Autor autor) {
		AutorResponse autorResponse = new AutorResponse();
		autorResponse.setId(autor.getId());
		autorResponse.setNome(autor.getNome());
		autorResponse.setNacionalidade(autor.getNacionalidade());
		autorResponse.setAnoNascimento(autor.getAnoNascimento());
		autorResponse.setTitulosLivros(autor.getLivros() != null 
			    ? autor.getLivros().stream().map(Livro::getNome).toList() 
			    	    : List.of());
		return autorResponse;
	}

	public List<String> getTitulosLivros() {
		return titulosLivros;
	}

	public void setTitulosLivros(List<String> titulosLivros) {
		this.titulosLivros = titulosLivros;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNacionalidade() {
		return nacionalidade;
	}

	public void setNacionalidade(String nacionalidade) {
		this.nacionalidade = nacionalidade;
	}

	public int getAnoNascimento() {
		return anoNascimento;
	}

	public void setAnoNascimento(int anoNascimento) {
		this.anoNascimento = anoNascimento;
	}
	
	
}
