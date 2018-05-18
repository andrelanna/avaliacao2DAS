public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		initParcelas();

		float pmtFinal = calcPmt();
		
		float amort = calcAmort(pmtFinal);

		calculaParcelas(pmtFinal, amort);

		return pmtFinal;
	}

	private void initParcelas() {
		parcelas = new Parcela[fin.getN()];
	}

	private float getImpFin() {
		return (float) Math.pow((1+i), fin.getN());
	}

	private float calcPmt() {
		float impFin = getImpFin();
		float pmt1 = (float) (impFin * i);
		float pmt2 = (float) (pmt1/(impFin - 1));

		return fin.getPv() * pmt2;
	}

	private float calcAmort(float pmtFinal) {
		return pmtFinal - fin.getPv() * i;
	}

	private void calculaParcelas(float pmtFinal, float amort) {
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (amort * Math.pow((1+this.i), i-1));
			float juros = pmtFinal - amortizacao;
			Parcela p = createParcela(pmtFinal, amortizacao, juros);
			parcelas[i-1] = p;
		}
	}

	private Parcela createParcela(float pmtFinal, float amortizacao, float juros) {
		return new Parcela(pmtFinal, juros, amortizacao);
	}

}
