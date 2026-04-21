package com.gabriel.biblioteca.exception;

public class AutorNaoEncontradoException extends RuntimeException{

	public AutorNaoEncontradoException(Long id) {
		super("Autor de id " + id + " não encontrado");
	}
}
