package Financeiro;
public class CalcularPrestacoes {
	
	public Price price;
	
	public float numerador;
	public float denominador;
	public float divisao;
	public float pmt;
	
	public float a1;
	public float amortizacao;
	public Parcela p;
	public float juros;
	
	Parcela[] parcelas;
	
	public CalcularPrestacoes(Price _price) {
		this.price = _price;
	}
	
	public float execute() {
		parcelas = new Parcela[price.getFin().getN()];
		
		calcular();
		
		atualizarParcelas();
		
		return pmt;
		
	}

	private void calcular() {
		numerador = (float) (calculaPow() * price.getI());
		denominador = (float)(calculaPow() - 1);
		divisao = (float) (numerador/denominador);
		pmt = price.getFin().getPv() * divisao;
	}

	private float calculaPow() {
		return (float)Math.pow((1+price.getI()), price.getFin().getN());
	}
	
	private void atualizarParcelas() {
		a1 = pmt - price.getFin().getPv() * price.getI();
		
		for (int i=1; i<= price.getFin().getN(); i++) {
			amortizacao = (float) (a1 * Math.pow((1+price.getI()), i-1));
			juros = pmt - amortizacao;
			p = new Parcela(pmt, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		price.setParcelas(parcelas);
	}

}