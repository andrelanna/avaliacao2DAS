package Financeiro;

public class CalculaPrestacao {
	private final Price _price;

	public CalculaPrestacao(Price _price) {
		super();
		this._price = _price;

	}

	float compute () {
		_price.parcelas = new Parcela[_price.fin.getN()];
		
		final float pmt = (float) (Math.pow((1+_price.i), _price.fin.getN()) * _price.i);
		final float dividedPmt = (float) (pmt/(Math.pow((1+_price.i), _price.fin.getN()) - 1));
		final float provision = _price.fin.getPv() * dividedPmt;
		final float a1 = provision - _price.fin.getPv() * _price.i;
		
		adicionaParcelas(pmt, dividedPmt, provision, a1);

		return provision;
	}

	private void adicionaParcelas(float pmt2, float dividedPmt, float provision, float a1) {
		for (int i=1; i<= _price.fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+_price.i), i-1));
			float juros = provision - amortizacao;
			_price.parcelas[i-1] = new Parcela(provision, juros, amortizacao);;
		}
		return;
	}
}
