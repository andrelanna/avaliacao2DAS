package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}

	public float calcularPrestacoes() {
		parcelas = new Parcela[fin.getN()];
		
		// Aplicação de dividir variável temporária. Transformação de pmt em pmt, dividedPmt e provision
		final float pmt = (float) (Math.pow((1+i), fin.getN()) * i);
		final float dividedPmt = (float) (pmt/(Math.pow((1+i), fin.getN()) - 1));
		final float provision = fin.getPv() * dividedPmt;
		
		final float a1 = provision - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = provision - amortizacao;
			Parcela p = new Parcela(provision, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return provision;
	}
	
}
