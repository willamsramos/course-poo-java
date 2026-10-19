package entities;

import entities.enums.WorkerLevel;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Worker {

    private String nome;
    private WorkerLevel nivel;
    private Double salarioBase;

    private Departament departament;
    private List<HourContract> contracts = new ArrayList<>();

    public Worker() {
    }

    public Worker(String nome, WorkerLevel nivel, Double salarioBase, Departament departament) {
        this.nome = nome;
        this.nivel = nivel;
        this.salarioBase = salarioBase;
        this.departament = departament;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public WorkerLevel getNivel() {
        return nivel;
    }

    public void setNivel(WorkerLevel nivel) {
        this.nivel = nivel;
    }

    public Double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(Double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    public List<HourContract> getContracts() {
        return contracts;
    }

    public void addContrato(HourContract contract) {
        contracts.add(contract);
    }

    public void removeContracts(HourContract contract) {
        contracts.remove(contract);
    }

    public double renda(int ano, int mes) {
        double soma = salarioBase;
        for (HourContract c : contracts) {
            Calendar cal = Calendar.getInstance();
            cal.setTime(c.getData());

            int c_ano = cal.get(Calendar.YEAR);
            int c_mes = 1 + cal.get(Calendar.MONTH);

            if (ano == c_ano && mes == c_mes) {
                soma += c.valorTotal();

            }
        }

        return soma;
    }

}
