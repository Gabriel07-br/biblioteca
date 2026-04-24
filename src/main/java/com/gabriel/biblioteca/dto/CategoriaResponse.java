package com.gabriel.biblioteca.dto;

import java.util.List;

import com.gabriel.biblioteca.model.Categoria;
import com.gabriel.biblioteca.model.Livro;

public class CategoriaResponse {
	
	private List<String> livros;
	private Long id;
	private String nome;
	
	public static CategoriaResponse fromEntity(Categoria categoria) {
		CategoriaResponse categoriaResponse = new CategoriaResponse();
		categoriaResponse.setId(categoria.getId());
		categoriaResponse.setNome(categoria.getNome());
		categoriaResponse.setLivros(categoria.getLivros().stream().map(Livro::getNome).toList());
		return categoriaResponse;
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

	public List<String> getLivros() {
		return livros;
	}

	public void setLivros(List<String> livros) {
		this.livros = livros;
	}
	
	
}
