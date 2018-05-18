package Financeiro;

public class CalcularPrestacoes {
	float parcelaComTempo;
	float parcelaComJuros;
	float valorTotalParcela;
	Price price;
	
	public CalcularPrestacoes (Price price) {
		this.price = price;
	}
	
	float calcula() {
		price.parcelas = new Parcela[fin.getN()];
		this.parcelaComTempo = (float) (Math.pow((1+price.i), price.fin.getN()) * price.i);
		this.parcelaComJuros = (float) (this.parcelaComTempo/(Math.pow((1+price.i), price.fin.getN()) - 1));
		this.valorTotalParcela = price.fin.getPv() * this.parcelaComJuros;
		
		float a1 = this.valorTotalParcela - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = valorTotalParcela - amortizacao;
			Parcela p = new Parcela(valorTotalParcela, juros, amortizacao);
			price.parcelas[i-1] = p;
		}
		
		return valorTotalParcela;
	}

}
