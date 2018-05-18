package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		final float pmtFirst = (float) (Math.pow((1+i), fin.getN()) * i);
		final float pmtSecond = (float) (pmtFirst/(Math.pow((1+i), fin.getN()) - 1));
		final float pmtLast = fin.getPv() * pmtSecond;
		
		float a1 = pmtLast - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = pmtLast - amortizacao;
			Parcela p = new Parcela(pmtLast, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return pmtLast;
	}
	
}
