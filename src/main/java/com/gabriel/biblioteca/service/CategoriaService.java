package com.gabriel.biblioteca.service;

import com.gabriel.biblioteca.exception.CategoriaNaoEncontradaException;
import com.gabriel.biblioteca.model.Categoria;
import com.gabriel.biblioteca.repository.CategoriaRepository;

public class CategoriaService {
	
	private final CategoriaRepository repository;
	
	public CategoriaService(CategoriaRepository repository) {
		this.repository = repository;
	}
	
	public Categoria BuscarPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new CategoriaNaoEncontradaException(id));
	}
	
	public Categoria cadastrar(Categoria categoria) {
		return repository.save(categoria);
	}

}
