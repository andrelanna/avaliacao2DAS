package Financeiro;

public class Price extends Modalidade {
	
	private final CalcularPrestacoes calculo;
	
	public Price(String banco, float i) {
		super(banco, i);
		calculo = new CalcularPrestacoes(this);
	}

	public float calcularPrestacoes() {
		float valor = this.calculo.calcula();
		return valor;
	}
	
}
