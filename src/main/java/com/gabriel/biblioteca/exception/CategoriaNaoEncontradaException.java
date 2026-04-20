package com.gabriel.biblioteca.exception;

public class CategoriaNaoEncontradaException extends RuntimeException{
	
	public CategoriaNaoEncontradaException(Long id) {
		super("Categoria com id " + id + " não encontrada");
	}
}
