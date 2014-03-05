package tdd.cap9;

import java.util.ArrayList;
import java.util.List;

public class Fatura {
	
	private List<Pagamento> pagamentos = new ArrayList<Pagamento>();
	private double valor = 0;
	private boolean pago;
	private String cliente;
	
	public Fatura(String s, double d) {
		valor = d;
		cliente = s;
	}

	public List<Pagamento> getPagamentos() {
		return pagamentos;
	}

	public double getValor() {
		return valor;
	}

	public void setPago(boolean b) {
		pago = b;
	}

	public boolean isPago() {
		return pago;
	}

	public void adicionaPagamento(Pagamento pagamento) {
		this.pagamentos.add(pagamento);
		double valorTotal = 0;
		for (Pagamento p : pagamentos) {
			valorTotal += p.getValor();
		}
		if (valorTotal >= this.valor) {
			this.pago = true;
		}
	}

}
