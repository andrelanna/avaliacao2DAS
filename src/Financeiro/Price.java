package Financeiro;

public class Price extends Modalidade {
	private final CalcularPrestacoes calculoPrestacoes;
	
	public Price(String banco, float i) {
		super(banco, i);
		calculoPrestacoes = new CalcularPrestacoes(this);
	}

	public float calcularPrestacoes() {
		float total;

		total = this.calculoPrestacoes.calcularPrestacoes();

		return total;
	}
	
	
}
