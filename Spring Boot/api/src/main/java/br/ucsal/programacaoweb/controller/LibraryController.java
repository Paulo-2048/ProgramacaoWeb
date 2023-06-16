
package br.ucsal.programacaoweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.ucsal.programacaoweb.repository.LibraryRepository;
import br.ucsal.programacaoweb.entity.LibraryEntity;
import br.ucsal.programacaoweb.dto.LibraryRequestDTO;
import br.ucsal.programacaoweb.dto.ApiResponse;
import br.ucsal.programacaoweb.dto.ResponseFail;
import br.ucsal.programacaoweb.dto.ResponseSuccess;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("livro")
public class LibraryController {
  
  @Autowired
  private LibraryRepository repository;
  

  @GetMapping
  public ResponseEntity<ApiResponse> findAll() {
    try{
      List<LibraryEntity> books = repository.findAll();

      if (books.isEmpty()) {
        throw new Exception("Nenhum livro encontrado");
      }

      ResponseSuccess response = new ResponseSuccess("Livros listados com sucesso", books);

      return ResponseEntity.ok().body(response);
    } catch(Exception e){
      System.out.println(e.getMessage());

      ResponseFail errorResponse = new ResponseFail("Erro ao listar livros");
      return ResponseEntity.badRequest().body(errorResponse);
    }
    
  }

  @GetMapping("/{id}")
  public ResponseEntity<ApiResponse> findById(@PathVariable Integer id) {
    try{
      LibraryEntity book = repository.findById(id).orElse(null);

      if (book == null) {
        throw new Exception("Livro não encontrado");
      }

      ResponseSuccess response = new ResponseSuccess("Livro listado com sucesso", book);

      return ResponseEntity.ok().body(response);
    } catch(Exception e){
      System.out.println(e.getMessage());

      ResponseFail errorResponse = new ResponseFail("Erro ao listar Livro");
      return ResponseEntity.badRequest().body(errorResponse);
    }
  }

  @GetMapping("/isbn/{isbn}")
  public ResponseEntity<ApiResponse> findByMatricula(@PathVariable String isbn) {
    try{
      LibraryEntity book = repository.findByIsbn(isbn);

      if (book == null) {
        throw new Exception("Livro não encontrado");
      }

      ResponseSuccess response = new ResponseSuccess("Livro listado com sucesso", book);

      return ResponseEntity.ok().body(response);

    } catch(Exception e){
      System.out.println(e.getMessage());

      ResponseFail errorResponse = new ResponseFail("Erro ao listar livro");
      return ResponseEntity.badRequest().body(errorResponse);
    }
  }

  @PostMapping
  public ResponseEntity<ApiResponse> create(@RequestBody LibraryRequestDTO data) {
    try{
      System.out.println(data);
      System.out.println("Titulo" + data.titulo());
      System.out.println("Autor" + data.autor());
      System.out.println("Editora" + data.editora());
      System.out.println("Ano" + data.anoPublicacao());
      System.out.println("ISBN" + data.isbn());


      LibraryEntity book = new LibraryEntity(data);
      LibraryEntity bookResponse = repository.save(book);

      ResponseSuccess response = new ResponseSuccess("Livro criado com sucesso", bookResponse);

      return ResponseEntity.ok().body(response);
    } catch(Exception e){
      System.out.println(e.getMessage());

      ResponseFail errorResponse = new ResponseFail("Erro ao criar livro");
      return ResponseEntity.badRequest().body(errorResponse);
    }
    
  }

  @PutMapping("/{id}")
  public ResponseEntity<ApiResponse> update(@PathVariable Integer id, LibraryRequestDTO data) {
    try {
      LibraryEntity book = repository.findById(id).orElse(null);

      if (book == null) {
        throw new Exception("Livro não encontrado");
      }

      book.setTitle(data.titulo());
      book.setAuthor(data.autor());
      book.setPublisher(data.editora());
      book.setYear(data.anoPublicacao());
      book.setIsbn(data.isbn());

      LibraryEntity bookResponse = repository.save(book);

      ResponseSuccess response = new ResponseSuccess("Livro atualizado com sucesso", bookResponse);

      return ResponseEntity.ok().body(response);
    } catch (Exception e) {
      System.out.println(e.getMessage());

      ResponseFail errorResponse = new ResponseFail("Erro ao atualizar livro");
      return ResponseEntity.badRequest().body(errorResponse);
    } 
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<ApiResponse> delete(@PathVariable Integer id) {
    try{
      repository.deleteById(id);

      ResponseSuccess response = new ResponseSuccess("Livro removido com sucesso");
      return ResponseEntity.ok().body(response.OnlyMessage());
    } catch(Exception e){
      System.out.println(e.getMessage());

      ResponseFail errorResponse = new ResponseFail("Erro ao remover livro");
      return ResponseEntity.badRequest().body(errorResponse);
    }
  }
}
