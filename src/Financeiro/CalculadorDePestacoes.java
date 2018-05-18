package Financeiro;

public class CalculadorDePestacoes {
	
	private float pmt1, pmt2, pmt_final, a1, amortizacao, juros;
	
	
	public float calcularPmtFinal(Parcela[] parcelas, Financiamento fin, float i) {
		pmt1 = (float) (Math.pow((1+i), fin.getN()) * i);
		pmt2 = (float) (pmt1/(Math.pow((1+i), fin.getN()) - 1));
		pmt_final = fin.getPv() * pmt2;
		return pmt_final;
	}
	
	public void calculaAmortizacaoEJuros(Parcela[] parcelas,Financiamento fin, float intrests, float pmt_final, int aux) {
		this.a1 = pmt_final - fin.getPv() * intrests;
		this.amortizacao = (float) (a1 * Math.pow((1+intrests), aux-1));
		this.juros = pmt_final - amortizacao;
		Parcela p = new Parcela(pmt_final, juros, amortizacao);
		parcelas[aux-1] = p;
	}
	

}
