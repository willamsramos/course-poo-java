package application;

import entities.Departament;
import entities.HourContract;
import entities.Worker;
import entities.enums.WorkerLevel;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class Program01 {

  public static void main(String[] args) throws ParseException {

    Locale.setDefault(Locale.US);
    Scanner sc = new Scanner(System.in);

    System.out.print("Entre com o nome do departamento: ");
    String nomeDepartamento = sc.nextLine();
    System.out.print("Insira os dados do trabalhador: ");
    System.out.print("Nome: ");
    String nomeTrabalhador = sc.nextLine();
    System.out.print("Nível: ");
    String nivelTrabalhador = sc.nextLine();
    System.out.println("Salario Base");
    Double baseSalarial = sc.nextDouble();
    Worker worker = new Worker(nomeTrabalhador, WorkerLevel.valueOf(nivelTrabalhador), baseSalarial, new Departament(nomeDepartamento));

    System.out.print("Quantos contratos esse trabalhador tem? ");
    int n = sc.nextInt();
    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
    List<HourContract> contracts = new ArrayList<>();

    for (int i = 0; i < n; i++) {
      System.out.println("Entre com os dados do contrato #" + (i + 1) + " data:");
      System.out.print("Data (DD/MM/YYYY): ");
      Date contractDate = sdf.parse(sc.next());
      System.out.println("Valor por hora: ");
      double valuePerHour = sc.nextDouble();
      System.out.println("Duração (horas): ");
      int hours = sc.nextInt(); 
      HourContract contract = new HourContract(contractDate, valuePerHour, hours);
      contracts.add(contract);
    }

    System.out.println();
    System.out.print("Entre com o mês e ano para calcular o salário (MM/YYYY): ");
    String monthAndYear = sc.next();
    int month = Integer.parseInt(monthAndYear.substring(0, 2));
    int year = Integer.parseInt(monthAndYear.substring(3));
    System.out.println("Nome: " + worker.getNome());
    System.out.println("Departamento: " + worker.getDepartament().getName());
    System.out.println("Salário para " + monthAndYear + ": " + String.format("%.2f", worker.renda(year, month)));

    sc.close();
  }

}
