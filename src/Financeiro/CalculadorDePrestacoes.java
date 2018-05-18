package Financeiro;

public class CalculadorDePrestacoes {

	private Price price;
	
	public CalculadorDePrestacoes(Price price){
		this.price = price;
	}
	
	public float calcularPrestacoes() {
		price.parcelas = new Parcela[price.fin.getN()];
		
		float potency = (float) Math.pow((1+price.i), price.fin.getN());
		float pmt_aux1 	= potency * price.i;
		float pmt_aux2 = pmt_aux1/(potency - 1);
		float pmt = price.fin.getPv() * pmt_aux2;
		
		float a1 = pmt - price.fin.getPv() * price.i;
		
		for (int i=1; i<= price.fin.getN(); i++) 
		{
			float amortizacao = (float) (a1 * Math.pow( (1+price.i), i-1 ) );
			float juros = pmt - amortizacao;
			
			Parcela p = new Parcela(pmt, juros, amortizacao);
			price.parcelas[i-1] = p;
		}
		
		return pmt;
	}
	
}
