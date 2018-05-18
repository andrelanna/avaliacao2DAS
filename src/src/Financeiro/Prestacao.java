package Financeiro;

public class Prestacao {
	
	 private final Price price; 

	public Prestacao(Price price) {
		// TODO Auto-generated constructor stub
		this.price = price;
	
	}
	
	
	public float calcularPrestacoes() {
		price.parcelas = new Parcela[price.fin.getN()];
				
				final float pmt1 = (float) (Math.pow((1+price.i), price.fin.getN()) * price.i);
				final float pmt2 = (float) (pmt1/(Math.pow((1+price.i), price.fin.getN()) - 1));
				final float pmt3 = price.fin.getPv() * pmt2;
			
				float a1 = pmt3 - price.fin.getPv() * price.i;
				for (int i=1; i<= price.fin.getN(); i++) {
					float amortizacao = (float) (a1 * Math.pow((1+this.price.i), i-1));
					float juros = pmt3 - amortizacao;
					Parcela p = new Parcela(pmt3, juros, amortizacao);
					price.parcelas[i-1] = p;
				}
				
				return pmt3;
	}
}