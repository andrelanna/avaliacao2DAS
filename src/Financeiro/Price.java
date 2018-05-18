package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		Prestacoes prestacao = new Prestacoes(this);
		return prestacao.calcularPrestacoes();
	}
	
}
