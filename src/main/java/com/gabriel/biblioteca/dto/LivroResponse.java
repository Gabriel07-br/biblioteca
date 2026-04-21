package com.gabriel.biblioteca.dto;

import com.gabriel.biblioteca.model.Livro;

public class LivroResponse {
	
	private Long id;
	private String nome;
	private String nomeAutor;
	private String nomeCategoria;
	private double preco;
	private int anoPublicacao;
	
	public static LivroResponse fromEntity(Livro livro) {
		LivroResponse response = new LivroResponse();
		response.setId(livro.getId());
		response.setNome(livro.getNome());
		response.setPreco(livro.getPreco());
		response.setAnoPublicacao(livro.getAnoPublicacao());
		response.setNomeAutor(livro.getAutor().getNome());
		response.setNomeCategoria(livro.getCategoria().getNome());
		return response;
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
	public String getNomeAutor() {
		return nomeAutor;
	}
	public void setNomeAutor(String nomeAutor) {
		this.nomeAutor = nomeAutor;
	}
	public String getNomeCategoria() {
		return nomeCategoria;
	}
	public void setNomeCategoria(String nomeCategoria) {
		this.nomeCategoria = nomeCategoria;
	}
	public double getPreco() {
		return preco;
	}
	public void setPreco(double preco) {
		this.preco = preco;
	}
	public int getAnoPublicacao() {
		return anoPublicacao;
	}
	public void setAnoPublicacao(int anoPublicacao) {
		this.anoPublicacao = anoPublicacao;
	}
	
	
}
