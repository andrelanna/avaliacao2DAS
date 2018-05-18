package Financeiro;

public class Price extends Modalidade {

	Calculadora calculadora = new Calculadora();

	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {

		return calculadora.calcularPrestacoes(this);
	}
}
