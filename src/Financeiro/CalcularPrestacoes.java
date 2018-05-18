package Financeiro;

public class CalcularPrestacoes {
	private Price price;
	private float numerador, denominador, pmt, a1, amortizacao, juros;
	private Parcela p;
	
	public CalcularPrestacoes(Price price) {
		super();
		this.price = price;
	}
	
	public float computar() {
		price.parcelas = new Parcela[price.fin.getN()];
		
		numerador = (float) (Math.pow((1+price.i), price.fin.getN()) * price.i);
		denominador = (float) (numerador/(Math.pow((1+price.i), price.fin.getN()) - 1));
		pmt = price.fin.getPv() * denominador;
		
		a1 = pmt - price.fin.getPv() * price.i;
		for (int i=1; i<= price.fin.getN(); i++) {
			amortizacao = (float) (a1 * Math.pow((1+this.price.i), i-1));
			juros = pmt - amortizacao;
			p = new Parcela(pmt, juros, amortizacao);
			price.parcelas[i-1] = p;
		}
		
		return pmt;
	}
	
}
