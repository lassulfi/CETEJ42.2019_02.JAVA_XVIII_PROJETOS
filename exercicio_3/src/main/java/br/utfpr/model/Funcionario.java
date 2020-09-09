package br.utfpr.model;

import br.utfpr.enums.CargoEnum;

public class Funcionario {

    private String nome;
    private double salarioBase;
    private CargoEnum cargo;

    public Funcionario(String nome, double salarioBase, CargoEnum cargo) {
        this.nome = nome;
        this.salarioBase = salarioBase;
        this.cargo = cargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public CargoEnum getCargo() {
        return cargo;
    }

    public void setCargo(CargoEnum cargo) {
        this.cargo = cargo;
    }
}
