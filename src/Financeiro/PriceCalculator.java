package Financeiro;
public class PriceCalculator {
	
	public Price price;
	public float pmtNumerador;
	public float pmtDenominador;
	public float pmtDivisao;
	public float pmt;
	public float a1;
	public float amortizacao;
	public Parcela p;
	public float juros;
	
	public PriceCalculator(Price _price) {
		this.price = _price;
	}
	
	public float calcularPrestacoes() {
		price.parcelas = new Parcela[price.fin.getN()];
		
		calculaPMT();
		redefineParcelas();
		
		return pmt;
		
	}

	private void redefineParcelas() {
		a1 = pmt - price.fin.getPv() * price.i;
		
		for (int i=1; i<= price.fin.getN(); i++) {
			amortizacao = (float) (a1 * Math.pow((1+price.i), i-1));
			juros = pmt - amortizacao;
			p = new Parcela(pmt, juros, amortizacao);
			price.parcelas[i-1] = p;
		}
	}

	private void calculaPMT() {
		pmtNumerador = (float) (calculaPotencia() * price.i);
		pmtDenominador = (float)(calculaPotencia() - 1);
		pmtDivisao = (float) (pmtNumerador/pmtDenominador);
		pmt = price.fin.getPv() * pmtDivisao;
	}

	private float calculaPotencia() {
		return (float)Math.pow((1+price.i), price.fin.getN());
	}

}
