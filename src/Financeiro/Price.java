package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		// i = taxa de juros
		// fin = financiamento
		// getN() = getNúmero de prestações
		// pmt = parcela price = amortização do valor financiado PC e o valor de juros pagos
		float pmtNumerador = (float) (Math.pow((1+i), fin.getN()) * i); // (Juros + 1)^(prestações * juros) 
	
		float pmtDenominador = (float) (pmtNumerador/(Math.pow((1+i), fin.getN()) - 1));
		
		float valorParcelaPrice = fin.getPv() * pmtDenominador;
		
		float a1 = valorParcelaPrice - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = valorParcelaPrice - amortizacao;
			Parcela p = new Parcela(valorParcelaPrice, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return valorParcelaPrice;
	}
	
}
