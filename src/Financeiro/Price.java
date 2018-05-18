package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
			
		final float primaryPmt = (float) (Math.pow((1+i), fin.getN()) * i);
		final float secundaryPmt = (float) (primaryPmt/(Math.pow((1+i), fin.getN()) - 1));
		final float tercearyPmt = fin.getPv() * secundaryPmt;
		
		float a1 = tercearyPmt - fin.getPv() * i;
		
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = tercearyPmt - amortizacao;
			Parcela p = new Parcela(tercearyPmt, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return tercearyPmt;
	}
	
}
