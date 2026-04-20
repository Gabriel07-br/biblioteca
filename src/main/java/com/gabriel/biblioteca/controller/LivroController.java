package com.gabriel.biblioteca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.biblioteca.model.Livro;
import com.gabriel.biblioteca.service.LivroService;

@RestController
public class LivroController {

	private final LivroService services;
	
	public LivroController(LivroService services) {
		this.services = services;
	}
	
	@GetMapping("/livros/{id}")
	public Livro buscarPorId(@PathVariable Long id) {
		Livro livro = services.buscarLivrosPorId(id);
		return livro;
	}
	
	@PostMapping("/livros")
	public ResponseEntity<Livro> cadastrar(@RequestBody Livro livro){
		Livro livroCadastrado = services.cadastrar(livro);
		return ResponseEntity.created(null).body(livroCadastrado);
	}
	
	@DeleteMapping("/livros/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		services.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/livros/{id}")
	public ResponseEntity<Livro> atualizar(@PathVariable Long id, @RequestBody Livro livro){
		Livro livroAtualizado = services.cadastrar(livro);
		return ResponseEntity.ok(livroAtualizado);
		
	}
	
}
