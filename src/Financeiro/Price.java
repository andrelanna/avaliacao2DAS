package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		final float temporariaUm = (float) (Math.pow((1+interest), fin.getN()) * interest);
		final float temporariaDois = (float) (temporariaUm/(Math.pow((1+interest), fin.getN()) - 1));
		final float temporariaTres = fin.getPv() * temporariaDois;
		
		final float a1 = temporariaTres - fin.getPv() * interest;
		for (int i=1; i<= fin.getN(); i++) {
			final float amortizacao = (float) (a1 * Math.pow((1+this.interest), i-1));
			final float juros = temporariaTres - amortizacao;
			Parcela p = new Parcela(temporariaTres, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return temporariaTres;
	}
	
}
