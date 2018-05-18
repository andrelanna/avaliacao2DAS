package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}
	
	private float amort;
	private float interest;
	private float prestacao;
	Price price = new Price(banco, i);
	

	public float calcularPrestacoes() {
		CalculadoraDePrestacoes calculadoraDePrestacao = new CalculadoraDePrestacoes(price, amort, interest, prestacao);

		return calculadoraDePrestacao.calcularPrestacoes();
	}
	
}
