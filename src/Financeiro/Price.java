package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		this.parcelas = new Parcela[fin.getN()];
		
		float pmt_num = (float) (Math.pow((1+i), fin.getN()) * i);
		float pmt_div = (float) (pmt_num/(Math.pow((1+i), fin.getN()) - 1));
		float new_pmt = fin.getPv() * pmt_div;
		
		float a1 = new_pmt - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = new_pmt - amortizacao;
			Parcela p = new Parcela(new_pmt, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return new_pmt;
	}
	
}
