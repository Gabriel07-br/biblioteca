package com.gabriel.biblioteca.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gabriel.biblioteca.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, Long>{

}
