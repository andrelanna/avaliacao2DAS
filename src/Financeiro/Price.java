package Financeiro;

public class Price extends Modalidade {
	public Price(String banco, float i) {
		super(banco, i);
	}
	
	
	
	final float pmt_aux_0 = (float) (Math.pow((1+i), fin.getN()) * i);
	final float pmt_aux_1 = (float) (pmt_aux_0/(Math.pow((1+i), fin.getN()) - 1));
	final float pmt = fin.getPv() * pmt_aux_1;
	float a1 = pmt - fin.getPv() * i;
	
	CalcularPrestacoes calcPresta = new CalcularPrestacoes(price, pmt_aux_0, new Parcela[fin.getN()]);
	

	
}
