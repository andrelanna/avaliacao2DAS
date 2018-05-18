package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];

		float parcelaComTempo = (float) (Math.pow((1+i), fin.getN()) * i);
		float parcelaComJuros = (float) (parcelaComTempo/(Math.pow((1+i), fin.getN()) - 1));
		float valorTotalParcela = fin.getPv() * parcelaComJuros;
		
		float a1 = valorTotalParcela - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = valorTotalParcela - amortizacao;
			Parcela p = new Parcela(valorTotalParcela, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return valorTotalParcela;
	}
}
