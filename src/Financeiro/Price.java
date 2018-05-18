package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		final float auxPmt1 = (float) (Math.pow((1+i), fin.getN()) * i);
		final float auxPmt2 = (float) (auxPmt1/(Math.pow((1+i), fin.getN()) - 1));
		final float final_pmt = fin.getPv() * auxPmt2;
		
		float a1 = final_pmt - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = final_pmt - amortizacao;
			Parcela p = new Parcela(final_pmt, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return final_pmt;
	}
	
}
