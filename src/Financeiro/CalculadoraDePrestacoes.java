package Financeiro;

public class CalculadoraDePrestacoes {

	public float calcularPrestacoes(Price price) {
		price.parcelas = new Parcela[price.fin.getN()];
		
		final float pmtFirst = (float) (Math.pow((1+price.i), price.fin.getN()) * price.i);
		final float pmtSecond = (float) (pmtFirst/(Math.pow((1+price.i), price.fin.getN()) - 1));
		final float pmtLast = price.fin.getPv() * pmtSecond;
		
		float a1 = pmtLast - price.fin.getPv() * price.i;
		for (int i=1; i<= price.fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+price.i), i-1));
			float juros = pmtLast - amortizacao;
			Parcela p = new Parcela(pmtLast, juros, amortizacao);
			price.parcelas[i-1] = p;
		}
		
		return pmtLast;
	}

}
