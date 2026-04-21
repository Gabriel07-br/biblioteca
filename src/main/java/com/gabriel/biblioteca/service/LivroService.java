package com.gabriel.biblioteca.service;

import org.springframework.stereotype.Service;

import com.gabriel.biblioteca.dto.LivroRequest;
import com.gabriel.biblioteca.exception.LivroNaoEncontradoException;
import com.gabriel.biblioteca.model.Livro;
import com.gabriel.biblioteca.repository.AutorRepository;
import com.gabriel.biblioteca.repository.CategoriaRepository;
import com.gabriel.biblioteca.repository.LivroRepository;
@Service
public class LivroService {
	
	private final LivroRepository repository;
	private final AutorRepository aRepository;
	private final CategoriaRepository cRepository;
	
	public LivroService(LivroRepository repository, AutorRepository aRepository, CategoriaRepository cRepository) {
		this.repository = repository;
		this.aRepository = aRepository;
		this.cRepository = cRepository;
	}
	
	public Livro buscarLivrosPorId(Long id) {
		return repository.findById(id).orElseThrow(() -> new LivroNaoEncontradoException(id));
	}
	
	public Livro cadastrar(LivroRequest request) {
		Livro livro = request.toEntity();
		livro.setAutor(aRepository.findById(request.autorId()).orElseThrow());
		livro.setCategoria(cRepository.findById(request.categoriaId()).orElseThrow());
		return repository.save(livro);
	}
	
	public void deletar(Long id) {
	    repository.deleteById(id);
	}
}
