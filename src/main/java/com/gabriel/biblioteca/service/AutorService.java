package com.gabriel.biblioteca.service;

import org.springframework.stereotype.Service;

import com.gabriel.biblioteca.exception.AutorNaoEncontradoException;
import com.gabriel.biblioteca.model.Autor;
import com.gabriel.biblioteca.repository.AutorRepository;

@Service
public class AutorService {
	
	private final AutorRepository repository;
	
	public AutorService(AutorRepository repository) {
		this.repository = repository;
	}
	
	public Autor buscarPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new AutorNaoEncontradoException(id));
	}
	
	public Autor cadastrar(Autor autor) {
		return repository.save(autor);
	}
	
	public void deletar(Long id) {
		repository.deleteById(id);
	}
}
