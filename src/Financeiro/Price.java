package Financeiro;

public class Price extends Modalidade {
	CalculadoraDePrestacoes calculadoraDePrestacoes = new CalculadoraDePrestacoes();
	
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		return calculadoraDePrestacoes.calcularPrestacoes(this);
	}
	
}
