package com.gabriel.biblioteca.exception;

public class LivroNaoEncontradoException extends RuntimeException{

	public LivroNaoEncontradoException(Long id) {
		super("Livro de id " + id + "não encontrado");
	}
	
}
