package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		final float pmt = (float) (Math.pow((1+i), fin.getN()) * i);
		final float pmt2 = (float) (pmt/(Math.pow((1+i), fin.getN()) - 1));
		final float valorParcela = fin.getPv() * pmt2;
		System.out.println("pmt3 "+ valorParcela);
		
		float a1 = valorParcela - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = valorParcela - amortizacao;
			Parcela p = new Parcela(valorParcela, juros, amortizacao);
			parcelas[i-1] = p;
			System.out.println("pmt3 "+valorParcela+ "p " + p.pmt);
		}
		System.out.println("pmt3 "+ valorParcela);
		return valorParcela;
		
	}
	
}
