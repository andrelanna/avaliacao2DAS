package Financeiro;

public class Price extends Modalidade {
	
	private Pmt pmt;
	
	public Price(String banco, float i) {
		super(banco, i);
		pmt = new Pmt(this);
	}

	public float calcularPrestacoes() {
	
		final float final_pmt = pmt.computarPmt(fin,i);
		parcelas = pmt.computaParcela(fin, i);
		return final_pmt;
	}
	
}
