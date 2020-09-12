package br.utfpr.calculadora;

import br.utfpr.exceptions.FuncionarioException;
import br.utfpr.model.Funcionario;

public class Calculadora {

    public double calcularSalario(Funcionario funcionario) throws FuncionarioException {
        validarSalarioBaseNegativo(funcionario.getSalarioBase());
        double desconto = 0.0;
        switch (funcionario.getCargo()) {
            case DESENVOLVEDOR:
                desconto = calcularDescontoDesenvolvedor(funcionario.getSalarioBase());
                break;
            case DBA:
            case TESTADOR:
                desconto = calcularDescontoDBAOuTestador(funcionario.getSalarioBase());
                break;
            case GERENTE:
                desconto = calcularDescontoGerente(funcionario.getSalarioBase());
                break;
            default:
                throw new FuncionarioException("Cargo não cadastrado");
        }

        return funcionario.getSalarioBase() * (1 - desconto);
    }

    private void validarSalarioBaseNegativo(double salarioBase)
            throws FuncionarioException {
        if(salarioBase <= 0) {
            throw new FuncionarioException("Salário-base deve ser positivo e maior que zero");
        }
    }

    private double calcularDescontoDesenvolvedor(double salarioBase) {
        if(salarioBase <= 3000.0) {
            return 0.1;
        } else {
            return 0.2;
        }
    }

    private double calcularDescontoDBAOuTestador(double salarioBase) {
        if(salarioBase <= 2000.0) {
            return 0.15;
        } else {
            return 0.25;
        }
    }

    private double calcularDescontoGerente(double salarioBase) {
        if(salarioBase <= 5000.0) {
            return 0.2;
        } else {
            return 0.3;
        }
    }
}
