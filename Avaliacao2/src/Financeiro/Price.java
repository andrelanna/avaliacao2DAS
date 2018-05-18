package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		float pmt = (float) (Math.pow((1+i), fin.getN()) * i);
		
		float pmtJuros = (float) (pmt/(Math.pow((1+i), fin.getN()) - 1));
		
		float pmtPV = fin.getPv() * pmtJuros;
		
		float pmtAmort = pmtPV - fin.getPv() * i;
		
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (pmtAmort * Math.pow((1+this.i), i-1));
			float juros = pmtPV - amortizacao;
			Parcela p = new Parcela(pmtPV, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return pmtPV;
	}
	
}
