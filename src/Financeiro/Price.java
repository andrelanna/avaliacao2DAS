package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		final float pmt = (float) (Math.pow((1+i), fin.getN()) * i);
		final float pmt2 = (float) (pmt/(Math.pow((1+i), fin.getN()) - 1));
		final float pmt3 = fin.getPv() * pmt2;
		
		float a1 = pmt3 - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = pmt3 - amortizacao;
			Parcela p = new Parcela(pmt3, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return pmt3;
	}
	
}
