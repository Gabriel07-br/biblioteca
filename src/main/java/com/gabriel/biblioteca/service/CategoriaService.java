package com.gabriel.biblioteca.service;

import org.springframework.stereotype.Service;

import com.gabriel.biblioteca.exception.CategoriaNaoEncontradaException;
import com.gabriel.biblioteca.model.Categoria;
import com.gabriel.biblioteca.repository.CategoriaRepository;
@Service
public class CategoriaService {
	
	private final CategoriaRepository repository;
	
	public CategoriaService(CategoriaRepository repository) {
		this.repository = repository;
	}
	
	public Categoria buscarPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new CategoriaNaoEncontradaException(id));
	}
	
	public Categoria cadastrar(Categoria categoria) {
		return repository.save(categoria);
	}
	public void deletar(Long id) {
	    repository.deleteById(id);
	}

}
