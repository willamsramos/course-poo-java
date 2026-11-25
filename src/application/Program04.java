package application;

import entities.Autor;
import entities.Livro;

import java.util.Locale;
import java.util.Scanner;

public class Program04 {

  static void main(String[] args) {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.print("Digite o titulo do livro: ");
    String titulo = sc.nextLine();

    System.out.print("Digite o preço do livro: ");
    Double preco = sc.nextDouble();

    Livro livro = new Livro(titulo, preco);

    System.out.print("Quanto autores deseja cadastrar? ");
    int quantidade = sc.nextInt();
    sc.nextLine();

    for(int i = 1; i <= quantidade; i++) {
      System.out.println("Cadastro do autor #" + i);

      System.out.print("Nome: ");
      String nome = sc.nextLine();

      System.out.print("Email: ");
      String emeil = sc.nextLine();

      Autor autor = new Autor(emeil, nome);

      livro.adicionarAutor(autor);

      System.out.println("\nRESUMO DO LIVRO");
      System.out.println("Titulo: " + livro.getTitulo());

      System.out.printf("Preço, %.2f%n", livro.getPreco());

      System.out.println("\nAutores:");
      livro.exibirAutores();
    }

    sc.close();

  }
}
