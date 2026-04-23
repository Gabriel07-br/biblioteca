package com.gabriel.biblioteca.dto;

import com.gabriel.biblioteca.model.Categoria;

public class CategoriaResponse {

	private Long id;
	private String nome;
	
	public static CategoriaResponse fromEntity(Categoria categoria) {
		CategoriaResponse categoriaResponse = new CategoriaResponse();
		categoriaResponse.setId(categoria.getId());
		categoriaResponse.setNome(categoria.getNome());
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
	
	
}
