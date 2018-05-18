package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		float parcelaInitialPrice = (float) (Math.pow((1+i), fin.getN()) * i);
		
		float parcelaPrice = (float) (parcelaInitialPrice/(Math.pow((1+i), fin.getN()) - 1));
		
		float prestacoes = fin.getPv() * parcelaPrice;
		
		float a1 = prestacoes - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = prestacoes- amortizacao;
			Parcela p = new Parcela(prestacoes, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return prestacoes;
	}
	
}
