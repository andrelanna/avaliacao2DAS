package Financeiro;

public class Prestacoes extends Modalidade{

	Prestacoes(String banco, float i) {
		super(banco, i);
	}
	
	public Parcela[] parcelas = new Parcela[fin.getN()];
	public float parcelaInitialPrice;
	public float parcelaPrice;
	public float prestacoes;
	public Price val = new Price(banco, parcelaInitialPrice);
	
	public float compute() {
		
		parcelaInitialPrice = (float) (Math.pow((1+i), fin.getN()) * i);
		
		parcelaPrice = (float) (parcelaInitialPrice/(Math.pow((1+i), fin.getN()) - 1));
		
		prestacoes = fin.getPv() * parcelaPrice;
		
		float a1 = prestacoes - fin.getPv() * i;
		for (int i=1; i<= fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = prestacoes- amortizacao;
			Parcela p = new Parcela(prestacoes, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return prestacoes;
	}

	@Override
	public float calcularPrestacoes() {
		// TODO Auto-generated method stub
		return 0;
	}
}
