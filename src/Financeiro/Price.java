package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		float juros_total = (float) (Math.pow((1+i), fin.getN()) * i);
		float juros_da_parcela_atual = (float) (juros_total/(Math.pow((1+i), fin.getN()) - 1));
		float pmt = fin.getPv() * juros_da_parcela_atual;
		
		float a1 = pmt - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = pmt - amortizacao;
			Parcela p = new Parcela(pmt, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return pmt;
	}
	
}
