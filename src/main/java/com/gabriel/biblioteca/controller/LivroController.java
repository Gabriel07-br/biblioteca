package com.gabriel.biblioteca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.biblioteca.dto.LivroRequest;
import com.gabriel.biblioteca.dto.LivroResponse;
import com.gabriel.biblioteca.model.Livro;
import com.gabriel.biblioteca.service.LivroService;

import jakarta.validation.Valid;


@RestController
public class LivroController {

	private final LivroService services;
	
	public LivroController(LivroService services) {
		this.services = services;
	}
	
	@GetMapping("/livros/{id}")
	public LivroResponse buscarPorId(@PathVariable Long id) {
		Livro livro = services.buscarLivrosPorId(id);
		
		return LivroResponse.fromEntity(livro);
	}
	
	@PostMapping("/livros")
	public ResponseEntity<LivroResponse> cadastrar(@Valid @RequestBody LivroRequest livro){
		Livro livroCadastrado = services.cadastrar(livro);
		return ResponseEntity.created(null).body(LivroResponse.fromEntity(livroCadastrado));
	}
	
	@DeleteMapping("/livros/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		services.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/livros/{id}")
	public ResponseEntity<LivroResponse> atualizar(@PathVariable Long id, @RequestBody LivroRequest livro){
		Livro livroAtualizado = services.cadastrar(livro);
		return ResponseEntity.ok(LivroResponse.fromEntity(livroAtualizado));
	}
	
}
