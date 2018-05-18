package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];

		// float pmt = (float) (Math.pow((1+i), fin.getN()) * i);
		// pmt = (float) (pmt/(Math.pow((1+i), fin.getN()) - 1));
		// pmt = fin.getPv() * pmt;

		float p_price1 = (float) (Math.pow((1+i), fin.getN()) * i);
		float p_price2 = (float) (p_price1/(Math.pow((1+i), fin.getN()) - 1));
		float pmt = fin.getPv() * p_price2;

		float a1 = pmt - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = pmt - amortizacao;
			Parcela p = new Parcela(pmt, juros, amortizacao);
			parcelas[i-1] = p;
		}

		return pmt;
	}

}
