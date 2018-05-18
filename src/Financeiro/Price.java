package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		float potency = (float) Math.pow((1+i), fin.getN());
		float pmt_aux1 	= potency * i;
		float pmt_aux2 = pmt_aux1/(potency - 1);
		float pmt = fin.getPv() * pmt_aux2;
		
		float a1 = pmt - fin.getPv() * i;
		
		for (int i=1; i<= fin.getN(); i++) 
		{
			float amortizacao = (float) (a1 * Math.pow( (1+this.i), i-1 ) );
			float juros = pmt - amortizacao;
			
			Parcela p = new Parcela(pmt, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return pmt;
	}
	
}
