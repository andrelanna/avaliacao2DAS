package Financeiro;

public class CalcularPrestacoes {
	
	private final Parcela _parcela;
	private final Prince _prince;
	private final Financiamento _fin;
	
	private float primaryPmt; 
	private float secundaryPmt;
	private float tercearyPmt;
	private float a1;
	
	public CalcularPrestacoes(Prince prince, Parcela parcela, Financiamento fin) {
		this._prince = prince;
		this._parcela = parcela;
		this._fin = fin;
	}
	public calculate(){
		
		this.calculatePmt();
		
		this.calculaterPrestacoes();
		
		return tercearyPmt;
	}
	public float calculaterPrestacoes() {
		
		a1 = tercearyPmt - fin.getPv() * i;
		
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = tercearyPmt - amortizacao;
			Parcela p = new Parcela(tercearyPmt, juros, amortizacao);
			parcelas[i-1] = p;
		}
	}
	
	private calculatePmt() {
		primaryPmt = (float) (Math.pow((1+i), fin.getN()) * i);
		secundaryPmt = (float) (primaryPmt/(Math.pow((1+i), fin.getN()) - 1));
		tercearyPmt = fin.getPv() * secundaryPmt;
		
	}
	
}