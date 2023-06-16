package br.ucsal.programacaoweb.dto;

public record LibraryRequestDTO(
  String titulo,
  String autor,
  String editora,
  Integer anoPublicacao,
  String isbn) {
  
}
