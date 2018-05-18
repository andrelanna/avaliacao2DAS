package Financeiro;

public class CalculoPrestacoes {
	private final Price _price;
	private Parcela parcelas[];

	private float juros_total;
	private float juros_da_parcela_atual;
	private float pmt;
	private float a1;

	public CalculoPrestacoes(Price _price) {
		super();
		this._price = _price;
	}

	float compute() {
		parcelas = new Parcela[_price.fin.getN()];
		
		juros_total = (float) (Math.pow((1+_price.i), _price.fin.getN()) * _price.i);
		juros_da_parcela_atual = (float) (juros_total/(Math.pow((1+_price.i), _price.fin.getN()) - 1));
		pmt = _price.fin.getPv() * juros_da_parcela_atual;
		
		float a1 = pmt - _price.fin.getPv() * _price.i;
		
		for (int i=1; i<= _price.fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+_price.i), i-1));
			float juros = pmt - amortizacao;
			Parcela p = new Parcela(pmt, juros, amortizacao);
			parcelas[i-1] = p;
		}
		
		return pmt;
	}

	void importantThing() {
		for (int i=1; i<= _price.fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+_price.i), i-1));
			float juros = pmt - amortizacao;
			Parcela p = new Parcela(pmt, juros, amortizacao);
			parcelas[i-1] = p;
		}
	}
}
