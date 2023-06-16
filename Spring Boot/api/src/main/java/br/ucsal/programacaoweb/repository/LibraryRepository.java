package br.ucsal.programacaoweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ucsal.programacaoweb.entity.LibraryEntity;

public interface LibraryRepository extends JpaRepository<LibraryEntity, Integer> {
  
  public LibraryEntity findByIsbn(String isbn);
}
