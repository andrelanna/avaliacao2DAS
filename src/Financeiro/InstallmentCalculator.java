package Financeiro;

public class InstallmentCalculator {
	public Price price;
	public float numeradorPMT;
	public float denominadorPMT;
	public float valorParcelaPrice;
	public float a1;
	public float amortizacao;
	public Parcela p;
	public float juros;
	
	public InstallmentCalculator(Price price) {
		this.price = price;
	}
	
	public float calcularPrestacoes() {
		price.parcelas = new Parcela[price.fin.getN()];
		
		
		float valorParcelaPrice = calculaPretacaoPrice();
		
		float a1 = valorParcelaPrice - price.fin.getPv() * price.i;
		
		criaParcelas(valorParcelaPrice, a1);
		
		return valorParcelaPrice;
	}

	private void criaParcelas(float valorParcelaPrice, float a1) {
		for (int i=1; i<= price.fin.getN(); i++) {
			float amortizacao = calculaAmortizacao(a1, i);
			float juros = calculaJuros(valorParcelaPrice, amortizacao);
			Parcela p = new Parcela(valorParcelaPrice, juros, amortizacao);
			price.parcelas[i-1] = p;
		}
	}

	private float calculaJuros(float valorParcelaPrice, float amortizacao) {
		float juros = valorParcelaPrice - amortizacao;
		return juros;
	}

	private float calculaAmortizacao(float a1, int i) {
		float amortizacao = (float) (a1 * Math.pow((1+this.price.i), i-1));
		return amortizacao;
	}

	private float calculaPretacaoPrice() {
		float numeradorPMT = (float) (Math.pow((1+price.i), price.fin.getN()) * price.i); // (Juros + 1)^(prestações * juros) 
	
		float denominadorPMT = (float) (numeradorPMT/(Math.pow((1+price.i), price.fin.getN()) - 1));
		
		float valorParcelaPrice = price.fin.getPv() * denominadorPMT;
		return valorParcelaPrice;
	}

}
