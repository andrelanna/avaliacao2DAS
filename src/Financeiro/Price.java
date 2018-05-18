package Financeiro;

public class Price extends Modalidade {

	
	public Price(String banco, float i) {
		super(banco, i);
	}
	
	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		return new PaymentCalculator(this).calcular();
	}
	
}

