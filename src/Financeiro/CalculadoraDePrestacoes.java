package Financeiro;

public class CalculadoraDePrestacoes {
	private final Price _price;
	private float amort;
	private float interest;
	private float prestacao;
	
	public CalculadoraDePrestacoes(Price source, float amortArg, float interestArg, float prestacaoArg){
		_price = source;
		amort = amortArg;
		interest = interestArg;
		prestacao = prestacaoArg;
	}
	
	public float calcularPrestacoes() {
		_price.parcelas = new Parcela[_price.fin.getN()];
		
		amort = (float) (Math.pow((1 + _price.i), _price.fin.getN()) * _price.i);
		interest = (float) (amort/(Math.pow((1 + _price.i), _price.fin.getN()) - 1));
		prestacao = _price.fin.getPv() * interest;
		
		float a1 = prestacao - _price.fin.getPv() * _price.i;
		for (int i=1; i<= _price.fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this._price.i), i-1));
			float juros = prestacao - amortizacao;
			Parcela p = new Parcela(prestacao, juros, amortizacao);
			_price.parcelas[i-1] = p;
		}
		
		return prestacao;
	}
}
