package com.gabriel.biblioteca.model;



import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "Livro")
public class Livro {
	
	@Id
	@GeneratedValue
	private Long id;
	@NotBlank(message = "Nome é Obrigatorio")
	private String nome;
	@ManyToOne(fetch = FetchType.EAGER)
	@NotNull(message = "Autor é Obrigatorio")
	private Autor autor;
	@Min(1)
	private double preco;
	@Min(1401)
	private int anoPublicacao;
	@NotNull(message = "Categoria é obrigatorio")
	@ManyToOne(fetch = FetchType.EAGER)
	private Categoria categoria;
	public Livro() {
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
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

	public Autor getAutor() {
		return autor;
	}

	public void setAutor(Autor autor) {
		this.autor = autor;
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
