package br.ucsal.programacaoweb.entity;


import br.ucsal.programacaoweb.dto.LibraryRequestDTO;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;
// -- Tabela liv_livros
// CREATE TABLE liv_livros (
//     liv_id INTEGER PRIMARY KEY GENERATED ALWAYS AS IDENTITY,
//     liv_titulo VARCHAR(150) NOT NULL,
//     liv_autor VARCHAR(100) NOT NULL,
//     liv_editora VARCHAR(100) NOT NULL,
//     liv_ano_publicao INTEGER NOT NULL,
//     liv_isbn VARCHAR(13) NOT NULL
// )

@Table(name = "liv_livros")
@Entity(name = "Livros")
@Getter
@Setter
public class LibraryEntity {
  

  @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "liv_id")
  private Integer id;

  @Column(name = "liv_titulo", nullable = false)
  private String title;

  @Column(name = "liv_autor", nullable = false)
  private String author;

  @Column(name = "liv_editora", nullable = false)
  private String publisher;

  @Column(name = "liv_ano_publicao", nullable = false)
  private Integer year;

  @Column(name = "liv_isbn", nullable = false)
  private String isbn;

  public LibraryEntity(LibraryRequestDTO data) {
    this.title = data.titulo();
    this.author = data.autor();
    this.publisher = data.editora();
    this.year = data.anoPublicacao();
    this.isbn = data.isbn();
  }

  public LibraryEntity() {
  }
}
