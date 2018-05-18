package Financeiro;

public class CalcularPrestacoes {

	
	
	

	private float pmt;
	

	private float a1;
	private Parcela parcelas[];
	private Price price;
	
	CalcularPrestacoes(final Price price, float pmt,float a1, Parcela parcelas[]){

		setPrice(price);
		setPmt(pmt);
		setA1(a1);
		
		
		
	}
	
	float compute() {
		
		
		for (int i=1; i<= price.fin.getN(); i++) {
			final float amortizacao = (float) (a1 * Math.pow((1+price.i), i-1));
			final float juros = pmt - amortizacao;
			Parcela p = new Parcela(pmt, juros, amortizacao);
			this.parcelas[i-1] = p;
		}
		
		return pmt;
		
	}
	

	public float getPmt() {
		return pmt;
	}

	public void setPmt(float pmt) {
		this.pmt = pmt;
	}

	public float getA1() {
		return a1;
	}

	public void setA1(float a1) {
		this.a1 = a1;
	}



	public Price getPrice() {
		return price;
	}

	public void setPrice(Price price) {
		this.price = price;
	}
}