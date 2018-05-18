package Financeiro;

public class Prestacoes{
	public Price price;
	float pmt_num;
	float pmt_div;
	float new_pmt;
	float a1;
	float amortizacao;
	float juros;
	Parcela p;
	
	public Prestacoes(Price price) {
		this.price = price;
	}
	
	public float calcularPrestacoes() {
		price.parcelas = new Parcela[price.fin.getN()];
		
		calculaPMT();
		
		calculaParcelas();
		
		return new_pmt;
	}

	private void calculaPMT() {
		pmt_num = (float) (Math.pow((1+price.i), price.fin.getN()) * price.i);
		pmt_div = (float) (pmt_num/(Math.pow((1+price.i), price.fin.getN()) - 1));
		new_pmt = price.fin.getPv() * pmt_div;
	}

	private void calculaParcelas() {
		a1 = new_pmt - price.fin.getPv() * price.i;
		for (int i=1; i<= price.fin.getN(); i++) {
			amortizacao = (float) (a1 * Math.pow((1+price.i), i-1));
			juros = new_pmt - amortizacao;
			p = new Parcela(new_pmt, juros, amortizacao);
			price.parcelas[i-1] = p;
		}
	}

	
}
