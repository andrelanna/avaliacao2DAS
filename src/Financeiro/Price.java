package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		float pmt;
		
		final float primaryPmt = (float) (Math.pow((1+i), fin.getN()) * i);
		float secondPmt = (float) (primaryPmt/(Math.pow((1+i), fin.getN()) - 1));
		float thirtPmt = fin.getPv() * secondPmt;
		
		float a1 = thirtPmt - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = thirtPmt - amortizacao;
			Parcela p = new Parcela(thirtPmt, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return thirtPmt;
	}
	
}
