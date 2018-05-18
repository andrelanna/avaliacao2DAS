public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];

		float impFin = (float) Math.pow((1+i), fin.getN());

		float pmt1 = (float) (impFin * i);
		float pmt2 = (float) (pmt1/(impFin - 1));
		float pmtFinal = fin.getPv() * pmt2;
		
		float a1 = pmtFinal - fin.getPv() * i;

		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = pmtFinal - amortizacao;
			Parcela p = new Parcela(pmtFinal, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return pmtFinal;
	}
	
}
