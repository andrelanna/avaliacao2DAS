package Financeiro;

public class Prestacao {
	
	 private final Price _price; 

	public Prestacao(Price price) {
		// TODO Auto-generated constructor stub
		_price = price;
	
	}
	
	public float calcularPrestacoes() {
		_price.parcelas = new Parcela[_price.fin.getN()];
		
		float parcelaPrime = (float) (Math.pow((1+_price.i), _price.fin.getN()) * _price.i);
		float parcelaPrime2 = (float) (parcelaPrime/(Math.pow((1+_price.i), _price.fin.getN()) - 1));
		float parcelaPrime3 = _price.fin.getPv() * parcelaPrime2;
		float a1 = parcelaPrime3 - _price.fin.getPv() * _price.i;
		
		for (int i=1; i<= _price.fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this._price.i), i-1));
			float juros = parcelaPrime3 - amortizacao;
			Parcela p = new Parcela(parcelaPrime3, juros, amortizacao);
			_price.parcelas[i-1] = p;
		}
		
		return parcelaPrime3;
	}

}
