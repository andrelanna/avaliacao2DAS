package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		float amort = (float) (Math.pow((1+i), fin.getN()) * i);
		float interest = (float) (amort/(Math.pow((1+i), fin.getN()) - 1));
		float prestacao = fin.getPv() * interest;
		
		float a1 = prestacao - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = prestacao - amortizacao;
			Parcela p = new Parcela(prestacao, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return prestacao;
	}
	
}
