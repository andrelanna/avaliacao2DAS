package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		
		parcelas = new Parcela[fin.getN()];
		
		final float pmt_aux_0 = (float) (Math.pow((1+i), fin.getN()) * i);
		final float pmt_aux_1 = (float) (pmt_aux_0/(Math.pow((1+i), fin.getN()) - 1));
		final float pmt = fin.getPv() * pmt_aux_1;
		
		float a1 = pmt - fin.getPv() * i;
		
		for (int i=1; i<= fin.getN(); i++) {
			final float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			final float juros = pmt - amortizacao;
			Parcela p = new Parcela(pmt, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return pmt;
	}
	
}
