package tdd.cap8;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class GeradorDeNotaFiscalTest {

	private List<AcaoAposGerarNota> acoes;
	private Tabela tabela;
	
	@Before
	public void inicializa() {
		AcaoAposGerarNota acao1 = Mockito.mock(AcaoAposGerarNota.class);
		AcaoAposGerarNota acao2 = Mockito.mock(AcaoAposGerarNota.class);
		acoes = Arrays.asList(acao1, acao2);
		
		// mockando uma tabela, que ainda nem existe
		tabela = Mockito.mock(Tabela.class);
		// definindo o futuro comportamento "paraValor",
		// que deve retornar 0.2 caso o valor seja 1000.0
		Mockito.when(tabela.paraValor(1000.0)).thenReturn(0.2);

	}

	@Test
	public void deveInvocarAcoesPosteriores() {

		GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(acoes, tabela);
		Pedido pedido = new Pedido("Mauricio", 1000, 1);
		NotaFiscal nf = gerador.gera(pedido);
		
		for (int i = 0; i < acoes.size(); i++) {
			Mockito.verify(acoes.get(i)).executa(nf);
		}

	}

	@Test
	public void deveGerarNFComValorDeImpostoDescontado() {
		
		Mockito.when(tabela.paraValor(1000.0)).thenReturn(0.94);
		
		GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(acoes, tabela);
		Pedido pedido = new Pedido("Mauricio", 1000, 1);
		NotaFiscal nf = gerador.gera(pedido);
		assertEquals(1000 * 0.94, nf.getValor(), 0.0001);
	}

	@Test
	public void deveConsultarATabelaParaCalcularValor() {
		GeradorDeNotaFiscal gerador = new GeradorDeNotaFiscal(acoes, tabela);
		Pedido pedido = new Pedido("Mauricio", 1000, 1);
		NotaFiscal nf = gerador.gera(pedido);
		
		// garantindo que a tabela foi consultada
		Mockito.verify(tabela).paraValor(1000.0);
		assertEquals(1000 * 0.2, nf.getValor(), 0.00001);

	}

}
