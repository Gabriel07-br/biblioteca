package com.gabriel.biblioteca.dto;

import com.gabriel.biblioteca.model.Livro;

public record LivroRequest(String nome, double preco, int anoPublicacao, Long autorId, Long categoriaId) {

	public Livro toEntity() {
		Livro livro = new Livro();
		livro.setNome(this.nome);
		livro.setPreco(this.preco);
		livro.setAnoPublicacao(this.anoPublicacao);
		return livro;
		
	}
}
