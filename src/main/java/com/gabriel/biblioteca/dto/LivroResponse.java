package com.gabriel.biblioteca.dto;

import java.util.List;

import com.gabriel.biblioteca.model.Autor;
import com.gabriel.biblioteca.model.Livro;

public class LivroResponse {
	
	private Long id;
	private String nome;
	private List<String> nomesAutores;
	private String nomeCategoria;
	private double preco;
	private int anoPublicacao;
	
	public static LivroResponse fromEntity(Livro livro) {
		LivroResponse response = new LivroResponse();
		response.setId(livro.getId());
		response.setNome(livro.getNome());
		response.setPreco(livro.getPreco());
		response.setAnoPublicacao(livro.getAnoPublicacao());
		response.setNomesAutores(livro.getAutores().stream().map(Autor::getNome).toList());
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

	public List<String> getNomesAutores() {
		return nomesAutores;
	}

	public void setNomesAutores(List<String> nomesAutores) {
		this.nomesAutores = nomesAutores;
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
