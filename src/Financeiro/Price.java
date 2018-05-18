package Financeiro;

public class Price extends Modalidade {
	
	private CalculadorDePrestacoes calc;
	
	public Price(String banco, float i) {
		super(banco, i);
		calc = new CalculadorDePrestacoes(this);
	}

	public float calcularPrestacoes() {
		return calc.calcularPrestacoes();
	}
	
}
