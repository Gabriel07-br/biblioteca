package com.gabriel.biblioteca.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(LivroNaoEncontradoException.class)
	public ResponseEntity<String> handleLivroNaoEncontrado(LivroNaoEncontradoException ex){
		return ResponseEntity.status(404).body(ex.getMessage());
	}
	
	@ExceptionHandler(CategoriaNaoEncontradaException.class)
	public ResponseEntity<String> handleCategoriaNaoEncontrada(CategoriaNaoEncontradaException ex){
		return ResponseEntity.status(404).body(ex.getMessage());
	}

}
