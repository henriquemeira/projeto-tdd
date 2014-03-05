package tdd;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculadoraDeSalarioTest {

	@Test
	public void deveCalcularSalarioParaDesenvolvedoresComSalarioAbaixoDoLimite() {

		CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
		Funcionario desenvolvedor = new Funcionario("Mauricio", 1500,
				Cargo.DESENVOLVEDOR);

		double salario = calculadora.calculaSalario(desenvolvedor);

		assertEquals(1500 * .9, salario, 0.00001);

	}

	@Test
	public void deveCalcularSalarioParaDesenvolvedoresComSalarioAcimaDoLimite() {

		CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
		Funcionario desenvolvedor = new Funcionario("Mauricio", 4000,
				Cargo.DESENVOLVEDOR);

		double salario = calculadora.calculaSalario(desenvolvedor);

		assertEquals(4000 * .8, salario, 0.00001);

	}

	@Test
	public void deveCalcularSalarioParaDBAsComSalarioAbaixoDoLimite() {
		CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
		Funcionario dba = new Funcionario("Mauricio", 500.0, Cargo.DBA);
		double salario = calculadora.calculaSalario(dba);
		assertEquals(500.0 * 0.85, salario, 0.00001);
	}
	
	@Test
	public void deveCalcularSalarioParaDBAsComSalarioAcimaDoLimite() {
		CalculadoraDeSalario calculadora = new CalculadoraDeSalario();
		Funcionario dba = new Funcionario("Mauricio", 2501.0, Cargo.DBA);
		double salario = calculadora.calculaSalario(dba);
		assertEquals(2501.0 * 0.75, salario, 0.00001);
	}
	

}
