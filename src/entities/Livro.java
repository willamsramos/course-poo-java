package entities;

import java.util.ArrayList;
import java.util.List;

public class Livro {

  private String titulo;
  private Double preco;
  private List<Autor> autores = new ArrayList<>();

  public Livro() {
  }

  public Livro(String titulo, Double preco) {
    this.titulo = titulo;
    this.preco = preco;
  }
  
  public String getTitulo() {
    return titulo;
  }

  public void setTitulo(String titulo) {
    this.titulo = titulo;
  }

  public Double getPreco() {
    return preco;
  }

  public void setPreco(Double preco) {
    this.preco = preco;
  }

  public void adicionarAutor(Autor autor) {
    autores.add(autor);
  }

  public void removerAutor(Autor autor) {
    autores.remove(autor);
  }

  public void exibirAutores() {
    for (Autor autor : autores) {
      System.out.println(autor.getNome() + " - " + autor.getEmail());
    }
  }

}
