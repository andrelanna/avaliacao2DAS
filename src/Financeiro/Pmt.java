package Financeiro;

public class Pmt {

	private Parcela[] parcelas;
	private float a1;
	private float amortizacao;
	private float juros;
	
	private float auxPmt1;
	private float auxPmt2;
	private float final_pmt;

	private Price price;
	
	public Pmt(Price price) {
		price = this.price;
		// TODO Auto-generated constructor stub
	}
	
	public Parcela[] computaParcela(Financiamento fin,float i){
		parcelas = new Parcela[fin.getN()];
		

		a1 = final_pmt - fin.getPv() * i;
		for (int cont=1; i<= fin.getN(); cont++) {
			amortizacao = (float) (a1 * Math.pow((1+price.i), cont-1));
			juros = final_pmt - amortizacao;
			Parcela p = new Parcela(final_pmt, juros, amortizacao);
			parcelas[cont-1] = p;
		}
		
		
		return parcelas;
	}
	
	public float computarPmt(Financiamento fin, float i) {
		auxPmt1 = (float) (Math.pow((1+i), fin.getN()) * i);
		auxPmt2 = (float) (auxPmt1/(Math.pow((1+i), fin.getN()) - 1));
		final_pmt = fin.getPv() * auxPmt2;
	
		return final_pmt;	
	}
}
