package com.gabriel.biblioteca.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.validation.FieldError;

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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>>handleValidacaoDeDados(MethodArgumentNotValidException ex){
		Map<String, String> erros = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error) -> {
			String nomeDoCampo = ((FieldError) error).getField();
			String mensagemDeErro = error.getDefaultMessage();
			erros.put(nomeDoCampo, mensagemDeErro);
		});
		return ResponseEntity.status(400).body(erros);
	}

}
