package br.utfpr.calculadora;

import br.utfpr.enums.CargoEnum;
import br.utfpr.exceptions.FuncionarioException;
import br.utfpr.model.Funcionario;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class CalculadoraTest {

    private Calculadora calculadora;

    @Before
    public void setup() {
        calculadora = new Calculadora();
    }

    @Test
    public void deveCalcularSalarioParaDesenvolvedor() throws FuncionarioException {
        double salario1 = calculadora.calcularSalario(new Funcionario("Fulando de Tal",
                "fulano@email.com", 3000.00, CargoEnum.DESENVOLVEDOR));
        double salario2 = calculadora.calcularSalario(new Funcionario("Ciclano Beltrano",
                "ciclano@email.com", 5000.00, CargoEnum.DESENVOLVEDOR));

        assertThat(2700.00, equalTo(salario1));
        assertThat(4000.00, equalTo(salario2));
    }

    @Test
    public void deveCalcularSalarioParaDBA() throws FuncionarioException {
        double salario1 = calculadora.calcularSalario(new Funcionario("Fulando de Tal",
                "fulano@email.com",2000.00, CargoEnum.DBA));
        double salario2 = calculadora.calcularSalario(new Funcionario("Ciclano Beltrano",
                "ciclano@email.com",5000.00, CargoEnum.DBA));

        assertThat(1700.00, equalTo(salario1));
        assertThat(3750.00, equalTo(salario2));
    }

    @Test
    public void deveCalcularSalarioParaTestador() throws FuncionarioException {
        double salario1 = calculadora.calcularSalario(new Funcionario("Fulando de Tal",
                "fulano@email.com",2000.00, CargoEnum.TESTADOR));
        double salario2 = calculadora.calcularSalario(new Funcionario("Ciclano Beltrano",
                "ciclano@email.com",5000.00, CargoEnum.TESTADOR));

        assertThat(1700.00, equalTo(salario1));
        assertThat(3750.00, equalTo(salario2));
    }

    @Test
    public void deveCalcularSalarioGerente() throws FuncionarioException {
        double salario1 = calculadora.calcularSalario(new Funcionario("Fulando de Tal",
                "fulano@email.com", 5000.00, CargoEnum.GERENTE));
        double salario2 = calculadora.calcularSalario(new Funcionario("Ciclano Beltrano",
                "ciclano@email.com", 8000.00, CargoEnum.GERENTE));

        assertThat(4000.00, equalTo(salario1));
        assertThat(5600.00, equalTo(salario2));
    }

    @Test(expected = FuncionarioException.class)
    public void deveLancarExcecaoParaCargosNaoCadastrados() throws FuncionarioException {
        calculadora.calcularSalario(new Funcionario("Fulando de Tal",
                "fulano@email.com", 5000.00, CargoEnum.AUXILIAR));
        Assert.fail();
    }

    @Test(expected = FuncionarioException.class)
    public void deveLancarExcecaoParaSalarioBaseNegativo() throws FuncionarioException {
        calculadora.calcularSalario(new Funcionario("Fulando de Tal",
                "fulano@email.com", -1000.00, CargoEnum.GERENTE));
        Assert.fail();
    }

    @Test(expected = FuncionarioException.class)
    public void deveLancarExcecaoParaSalarioNulo() throws FuncionarioException {
        calculadora.calcularSalario(new Funcionario("Fulano de Tal",
                "fulano@email.com", 0.00, CargoEnum.GERENTE));
        Assert.fail();
    }
 }
