package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		// aplicando Dividir variável temporária em pmt:
		
		float pmt1, pmt2, pmt_final;
		pmt1 = (float) (Math.pow((1+i), fin.getN()) * i);
		pmt2 = (float) (pmt1/(Math.pow((1+i), fin.getN()) - 1));
		pmt_final = fin.getPv() * pmt2;
		
		float a1 = pmt_final - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = pmt_final - amortizacao;
			Parcela p = new Parcela(pmt_final, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return pmt_final;
	}
	
}
