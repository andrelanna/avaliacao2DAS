package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		CalculoDePrestacao calculoDePrestacao = new CalculoDePrestacao(this);

		return calculoDePrestacao.calcular();
	}
	
}
