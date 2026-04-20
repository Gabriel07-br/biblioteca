package com.gabriel.biblioteca.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.gabriel.biblioteca.model.Categoria;
import com.gabriel.biblioteca.service.CategoriaService;

@RestController
public class CategoriaController {

	private final CategoriaService services;
	
	public CategoriaController(CategoriaService services) {
		this.services = services;
	}
	
	@GetMapping("/categorias/{id}")
	public Categoria buscarPorId(@PathVariable Long id) {
		Categoria categoria = services.buscarPorId(id);
		return categoria;
	}
	
	@PostMapping("/categorias")
	public ResponseEntity<Categoria> cadastrar(@RequestBody Categoria categoria){
		Categoria categoriaCadastrada = services.cadastrar(categoria);
		return ResponseEntity.created(null).body(categoriaCadastrada);
	}
	
	@DeleteMapping("/categorias/{id}")
	public ResponseEntity<Void> deletar(@PathVariable Long id){
		services.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("categorias/{id}")
	public ResponseEntity<Categoria> atualizar(@PathVariable Long id, @RequestBody Categoria categoria){
		Categoria categoriaAtualizada = services.cadastrar(categoria);
		return ResponseEntity.ok(categoriaAtualizada);
	}
}

