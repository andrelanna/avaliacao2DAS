package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		float pmtBase = calcularBasePmt();
		float pmtJuros = calcularJuros(pmtBase);
		float pmtPV = calcularFinanciamentoPV(pmtJuros);
		
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = calcularAmortizacao(pmtPV);
			float juros = pmtPV - amortizacao;
			Parcela p = new Parcela(pmtPV, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return pmtPV;
	}

	public float calcularBasePmt() {
		float pmtBase = (float) (Math.pow((1+i), fin.getN()) * i);
		
		return pmtBase;
	}

	public float calcularJuros(float pmtBase) {
		float pmtJuros = (float) (pmtBase/(Math.pow((1+i), fin.getN()) - 1));
		
		return pmtJuros;
	}
	
	public float calcularFinanciamentoPV(float pmtJuros) {
		float pmtPV = fin.getPv() * pmtJuros;
		
		return pmtPV;
	}
	
	public float calcularAmortizacao(float pmtPV){
		float pmtAmort = pmtPV - fin.getPv() * i;
		float amortizacao = (float) (pmtAmort * Math.pow((1+this.i), i-1));
		
		return amortizacao;
	}
	
}
