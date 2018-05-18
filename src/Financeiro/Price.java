package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		// 
		float parcelaPrime = (float) (Math.pow((1+i), fin.getN()) * i);
		
		
		float parcelaPrime2 = (float) (parcelaPrime/(Math.pow((1+i), fin.getN()) - 1));
		
		
		float parcelaPrime3 = fin.getPv() * parcelaPrime2;
		
		float a1 = parcelaPrime3 - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = parcelaPrime3 - amortizacao;
			Parcela p = new Parcela(parcelaPrime3, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return parcelaPrime3;
	}
	
}
