package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		int n =  fin.getN();
		float pv = fin.getPv();
		
		float pmt = price (n, pv);
		
		parcelas(n, pv, pmt);
		
		return pmt;
	}
	
	float price(int n, float pv) {
		float pmt3 = 0;
		
		float pmt1 = (float) (Math.pow((1+i), n) * i);
		float pmt2 = (float) (pmt1/(Math.pow((1+i), n) - 1));
		pmt3 = pv * pmt2;
		
		return pmt3;
	}
	
	void parcelas (int n, float pv, float pmt) {
		float a1 = pmt - pv * i;
		for (int i=1; i<= n; i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = pmt - amortizacao;
			Parcela p = new Parcela(pmt, juros, amortizacao);
			parcelas[i-1] = p;
			calcularTotalJuros(juros);
		}
	}
	
}
