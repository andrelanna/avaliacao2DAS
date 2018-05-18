package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		final float pmtNumerador = (float) (Math.pow((1+i), fin.getN()) * i);
		final float pmtDenominador = (float)(Math.pow((1+i), fin.getN()) - 1);
		final float pmtDivisao = (float) (pmtNumerador/pmtDenominador);
		final float pmt = fin.getPv() * pmtDivisao;
		
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
