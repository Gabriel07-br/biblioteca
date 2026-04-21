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

import com.gabriel.biblioteca.exception.AutorNaoEncontradoException;
import com.gabriel.biblioteca.model.Autor;
import com.gabriel.biblioteca.repository.AutorRepository;

@ExtendWith(MockitoExtension.class)
public class AutorServiceTest {
	@Mock
	private AutorRepository repository;
	
	@InjectMocks
	private AutorService service;
	
	@Test
	public void deveCadastrarAutorComSucesso() {
		Autor autor = new Autor();
		autor.setNome("Robert C Martin");
		autor.setNacionalidade("EUA");
		autor.setAnoNascimento(1952);
		
		when(repository.save(autor)).thenReturn(autor);
		
		Autor resultado = service.cadastrar(autor);
		
		assertNotNull(resultado);
		assertEquals("Robert C Martin", resultado.getNome());
		verify(repository, times(1)).save(autor);
	}
	
	@Test
	public void deveLancarExececaoQuandoAutorNaoEncontrado() {
		Long idInexistente = 999L;
		when(repository.findById(idInexistente)).thenReturn(java.util.Optional.empty());
		
		assertThrows(AutorNaoEncontradoException.class, () -> service.buscarPorId(idInexistente));
	}
	
	@Test
	public void testaDeletar() {
		Long id = 1L;
		
		service.deletar(id);
		
		verify(repository, times(1)).deleteById(id);
	}
	
	@Test
	public void testarBuscarPorId() {
		Autor autor = new Autor();
		autor.setNome("Robert C Martin");
		autor.setNacionalidade("EUA");
		autor.setAnoNascimento(1952);
		autor.setId(1L);
		
		when(repository.findById(1L)).thenReturn(Optional.of(autor));
		
		Autor resultado = service.buscarPorId(autor.getId());
		
		assertNotNull(resultado);
		assertEquals("Robert C Martin", resultado.getNome());
		verify(repository, times(1)).findById(1L);
	}
}
