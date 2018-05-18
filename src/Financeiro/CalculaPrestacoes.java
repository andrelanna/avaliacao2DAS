package Financeiro;

public class CalculaPrestacoes {
    private final Price _price;
    private float pmtElevado;
    private float pmtDivisao;
    private float pmt;
    private float a1;

    CalculaPrestacoes(Price source) {
        super();
        _price = source;
    }

    float compute() {
		_price.parcelas = new Parcela[_price.fin.getN()];
    
        pmtElevado = (float) (Math.pow((1+_price.i), _price.fin.getN()) * _price.i);
		pmtDivisao = (float) (pmtElevado/(Math.pow((1+_price.i), _price.fin.getN()) - 1));
		pmt = _price.fin.getPv() * pmtDivisao;
        
        a1 = pmt - _price.fin.getPv() * _price.i;   
        
        criaParcelas();
        
        return pmt;
    }
    
    void criaParcelas () {
        for (int i=1; i<= _price.fin.getN(); i++) {
			float amortizacao = (float) (a1 * Math.pow((1+this.i), i-1));
			float juros = pmt - amortizacao;
			Parcela p = new Parcela(pmt, juros, amortizacao);
			parcelas[i-1] = p;
		}
    }
}