package tdd;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

public class MaiorPrecoTest {

	private CarrinhoDeComprasBuilder builder;

	@Before
	public void inicializa() {
		builder = new CarrinhoDeComprasBuilder();
	}

	@Test
	public void deveRetornarZeroSeCarrinhoVazio() {

		assertEquals(0, builder.cria().maiorValor(), 0.0001);

	}

	@Test
	public void deveRetornarValorDoItemSeCarrinhoCom1Elemento() {

		CarrinhoDeCompras carrinho = builder.comItens(900).cria();
		assertEquals(900, carrinho.maiorValor(), 0.0001);

	}

	@Test
	public void deveRetornarValorDoItemSeCarrinhoComMuitosElementos() {

		CarrinhoDeCompras carrinho = builder.comItens(900, 1500, 750).cria();

		assertEquals(1500, carrinho.maiorValor(), 0.0001);

	}

}
