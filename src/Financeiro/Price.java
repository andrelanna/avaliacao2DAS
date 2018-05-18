package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		float pmt = (float) (Math.pow((1+i), fin.getN()) * i);
		float pmt1 = (float) (pmt/(Math.pow((1+i), fin.getN()) - 1));
		float pmt2 = fin.getPv() * pmt1;
		
		float a1 = pmt2 - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = pmt2 - amortizacao;
			Parcela p = new Parcela(pmt2, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return pmt2;
	}
	
}
