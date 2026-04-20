package com.gabriel.biblioteca.service;

import org.springframework.stereotype.Service;

import com.gabriel.biblioteca.exception.LivroNaoEncontradoException;
import com.gabriel.biblioteca.model.Livro;
import com.gabriel.biblioteca.repository.LivroRepository;
@Service
public class LivroService {
	
	private final LivroRepository repository;
	
	public LivroService(LivroRepository repository) {
		this.repository = repository;
	}
	
	public Livro buscarLivrosPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new LivroNaoEncontradoException(id));
	}
	
	public Livro cadastrar(Livro livro) {
		return repository.save(livro);
	}
	
	public void deletar(Long id) {
	    repository.deleteById(id);
	}
}
