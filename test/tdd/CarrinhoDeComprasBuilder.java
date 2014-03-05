package tdd;

public class CarrinhoDeComprasBuilder {
	
	private CarrinhoDeCompras carrinho;
	
	public CarrinhoDeComprasBuilder(){
		carrinho = new CarrinhoDeCompras();
	}
	
	
	public CarrinhoDeComprasBuilder comItens(double...items){
		for (double d : items) {
			carrinho.adiciona(new Item("item", 1, d));
		}
		return this;
	}
	
	public CarrinhoDeCompras cria(){
		return carrinho;
	}

}
