package com.gabriel.biblioteca.model;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "Categoria")
public class Categoria {
	@Id
	@GeneratedValue
	private Long id;
	@NotBlank(message = "Nome é obrigatorio")
	private String nome;
	@OneToMany(mappedBy = "categoria")
	private List<Livro> livros;
	
	public List<Livro> getLivros() {
		return livros;
	}

	public Categoria() {
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
