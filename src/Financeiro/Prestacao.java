package Financeiro;

public class Prestacao {
	private Price price;
	private float i;
	private int N;
	private float Pv;
	
	Prestacao(Price price){
		this.i = price.i;
		this.N = price.fin.getN();
		this.Pv = price.fin.getPv();
	}
	
	public float calcular() {
		
		//Aplicando a operação de refatoração Dividir variável temporária
		float pmt_pt1 = (float) (Math.pow((1+i), N) * i);
		float pmt_pt2 = (float) (pmt_pt1/(Math.pow((1+i), N) - 1));
		float pmt = Pv * pmt_pt2;
		
		return pmt;
		
	}
}
