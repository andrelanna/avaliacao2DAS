package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		CalcularPrestacoes calcularPrestacoes = new CalcularPrestacoes(this); 
	    return calcularPrestacoes.computar();
	}
	
}
