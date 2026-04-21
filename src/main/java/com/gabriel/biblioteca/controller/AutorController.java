package com.gabriel.biblioteca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.biblioteca.model.Autor;
import com.gabriel.biblioteca.service.AutorService;

import jakarta.validation.Valid;

@RestController
public class AutorController {
	
	private AutorService service;
	
	public AutorController(AutorService service) {
		this.service = service;
	}
	
	@GetMapping("/autores/{id}")
	public Autor buscarPorId(@PathVariable Long id) {
		Autor autor = service.buscarPorId(id);
		return autor;
	}
	
	@PostMapping("/autores")
	public ResponseEntity<Autor> cadastrar(@Valid @RequestBody Autor autor){
		Autor autorCadastrado = service.cadastrar(autor);
		return ResponseEntity.created(null).body(autorCadastrado);
	}
	
	@PutMapping("/autores/{id}")
	public ResponseEntity<Autor> atualizar(@PathVariable Long id, @Valid @RequestBody Autor autor){
		Autor autorAtualizado = service.cadastrar(autor);
		return ResponseEntity.ok(autorAtualizado);
	}
	
	@DeleteMapping("/autores/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		service.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
}
