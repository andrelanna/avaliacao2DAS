package Financeiro;

public class CalcularPrestacoes {
	private final Price preco;
	
	public CalcularPrestacoes(Price p) {
		preco = p;
	}
	
	public float calcula() {
		preco.parcelas = new Parcela[preco.fin.getN()];
		
		float pmt = (float) (Math.pow((1+preco.i), preco.fin.getN()) * preco.i);
		float pmt1 = (float) (pmt/(Math.pow((1+preco.i), preco.fin.getN()) - 1));
		float pmt2 = preco.fin.getPv() * pmt1;
		
		float a1 = pmt2 - preco.fin.getPv() * preco.i;
		for (int i=1; i<= preco.fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+preco.i), i-1));
			float juros = pmt2 - amortizacao;
			Parcela p = new Parcela(pmt2, juros, amortizacao);
			preco.parcelas[i-1] = p;
		}
		
		return pmt2;
	}
	
}
