package com.gabriel.biblioteca.dto;

import com.gabriel.biblioteca.model.Autor;

public class AutorResponse {
	
	private Long id;
	private String nome;
	private String nacionalidade;
	private int anoNascimento;
	
	public static AutorResponse fromEntity(Autor autor) {
		AutorResponse autorResponse = new AutorResponse();
		autorResponse.setId(autor.getId());
		autorResponse.setNome(autor.getNome());
		autorResponse.setNacionalidade(autor.getNacionalidade());
		autorResponse.setAnoNascimento(autor.getAnoNascimento());
		return autorResponse;
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
