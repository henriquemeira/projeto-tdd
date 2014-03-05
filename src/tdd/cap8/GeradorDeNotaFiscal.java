package tdd.cap8;

import java.util.Calendar;
import java.util.List;

public class GeradorDeNotaFiscal {

	private final List<AcaoAposGerarNota> acoes;

	private final Relogio relogio;
	private final Tabela tabela;

	public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acoes) {
		this(acoes, new RelogioDoSistema(), null);
	}

	public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acoes, Tabela tabela) {
		this(acoes, new RelogioDoSistema(), tabela);
	}
	
	public GeradorDeNotaFiscal(List<AcaoAposGerarNota> acoes, Relogio relogio, 
			Tabela tabela) {
		this.acoes = acoes;
		this.relogio = relogio;
		this.tabela = tabela;
	}

	public NotaFiscal gera(Pedido pedido) {
		NotaFiscal nf = new NotaFiscal(pedido.getCliente(),
				pedido.getValorTotal() * tabela.paraValor(pedido.getValorTotal()), 
				relogio.hoje());
		for (AcaoAposGerarNota acao : acoes) {
			acao.executa(nf);
		}
		return nf;
	}

}
