package com.gabriel.biblioteca.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.gabriel.biblioteca.exception.LivroNaoEncontradoException;
import com.gabriel.biblioteca.model.Livro;
import com.gabriel.biblioteca.repository.LivroRepository;

@ExtendWith(MockitoExtension.class)
public class LivroServiceTest {
	
	@Mock
	private LivroRepository repository;
	
	@InjectMocks
	private LivroService service;
	
	@Test
	public void deveCadastrarLivroComSucesso() {
		//Arrange - prepara os dados
		Livro livro = new Livro();
		livro.setNome("Clean Code");
		livro.setPreco(89.90);
		livro.setAnoPublicacao(2008);
		
		when(repository.save(livro)).thenReturn(livro);
		
		//Act - executa o método
		Livro resultado = service.cadastrar(livro);
		
		//Assert - verifica o resultado
		assertNotNull(resultado);
		assertEquals("Clean Code", resultado.getNome());
		verify(repository, times(1)).save(livro);
	}
	
	@Test
	public void deveLancarExcecaoQuandoLivroNaoEncontrado() {
		//Arrange
		Long idInexistente = 999L;
		when(repository.findById(idInexistente)).thenReturn(java.util.Optional.empty());
		
		//Act e Assert juntos
		assertThrows(LivroNaoEncontradoException.class, () -> service.buscarLivrosPorId(idInexistente));
	}
	
	@Test
	public void testaDeletar() {
		Long id = 1L;
		
		service.deletar(id);
		
		verify(repository, times(1)).deleteById(id);
	}
	
	@Test
	public void testarBuscarPorId() {
		Livro livro = new Livro();
		livro.setNome("Clean Code");
		livro.setPreco(89.90);
		livro.setAnoPublicacao(2008);
		livro.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(livro));
		
		Livro resultado = service.buscarLivrosPorId(livro.getId());
		
		assertNotNull(resultado);
		assertEquals("Clean Code", resultado.getNome());
		verify(repository, times(1)).findById(1L);
	}
}
