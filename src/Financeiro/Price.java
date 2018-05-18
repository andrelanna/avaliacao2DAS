package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];

		final float mult;
		final float sub;
		final float pmt; 

		float a1;
		float amortizacao;
		float juros;
		
		mult = (float) (Math.pow((1+i), fin.getN()) * i);
		sub = (float) (mult/(Math.pow((1+i), fin.getN()) - 1));
		pmt = fin.getPv() * sub; 

		a1 = pmt - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			juros = pmt - amortizacao;
			Parcela p = new Parcela(pmt, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return pmt;
	}
	
}
