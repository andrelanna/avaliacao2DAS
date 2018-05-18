package Financeiro;

public class PaymentCalculator {
	
	private final Price _price;
	
	public PaymentCalculator(Price price){
		_price = price;
	}
	
	public float calcular() {
		_price.parcelas = new Parcela[_price.fin.getN()];
				
		final float pmt = (float) (Math.pow((1+_price.i), _price.fin.getN()) * _price.i);
		final float pmt2 = (float) (pmt/(Math.pow((1+_price.i), _price.fin.getN()) - 1));
		final float pmt3 = _price.fin.getPv() * pmt2;
		
		float a1 = pmt3 - _price.fin.getPv() * _price.i;
		for (int i=1; i<= _price.fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this._price.i), i-1));
			float juros = pmt3 - amortizacao;
			Parcela p = new Parcela(pmt3, juros, amortizacao);
			_price.parcelas[i-1] = p;
		}

		return pmt3;
	}
}
