package Financeiro;

public class Price extends Modalidade {
	
	public Price(String banco, float i) {
		super(banco, i);
	}
	public Prestacoes valor = new Prestacoes(banco, i);
	
	@Override
	public float calcularPrestacoes() {
		return valor.compute();
	}
}