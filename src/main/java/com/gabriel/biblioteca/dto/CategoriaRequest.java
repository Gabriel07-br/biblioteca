package com.gabriel.biblioteca.dto;

import com.gabriel.biblioteca.model.Categoria;

public record CategoriaRequest(String nome) {

	public Categoria toEntity() {
		Categoria categoria = new Categoria();
		categoria.setNome(this.nome);
		return categoria;
	}
}
