package com.gabriel.biblioteca.dto;

import com.gabriel.biblioteca.model.Autor;

public record AutorRequest(String nome, String nacionalidade, int anoNascimento) {

	public Autor toEntity() {
		Autor autor = new Autor();
		autor.setNome(this.nome);
		autor.setAnoNascimento(this.anoNascimento);
		autor.setNacionalidade(this.nacionalidade);
		return autor;
	}
}
