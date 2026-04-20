package com.gabriel.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.biblioteca.model.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long>{

}
